package edu.uprm.cse.ds.recursion;

public class Factorial {

	public static long factorial(int n) {
		System.out.println("n = " + n);
		if (n == 0) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println("Factorial: 0 " + factorial(0));		
		//System.out.println("Factorial: 1 " + factorial(1));

		//System.out.println("Factorial: 2 " + factorial(2));
		//System.out.println("Factorial: 3 " + factorial(3));

		//System.out.println("Factorial: 4 " + factorial(4));
		System.out.println("Factorial: 5 " + factorial(5));


	}

}
