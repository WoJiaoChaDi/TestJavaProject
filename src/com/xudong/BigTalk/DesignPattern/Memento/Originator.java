package com.xudong.BigTalk.DesignPattern.Memento;

/**
 * 发起人
 * @author XuDong
 *
 */
public class Originator {

	/*
	 * 需要保存的属性
	 */
	private String state;
	private String health;
	private String attack;
	private String time;
	
	/*
	 * 创建备忘录，将当前需要保存的信息导入并实例化一个Memento对象
	 */
	public Memento createMemento(){
		return new Memento(state, health, attack);
	}
	
	/*
	 * 恢复备忘录，将Memento导入并将相关数据恢复
	 */
	public void setMemento(Memento memento){
		this.state = memento.getState();
		this.health = memento.getHealth();
		this.attack = memento.getAttack();
	}
	
	public void show(){
		System.out.println(state);
		System.out.println(health);
		System.out.println(attack);
		System.out.println(time);
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getAttack() {
		return attack;
	}
	public void setAttack(String attack) {
		this.attack = attack;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
