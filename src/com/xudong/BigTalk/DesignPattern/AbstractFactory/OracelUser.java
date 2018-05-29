package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class OracelUser implements IUser {

	@Override
	public void insertUser(User user) {
		System.out.println("在Oracel中给User新增一天记录");
	}

	@Override
	public void getUser(int id) {
		System.out.println("在Oracel中根据ID得到User表的一条记录");
	}

}
