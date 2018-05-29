package com.xudong.BigTalk.DesignPattern.State;

/**
 * 上午工作状态
 * @author XuDong
 *
 */
public class EveningState extends State {

	@Override
	public void writeProgram(Work work) {
		
		if(work.isFinish()){
			work.setCurrent(new RestState());
			work.writeProgram();
		}else{
			if(work.getHour() < 21){
				System.out.println("当前时间:" + work.getHour() + "点，加班哦，疲惫至极！");
			}else{
				work.setCurrent(new SleepingState());
				work.writeProgram();
			}
		}
	}

}
