package com.xudong.BigTalk.DesignPattern.PublishSubscribe;

public class TestPublishSubscribe {

	public static void main(String[] args) {
		
		ConcreteSubject cs = new ConcreteSubject();
		cs.attach(new ConcreteObserver(cs, "X"));
		cs.attach(new ConcreteObserver(cs, "Y"));
		cs.attach(new ConcreteObserver2(cs, "Z"));
		
		cs.setSubjectState("ABC");
		cs.notifyMethod();
		
		cs.setSubjectState("DEF");
		cs.notifyMethod();
	}
}
