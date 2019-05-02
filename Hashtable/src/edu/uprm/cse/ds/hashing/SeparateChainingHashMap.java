package edu.uprm.cse.ds.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashMap<K, V> extends AbstractHashMap<K, V> {
	// Array of buckets
	private List<Entry<K,V>>[] buckets;
	private static final int DEFAULT_SIZE = 101;
	
	public SeparateChainingHashMap(){
		super();
		this.buckets = ((List<Entry<K,V>>[]) new List[DEFAULT_SIZE]);
		//this.buckets = (List<Entry<K, V>>[]) new Object[DEFAULT_SIZE];
		//this.buckets = new List<Entry<K, V>>[DEFAULT_SIZE];

		for (int i=0; i < this.buckets.length; ++i) {
			this.buckets[i] = new LinkedList<Entry<K,V>>();
		}
		
	}

	private int hash(K key) {
		return key.hashCode() % this.buckets.length;
	}
	@Override
	public V get(K key) {
		// find bucket
		int targetBucket = this.hash(key);
		List<Entry<K,V>> B = this.buckets[targetBucket];
		for (Entry<K,V> e : B) {
			if (this.comparator.compare(key, e.getKey()) == 0) {
				return e.getValue();
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		// first erase it
		this.remove(key);
		// find bucket
		int targetBucket = this.hash(key);
		List<Entry<K,V>> B = this.buckets[targetBucket];
		B.add(new HMEntry<K,V>(key, value));
		this.size++;
		return value;

	}

	@Override
	public V remove(K key) {
		// find bucket
		int targetBucket = this.hash(key);
		List<Entry<K,V>> B = this.buckets[targetBucket];
		// find the index of entry with given key
		int position = -1;
		for (int i = 0 ; i < B.size(); ++i) {
			if (this.comparator.compare(key, B.get(i).getKey()) == 0) {
				position = i;
				break;
			}
		}
		if (position == -1) {
			return null;
		}
		else {
			this.size--;
			return B.remove(position).getValue();
		}
	}

	@Override
	public Iterable<K> keySet() {
		List<K> L = new ArrayList<K>(this.size);
		for (List<Entry<K,V>> B : this.buckets) {
			for (Entry<K,V> e : B) {
				L.add(e.getKey());
			}
		}
		return L;
	}

	@Override
	public Iterable<V> values() {
		List<V> L = new ArrayList<V>(this.size);
		for (List<Entry<K,V>> B : this.buckets) {
			for (Entry<K,V> e : B) {
				L.add(e.getValue());
			}
		}
		return L;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		List<Entry<K,V>> L = 
				new ArrayList<Entry<K,V>>(this.size);
		for (List<Entry<K,V>> B : this.buckets) {
			for (Entry<K,V> e : B) {
				L.add(e);
			}
		}
		return L;
	}

}
