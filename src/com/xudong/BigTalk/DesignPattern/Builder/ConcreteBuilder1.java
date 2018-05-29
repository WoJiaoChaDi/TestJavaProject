package com.xudong.BigTalk.DesignPattern.Builder;

public class ConcreteBuilder1 extends Builder{

	private Product product = new Product();
	
	@Override
	public void buildPartA() {
		product.add("部件A");
	}

	@Override
	public void buildPartB() {
		product.add("部件B");
	}

	@Override
	public void buildPartC() {
		product.add("部件C");
	}

	@Override
	public Product getProduct() {
		return product;
	}

}
