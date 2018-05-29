package com.xudong.BigTalk.DesignPattern.Prototype;


public class Resume implements Cloneable{

	private String name;
	private WorkExperience work;
	
	public Resume(String name){
		this.name = name;
		this.work = new WorkExperience();
	}
	
	public void setWorkExperience(String workDate, String company){
		this.work.setWorkDate(workDate);
		this.work.setCompany(company);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		/*
		 * 浅克隆
		 */
//		return super.clone();
		
		/*
		 * 深克隆
		 */
		Object obj = super.clone();//object的clone方法
		Resume resume = (Resume) obj;
		resume.work = (WorkExperience) this.work.clone();//对象属性也进行克隆，实现深克隆   没有这句，就是浅克隆
		return resume;
	}

	@Override
	public String toString() {
		return "Resume [name=" + name + ", work=" + work.getWorkDate() + "," + work.getCompany() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
