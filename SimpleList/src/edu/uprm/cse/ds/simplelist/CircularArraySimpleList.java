package edu.uprm.cse.ds.simplelist;

public class CircularArraySimpleList<T> implements SimpleList<T> {
	
	private T[] elements;
	private int size;
	private int firstPosition;
	private int lastPosition;
	private static final int INITCAP = 10;

	
	public CircularArraySimpleList() {
		this.elements= (T[]) new Object[INITCAP];
		this.size = 0;
		this.firstPosition = this.lastPosition=0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;

	}

	@Override
	public T first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.elements[this.firstPosition];
		}
	}

	@Override
	public T last() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.elements[this.lastPosition];
		}
	}

	@Override
	public void addFirst(T e) {
		if (this.isEmpty()) {
			this.elements[0] = e;
			this.firstPosition = 0;
			this.lastPosition = 0;
			this.size++;
		}
		else {
			if (this.size() == this.elements.length) {
				this.changeCapacity(2* this.elements.length);
			}
			this.firstPosition = this.previousPosition(this.firstPosition);
			this.elements[this.firstPosition] = e;
			this.size++;
		}
	}

	@Override
	public void addLast(T e) {
		if (this.isEmpty()) {
			this.elements[0] = e;
			this.firstPosition = 0;
			this.lastPosition = 0;
			this.size++;
		}
		else {
			if (this.size() == this.elements.length) {
				this.changeCapacity(2* this.elements.length);
			}
			this.lastPosition = this.nextPosition(this.lastPosition);
			this.elements[this.lastPosition] = e;
			this.size++;
		}
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int nextPosition(int i) {
		return (i + 1) % this.elements.length; 
	}
	
	private int previousPosition(int i) {
		return (i + this.elements.length - 1) % this.elements.length;
	}
	
	private void changeCapacity(int newCapacity) {
		T [] temp = (T[]) new Object[newCapacity];
		for (int i=0; i < this.size(); ++i) {
			temp[i] = this.elements[i];
		}
		this.elements = temp;
	}
}



