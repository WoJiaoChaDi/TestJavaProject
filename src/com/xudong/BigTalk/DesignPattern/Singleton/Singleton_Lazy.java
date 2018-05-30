package com.xudong.BigTalk.DesignPattern.Singleton;


/**
 * 双重锁线程安全的懒汉式，在需要的时候才
 * @author XuDong
 *
 */
public class Singleton_Lazy {

	private static Singleton_Lazy instance;
	
	/**
	 *构造方法让其private，这就堵死了外界利用 
	 */
	private Singleton_Lazy(){
		
	}
	
	/**
	 * 此方法是获得本类实例的唯一全局访问点
	 * @return
	 */
	public static Singleton_Lazy getInstance(){//第一次被引用的时候，才会将自己实例化，所以是懒汉模式（懒汉模式需要面临多线程访问的安全性，需要双重锁定才能保证安全）
		
		if(instance == null){
			synchronized (Singleton_Lazy.class) {
				if(instance == null){
					instance = new Singleton_Lazy();
				}
			}
		}
		
		return instance;
	}
	
	/*
	 *双重校验锁法会有怎样的情景：
	 *STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。
	 *STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。
	 *STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。
	 *STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。
	 *STEP 5. 线程A初始化并获取到了单例实例并返回，线程B获取了在线程A中初始化的单例。
	 *理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
	 */
		
}
