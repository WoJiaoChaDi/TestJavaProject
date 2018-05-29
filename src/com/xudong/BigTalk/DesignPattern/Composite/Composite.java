package com.xudong.BigTalk.DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

	private List<Component> children = new ArrayList<Component>();
	
	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		children.add(c);
	}

	@Override
	public void remove(Component c) {
		children.remove(c);
	}

	@Override
	public void display(int depth) {
		String str = "";
		for (int i = 0; i < depth; i++) {
			str += "-";
		}
		System.out.println(str + name);
		
		for (Component component : children) {
			component.display(depth + 2);
		}
	}

}
