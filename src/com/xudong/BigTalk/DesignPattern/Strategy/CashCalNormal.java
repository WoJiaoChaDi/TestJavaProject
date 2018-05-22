package com.xudong.BigTalk.DesignPattern.Strategy;


public class CashCalNormal extends AbstarctCashCal{

	public CashCalNormal(double money, int number) {
		super(money, number);
	}

	@Override
	public double getTotalPrice() {
		double total = this.getMoney() * this.getNum();
		System.out.println("商品单价：" + this.getMoney() + "；商品数量：" + this.getNum() + ";商品总价" + total);
		return total;
	}

	
}
