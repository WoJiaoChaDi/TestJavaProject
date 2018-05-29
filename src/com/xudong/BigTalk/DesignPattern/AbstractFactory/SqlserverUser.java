package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class SqlserverUser implements IUser {

	@Override
	public void insertUser(User user) {
		System.out.println("在SQL Server中给User新增一天记录");
	}

	@Override
	public void getUser(int id) {
		System.out.println("在SQL Server中根据ID得到User表的一条记录");
	}

}
