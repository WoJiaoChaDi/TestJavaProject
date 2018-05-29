package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class TestSimpleFactory {

	public static void main(String[] args) {
		
		/*
		 * 简单工厂模式
		 * 对客户端进行解耦，客户端不需要关注是SQLServer还是Oracel
		 */
		
		User user = new User();
		IUser iuser = SimpleFactory.createUser();
		iuser.insertUser(user);
		iuser.getUser(1);
		
		Department department = new Department();
		IDepartment iDepartment = SimpleFactory.createDepartment();
		iDepartment.insertDepartment(department);
		iDepartment.getDepartment(2);
		
	}
}
