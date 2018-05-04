package com.xudong.algorithmic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.xudong.linearStructure.Stack;

public class TestStack {

	private static Stack stack = null;
	
	@Before
	public void setUp() throws Exception {
		stack = new Stack(10);
	}

	@Test
	public void test() throws Exception {
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(6);
		stack.push(77);
		
		stack.display();
		
		System.out.println(stack.search(1));
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
	}

}
