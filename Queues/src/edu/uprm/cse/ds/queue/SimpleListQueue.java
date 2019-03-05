package edu.uprm.cse.ds.queue;

import edu.uprm.cse.ds.simplelist.DLLSimpleList;
import edu.uprm.cse.ds.simplelist.SimpleList;

public class SimpleListQueue<E> implements Queue<E> {
	
	private SimpleList<E> list;
	
	
	public SimpleListQueue() {
		this.list = new DLLSimpleList<E>();
		
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
	public E front() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.list.first();
		}
	}

	@Override
	public void enqueue(E e) {
		this.list.addLast(e);
	}

	@Override
	public E dequeue() {
		//E result = this.front();
		//this.list.removeFirst();
		//return result;
		
		return this.list.removeFirst();
	}

	@Override
	public void makeEmpty() {
		while(!(this.dequeue() == null));
	}

}
