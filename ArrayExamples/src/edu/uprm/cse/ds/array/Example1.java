package edu.uprm.cse.ds.array;

public class Example1 {

	public static void main(String[] args) {
		// Declaritve
		System.out.println("Case 1: declarative");

		int intArray[] = {0, 1, 2, 3, 4, 5, 6};
		System.out.println("length: " + intArray.length);
		for (int i=0; i < intArray.length; ++i) {
			System.out.println(intArray[i]);
		}
		System.out.println("\nCase 2: with new");

		int intArray2[] = new int[7];
		System.out.println("length: " + intArray2.length);
		for (int i=0; i < intArray2.length; ++i) {
			intArray2[i]  = i;
		}
		for (int i=0; i < intArray2.length; ++i) {
			System.out.println(intArray2[i]);
		}
	

	}

}
