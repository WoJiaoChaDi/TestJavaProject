package com.xudong.BigTalk.DesignPattern.PublishSubscribe;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	
	//新增观察者
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	//移除观察者
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	//通知
	public void notifyMethod(){
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
