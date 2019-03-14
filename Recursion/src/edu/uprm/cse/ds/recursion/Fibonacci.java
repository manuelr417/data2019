package edu.uprm.cse.ds.recursion;

public class Fibonacci {

	public static int Fibonacci(int k) {
		if (k == 0) {
			return 0;
		}
		else if (k == 1) {
			return 1;
		}
		else {
			return Fibonacci(k-1) + Fibonacci(k-2);
		}
	}
	public static void main(String[] args) {
		System.out.println("Fibonaci 0: " + Fibonacci(0));
		System.out.println("Fibonaci 1: " + Fibonacci(1));
		System.out.println("Fibonaci 2: " + Fibonacci(2));
		System.out.println("Fibonaci 3: " + Fibonacci(3));
		System.out.println("Fibonaci 4: " + Fibonacci(4));

	}

}
