package com.xudong.BigTalk.DesignPattern.PublishSubscribe;

public class ConcreteSubject extends Subject{

	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
	}
	
}
