package com.xudong.BigTalk.DesignPattern.TemplateMethod;

public abstract class AbstractClass {

	public abstract void primitiveOperation1();//抽象行为1
	public abstract void primitiveOperation2();//抽象行为2
	
	public void templateMethod(){//模板方法，给出逻辑的框架，逻辑的组成是一些相应的抽象操作，他们都推迟到子类实现
		primitiveOperation1();
		primitiveOperation2();
	}
	
}
