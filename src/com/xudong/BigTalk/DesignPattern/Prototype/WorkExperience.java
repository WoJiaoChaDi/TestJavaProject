package com.xudong.BigTalk.DesignPattern.Prototype;

public class WorkExperience implements Cloneable{
	
	private String workDate;
	private String company;
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();//object的clone方法
		return obj;		
	}
	
}
