package com.xudong.BigTalk.DesignPattern.Decorate;

public class Person {//ConcreteComponent

	private String name;
	
	public Person(){
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public void show(){
		System.out.println("装扮的" + name);
	}
}
