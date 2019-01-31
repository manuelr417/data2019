package edu.uprm.cse.ds.vector;

public class VectornDTest {

	public static void main(String[] args) {
		double coordinates1[] = {8, -9, 4, 3};
		double coordinates2[] = {1, 2, 3, 4};

		Vector v1 = new VectornD(coordinates1);
		Vector v2 = new VectornD(coordinates2);
		System.out.printf("v1: %s\n", v1);
		System.out.printf("v2: %s\n", v2);
		System.out.printf("v1 + v2: %s\n", v1.sum(v2));
		System.out.printf("v1 - v2: %s\n", v1.substract(v2));
		System.out.printf("<v1,v2>: %s\n", v1.innerProduct(v2));
		System.out.printf("||v1||: %s\n", v1.magnitude());
		System.out.printf("||v2||: %s\n", v2.magnitude());

	}

}
