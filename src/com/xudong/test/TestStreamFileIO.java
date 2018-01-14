package com.xudong.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestStreamFileIO {

	public static void main(String[] args) throws IOException {
		
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.toString();
		do {
			c = (char) br.read();
			System.out.println("this is:" + c);
		}while(c != 'q');
	
		System.out.println(666);
	}
}
