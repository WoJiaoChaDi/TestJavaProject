package com.xudong.test;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

public class AcceptMailDemo {

	/**
	 * 接受邮件
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String imapserver = "imap.163.com"; // 邮件服务器
		String user = "****@163.com";// 邮箱
		String password = "*****"; // 邮箱授权密码
		// 获取默认会话
		Properties prop = System.getProperties();
		prop.put("mail.imap.host", imapserver);
		prop.put("mail.imap.auth.plain.disable", "true");
		Session mailsession = Session.getInstance(prop, null);
		mailsession.setDebug(false); // 是否启用debug模式
		IMAPFolder folder = null;
		IMAPStore store = null;
		int total = 0;
		try {
			store = (IMAPStore) mailsession.getStore("imap"); // 使用imap会话机制，连接服务器
			store.connect(imapserver, user, password);
			folder = (IMAPFolder) store.getFolder("INBOX"); // 收件箱
			// 使用只读方式打开收件箱
			folder.open(Folder.READ_WRITE);
			// 获取总邮件数
			total = folder.getMessageCount();
			System.out.println("-----------------您的邮箱共有邮件：" + total + " 封--------------");

			// 得到收件箱文件夹信息，获取邮件列表
			Message[] msgs = folder.getMessages();

			for (Message message : msgs) {
				System.out.print("\t" + message.getSubject());// 收件主题
				System.out.print("\t" + message.getReceivedDate());// 收件时间

				// 收件内容
				MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();

				for (int i = 0; i < mimeMultipart.getCount(); i++) {
					// 单个部件 注意：单个部件有可能又为一个Multipart，层层嵌套
					BodyPart part = mimeMultipart.getBodyPart(i);
					// 单个部件类型
					String type = part.getContentType().split(";")[0];
					/**
					 * 类型众多，逐一判断，其中TEXT、HTML类型可以直接用字符串接收，其余接收为内存地址
					 * 可能不全，如有没判断住的，请自己打印查看类型，在新增判断
					 */
					if (type.equalsIgnoreCase("multipart/Alternative")) {
						/**
						 * 获取超文本复合内容 他本是又是一个Multipart容器
						 * 此时邮件会分为TEXT（纯文本）正文和HTML正文（HTML标签元素）
						 */
						Multipart m = (Multipart) part.getContent();
						for (int k = 0; k < m.getCount(); k++) {
							if (m.getBodyPart(k).getContentType()
									.startsWith("Text/Plain")) {
								// 处理文本正文
								System.out.println("TEXT文本内容："
										+ "\n"
										+ m.getBodyPart(k).getContent()
												.toString().trim() + "\n");
							} else {
								// 处理 HTML 正文
								System.out.println("HTML文本内容：" + "\n"
										+ m.getBodyPart(k).getContent() + "\n");
							}
						}
					} else if (type.equalsIgnoreCase("text/plain")) { // 纯文本
						System.out.println("纯文本:"
								+ part.getContent().toString());
					} else if (type.equalsIgnoreCase("text/html")) { // HTML标签元素
						System.out.println("HTML元素:"
								+ part.getContent().toString());
					} else if (type.equalsIgnoreCase("multipart/related")) { // 内嵌资源
																	// (包涵文本和超文本组合)
						System.out.println("内嵌资源:"
								+ part.getContent().toString());
					} else if (type.contains("application/")) { // 应用附件
																// （zip、xls、docx等）
						System.out.println("应用文件："
								+ part.getContent().toString());
					} else if (type.contains("image/")) { // 图片附件
															// （jpg、gpeg、gif等）
						System.out.println("图片文件："
								+ part.getContent().toString());
					}
				}

				System.out.print("\t" + message.getFlags());// 收件标记
				if (message.getFlags().toString()
						.equals("com.sun.mail.imap.protocol.FLAGS@0")) {
					System.out.print("\t" + "这封是新邮件");
					message.setFlag(Flags.Flag.SEEN, true);// 标记为已读
				}
				
				System.out.println();
			}
			System.out.println("\t收件箱的总邮件数：" + msgs.length);
			System.out.println("\t未读邮件数：" + folder.getUnreadMessageCount());
			System.out.println("\t新邮件数：" + folder.getNewMessageCount());
			System.out.println("----------------End------------------");
		} catch (MessagingException ex) {
			System.err.println("不能以读写方式打开邮箱!");
			ex.printStackTrace();
		} finally {
			// 释放资源
			try {
				if (folder != null)
					folder.close(true); // 退出收件箱时,删除做了删除标识的邮件
				if (store != null)
					store.close();
			} catch (Exception bs) {
				bs.printStackTrace();
			}
		}
	}

}