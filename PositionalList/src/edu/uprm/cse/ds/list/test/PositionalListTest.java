package edu.uprm.cse.ds.list.test;

import edu.uprm.cse.ds.list.DLLPositionalList;
import edu.uprm.cse.ds.list.PositionalList;

public class PositionalListTest {

	public static void main(String[] args) {
		PositionalList<String> L = new DLLPositionalList<String>();
		L.addFirst("Joe");
		L.addLast("Amy");
		L.addAfter(L.first(), "Ken");
		L.addBefore(L.last(), "Ned");
		
		for (String s: L) {
			System.out.println(s);
		}
		L.set(L.first(), "Apu");
		System.out.println();

		for (String s: L) {
			System.out.println(s);
		}
	}

}
