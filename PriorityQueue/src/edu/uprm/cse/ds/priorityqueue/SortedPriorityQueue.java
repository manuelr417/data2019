package edu.uprm.cse.ds.priorityqueue;

import edu.uprm.cse.ds.list.DLLPositionalList;
import edu.uprm.cse.ds.list.Position;
import edu.uprm.cse.ds.list.PositionalList;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
	private PositionalList<Entry<K,V>> list;
	
	
	public SortedPriorityQueue() {
		super();
		this.list = new DLLPositionalList<Entry<K,V>>();
	}

	public SortedPriorityQueue(Comparator<K> comparator) {
		super(comparator);
		this.list = new DLLPositionalList<Entry<K,V>>();
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) {
		Entry<K,V> newEntry = new PQEntry<K,V>(key, value);
		if (this.isEmpty()) {
			this.list.addFirst(newEntry);
			return newEntry;
		}
		else {
			Position<Entry<K,V>> p = this.list.first();
			while (p != null) {
				if (this.compare(newEntry, p.getElement())< 0) {
					this.list.addBefore(p, newEntry);
					return newEntry;
				}
				p = this.list.after(p);
			}
			this.list.addLast(newEntry);
			return newEntry;
		}
	}

	@Override
	public Entry<K, V> min() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.list.first().getElement();
		}
	}

	@Override
	public Entry<K, V> removeMin() {
		Entry<K, V> result = this.min();
		Position<Entry<K, V>> target = this.list.first();
		this.list.remove(target);
		return result;
	}

}
