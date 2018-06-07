package com.xudong.BigTalk.DesignPattern.ChainOfResponsibility;

public abstract class Handler {

	protected Handler successor;
	
	public void setSuccessor(Handler successor){//设置继承者
		this.successor = successor;
	}
	
	public abstract void handleRequest(int request);//处理请求的抽象方法
}
