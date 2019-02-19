package edu.uprm.cse.ds.iterator;

import java.util.ArrayList;

public class ArrayListIterator {

	public static void main(String[] args) {
		ArrayList<String> L = new ArrayList<String>();
		L.add("Joe");
		L.add("Ned");
		L.add("Bob");
		L.add("Amy");
		L.add("Apu");
		
		for (String s : L) {
			System.out.println(s);
		}


		
	}

}
