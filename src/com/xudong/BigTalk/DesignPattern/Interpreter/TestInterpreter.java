package com.xudong.BigTalk.DesignPattern.Interpreter;

import java.util.ArrayList;
import java.util.List;

public class TestInterpreter {

	public static void main(String[] args) {
		
		Context context = new Context();
		List<AbstractExpression> list = new ArrayList<AbstractExpression>();
		list.add(new TerminalExpression());
		list.add(new NonterminalExpression());
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		list.add(new TerminalExpression());
		
		for (AbstractExpression exp : list) {
			exp.interpret(context);
		}
	}
}
