package com.xudong.BigTalk.DesignPattern.AbstractFactory;

import java.lang.reflect.Constructor;

/**
 * 简单工厂模式 + 反射 
 * @author XuDong
 *
 */
public class SimpleFactoryReflect {

	private static final String db = "Sqlserver";
//	private static final String db = "Oracel";
	
	/*
	 * 通过使用反射，简单工厂模式中不需要进行case的判断
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static IUser createUser() throws Exception{
		
		Class clazz = Class.forName("com.xudong.BigTalk.DesignPattern.AbstractFactory." + db + "User"); 
		Constructor con = clazz.getConstructor();
		return (IUser)con.newInstance();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static IDepartment createDepartment() throws Exception{
		Class clazz = Class.forName("com.xudong.BigTalk.DesignPattern.AbstractFactory." + db + "Department"); 
		Constructor con = clazz.getConstructor();
		return (IDepartment)con.newInstance();
	}
	
}
