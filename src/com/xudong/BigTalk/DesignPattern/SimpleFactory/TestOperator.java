package com.xudong.BigTalk.DesignPattern.SimpleFactory;

public class TestOperator{

	public static void main(String[] args) {
		
		AbstractOperator opertor = FactoryOperator.getOpertor("+");
		opertor.setVar_a(5);
		opertor.setVar_b(9);
		System.out.println(opertor.operator());
		
		opertor = FactoryOperator.getOpertor("-");
		opertor.setVar_a(5);
		opertor.setVar_b(9);
		System.out.println(opertor.operator());
	}

}
