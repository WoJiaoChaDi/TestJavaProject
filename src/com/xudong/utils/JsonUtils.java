package com.xudong.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	@Test
	public void Test() throws IOException{
		
		List stuList = new ArrayList();
		Student stu1 = new Student("李四", 12);
		stuList.add(stu1);
		Student stu2 = new Student("王五", 14);
		stuList.add(stu2);
		
		Student stu = new Student("张三", 12);
		stu.setName("张三");
		stu.setAge(12);
		stu.setMoney(new BigDecimal(2211448.01));
//		stu.setLastmoddate(new Timestamp(System.currentTimeMillis()));
		stu.setBorther(stuList);
		
		System.out.println("\n---JSONObject---");
		//java对象
		//转json对象，最外层是{}
		String content_jsob = JSONObject.fromObject(stu).toString();
		System.out.println("JSONObject转json-->" + content_jsob);
		
		//转json数组，最外层套上[]
		String content_jsar = JSONArray.fromObject(stu).toString();
		System.out.println("JSONArray转json-->" + content_jsar);
		
		//转json对象，最外层是{}
		String content_jsser = JSONSerializer.toJSON(stu).toString();
		System.out.println("JSONSerializer转json-->" + content_jsser);
		
		//json字符串转java对象
		JSONObject obj = JSONObject.fromObject(content_jsob);
		//json字符串转Map
		Map stuMap = (Map) JSONObject.toBean(obj, Map.class);//使用JSONObject.toBean，需要对象有空的构造方法
		System.out.println("JSONObject转Map-->" + stuMap);
		//json字符串转Bean
		Student stuObj = (Student) JSONObject.toBean(obj, Student.class);//使用JSONObject.toBean，需要对象有空的构造方法
		System.out.println("JSONObject转Bean-->" + stuObj.getName());
		
		//json字符串转List的java对象
		JSONArray array = JSONArray.fromObject(content_jsar);
		List<Student> stuJsonList = (List<Student>)JSONArray.toCollection(array,Student.class);//使用JSONObject.toCollection，需要对象有空的构造方法
		System.out.println("JSONArray转List<Bean>-->" + stuJsonList.get(0).getName());

		//-----------ObjectMapper-----------
		System.out.println("\n---ObjectMapper---");
		ObjectMapper mapper = new ObjectMapper();
		//java对象转json字符串
		String stu_cont = mapper.writeValueAsString(stu);
		System.out.println("ObjectMapper转json-->" + stu_cont);
		//javaList转json字符串
		String stuList_cont = mapper.writeValueAsString(stuList);
		System.out.println("ObjectMapper转json-->" + stuList_cont);
		
		//json字符串转Map
		Map omStuMap = mapper.readValue(stu_cont, Map.class);
		System.out.println("ObjectMapper转Map-->" + omStuMap);
		//json字符串转Bean
		Student omStuBean = mapper.readValue(stu_cont, Student.class);
		System.out.println("ObjectMapper转Beam-->" + omStuBean.getName());
		
		//json字符串转List<Bean>
		List<Map> stuListMap =mapper.readValue(stuList_cont, new TypeReference<List<Map>>(){});
		System.out.println("ObjectMapper转List<Map>-->" + stuListMap);
		List<Student> stuListBean =mapper.readValue(stuList_cont, new TypeReference<List<Student>>(){});
		System.out.println("ObjectMapper转List<Beam>-->" + stuListBean);
		
	}

}