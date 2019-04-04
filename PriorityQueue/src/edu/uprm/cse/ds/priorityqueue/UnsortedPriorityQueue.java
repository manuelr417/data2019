package edu.uprm.cse.ds.priorityqueue;

import java.util.LinkedList;
import java.util.List;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	
	private List<Entry<K,V>> list;
	

	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
		this.list = new LinkedList<Entry<K,V>>();
	}

	public UnsortedPriorityQueue() {
		super();
		this.list = new LinkedList<Entry<K,V>>();
	}
	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) {
		Entry<K,V> result = new PQEntry<K,V>(key, value);
		this.list.add(0, result);
		return result;
	}

	@Override
	public Entry<K, V> min() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.findMin();
		}
	}

	private Entry<K, V> findMin() {
		Entry<K,V> min = this.list.get(0);
		for (Entry<K,V> e: this.list) {
			if (this.compare(e, min) < 0) {
				min =e;
			}
		}
		return min;
	}

	@Override
	public Entry<K, V> removeMin() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			Entry<K,V> result = this.min();
			int target = this.findMinIndex();
			this.list.remove(target);
			return result;
			
		}
	}

	private int findMinIndex() {
		Entry<K,V> min = this.list.get(0);
		int minIndex = 0;
		int i=0;
		for (Entry<K,V> e: this.list) {
			if (this.compare(e, min) < 0) {
				min = e;
				minIndex = i;
			}
			++i;
		}
		return minIndex;

	}

	private int findMinIndex2() {
		Entry<K,V> min = this.list.get(0);
		int minIndex = 0;
		for (int i=0; i < this.size(); ++i) {
			if (this.compare(this.list.get(i), min) < 0) {
				min = this.list.get(i);
				minIndex = i;
			}
		}
		return minIndex;

	}
}
