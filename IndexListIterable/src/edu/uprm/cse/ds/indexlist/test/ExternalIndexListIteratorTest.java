package edu.uprm.cse.ds.indexlist.test;

import edu.uprm.cse.ds.indexlist.ExternalIndexListIterable;
import edu.uprm.cse.ds.indexlist.IndexList;
import edu.uprm.cse.ds.indexlist.LinkedListIndexList;

public class ExternalIndexListIteratorTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		IndexList<String> L = new LinkedListIndexList<String>();
		
		L.add("Joe");
		L.add("Bob");
		L.add("Ron");
		L.add("Jil");
		L.add("Joe");
		L.add("Amy");
		L.add("Kim");
		
		System.out.println("Iterate with get!");
		for (int i=0; i < L.size(); ++i) {
			System.out.println(L.get(i));
		}
		System.out.println("\n Iterate with Iterator!");
	
		for (String s: new ExternalIndexListIterable<String>(L)) {
			System.out.println(s);

		}
		System.out.println("\n Done");


	}

}
