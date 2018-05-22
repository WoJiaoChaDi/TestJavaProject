package com.xudong.BigTalk.DesignPattern.Strategy;


public class CashCalReturn extends AbstarctCashCal{

	private double returnLine;
	private double returnMoney;
	
	public CashCalReturn(double money, int number) {
		super(money, number);
	}
	
	public double getReturnLine() {
		return returnLine;
	}

	public void setReturnLine(double returnLine) {
		this.returnLine = returnLine;
	}

	public double getReturnMoney() {
		return returnMoney;
	}



	public void setReturnMoney(double returnMoney) {
		this.returnMoney = returnMoney;
	}



	@Override
	public double getTotalPrice() {
		double totalPrice = this.getMoney() * this.getNum();;
		totalPrice = totalPrice - Math.floor(totalPrice/this.returnLine)*this.returnMoney;
		System.out.println("商品单价：" + this.getMoney() + "；商品数量：" + this.getNum() + ";商品总价" + totalPrice);
		return totalPrice;
	}

	
}
