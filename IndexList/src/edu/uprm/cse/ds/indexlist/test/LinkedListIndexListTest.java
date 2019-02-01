package edu.uprm.cse.ds.indexlist.test;

import edu.uprm.cse.ds.indexlist.ArrayIndexList;
import edu.uprm.cse.ds.indexlist.IndexList;
import edu.uprm.cse.ds.indexlist.LinkedListIndexList;

public class LinkedListIndexListTest {

	public static void main(String[] args) {
		IndexList<String> L =  new LinkedListIndexList<String>();
		
		L.add("Bob");
		L.add("Jil");
		L.add("Ned");
		L.add("Jil");
		printList(L);
		System.out.println();
		L.set(1,  "Ron");
		printList(L);
		System.out.println();
		L.add(2,  "Moe");
		L.add(0,  "Ken");
		printList(L);

		System.out.println();
		L.remove(0);
		printList(L);

		System.out.println();

		L.remove(3);
		printList(L);

	}

	private static void printList(IndexList<String> L) {
		for (int i=0; i < L.size(); ++i) {
			System.out.println(L.get(i));
		}
	}
}
