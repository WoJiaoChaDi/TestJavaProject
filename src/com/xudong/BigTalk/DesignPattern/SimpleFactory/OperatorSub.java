package com.xudong.BigTalk.DesignPattern.SimpleFactory;

public class OperatorSub extends AbstractOperator{

	@Override
	protected double operator() {
		return getVar_a()-getVar_b();
	}

}
