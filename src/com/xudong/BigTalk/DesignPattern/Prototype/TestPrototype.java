package com.xudong.BigTalk.DesignPattern.Prototype;


public class TestPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Resume resume1 = new Resume("张三");
		resume1.setWorkExperience("1991-12-12", "xx公司");
		Resume resume2 = (Resume) resume1.clone();
		System.out.println(resume1.toString());
		System.out.println(resume2.toString());
		
		/**
		 * 如果字段是值类型，则对该字段执行逐位复制
		 * 如果字段是引用类型，则复制引用但不复制引用对象
		 */
		resume2.setWorkExperience("2007-07-07", "yyyyy公司");//因为复制的是引用，所以改方法赋值的是引用的对象
		System.out.println(resume1.toString());
		System.out.println(resume2.toString());
		
		
	}
}
