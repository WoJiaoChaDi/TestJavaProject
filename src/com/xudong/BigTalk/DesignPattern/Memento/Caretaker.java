package com.xudong.BigTalk.DesignPattern.Memento;

import org.junit.Test;

/**
 * 管理者
 * @author XuDong
 *
 */
public class Caretaker {

	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	@Test
	public void test(){
		Originator originator = new Originator();
		System.out.println("战斗前：");
		originator.setState("状态：良好");
		originator.setHealth("健康值：100");
		originator.setAttack("攻击力：56");
		originator.setTime("游戏时长：10h");
		originator.show();
		
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(originator.createMemento());//保存状态，由于有了很好的封装，可以隐藏Originator的实现细节
		
		System.out.println();
		System.out.println("经历战斗后：");
		originator.setState("状态：死亡边缘");
		originator.setHealth("健康值：1");
		originator.setAttack("攻击力：1");
		originator.setTime("游戏时长：12h");
		originator.show();
		
		System.out.println();
		System.out.println("重新读档：");
		originator.setMemento(caretaker.getMemento());
		originator.show();
		
	}
}
