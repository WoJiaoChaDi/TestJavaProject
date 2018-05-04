package com.xudong.algorithmic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;


/**
 * 算法
 * @author    XuDong
 * @version   V1.0 2018年3月20日
 */
public class Algorithmic {

	/**
	 * 青蛙台阶问题
	 * @Title getStep_Traverse
	 * @param n	总台阶数
	 * 青蛙一次走一步或者两步，台阶有n阶，一共有多少种走法
	 */
	
	/**
	 * 1.用递归
	 * 此方法的：
	 * 时间复杂度 O(2^N)  -->递归深度，有2^N次计算
	 * @return
	 */
	public int getStep_Traverse_v1(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		int value_1 = getStep_Traverse_v1(n-1);//获取差1步走完的方法数目
		int value_2 = getStep_Traverse_v1(n-2);//获取差2步走完的方法数目
		int value = value_1 + value_2;
		return value;
	}
	
	/**
	 * 
	 * 2.带备忘递归
	 * 此方法的：
	 * 时间复杂度:O(N)	--->有N次计算
	 * 空间复杂度:O(N)	--->有N个结果需要存储
	 * @Title getStep_Traverse_v2
	 * @return
	 */
	public int getStep_Traverse_v2(int n, HashMap<Integer, Integer> map){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		
		if(map.containsKey(n)){
			return map.get(n);
		}else{
			int value_1 = getStep_Traverse_v1(n-1);//获取差1步走完的方法数目
			int value_2 = getStep_Traverse_v1(n-2);//获取差2步走完的方法数目
			int value = value_1 + value_2;
			return value;
		}
	}
	
	/**
	 * 3.动态规划求解
	 * 时间复杂度：O(N)
	 * 空间复杂度：N(1)
	 * @Title getStep_Traverse_v3
	 * @param n
	 * @return
	 */
	public int getStep_Traverse_v3(int n){
		int a = 1;//走1阶台阶的方法数
		int b = 2;//走2阶台阶的方法数
		int count = 0;
		
		for(int i = 3; i <= n ; i++){
			count = a + b;//走i阶台阶时，有上两种台阶方法之和
			a = b;//将差2阶台阶的方法数量a,重新赋值
			b = count;//将差1阶台阶的方法数量b,重新赋值
		}
		return count;
	}
	
	/**
	 * 二分搜索
	 * 给出一个有序数组scrArray以及一个目标值des，要求返回scrArray在数组中的位置，若数组里不存在des，则返回-1
	 * @Title binarySearch
	 * @param scrArray
	 * @param des
	 * @return
	 */
	public Integer binarySearch(Integer[] scrArray, int des){
		int low = 0;
		int high = scrArray.length - 1;
		
		while(low <= high){
			int mid = (low + high) >>> 1;
			if( des == scrArray[mid]){
				return mid;
			}else if( des < scrArray[mid]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return -1;
	}
	
	
	@Test
	public void Test(){
		
		//青蛙台阶
		//迭代法
//		int step = 45;
//		long v1_s = System.currentTimeMillis();
//		System.out.println(getStep_Traverse_v1(step));
//		long v1_e = System.currentTimeMillis();
//		System.out.println("迭代法：" + (v1_e - v1_s));
//		
		//迭代备忘录法
//		long v2_s = System.currentTimeMillis();
//		System.out.println(getStep_Traverse_v2(step, new HashMap()));
//		long v2_e = System.currentTimeMillis();
//		System.out.println("迭代备忘录法：" + (v2_e - v2_s));
//		
		//动态规划法
//		long v3_s = System.currentTimeMillis();
//		System.out.println(getStep_Traverse_v3(step));
//		long v3_e = System.currentTimeMillis();
//		System.out.println("动态规划法：" + (v3_e - v3_s));
		
		//二分法
//		Integer[] scrArray = {1,3,5,7,9,11,13,15,17};
//		System.out.println(binarySearch(scrArray, 7));
		
	}
}
