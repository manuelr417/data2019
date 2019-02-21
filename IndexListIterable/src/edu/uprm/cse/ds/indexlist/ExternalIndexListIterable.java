package edu.uprm.cse.ds.indexlist;

import java.util.Iterator;

public class ExternalIndexListIterable<T> implements Iterable<T> {
	private IndexList<T> list;
	
	public ExternalIndexListIterable(IndexList<T> L) {
		this.list = L;
	}
	@Override
	public Iterator<T> iterator() {
		return new ExternalIndexlistIterator(this.list);
	}

}
