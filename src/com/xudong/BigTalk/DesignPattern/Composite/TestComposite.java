package com.xudong.BigTalk.DesignPattern.Composite;

public class TestComposite {

	public static void main(String[] args) {
		
		Component root = new Composite("root");
		root.add(new Leaf("Leaf A"));
		root.add(new Leaf("Leaf B"));
		
		Component comp = new Composite("Composite X");
		Component comp2 = new Composite("Composite XY");
		comp2.add(new Leaf("Leaf XYA"));
		comp2.add(new Leaf("Leaf XYB"));
		comp.add(comp2);
		
		comp.add(new Leaf("Leaf XA"));
		comp.add(new Leaf("Leaf XB"));
		root.add(comp);
		
		root.add(new Leaf("Leaf C"));
		Component leafD = new Leaf("Leaf D");
		root.add(leafD);
		root.remove(leafD);
		
		root.display(1);
	}
}
