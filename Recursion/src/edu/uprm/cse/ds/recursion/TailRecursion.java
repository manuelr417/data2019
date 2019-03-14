package edu.uprm.cse.ds.recursion;

public class TailRecursion {

	public static void reverseArray(int[] A, int low, int end) {
		if (low < end) {
			int temp; 
			temp = A[low];
			A[low] = A[end];
			A[end] =temp;
			reverseArray(A, low+1, end-1);
		}
	}
	
	public static void reverseArrayIterative(int[] A, int low, int end) {
		int temp;
		while (low < end) {
			temp = A[low];
			A[low] = A[end];
			A[end] =temp;
			low++;
			end--;
		}
	}
	public static void printArray(int[] A) {
		for (int i=0; i < A.length; ++i) {
			System.out.print(A[i]+ " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A = {2, 5, 6, 7, 8, 8, 10, 14, 18, 19, 21, 23, 27, 30, 31};
		int[] B = new int[A.length]; 
		System.arraycopy(A, 0, B, 0, A.length);
		printArray(A);
		reverseArray(A, 0, A.length-1);
		printArray(A);
		printArray(B);
		reverseArrayIterative(B, 0, B.length-1);
		printArray(B);


	}

}
