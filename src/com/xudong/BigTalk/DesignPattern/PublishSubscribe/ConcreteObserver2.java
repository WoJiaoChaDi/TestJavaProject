package com.xudong.BigTalk.DesignPattern.PublishSubscribe;

public class ConcreteObserver2 extends Observer {

	private String name;
	private String age;
	private String observerState;
	private ConcreteSubject subject;
	
	public ConcreteObserver2(ConcreteSubject subject, String name) {
		this.subject = subject;
		this.name = name;
		this.age = "6";
	}
	
	@Override
	public void update() {
		observerState = subject.getSubjectState();
		System.out.println("观察者2" + name + "的新状态是" + observerState + ",其独有属性age=" + age);
	}

//	public ConcreteSubject getSubject() {
//		return subject;
//	}
//
//	public void setSubject(ConcreteSubject subject) {
//		this.subject = subject;
//	}

}
