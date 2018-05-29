package com.xudong.BigTalk.DesignPattern.FactoryMethod;

public class FactoryAdd implements IOperratorFactory{

	@Override
	public AbstractOperator createOperator() {
		return new OperatorAdd();
	}

}
