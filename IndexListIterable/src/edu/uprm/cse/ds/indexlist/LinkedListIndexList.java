package edu.uprm.cse.ds.indexlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIndexList<T> implements IndexList<T> {
	private class ListIterator<T> implements Iterator<T>{
		
		private Node<T> currentNode;
		
		public ListIterator() {
			this.currentNode = (Node<T>)header;
		}
		@Override
		public boolean hasNext() {
			return this.currentNode != null;
		}

		@Override
		public T next() {
			if (this.hasNext()) {
				T result= null;
				result = this.currentNode.getElement();
				this.currentNode = this.currentNode.getNext();
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
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
		if (this.isEmpty()) {
			return null;
		}
		this.checkIndex(index);
		if (index == 0) {
			Node<T> temp = this.header;
			T result = temp.getElement();
			this.header = this.header.getNext();
			temp.setNext(null);
			temp.setElement(null);
			this.size--;
			return result;
		}
		else {
			Node<T> temp1 = this.findNode(index - 1);
			Node<T> temp2 = temp1.getNext();
			T result = temp2.getElement();
			temp1.setNext(temp2.getNext());
			temp2.setNext(null);
			temp2.setElement(null);
			this.size--;
			return result;
		}
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
		if (index == this.size()) {
			this.add(e);
			return;
		}
		this.checkIndex(index);

		if (index == 0) {
			Node<T> newNode = new Node<T>(e, null);
			newNode.setNext(this.header);
			this.header = newNode;
		}
		else {
			Node<T> newNode = new Node<T>(e, null);
			Node<T> temp = this.findNode(index-1);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		this.size++;
	}

	@Override
	public void add(T e) {
		if (this.isEmpty()) {
			this.header = new Node(e, null);

		}
		else {
			Node<T> newNode = new Node<T>(e,null );
			Node<T> temp = this.findNode(this.size() - 1);
			temp.setNext(newNode);
		}
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

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>();
	}
}
