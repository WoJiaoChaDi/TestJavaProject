package com.xudong.BigTalk.DesignPattern.Flyweight;

public class TestFlyweight {

	public static void main(String[] args) {
		
		int extrinsicstate = 22;//代码外部状态
		
		FlyweightFactory fac = new FlyweightFactory();
		
		Flyweight fx = fac.getFlyweight("X");
		fx.operation(--extrinsicstate);
		
		Flyweight fy = fac.getFlyweight("Y");
		fy.operation(--extrinsicstate);
		
		Flyweight fz = fac.getFlyweight("Z");
		fz.operation(--extrinsicstate);
		
		UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
		
		uf.operation(--extrinsicstate);
		
	}
}
