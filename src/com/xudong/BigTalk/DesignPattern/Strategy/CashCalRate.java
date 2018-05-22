package com.xudong.BigTalk.DesignPattern.Strategy;


public class CashCalRate extends AbstarctCashCal{

	private double rate;
	public CashCalRate(double money, int number) {
		super(money, number);
	}
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double getTotalPrice() {
		double total = this.getMoney() * this.getNum() * this.rate;
		System.out.println("商品单价：" + this.getMoney() + "；商品数量：" + this.getNum() + ";商品总价" + total);
		return total;
	}

	
}
