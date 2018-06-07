package com.xudong.BigTalk.DesignPattern.ChainOfResponsibility;

public class TestChainOfResponsibility {

	public static void main(String[] args) {
		
		Handler h1 = new ConcreteHandler1();
		Handler h2 = new ConcreteHandler2();
		Handler h3 = new ConcreteHandler3();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		
		int[] requests = {2, 5, 14, 50, 22, 18, 3, 27, 20};//50这个请求到了链的末端也没有后继者处理了
		
		for (int request : requests) {
			h1.handleRequest(request);
		}
	}
}
