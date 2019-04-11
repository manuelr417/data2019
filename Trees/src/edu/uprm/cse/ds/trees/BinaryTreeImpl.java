package edu.uprm.cse.ds.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeImpl<E> extends AbstractBinaryTree<E> {
	
	private static class BinaryNode<E> implements Position<E>{
		
		private E element;
		
		private BinaryNode<E> parent;
		private BinaryNode<E> leftChild;
		private BinaryNode<E> rightChild;


		public BinaryNode(E element, BinaryNode<E> parent, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
			super();
			this.element = element;
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		private void clear() {
			this.element = null;
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
		}

		public BinaryNode<E> getParent() {
			return parent;
		}

		public void setParent(BinaryNode<E> parent) {
			this.parent = parent;
		}

		public BinaryNode<E> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(BinaryNode<E> leftChild) {
			this.leftChild = leftChild;
		}

		public BinaryNode<E> getRightChild() {
			return rightChild;
		}

		public void setRightChild(BinaryNode<E> rightChild) {
			this.rightChild = rightChild;
		}

		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() {
			return this.element;
		}
		
	}

	private BinaryNode<E> root;
	private int size;
	
	
	public BinaryTreeImpl(BinaryNode<E> root, int size) {
		super();
		this.root = root;
		this.size = size;
	}

	public BinaryTreeImpl() {
		super();
		this.root = null;
		this.size = 0;
	}
	
	@Override
	public boolean isRoot(Position<E> p) {
		return super.isRoot(p) && p == this.root;
	}
	@Override
	public Position<E> left(Position<E> p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		BinaryNode<E> temp = (BinaryNode<E>) p;
		return temp.getLeftChild();
	}

	@Override
	public Position<E> right(Position<E> p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		BinaryNode<E> temp = (BinaryNode<E>) p;
		return temp.getRightChild();

	}

	@Override
	public Position<E> root() {
		return this.root;
	}

	@Override
	public Position<E> parent(Position<E> p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		BinaryNode<E> temp = (BinaryNode<E>) p;
		return temp.getParent();

	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<E> iterator() {
		List<E> list = new LinkedList<E>();
		for (Position<E> p : this.InOrderIterable()) {
			list.add(p.getElement());
		}
		return list.iterator();
	}

	public Position<E> addRoot(E e) {
		if (!this.isEmpty()) {
			throw new IllegalStateException("Three is not null");
		}
		this.size = 1;
		this.root = new BinaryNode<E>(e, null, null, null);
		return this.root;
	}
	public void attach(Position<E> p, BinaryTree<E> T1, BinaryTree<E> T2){
		if (T1.isEmpty() || T2.isEmpty()) {
			throw new IllegalStateException("Cannot pass empty tree");
		}
		if (this.isInternal(p)) {
			throw new IllegalStateException("Cannot attach to internal node");
		}
		BinaryNode<E> temp = (BinaryNode<E>) p;
		BinaryNode<E> tempLeft = (BinaryNode<E>) T1.root();
		BinaryNode<E> tempRight = (BinaryNode<E>) T2.root();
		temp.setLeftChild(tempLeft);
		tempLeft.setParent(temp);
		temp.setRightChild(tempRight);
		tempRight.setParent(temp);
		this.size += T1.size() + T2.size();
	
	}
}
