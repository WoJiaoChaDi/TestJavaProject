package com.xudong.BigTalk.DesignPattern.AbstractFactory;

public class OracelDepartment implements IDepartment {

	@Override
	public void insertDepartment(Department department) {
		System.out.println("在Oracel中给Department新增一天记录");
	}

	@Override
	public void getDepartment(int id) {
		System.out.println("在Oracel中根据ID得到Department表的一条记录");
	}

}
