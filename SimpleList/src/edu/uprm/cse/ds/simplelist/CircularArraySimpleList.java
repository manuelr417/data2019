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
		if (this.isEmpty()) {
			return null;
		}
		else {
			T result = this.elements[this.firstPosition];
			this.elements[this.firstPosition] = null;
			this.firstPosition = this.nextPosition(this.firstPosition);
			this.size--;
			return result;
		}
	}

	@Override
	public T removeLast() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			T result = this.elements[this.lastPosition];
			this.elements[this.lastPosition] = null;
			this.lastPosition = this.previousPosition(this.lastPosition);
			this.size--;
			return result;
		}
	}
	
	private int nextPosition(int i) {
		return (i + 1) % this.elements.length; 
	}
	
	private int previousPosition(int i) {
		return (i + this.elements.length - 1) % this.elements.length;
	}
	
	private void changeCapacity(int newCapacity) {
		T [] temp = (T[]) new Object[newCapacity];
		
		//int j = this.firstPosition;
		for (int i=0, j = this.firstPosition; i < this.size(); 
				++i, j = this.nextPosition(j)) {
			temp[i] = this.elements[j];
			//j = this.nextPosition(j);
		}
		this.elements = temp;
	}
}



