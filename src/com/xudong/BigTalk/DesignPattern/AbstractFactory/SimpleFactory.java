package com.xudong.BigTalk.DesignPattern.AbstractFactory;

/**
 * 简单工厂模式
 * @author XuDong
 *
 */
public class SimpleFactory {

	private static final String db = "Sqlserver";
//	private static final String db = "Oracel";
	
	public static IUser createUser(){
		IUser result = null;
		switch (db) {
		case "Sqlserver":
			result = new SqlserverUser();
			break;

		case "Oracel":
			result = new OracelUser();
			break;
		}
		
		return result;
	}
	
	public static IDepartment createDepartment(){
		IDepartment result = null;
		switch (db) {
		case "Sqlserver":
			result = new SqlserverDepartment();
			break;
			
		case "Oracel":
			result = new OracelDepartment();
			break;
		}
		
		return result;
	}
	
}
