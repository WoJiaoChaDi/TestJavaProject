package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class OracelFactory implements IFactory {

	@Override
	public IUser createUser() {
		return new OracelUser();
	}
	
	@Override
	public IDepartment createDepartment() {
		return new OracelDepartment();
	}

}
