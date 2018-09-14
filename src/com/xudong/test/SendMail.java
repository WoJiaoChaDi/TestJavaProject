package com.xudong.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    /**
     * 发送邮件
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	for (int i = 0; i < 10; i++) {
			
		
    	String smtpHost = "smtp.163.com";
        String from = "alexdongs@163.com";
//        String to = "xud@pete-cat.com";
        String to = "zhangsan@jfjfj.net";
        String subject = "邮件标题"; //subject javamail自动转码
    	
        Properties prop = new Properties();
        prop.setProperty("mail.host", smtpHost);//邮箱SMTP
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        
        StringBuffer theMessage = new StringBuffer();
        theMessage.append("<h2><font color=red>测试邮件内容</font></h2>");
        theMessage.append("<hr>");
        theMessage.append("<i>这是测试内容</i>");
        
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(false);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect(smtpHost, "alexdongs", "39whyi33");//邮箱前缀和授权密码（注意是授权密码，而不是邮箱登入密码）
        //4、创建邮件
        Message message = createSimpleMail(session, from, to, subject, theMessage.toString());
        //5、发送邮件
        try {
        	ts.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        ts.close();
    	}
    }
    
    /**
	 * @Method: createSimpleMail
 	 * @Description: 创建一封只包含文本的邮件
     * @param session
     * @param from
     * @param to
     * @param subject
     * @param theMessage
     * @return
     * @throws Exception
     */
    public static MimeMessage createSimpleMail(Session session, String from, String to, String subject, String theMessage)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(from));//需要与Transport的用户名一致
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //指明邮件的多个收件人
//        InternetAddress[] addrs = new InternetAddress[2];
//        addrs[0] = new InternetAddress("xud@pete-cat.com");
//        addrs[1] = new InternetAddress("xud1@pete-cat.com");
//        message.setRecipients(Message.RecipientType.TO, addrs);
        //邮件的标题
        message.setSubject(subject);
        //邮件的文本内容
        message.setContent(theMessage, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }
}