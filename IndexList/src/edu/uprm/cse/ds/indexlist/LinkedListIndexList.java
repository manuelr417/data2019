package edu.uprm.cse.ds.indexlist;

public class LinkedListIndexList<T> implements IndexList<T> {
	
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
	private int size;
	
	public LinkedListIndexList() {
		this.header = null;
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
		this.checkIndex(index);
		Node<T> target = this.findNode(index);
		return target.getElement();
	}



	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T e) throws IndexOutOfBoundsException {
		this.checkIndex(index);
		Node<T> target = this.findNode(index);
		T result = target.getElement();
		target.setElement(e);
		return result;
	}

	@Override
	public void add(int index, T e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(T e) {
		
		Node<T> newNode = new Node<T>(e,null );
		Node<T> temp = this.findNode(this.size() - 1);
		temp.setNext(newNode);
		this.size++;
	}

	
	private Node<T> findNode(int index) {
		Node<T> temp = this.header;
		int i = 0;
		
		while (i < index) {
			temp = temp.getNext();
			i++;
		}
		return temp;
		
	}

	private void checkIndex(int index) {
		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}
	}
}
