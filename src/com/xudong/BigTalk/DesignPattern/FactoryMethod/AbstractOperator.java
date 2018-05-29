package com.xudong.BigTalk.DesignPattern.FactoryMethod;

abstract class AbstractOperator {

	private double var_a;
	private double var_b;
	
	protected abstract double operator(); 
	
	public double getVar_a() {
		return var_a;
	}
	public void setVar_a(double var_a) {
		this.var_a = var_a;
	}
	public double getVar_b() {
		return var_b;
	}
	public void setVar_b(double var_b) {
		this.var_b = var_b;
	}
	
	
	
}
