package com.xudong.BigTalk.DesignPattern.Command;

public class TestCommand {

	public static void main(String[] args) {
		Receiver re = new Receiver();
		Command c = new ConcreteCommand(re);
		Invoker i = new Invoker();
		i.setCommand(c);
		i.executeCommand();
	}
}
