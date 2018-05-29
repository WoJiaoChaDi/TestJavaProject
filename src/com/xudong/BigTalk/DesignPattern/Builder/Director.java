package com.xudong.BigTalk.DesignPattern.Builder;

import org.junit.Test;

public class Director {

	public void construct(Builder builder){
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}
	
	@Test
	public void Test(){
		Director director = new Director();
		Builder b1= new ConcreteBuilder1();
		Builder b2= new ConcreteBuilder2();
		
		director.construct(b1);
		Product p1 = b1.getProduct();
		p1.show();
		
		director.construct(b2);
		Product p2 = b2.getProduct();
		p2.show();
	}
}
