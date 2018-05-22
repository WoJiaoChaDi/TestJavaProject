package com.xudong.BigTalk.DesignPattern.SimpleFacroty;

public class OperatorAdd extends AbstractOperator{

	@Override
	protected double operator() {
		return getVar_a() + getVar_b();
	}

}
