package com.xudong.BigTalk.DesignPattern.Adapter;

public class ForeignCenter {

	private String name;

	public void aaaaaattack(){
		System.out.println("外籍中锋" + this.getName() + "进攻攻攻攻攻！");
	}
	
	public void ddddddefense(){
		System.out.println("外籍中锋" + this.getName() + "防守守守守守！");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
