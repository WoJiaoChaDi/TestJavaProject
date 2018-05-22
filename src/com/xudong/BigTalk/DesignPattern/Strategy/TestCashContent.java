package com.xudong.BigTalk.DesignPattern.Strategy;

public class TestCashContent {

	public static void main(String[] args) {
		
		double total = 0;
		CashContent con = new CashContent();
		total += con.getContentResult(1, 500, 4);
		total += con.getContentResult(2, 500, 4);
		total += con.getContentResult(3, 500, 4);
		System.out.println("总价：" + total);
		
		
	}
}
