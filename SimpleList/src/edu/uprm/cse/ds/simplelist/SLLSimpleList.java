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
		if (this.isEmpty()) {
			Node<T> newNode = new Node<T>(e, null);
			this.header = this.tail = newNode;
			this.size++;
		}
		else {
			Node<T> newNode = new Node<T>(e, null);
			newNode.setNext(this.header);
			this.header = newNode;
			this.size++;
		}
	}

	@Override
	public void addLast(T e) {
		if (this.isEmpty()) {
			Node<T> newNode = new Node<T>(e, null);
			this.header = this.tail = newNode;
			this.size++;
		}
		else {
			Node<T> newNode = new Node<T>(e, null);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.size++;
		}
	}

	@Override
	public T removeFirst() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			T result = this.header.getElement();
			Node<T> temp = this.header;
			this.header = this.header.getNext();
			temp.setElement(null);
			temp.setNext(null);
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
			if (this.size() == 1) {
				T result = this.header.getElement();
				this.header.setElement(null);
				this.header = this.tail = null;
				this.size--;
				return result;
			}
			else {
				Node<T> temp = this.header;
				while(temp.getNext() != this.tail) {
					temp = temp.getNext();
				}
				Node<T> target = temp.getNext();
				T result = target.getElement();
				temp.setNext(null);
				this.tail = temp;
				target.setElement(null);
				this.size--;
				return result;
			}
		}
	}

}
