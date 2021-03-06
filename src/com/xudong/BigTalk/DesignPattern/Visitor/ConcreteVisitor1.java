package com.xudong.BigTalk.DesignPattern.Visitor;

public class ConcreteVisitor1 extends Visitor {

	@Override
	public void visitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA.getClass().getName() + "被" + this.getClass().getName() + "访问！");
	}

	@Override
	public void visitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB.getClass().getName() + "被" + this.getClass().getName() + "访问！");
	}

}
