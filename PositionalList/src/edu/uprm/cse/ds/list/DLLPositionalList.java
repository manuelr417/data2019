package edu.uprm.cse.ds.list;

import java.util.Iterator;

public class DLLPositionalList<T> implements PositionalList<T> {
	private static class Node<T> implements Position<T>{
		
		private T element;
		private Node<T> next;
		private Node<T> prev;
		
		

		public Node(T element, Node<T> next, Node<T> prev) {
			super();
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

		public Node() {
			super();
			this.element = null;
			this.next = null;
			this.prev = null;
		}


		public Node<T> getNext() {
			return next;
		}



		public void setNext(Node<T> next) {
			this.next = next;
		}



		public Node<T> getPrev() {
			return prev;
		}



		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}



		public void setElement(T element) {
			this.element = element;
		}



		@Override
		public T getElement() {
			// TODO Auto-generated method stub
			return this.element;
		}
		
	}

	private int size;
	private Node<T> header;
	private Node<T> tail;
	
	public DLLPositionalList() {
		this.size= 0;
		this.header = new Node<T>();
		this.tail= new Node<T>();
		this.header.setNext(this.tail);
		this.tail.setPrev(this.header);
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
	public Position<T> first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getNext();
		}
	}

	@Override
	public Position<T> last() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.tail.getPrev();
		}
	}

	@Override
	public Position<T> before(Position<T> p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		Node<T> temp = (Node<T>) p;
		if (temp.getPrev() == this.header) {
			return null;
		}
		else {
			return temp.getPrev();
		}
	}

	@Override
	public Position<T> after(Position<T> p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		Node<T> temp = (Node<T>) p;
		if (temp.getNext() == this.tail) {
			return null;
		}
		else {
			return temp.getNext();
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
	public void addBefore(Position<T> p, T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAfter(Position<T> p, T e) {
		// TODO Auto-generated method stub

	}

	@Override
	public T set(Position<T> p, T e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(Position<T> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
