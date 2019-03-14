package edu.uprm.cse.ds.recursion;

public class BinarySearch {

	public static boolean binarySearch(int[] A, int target, int low, int end) {
		System.out.printf("low: %d, end: %d\n", low, end);
		if (low > end) {
			return false;
		}
		else {
			int mid = (low + end)/2;
			if (A[mid] == target) {
				return true;
			}
			else if (A[mid] < target) {
				return binarySearch(A,target, mid + 1, end);
			}
			else {
				return binarySearch(A, target, low, mid-1);
			}
		}
	}
	public static void main(String[] args) {
		int[] A = {2, 5, 6, 7, 8, 8, 10, 14, 18, 19, 21, 23, 27, 30};
		
		System.out.println("Binary search 10: " + binarySearch(A, 10, 0,
				A.length-1));
		System.out.println();
		System.out.println("Binary search 23: " + binarySearch(A, 23, 0,
				A.length-1));
		System.out.println();
		System.out.println("Binary search 6: " + binarySearch(A, 6, 0,
				A.length-1));
		System.out.println();
		System.out.println("Binary search 100: " + binarySearch(A, 100, 0,
				A.length-1));
		System.out.println("Binary search -10: " + binarySearch(A, -10, 0,
				A.length-1));
		boolean isFound = binarySearch(A, 2, 0, A.length-1);
		System.out.println("Binary search 2: " + isFound);
	}

}
