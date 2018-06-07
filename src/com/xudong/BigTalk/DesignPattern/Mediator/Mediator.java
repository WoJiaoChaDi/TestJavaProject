package com.xudong.BigTalk.DesignPattern.Mediator;

public abstract class Mediator {

	//定义一个抽象的发送消息方法，得到同事对象和发送信息
	public abstract void send(String message, Colleague colleague);
}
