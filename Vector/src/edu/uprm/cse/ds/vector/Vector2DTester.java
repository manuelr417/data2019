package edu.uprm.cse.ds.vector;

public class Vector2DTester {

	public static void main(String[] args) {
		Vector v1 = new Vector2D(2, 4);
		Vector v2 = new Vector2D(1, 9);
		System.out.printf("v1: %s\n", v1);
		System.out.printf("v2: %s\n", v2);
		System.out.printf("v1 + v2: %s\n", v1.sum(v2));
		System.out.printf("v1 - v2: %s\n", v1.substract(v2));
		System.out.printf("<v1,v2>: %s\n", v1.innerProduct(v2));
		System.out.printf("||v1||: %s\n", v1.magnitude());
		System.out.printf("||v2||: %s\n", v2.magnitude());

	}

}
