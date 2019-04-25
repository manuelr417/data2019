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
		if (this.isEmpty()) {
			this.root = new BTNode<K,V>(new BTEntry<K, V>(key, value), null, null, null);
			this.size++;
		}
		else {
			this.addAux(this.root, key, value);
		}
	}

	private void addAux(BTNode<K, V> N, K key, V value) {
		// Assumes N is not null
		int c = this.comparator.compare(key, N.getValue().getKey());
		if (c == 0) {
			if (Math.random() > 0.5) {
				
				if (N.getRightChild() != null) {
					this.addAux(N.getRightChild(), key, value);

				}
				else {
					BTNode<K,V> newNode = 
							new BTNode<K,V>(new BTEntry<K, V>(key, value), null, null, null);
					N.setRightChild(newNode);
					newNode.setParent(N);
					this.size++;
					return;
				}
			}
			else {
				if (N.getLeftChild() != null) {
					this.addAux(N.getLeftChild(), key, value);
				}
				else {
					BTNode<K,V> newNode = 
							new BTNode<K,V>(new BTEntry<K, V>(key, value), null, null, null);
					N.setLeftChild(newNode);
					newNode.setParent(N);
					this.size++;
					return;
				}
			}
		}
		else if (c < 0) {
			// insert on left child
			if (N.getLeftChild() != null) {
				this.addAux(N.getLeftChild(), key, value);
			}
			else {
				BTNode<K,V> newNode = 
						new BTNode<K,V>(new BTEntry<K, V>(key, value), null, null, null);
				N.setLeftChild(newNode);
				newNode.setParent(N);
				this.size++;
				return;
			}
		}
		else {
			if (N.getRightChild() != null) {
				this.addAux(N.getRightChild(), key, value);

			}
			else {
				BTNode<K,V> newNode = 
						new BTNode<K,V>(new BTEntry<K, V>(key, value), null, null, null);
				N.setRightChild(newNode);
				newNode.setParent(N);
				this.size++;
				return;
			}
		}
		
	}

	@Override
	public Entry<K, V> remove(K key) {
		if (this.isEmpty()) {
			return null;
		}
		else {
			int c = this.comparator.compare(key, this.root.getValue().getKey());
			if (c == 0) {
				Entry<K,V> result = null;
				result = this.root.getValue();
				

				if ((this.root.getLeftChild() == null) &&
				(this.root.getRightChild() == null)) {
					this.root = null;
					this.size--;
					
				}
				else if (this.root.getRightChild() == null) {
					this.root = this.root.getLeftChild();
					this.size--;

				}
				else {
					Entry<K,V> temp = this.findMinRight(this.root.getRightChild());
					this.root.setValue(temp);
					this.removeAux(this.root.getRightChild(), temp.getKey());
				}
				return result;
			}
			else if (c < 0) {
				return this.removeAux(this.root.getLeftChild(), key);
			}
			else {
				return this.removeAux(this.root.getRightChild(), key);
			}
		}
	}

	
	private Entry<K, V> findMinRight(BTNode<K, V> N) {
		while (N.getLeftChild() != null) {
			N = N.getLeftChild();
		}
		return N.getValue();
	}

	private Entry<K, V> removeAux(BTNode<K, V> N, K key) {
		if (N == null) {
			return null;
		}
		else {
			int c = this.comparator.compare(key, N.getValue().getKey());
			if (c == 0) {
				Entry<K,V> result = null;
				result = N.getValue();
			

				if ((N.getLeftChild() == null) &&
				(N.getRightChild() == null)) {
					if (N.getParent().getLeftChild() == N) {
						N.getParent().setLeftChild(null);
					}
					else {
						N.getParent().setRightChild(null);
					}
					this.size--;
				}
				else if (N.getRightChild() == null) {
					if (N.getParent().getLeftChild() == N) {
						N.getParent().setLeftChild(N.getLeftChild());
						N.getLeftChild().setParent(N.getParent());
						N.setLeftChild(null);
						N.setParent(null);
						N.setValue(null);
					}
					else {
						N.getParent().setRightChild(N.getLeftChild());
						N.getLeftChild().setParent(N.getParent());
						N.setLeftChild(null);
						N.setParent(null);
						N.setValue(null);
					}
					this.size--;

				}
				else {
					Entry<K,V> temp = this.findMinRight(N.getRightChild());
					N.setValue(temp);
					this.removeAux(N.getRightChild(), temp.getKey());
				}
				return result;
	
			}
			else if (c < 0) {
				return this.removeAux(N.getLeftChild(), key);
			}
			else {
				return this.removeAux(N.getRightChild(), key);

			}
		}
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
