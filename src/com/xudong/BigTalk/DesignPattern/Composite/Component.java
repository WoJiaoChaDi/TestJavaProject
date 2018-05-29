package com.xudong.BigTalk.DesignPattern.Composite;

public abstract class Component {

	protected String name;
	
	public Component(String name){
		this.name = name;
	}
	
	public abstract void add(Component c);//add新增树叶树枝
	public abstract void remove(Component c);//remove移除树叶树枝
	public abstract void display(int depth);
}
