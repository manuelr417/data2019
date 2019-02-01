package edu.uprm.cse.ds.simplelist;


public class SLLSimpleList<T> implements SimpleList<T> {
	private static class Node<T>{
		
		private T element;
		private Node<T> next;
		
		public Node(){
			this.element = null;
			this.next = null;
		}
		
		public Node(T e, Node<T> N) {
			this.element = e;
			this.next = N;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
	private Node<T> header;
	private Node<T> tail;

	private int size;
	

	public SLLSimpleList() {
		this.header = null;
		this.tail = null;
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
	public T first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getElement();
		}
		// cool
		// return (this.isEmpty() ? null : this.header.getElement());
	}

	@Override
	public T last() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.tail.getElement();
		}
	}

	@Override
	public void addFirst(T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addLast(T e) {
		// TODO Auto-generated method stub

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

}
