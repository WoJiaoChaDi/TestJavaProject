package com.xudong.BigTalk.DesignPattern.Strategy;

public abstract class AbstarctCashCal {

	private double money;
	private int num;
	
	public AbstarctCashCal(double money, int number) {
		this.money = money;
		this.num = number;
	}
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public abstract double getTotalPrice();
}
