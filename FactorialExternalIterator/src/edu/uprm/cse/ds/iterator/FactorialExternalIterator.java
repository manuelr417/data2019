package edu.uprm.cse.ds.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FactorialExternalIterator implements Iterator<Double> {
	
	private long N;
	private long currentN;
	
	public FactorialExternalIterator(long N) {
		this.N= N;
		this.currentN = 0;
	}

	@Override
	public boolean hasNext() {
		return this.currentN <= this.N;
	}

	@Override
	public Double next() {
		if (this.hasNext()) {
			return this.factorial(this.currentN++);
			
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	private Double factorial(long N) {
		if (N == 0) {
			return 1.0;
		}
		else {
			return N * this.factorial(N-1);
		}
	}

}
