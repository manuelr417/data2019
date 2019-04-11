package edu.uprm.cse.ds.trees;

public class DefaultComparator<K> implements Comparator<K> {

	@Override
	public int compare(K a, K b) {
		return ((Comparable) a).compareTo(b);
	}
	

}
