package edu.uprm.cse.ds.recursion;

public class InfiniteRecursion {
	public static long factorial(int n) {
		// bad factorial
		if (n == 0) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
	public static long badfactorial(int n) {

		// bad factorial
		System.out.println("la n: " + n);
		return n * badfactorial(n-1);
		
	}
	
	public static void main(String[] args) {
		//long n = badfactorial(5);
		//System.out.println("N: " + badfactorial(5));
		
		System.out.println("N: " + factorial(-2));
	}

}
