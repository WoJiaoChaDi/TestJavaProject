package com.xudong.BigTalk.DesignPattern.AbstractFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * 简单工厂模式 + 反射 + 配置文件
 * @author XuDong
 *
 */
public class SimpleFactoryReflectConfig {

	private static String db = "";
	
	static {
		/*
		 * 通过配置文件，不需要重新编译
		 */
		Properties properties = new Properties();
		// 使用InPutStream流读取properties文件
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader("D:/Work/MyJava/Project/TestJavaProject/src/com/xudong/BigTalk/DesignPattern/AbstractFactory/App.properties"));
			properties.load(bufferedReader);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		db = properties.getProperty("DB");
	}
	
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
