package com.xudong.BigTalk.DesignPattern.FactoryMethod;

public class TestFactoryMethod {

	public static void main(String[] args) {
		
		//与简单工厂模式相比，工厂方法模式新增方法(必须需要添加一个类中没有的乘法)只需要新增乘法类，符合封闭-开放原则，而简单工厂模式需要更改工厂，不符合封闭-开放原则
		IOperratorFactory operAddFactory = new FactoryAdd();
		AbstractOperator operAdd = operAddFactory.createOperator();
		operAdd.setVar_a(1);
		operAdd.setVar_b(2);
		System.out.println(operAdd.operator());
		
		IOperratorFactory operSubFactory = new FactorySub();
		AbstractOperator operSub = operSubFactory.createOperator();
		operSub.setVar_a(1);
		operSub.setVar_b(2);
		System.out.println(operSub.operator());
		
		
		
	}
}
