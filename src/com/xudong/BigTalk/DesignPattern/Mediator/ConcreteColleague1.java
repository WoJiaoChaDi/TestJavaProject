package com.xudong.BigTalk.DesignPattern.Mediator;

public class ConcreteColleague1 extends Colleague {

	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
	}
	
	public void send(String message){
		super.mediator.send(message, this);
	}

	public void notify(String message){
		System.out.println("同事1得到信息：" + message);
	}
}
