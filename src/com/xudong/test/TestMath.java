package com.xudong.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMath {

    public static void main(String[] args){

    	Map retnMap = new HashMap();
		List list = new ArrayList();
		list.add(123456);
		retnMap.put("REFCODES", list);
		retnMap.put("REFGROUPCODE", 555);
		
		Object a = retnMap.get("3432432");
		
		System.out.println(retnMap);
        
    }
}
