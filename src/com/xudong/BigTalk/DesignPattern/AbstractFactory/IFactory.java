package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public interface IFactory {

	public IUser createUser();
	
	public IDepartment createDepartment();
}
