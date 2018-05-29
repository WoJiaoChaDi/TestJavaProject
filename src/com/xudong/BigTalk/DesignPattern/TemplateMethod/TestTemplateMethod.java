package com.xudong.BigTalk.DesignPattern.TemplateMethod;

public class TestTemplateMethod {

	public static void main(String[] args) {
		
		AbstractClass concreteA = new ConcreteClassA();
		concreteA.templateMethod();
		
		AbstractClass concreteB = new ConcreteClassB();
		concreteB.templateMethod();
	}
}
