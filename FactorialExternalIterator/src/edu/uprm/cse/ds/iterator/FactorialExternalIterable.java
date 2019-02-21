package edu.uprm.cse.ds.iterator;

import java.util.Iterator;

public class FactorialExternalIterable implements Iterable<Double> {
	
	private long N;
	
	public FactorialExternalIterable(long N) {
		if (N < 0) {
			throw new IllegalArgumentException();
		}
		this.N = N;
	}

	@Override
	public Iterator<Double> iterator() {
		return new FactorialExternalIterator(this.N);
	}

}
