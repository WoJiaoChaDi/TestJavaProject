package com.xudong.BigTalk.DesignPattern.State;

/**
 * 上午工作状态
 * @author XuDong
 *
 */
public class AfternoonState extends State {

	@Override
	public void writeProgram(Work work) {
		
		if(work.getHour() < 17){
			System.out.println("当前时间:" + work.getHour() + "点，下午状态还不错，继续努力！");
		}else{
			work.setCurrent(new EveningState());
			work.writeProgram();
		}
	}

}
