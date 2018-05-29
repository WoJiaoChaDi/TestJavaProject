package com.xudong.BigTalk.DesignPattern.Adapter;

public class Adapter extends Player {
	
	ForeignCenter foreignCenter = new ForeignCenter();
	
	public Adapter(String name) {
		super(name);
		foreignCenter.setName(name);
	}

	@Override
	public void attack() {
		foreignCenter.aaaaaattack();
	}

	@Override
	public void defense() {
		foreignCenter.ddddddefense();
	}

}
