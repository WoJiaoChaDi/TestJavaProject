package com.xudong.BigTalk.DesignPattern.Facade;

import org.junit.Test;

public class Facade {

	SubSystem1 sys1;
	SubSystem2 sys2;
	SubSystem3 sys3;
	
	public Facade(){
		sys1 = new SubSystem1();
		sys2 = new SubSystem2();
		sys3 = new SubSystem3();
	}
	
	public void methodA(){//方案A
		sys1.method1();
		sys2.method2();
		sys3.method3();
	}
	
	public void methodB(){//方案B
		sys1.method1();
		sys3.method3();
	}
	
	@Test
	public void Test(){
		Facade facade = new Facade();
		System.out.println("方案A:");
		facade.methodA();
		System.out.println("方案B:");
		facade.methodB();
	}
}
