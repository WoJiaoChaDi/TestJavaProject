package com.xudong.BigTalk.DesignPattern.Proxy;

public class TestProxy {
	public static void main(String[] args) {
		
		SchoolGirl mm = new SchoolGirl("李娇娇");
		
		Proxy proxy = new Proxy(mm);
		proxy.giveDolls();
		proxy.giveFlowers();
		proxy.giveChocolate();
	}
}
