package com.xudong.BigTalk.DesignPattern.Memento;

/**
 * 备忘录
 * @author XuDong
 *
 */
public class Memento {

	private String state;
	private String health;
	private String attack;
	
	public Memento(String state, String health, String attack){
		this.state = state;
		this.health = health;
		this.attack = attack;
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
	
	
}
