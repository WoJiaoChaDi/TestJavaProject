package com.xudong.BigTalk.DesignPattern.State;

/**
 * 上午工作状态
 * @author XuDong
 *
 */
public class ForenoonState extends State {

	@Override
	public void writeProgram(Work work) {
		
		if(work.getHour() < 12){
			System.out.println("当前时间:" + work.getHour() + "点，上午工作，精神百倍！");
		}else{
			work.setCurrent(new NoonState());
			work.writeProgram();
		}
	}

}
