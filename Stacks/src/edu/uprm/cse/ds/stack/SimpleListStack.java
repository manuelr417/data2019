package edu.uprm.cse.ds.stack;

import edu.uprm.cse.ds.simplelist.SLLSimpleList;
import edu.uprm.cse.ds.simplelist.SimpleList;

public class SimpleListStack<T> implements Stack<T> {
	private SimpleList<T> list;
	
	public SimpleListStack() {
		this.list = new SLLSimpleList<T>();
	}
	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public T top() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.list.first();
		}
	}

	@Override
	public T pop() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.list.removeFirst();
		}
	}

	@Override
	public void push(T e) {
		this.list.addFirst(e);
	}

	@Override
	public void makeEmpty() {
//		while(!this.isEmpty()) {
//			this.pop();
//		}
		
		while(!(this.pop() == null));
	}

}
