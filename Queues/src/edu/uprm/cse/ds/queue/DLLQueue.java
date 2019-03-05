package edu.uprm.cse.ds.queue;

public class DLLQueue<E> implements Queue<E> {

	private static class DNode<E> {
		private E element;
		private DNode<E> next;
		private DNode<E> prev;
		public E getElement() {
			return element;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public DNode<E> getNext() {
			return next;
		}
		public void setNext(DNode<E> next) {
			this.next = next;
		}
		public DNode<E> getPrev() {
			return prev;
		}
		public void setPrev(DNode<E> prev) {
			this.prev = prev;
		}
		public DNode(E element, DNode<E> next, DNode<E> prev) {
			super();
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		public DNode() {
			super();
			this.element = null;
			this.next = null;
			this.prev = null;
		}
	}
	
	private DNode<E> header;
	private DNode<E> tail;
	private int size;
	
	public DLLQueue() {
		this.header = new DNode<E>();
		this.tail = new DNode<E>();
		this.header.setNext(this.tail);
		this.tail.setPrev(this.header);
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
	public E front() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getNext().getElement();
		}
		
		//return (this.isEmpty() ? null : this.header.getNext().getElement());
	}

	@Override
	public void enqueue(E e) {
		DNode<E> temp = new DNode<E>(e, this.tail, this.tail.getPrev());
		this.tail.getPrev().setNext(temp);
		this.tail.setPrev(temp);
		this.size++;
	}

	@Override
	public E dequeue() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			DNode<E> temp = this.header.getNext();
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
			E result = temp.getElement();
			temp.setElement(null);
			temp.setNext(null);
			temp.setPrev(null);
			this.size --;
			return result;
		}
	}

	@Override
	public void makeEmpty() {
		while (!(this.dequeue() == null));
	}

}
