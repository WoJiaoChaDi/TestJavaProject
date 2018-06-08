package com.xudong.BigTalk.DesignPattern.Visitor;

public class ConcreteElementB extends Element {

	@Override
	public void accept(Visitor visitor) {
		visitor.visitConcreteElementB(this);
	}

	public void operationA(){//其他的相关方法
		
	}

}
