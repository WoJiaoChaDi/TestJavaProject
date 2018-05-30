package com.xudong.BigTalk.DesignPattern.Singleton;


public class TestSingleton_Lazy {

	public static void main(String[] args) {
		
//		Singleton s0 = new Singleton();//因为是私有的构造方法，所以不能new
		
		Singleton_Lazy s1 = Singleton_Lazy.getInstance();
		Singleton_Lazy s2 = Singleton_Lazy.getInstance();
		if(s1 == s2){
			System.out.println("s1、s2两个对象是相同的实例。");
		}
	}

}
