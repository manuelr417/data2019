package edu.uprm.cse.ds.hashing;

public class DefaultComparator<K> implements Comparator<K> {

	@SuppressWarnings("unchecked")
	@Override
	public int compare(K a, K b) {
		return ((Comparable<K>) a).compareTo(b);
	}
	

}
