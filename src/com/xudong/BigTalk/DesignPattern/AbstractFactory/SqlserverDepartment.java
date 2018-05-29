package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class SqlserverDepartment implements IDepartment {

	@Override
	public void insertDepartment(Department department) {
		System.out.println("在SQL Server中给Department新增一天记录");
	}

	@Override
	public void getDepartment(int id) {
		System.out.println("在SQL Server中根据ID得到Department表的一条记录");
	}

}
