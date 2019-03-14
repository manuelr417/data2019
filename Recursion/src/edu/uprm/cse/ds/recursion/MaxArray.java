package edu.uprm.cse.ds.recursion;

public class MaxArray {

	public static int maxArray(Integer[] A, int low, int end) {
		if (low == end) {
			return A[low];
		}
		else {
			return Math.max(A[low], maxArray(A, low + 1, end));
		}
	}
	public static void main(String[] args) {
		Integer[] A = {8, 14, 1, -2, 2, 100, 4};
		int result = maxArray(A, 0, A.length-1);
		System.out.println("max: " + result);

	}

}
