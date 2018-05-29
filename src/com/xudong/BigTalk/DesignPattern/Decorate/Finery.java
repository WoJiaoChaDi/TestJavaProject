package com.xudong.BigTalk.DesignPattern.Decorate;

public class Finery extends Person {//ConcreteComponent

	protected Person component;
	
	//打扮
	public void decorate(Person component){
		this.component = component;
	}
	
	@Override
	public void show(){
		if(component != null){
			component.show();
		}
	}
	
}
