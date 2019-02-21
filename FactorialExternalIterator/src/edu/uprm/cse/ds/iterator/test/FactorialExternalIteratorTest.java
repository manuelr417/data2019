package edu.uprm.cse.ds.iterator.test;

import edu.uprm.cse.ds.iterator.FactorialExternalIterable;

public class FactorialExternalIteratorTest {

	public static void main(String[] args) {
		System.out.println("Factorial from 0 to 10");
		int i=0;
		for (Double d : new FactorialExternalIterable(10)) {
			System.out.println("Factorial of " + i + " is: " + d);
			++i;
			
		}
		System.out.println();
	}

}
