package edu.uprm.cse.ds.indexlist;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExternalIndexlistIterator<T> implements Iterator<T> {
	
	private IndexList<T> list;
	private int currentPosition;
	
	public  ExternalIndexlistIterator(IndexList<T> list) {
		this.list = list;
		this.currentPosition = 0;
	}

	@Override
	public boolean hasNext() {
		return this.currentPosition < this.list.size();
	}

	@Override
	public T next() {
		if (this.hasNext()) {
			T result = this.list.get(this.currentPosition++);
			return result;
		}
		else {
			throw new NoSuchElementException();
		}
	}

}
