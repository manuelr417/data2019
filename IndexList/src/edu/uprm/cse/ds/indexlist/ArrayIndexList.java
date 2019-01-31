package edu.uprm.cse.ds.indexlist;

public class ArrayIndexList<T> implements IndexList<T> {
	
	private static final int INITCAP = 10;
	private T elements[];
	private int size;
	
	public ArrayIndexList() {
		this.elements= (T[]) new Object[INITCAP];
		this.size = 0;
	}
	public ArrayIndexList(int initCapacity) {
		if (initCapacity < 1) {
			throw new IllegalArgumentException
			("Initial capacity must be at least 1");
		}
		this.elements= (T[]) new Object[initCapacity];
		this.size = 0;
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
	public T get(int index) throws IndexOutOfBoundsException {
		if ((index < 0 ) || (index >= this.size())) {
			throw new IndexOutOfBoundsException();
		}
		return this.elements[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if ((index < 0 ) || (index >= this.size())) {
			throw new IndexOutOfBoundsException();
		}
		T result = this.elements[index];
		for (int i=index; i < this.size() - 1;++i) {
			this.elements[i] = this.elements[i+1];
		}
		this.elements[this.size()-1] = null;
		this.size--;
		return result;
	}

	@Override
	public T set(int index, T e) throws IndexOutOfBoundsException {
		if ((index < 0 ) || (index >= this.size())) {
			throw new IndexOutOfBoundsException();
		}
		T result = this.elements[index];
		this.elements[index] = e;
		return result;
	}

	@Override
	public void add(int index, T e) throws IndexOutOfBoundsException {
		if ((index < 0) || (index > this.size())) {
			throw new IndexOutOfBoundsException();
		}
		if (this.size() == this.elements.length) {
			this.changeCapacity(2 * this.size());
		}
		if (index == this.size()) {
			this.add(e);
			return;
		}
		for (int i= this.size(); i > index ; --i) {
			this.elements[i] = this.elements[i-1];
		}
		this.elements[index] = e;
		this.size++;
	}

	@Override
	public void add(T e) {
		if (this.size() == this.elements.length) {
			this.changeCapacity(2 * this.size());
		}
		this.elements[this.size++] = e;
		
	}
	private void changeCapacity(int newCapacity) {
		T [] temp = (T[]) new Object[newCapacity];
		for (int i=0; i < this.size(); ++i) {
			temp[i] = this.elements[i];
		}
		this.elements = temp;
	}

}








