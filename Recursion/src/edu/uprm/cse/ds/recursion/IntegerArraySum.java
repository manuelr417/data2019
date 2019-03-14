package edu.uprm.cse.ds.recursion;

public class IntegerArraySum {

	public static int IntegerSum(Integer[] A, int low, int high) {
		if (low == high) {
			return A[low];
		}
		else {
			return A[low] + IntegerSum(A, low + 1, high);
		}
	}
	
	public static int IntegerSumIterative(Integer[] A, int low, int high) {
		int result = 0;
		for (int i=low; i <= high; ++i){
			result += A[i];
		}
		return result;
	}
	public static void main(String[] args) {
		Integer[] A = {8, 14, 1, -2, 2, 4};
		int result1 = IntegerSum(A, 0, A.length-1);
		System.out.println("result1: " + result1);
		int result2 = IntegerSumIterative(A, 0, A.length-1);
		System.out.println("result2: " + result2);

	}

}
