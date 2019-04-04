package edu.uprm.cse.ds.priorityqueue;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
	
	protected static class PQEntry<K,V> implements Entry<K,V>{
		
		private K key;
		private V value;
		
		

		public PQEntry(K key, V value) {
			super();
			this.key = key;
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
		@Override
		public String toString() {
 			return "(" + this.key + ", " + this.value + ")";
		}
		
	}

	protected AbstractPriorityQueue(Comparator<K> comparator) {
		this.comparator = comparator;
	}
	protected AbstractPriorityQueue() {
		this.comparator = new DefaultComparator();
	}
	protected Comparator<K> comparator;
	
	protected int compare(Entry<K,V> e1, Entry<K,V> e2) {
		return this.comparator.compare(e1.getKey(), e2.getKey());
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}



}
