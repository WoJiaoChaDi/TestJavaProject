package com.xudong.BigTalk.DesignPattern.Birdge;

public class Abstraction {

	protected Implementor implementor;
	
	public void setImplementor(Implementor implementor){
		this.implementor = implementor;
	}
	
	public void operation(){
		this.implementor.operation();
	}
}
