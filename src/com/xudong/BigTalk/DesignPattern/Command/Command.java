package com.xudong.BigTalk.DesignPattern.Command;

public abstract class Command {

	protected Receiver receiver;
	
	public Command(Receiver receiver){
		this.receiver = receiver;
	}
	
	public abstract void execute();
}
