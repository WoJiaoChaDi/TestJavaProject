package com.xudong.BigTalk.DesignPattern.SimpleFacroty;

public class TestOperator{

	public static void main(String[] args) {
		
		AbstractOperator opertor = OperatorFactory.getOpertor("+");
		opertor.setVar_a(5);
		opertor.setVar_b(9);
		System.out.println(opertor.operator());
		
		opertor = OperatorFactory.getOpertor("-");
		opertor.setVar_a(5);
		opertor.setVar_b(9);
		System.out.println(opertor.operator());
	}

}
