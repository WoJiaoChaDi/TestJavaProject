package com.xudong.function;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static void main(String[] args) {
	/**
	 * 等待线程结束后，再往下执行
	 *	 		
	 */
		long startTime = System.currentTimeMillis();
		
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		//此行开始执行线程
		Future<Map> future = threadPool.submit(new Callable<Map>(){

			@Override
			public Map call() throws Exception {
				Map resultMap = new HashMap();//返回值
				Thread.sleep(5000);//做一些事情
				resultMap.put("success", true);
				return resultMap;
			}
			
		});
		
		try {
			Thread.sleep(1000);//做一些事情
			//如果有调用future.get()，那么线程会等待#正在执行的future线程，直到future执行完#才继续往下执行
			System.out.println(future.get());//等待线程结束
			
			long endTime = System.currentTimeMillis();
			System.out.println("总时间:" + (endTime - startTime));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
