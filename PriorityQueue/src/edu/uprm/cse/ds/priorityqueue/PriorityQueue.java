package edu.uprm.cse.ds.priorityqueue;

public interface PriorityQueue<K, V> {
	
	public int size();
	
	public boolean isEmpty();
	
	public Entry<K,V> insert(K key, V value);
	
	public Entry<K,V> min();
	
	public Entry<K,V> removeMin();

}
