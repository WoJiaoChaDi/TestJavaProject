package com.xudong.BigTalk.DesignPattern.Command;

public class ConcreteCommand extends Command {

	public ConcreteCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		super.receiver.action();
	}

}
