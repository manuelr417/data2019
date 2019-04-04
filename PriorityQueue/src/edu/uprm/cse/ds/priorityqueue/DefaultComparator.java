package edu.uprm.cse.ds.priorityqueue;

public class DefaultComparator<K> implements Comparator<K> {

	@Override
	public int compare(K a, K b) {
		return ((Comparable) a).compareTo(b);
	}
	

}
