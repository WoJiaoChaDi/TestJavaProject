package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class TestFactoryMethod {

	public static void main(String[] args) {
		
		/*
		 * 工厂方法模式
		 * 
		 */
		
		User user = new User();
		IFactory factory = new SqlserverFactory();//如果需要更改数据库类型，只需更改这句  IFactory factory = new OracelFactory();
		IUser iuser = factory.createUser();
		iuser.insertUser(user);
		iuser.getUser(1);
		
		Department department = new Department();
		IDepartment iDepartment = factory.createDepartment();
		iDepartment.insertDepartment(department);
		iDepartment.getDepartment(2);
	}

}
