package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class TestSimpleFactoryReflectConfig {

	public static void main(String[] args) throws Exception {
		
		/*
		 * 简单工厂模式 + 反射 + 配置文件
		 * 对客户端进行解耦，客户端不需要关注是SQLServer还是Oracel
		 */
		
		User user = new User();
		IUser iuser = SimpleFactoryReflectConfig.createUser();
		iuser.insertUser(user);
		iuser.getUser(1);
		
		Department department = new Department();
		IDepartment iDepartment = SimpleFactoryReflectConfig.createDepartment();
		iDepartment.insertDepartment(department);
		iDepartment.getDepartment(2);
		
	}
}
