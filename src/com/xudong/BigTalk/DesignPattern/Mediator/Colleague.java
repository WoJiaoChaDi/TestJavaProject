package com.xudong.BigTalk.DesignPattern.Mediator;

public abstract class Colleague {

	protected Mediator mediator;
	
	public Colleague(Mediator mediator){//构造方法，得到中介者对象
		this.mediator = mediator;
	}
}
