package com.xudong.BigTalk.DesignPattern.State;

public class Work {

	private State current;
	private int hour;//状态转换依据
	private boolean finish;//任务完成依据
	
	public Work() {
		current = new ForenoonState();//工作初始化为上午工作状态
	}
	
	public void writeProgram(){
		current.writeProgram(this);
	}
	
	public State getCurrent() {
		return current;
	}
	public void setCurrent(State current) {
		this.current = current;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public boolean isFinish() {
		return finish;
	}
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
}
