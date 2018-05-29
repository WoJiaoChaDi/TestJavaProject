package com.xudong.BigTalk.DesignPattern.FactoryMethod;

public class FactorySub implements IOperratorFactory{

	@Override
	public AbstractOperator createOperator() {
		return new OperatorSub();
	}

}
