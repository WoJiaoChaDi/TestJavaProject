package com.xudong.BigTalk.DesignPattern.Adapter;

public class TestAdapter {

	public static void main(String[] args) {
		Player b = new Forwards("<丹尼尔>");
		Player y = new Adapter("<姚明>");
		
		b.attack();
		y.attack();
		y.defense();
	}
}
