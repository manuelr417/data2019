package edu.uprm.cse.ds.hashing;

public abstract class AbstractHashMap<K, V> implements Map<K, V> {
	
	protected static class HMEntry<K,V> implements Entry<K,V> {

		private K key;
		private V value;
		
		public HMEntry(K key, V value) {
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
		
	}
	
	protected Comparator<K> comparator;
	protected int size;

	protected AbstractHashMap() {
		super();
		this.comparator = new DefaultComparator<K>();
		this.size = 0;
	}
	protected AbstractHashMap(Comparator<K> comparator) {
		super();
		this.comparator = comparator;
		this.size = 0;
	}
	
	

	@Override
	public final int size() {
		return this.size;
	}

	@Override
	public final boolean isEmpty() {
		return this.size() == 0;
	}

}
