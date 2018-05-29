package com.xudong.BigTalk.DesignPattern.State;

/**
 * 上午工作状态
 * @author XuDong
 *
 */
public class RestState extends State {

	@Override
	public void writeProgram(Work work) {
		
		System.out.println("当前时间:" + work.getHour() + "点，下班回家了！");
	}

}
