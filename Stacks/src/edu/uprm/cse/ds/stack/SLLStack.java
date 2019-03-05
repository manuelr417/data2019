package edu.uprm.cse.ds.stack;

public class SLLStack<T> implements Stack<T> {

	private static class Node<T>{
		private T element;
		private Node<T> next;
		
		public Node() {
			super();
		}
		
		public Node(T element, Node<T> next) {
			super();
			this.element = element;
			this.next = next;
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
	private int size;
	
	public SLLStack() {
		this.size = 0;
		this.header = new Node<T>();
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
	public T top() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getNext().getElement();
		}
	}

	@Override
	public T pop() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			T result = this.header.getNext().getElement();
			Node<T> temp = this.header.getNext();
			this.header.setNext(temp.getNext());
			temp.setElement(null);
			temp.setNext(null);
			this.size--;
			return result;
		}
	}

	@Override
	public void push(T e) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(e);
		newNode.setNext(this.header.getNext());
		this.header.setNext(newNode);
		this.size++;
	}

	@Override
	public void makeEmpty() {
		while (!(this.pop() == null));
	}

}
