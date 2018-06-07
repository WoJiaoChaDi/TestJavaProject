package com.xudong.BigTalk.DesignPattern.Birdge;

public class RefinedAbstraction extends Abstraction {

	@Override
	public void operation(){
		super.implementor.operation();
	}
}
