package edu.uprm.cse.ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

	private class PositionalListIterator<T> implements Iterator<T>{
		private Node<T> currentPosition;
		
		private PositionalListIterator() {
			this.currentPosition = (Node<T>) header.getNext();
		}
		@Override
		public boolean hasNext() {
			return this.currentPosition != tail;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T result = this.currentPosition.getElement();
				this.currentPosition = this.currentPosition.getNext();
				return result;
			}
			else {
				throw new NoSuchElementException();
			}
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
		this.addBetween(this.header, this.header.getNext(), e);
	}

	@Override
	public void addLast(T e) {
		this.addBetween(this.tail.getPrev(), this.tail, e);
	}

	@Override
	public void addBefore(Position<T> p, T e) {
		Node<T> temp = (Node<T>) p;
		if (temp == this.header) {
			throw new IllegalArgumentException();
		}
		else {
			this.addBetween(temp.getPrev(), temp, e);
		}

	}

	@Override
	public void addAfter(Position<T> p, T e) {
		Node<T> temp = (Node<T>) p;
		if (temp == this.tail) {
			throw new IllegalArgumentException();
		}
		else {
			this.addBetween(temp, temp.getNext(), e);
		}

	}

	@Override
	public T set(Position<T> p, T e) {
		Node<T> temp = (Node<T>) p;
		if ((temp == this.header) ||
				(temp == this.tail)) {
			throw new IllegalArgumentException();
		}
		else {
			T result = temp.getElement();
			temp.setElement(e);
			return result;
		}
	}

	@Override
	public T remove(Position<T> p) {
		Node<T> temp = (Node<T>) p;
		if ((temp == this.header) ||
				(temp == this.tail)) {
			throw new IllegalArgumentException();
		}	
		else {
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			T result = temp.getElement();
			temp.setElement(null);
			temp.setNext(null);
			temp.setPrev(null);
			this.size--;
			return result;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new PositionalListIterator<T>();
	}

	private void addBetween(Node<T> prev, Node<T> next, T e) {
		Node<T> temp = new Node();
		temp.setElement(e);
		temp.setNext(next);
		temp.setPrev(prev);
		prev.setNext(temp);
		next.setPrev(temp);
		this.size++;
	}
}
