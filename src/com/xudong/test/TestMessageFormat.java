package com.xudong.test;

import java.text.MessageFormat;

public class TestMessageFormat {

	public static void main(String[] args) {
		
		String msg = "abcde{0},{1},{2}";
		String msg1 = MessageFormat.format(msg, "一", "二", "三");
		String[] strarr = {"1", "2", "3"};
		String msg2 = MessageFormat.format(msg, strarr);
		System.out.println(msg1);
		System.out.println(msg2);

	}
	
	
}
