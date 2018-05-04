package com.xudong.algorithmic;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,11,13,16,2,3,5,7,11,12,13,44,45,47,48};
//		int[] temp = sort(arr, 0, 7, arr.length-1, new int[arr.length]);
		int[] temp = sort(arr);
		
		//输出
	    List list = new ArrayList();
		for (int i = 0; i < temp.length; i++) {
			list.add(temp[i]);
		}
		System.out.println(list);
	}
	
	public static int[] sort(int[] arr){
		
		int temp;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]){
				temp = arr[i];
				int j = i-1;
				while(j>0 && (temp < arr[j])){
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j+1] = temp;
			}
		}
		
		return arr;
		
	}
	
	

	
}
