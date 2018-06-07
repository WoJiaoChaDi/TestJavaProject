package com.xudong.BigTalk.DesignPattern.ChainOfResponsibility;

/**
 * ConcreteHandler类，具体处理者类，处理它所负责的请求，可访问他的后继者，如果可处理该请求，就处理之，否则就将该请求转发给它的后继者
 * ConcreteHandler2，当请求数在10-20之间则有权处理，否则转移到下一位
 * @author XuDong
 *
 */
public class ConcreteHandler3 extends Handler {

	@Override
	public void handleRequest(int request) {
		
		if(request >= 20 && request < 30){
			System.out.println(this.getClass().getName() + "处理请求" + request);
		}else if(successor != null){
			successor.handleRequest(request);//转移到下一位
		}else{
			System.out.println("我已经抵达链条的末端，无人处理！");
		}
	}

}
