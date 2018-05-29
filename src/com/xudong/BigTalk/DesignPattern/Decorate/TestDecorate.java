package com.xudong.BigTalk.DesignPattern.Decorate;

public class TestDecorate {

	public static void main(String[] args) {
		
		Person person = new Person("小菜");
		
		System.out.println("1---->:");
		
		Fin_BigTrouser bigTrouser = new Fin_BigTrouser();
		Fin_Cap cap = new Fin_Cap();
		Fin_Shoes shoes = new Fin_Shoes();
		Fin_TShirts tShirts = new Fin_TShirts();
		
		bigTrouser.decorate(person);//1.将垮裤装饰给人
		cap.decorate(bigTrouser);//2.将帽子装饰给垮裤
		shoes.decorate(cap);//3.将鞋子装饰给帽子
		tShirts.decorate(shoes);//4.将T恤装饰给鞋子
		tShirts.show();//T恤动作，然后找T恤是否有4.装饰器装饰的的对象鞋子，然后执行鞋子动作，再找鞋子是否有3.装饰器装饰的帽子....
		
	}
}
