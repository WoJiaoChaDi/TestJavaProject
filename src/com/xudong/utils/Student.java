package com.xudong.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Student {

	private String name;
	private int age;
	private Timestamp lastmoddate;
	private BigDecimal money;
	private List<Student> borther;
	
	public Student(){
		
	}
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getLastmoddate() {
		return lastmoddate;
	}
	public void setLastmoddate(Timestamp lastmoddate) {
		this.lastmoddate = lastmoddate;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public List<Student> getBorther() {
		return borther;
	}
	public void setBorther(List<Student> borther) {
		this.borther = borther;
	}
	
	
}
