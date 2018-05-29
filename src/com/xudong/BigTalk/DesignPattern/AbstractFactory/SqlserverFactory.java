package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class SqlserverFactory implements IFactory {
	
	@Override
	public IUser createUser() {
		return new SqlserverUser();
	}

	@Override
	public IDepartment createDepartment() {
		return new SqlserverDepartment();
	}

}
