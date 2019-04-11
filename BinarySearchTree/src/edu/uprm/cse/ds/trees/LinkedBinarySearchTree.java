package edu.uprm.cse.ds.trees;

import java.util.ArrayList;
import java.util.List;

public class LinkedBinarySearchTree<K, V> implements BinarySearchTree<K, V> {
	
	private static class BTEntry<K,V> implements Entry<K,V>{
		
		private K key;
		private V value;

		public BTEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
		
		
		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
		

	}
	
	private static class BTNode<K,V> {
		private Entry<K,V> value;
		private BTNode<K,V> parent;
		private BTNode<K,V> leftChild;
		private BTNode<K,V> rightChild;
		public BTNode(Entry<K, V> value, BTNode<K, V> parent, BTNode<K, V> leftChild, BTNode<K, V> rightChild) {
			super();
			this.value = value;
			this.parent = parent;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		public Entry<K, V> getValue() {
			return value;
		}
		public void setValue(Entry<K, V> value) {
			this.value = value;
		}
		public BTNode<K, V> getParent() {
			return parent;
		}
		public void setParent(BTNode<K, V> parent) {
			this.parent = parent;
		}
		public BTNode<K, V> getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(BTNode<K, V> leftChild) {
			this.leftChild = leftChild;
		}
		public BTNode<K, V> getRightChild() {
			return rightChild;
		}
		public void setRightChild(BTNode<K, V> rightChild) {
			this.rightChild = rightChild;
		}	
	}
	
	private BTNode<K,V> root ;
	private int size;
	private Comparator<K> comparator ;
	
	public LinkedBinarySearchTree() {
		super();
		this.root = null;
		this.size = 0;
		this.comparator = new DefaultComparator<K>();
		
	}

	public LinkedBinarySearchTree(Comparator<K> comp) {
		super();
		this.root = null;
		this.size = 0;
		this.comparator = comp;
		
	}

	@Override
	public List<Entry<K, V>> getAll(K key) {
		List<Entry<K,V>> result = new ArrayList<Entry<K, V>>();
		if (this.isEmpty()) {
			return result;
		}
		else {
			this.getAllAux(this.root, key, result);
			return result;
		}
	}

	
	private void getAllAux(BTNode<K, V> N, K key, List<Entry<K,V>> L) {
		if (N == null) {
			return;
		}
		else {
			int c = this.comparator.compare(key, N.getValue().getKey());
			if (c == 0) {
				L.add(N.getValue());
				this.getAllAux(N.leftChild, key, L);
				this.getAllAux(N.rightChild, key, L);

			}
			else if (c < 0) {
				this.getAllAux(N.getLeftChild(), key, L);
			}
			else {
				this.getAllAux(N.getRightChild(), key, L);
			}
		}

	}

	@Override
	public Entry<K, V> get(K key) {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.getAux(this.root, key);
		}
	}

	
	private Entry<K, V> getAux(BTNode<K, V> N, K key) {
		if (N == null) {
			// not found
			return null;
		}
		else {
			int c = this.comparator.compare(key, N.getValue().getKey());
			if (c == 0) {
				return N.getValue();
			}
			else if (c < 0) {
				return this.getAux(N.getLeftChild(), key);
			}
			else {
				return this.getAux(N.getRightChild(), key);
			}
		}
	}

	@Override
	public void add(K key, V value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Entry<K, V> remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

}
