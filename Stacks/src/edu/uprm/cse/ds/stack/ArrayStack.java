package edu.uprm.cse.ds.stack;

public class ArrayStack<T> implements Stack<T> {
	private T[] elements;
	private int top;
	private static final int INIT_CAPACITY = 10;
	

	public ArrayStack() {
		this.top = 0;
		this.elements = (T[]) new Object[INIT_CAPACITY];
	}
	@Override
	public int size() {
		return this.top;
	}

	@Override
	public boolean isEmpty() {
		return this.size() ==0;
	}

	@Override
	public T top() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.elements[this.top -1];
		}
	}

	@Override
	public T pop() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			T result = this.top();
			this.elements[this.top-1] = null;
			top--;
			// this.elements[--top] = null;
			return result;
		}
	}

	@Override
	public void push(T e) {
		if (this.size() == this.elements.length) {
			reallocate(2*this.size());
		}
		this.elements[this.top++] = e;
	}

	private void reallocate(int n) {
		T[] temp = (T[]) new Object[n];
		for (int i=0; i < this.size(); ++i) {
			temp[i] = this.elements[i];
		}
		this.elements= temp;
		
	}
	@Override
	public void makeEmpty() {
		while (!(this.pop() == null));

	}

}
