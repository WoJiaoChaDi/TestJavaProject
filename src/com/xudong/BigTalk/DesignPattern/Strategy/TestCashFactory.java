package com.xudong.BigTalk.DesignPattern.Strategy;

public class TestCashFactory {

	public static void main(String[] args) {
		
		double total = 0;
		AbstarctCashCal cashCal = null;
		cashCal= CashFactory.getCashFactory(1, 500, 4);
		total += cashCal.getTotalPrice();
		cashCal = CashFactory.getCashFactory(2, 500, 4);
		total += cashCal.getTotalPrice();
		cashCal = CashFactory.getCashFactory(3, 500, 4);
		total += cashCal.getTotalPrice();
		
		System.out.println("总价：" + total);
		
		
	}
}
