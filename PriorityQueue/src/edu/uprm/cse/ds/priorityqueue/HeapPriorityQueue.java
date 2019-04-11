package edu.uprm.cse.ds.priorityqueue;

import java.util.ArrayList;
import java.util.List;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	private List<Entry<K,V>> heap ;
	

	
	public HeapPriorityQueue() {
		super();
		this.heap = new ArrayList<Entry<K,V>>();
	}

	public HeapPriorityQueue(Comparator<K> comparator) {
		super(comparator);
		this.heap = new ArrayList<Entry<K,V>>();
	}

	@Override
	public int size() {
		return this.heap.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) {
		Entry<K,V> newEntry = new PQEntry<K,V>(key,value);
		this.heap.add(newEntry);
		this.upHeap();
		return newEntry;
	}
	
	private void upHeap() {
		int pos = this.size() -1;
		while (pos > 0) {
			Entry<K,V> current = this.heap.get(pos);
			Entry<K,V> parent = this.heap.get(this.parent(pos));
			if (this.compare(current, parent) >= 0) {
				break;
			}
			else {
				//swap
				this.swap(pos, this.parent(pos));
				pos = this.parent(pos);
			}
		}
	}

	private void swap(int i, int j) {
		Entry<K,V> temp = this.heap.get(i);
		this.heap.set(i, this.heap.get(j));
		this.heap.set(j,  temp);
	}
	private int parent(int pos) {
		return (pos - 1)/2; 
	}
	
	private int leftChild(int pos) {
		return 2*pos + 1;
	}
	private int rightChild(int pos) {
		return 2*pos + 2;
	}
	
	private boolean hasLeftChild(int pos) {
		return this.leftChild(pos) < this.size();
	}
	
	private boolean hasRightChild(int pos) {
		return this.rightChild(pos) < this.size();
	}
	
	@Override
	public Entry<K, V> min() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.heap.get(0);
		}
	}

	@Override
	public Entry<K, V> removeMin() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			Entry<K,V> result = this.min();
			this.swap(0,  this.size()-1);
			this.heap.remove(this.size()-1);
			this.downHeap();
			return result;
		}
	}
	
	private void downHeap() {
		int pos = 0;
		int smallIndex;
		while (pos < this.size()) {
		//while(this.hasLeftChild(pos)) {
			Entry<K,V> current = this.heap.get(pos);
			if (this.hasLeftChild(pos)) {
				Entry<K,V> leftChild  = this.heap.get(this.leftChild(pos));
				smallIndex = this.leftChild(pos);
				if (this.hasRightChild(pos)) {
					Entry<K,V> rightChild  = this.heap.get(this.rightChild(pos));
					if (this.compare(leftChild, rightChild) > 0) {
						smallIndex = this.rightChild(pos);
					}

				}
				Entry<K,V> smallest = this.heap.get(smallIndex);
				if (this.compare(current, smallest) <=0 ) {
					break;
				}
				else {
					this.swap(pos, smallIndex);
					pos = smallIndex;
				}
			}
			else {
				break;
			}
		}
	}
}
