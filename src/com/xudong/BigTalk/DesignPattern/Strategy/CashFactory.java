package com.xudong.BigTalk.DesignPattern.Strategy;


public class CashFactory{
	
	public static AbstarctCashCal getCashFactory(int mode, double money, int number){
		AbstarctCashCal cashCal = null;
		switch (mode) {
		case 1:
			cashCal = new CashCalNormal(money, number);
			break;
		case 2:
			CashCalRate cashCalRate = new CashCalRate(money, number);
			cashCalRate.setRate(0.8);
			cashCal = cashCalRate;
			break;
		case 3:
			CashCalReturn cashCalReturn = new CashCalReturn(money, number);
			cashCalReturn.setReturnLine(300);
			cashCalReturn.setReturnMoney(100);
			cashCal = cashCalReturn;
			break;
		default:
			cashCal = new CashCalNormal(money, number);
			break;
		}
		return cashCal;
	}
}
