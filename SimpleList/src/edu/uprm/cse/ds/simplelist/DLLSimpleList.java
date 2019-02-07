package edu.uprm.cse.ds.simplelist;


public class DLLSimpleList<T> implements SimpleList<T> {

	private static class Node<T>{
		
		private T element;
		private Node<T> next;
		private Node<T> previous;
		
		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}

		public Node(){
			this.element = null;
			this.next = null;
			this.previous = null;
		}
		
		public Node(T e, Node<T> N, Node<T> P) {
			this.element = e;
			this.next = N;
			this.previous = P;
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
	
	public  DLLSimpleList() {
		this.header = new Node<T>();
		this.tail = new Node<T>();
		this.header.setNext(this.tail);
		this.tail.setPrevious(this.header);
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
			return this.header.getNext().getElement();
		}
	}

	@Override
	public T last() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.tail.getPrevious().getElement();
		}
	}

	@Override
	public void addFirst(T e) {
		this.addBetween(this.header, this.header.getNext(), e);
		this.size++;
	}

	@Override
	public void addLast(T e) {
		this.addBetween(this.tail.getPrevious(), this.tail, e);
		this.size++;

	}

	private void addBetween(Node<T> P, Node<T> N, T e) {
		Node<T> newNode = new Node<T>(e, N, P);
		P.setNext(newNode);
		N.setPrevious(newNode);
	}

	@Override
	public T removeFirst() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			Node<T> target = this.header.getNext();
			T result = target.getElement();
			this.header.setNext(target.getNext());
			target.getNext().setPrevious(this.header);
			target.setNext(null);
			target.setPrevious(null);
			target.setElement(null);
			this.size--;
			return result;
		}
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

}
