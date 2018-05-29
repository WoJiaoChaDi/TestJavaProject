package com.xudong.BigTalk.DesignPattern.Composite;

public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		System.out.println("Cannot add to a leaf");
	}

	@Override
	public void remove(Component c) {
		System.out.println("Cannot remove from a leaf");
	}

	@Override
	public void display(int depth) {
		String str = "";
		for (int i = 0; i < depth; i++) {
			str += "-";
		}
		System.out.println( str + name);
	}

}
