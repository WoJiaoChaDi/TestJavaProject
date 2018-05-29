package com.xudong.BigTalk.DesignPattern.Builder;

public class ConcreteBuilder2 extends Builder{

	private Product product = new Product();
	
	@Override
	public void buildPartA() {
		product.add("部件X");
	}

	@Override
	public void buildPartB() {
		product.add("部件Y");
	}

	@Override
	public void buildPartC() {
		product.add("部件Z");
	}

	@Override
	public Product getProduct() {
		return product;
	}

}
