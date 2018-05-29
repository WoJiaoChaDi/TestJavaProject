package com.xudong.BigTalk.DesignPattern.SimpleFactory;

public class FactoryOperator{

	public static AbstractOperator getOpertor(String opertor){
		
		AbstractOperator opt = null;
		switch (opertor) {
		case "+":
			opt = new OperatorAdd();
			break;
		case "-":
			opt = new OperatorSub();
			break;
//		case "*":
//			
//			break;
//		case "/":
//			
//			break;
		default:
			break;
		}
		
		return opt;
	}

}
