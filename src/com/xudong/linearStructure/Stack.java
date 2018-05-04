package com.xudong.linearStructure;



/**
 * 栈
 * @author    XuDong
 * @version   V1.0 2018年3月20日
 */
public class Stack {

	private Object[] date = null;
	private int top = -1;
	private int maxSize = 0;
	
	public Stack(int max) throws Exception {
		if(max < 0){
			throw new Exception("初始化必须大于0！");
		}
		if(max >= 0){
			date = new Object[max];
			top = -1;
			maxSize = max;
		}
	}
	
	public boolean isEmpty(){
		return top == -1 ? true : false;
	}
	
	public boolean isMax(){
		return top == maxSize-1 ? true : false;
	}
	
	public Object peek() throws Exception{
		if(isEmpty()){
			throw new Exception("栈为空！");
		}
		return date[top];
	}
	
	public Object pop() throws Exception{
		if(isEmpty()){
			throw new Exception("栈为空,无法出栈！");
		}
		Object o = date[top];
		top--;
		return o;
	}
	
	public void push(Object element) throws Exception{
		if(isMax()){
			throw new Exception("栈为满了！");
		}
		top++;
		date[top] = element;
	}
	
	public void display(){
		System.out.println("bottom to top:|");
		for (int i = 0; i <= top; i++) {
			System.out.print(date[i] + "|");
		}
		System.out.println();
	}
	
	public int search(Object element) throws Exception{
		
		if(isEmpty()){
			throw new Exception("查询的时候发现栈为空！");
		}
		int tempTop = top;
		while(top != -1){
			if(peek().equals(element)){
				int index =  top;
				top = tempTop;
				return index;
			}
			top--;
		}
		
		return -1;
	}
	
}
