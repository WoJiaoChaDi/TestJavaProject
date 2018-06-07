package com.xudong.BigTalk.DesignPattern.Birdge;

public class TestBirdge {

	public static void main(String[] args) {
		Abstraction ab = new RefinedAbstraction();
		
		ab.setImplementor(new ConcreteImplementorA());
		ab.operation();
		
		ab.setImplementor(new ConcreteImplementorB());
		ab.operation();
		
	}
}
