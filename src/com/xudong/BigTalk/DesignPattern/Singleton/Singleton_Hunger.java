package com.xudong.BigTalk.DesignPattern.Singleton;

/**
 * 饿汉式，相比静态类多了一个内存常驻而已，在运行这个类的时候进行一次loading
 * @author XuDong
 *
 */
public class Singleton_Hunger {

	private static Singleton_Hunger instance = new Singleton_Hunger();
	private Singleton_Hunger(){
		
	}
	
	public static Singleton_Hunger getInstance(){
		return instance;
	}
}
