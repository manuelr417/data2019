package edu.uprm.cse.ds.hashing.test;

import edu.uprm.cse.ds.hashing.Entry;
import edu.uprm.cse.ds.hashing.Map;
import edu.uprm.cse.ds.hashing.SeparateChainingHashMap;

public class SeparateChainingTest {

	private static void print(Map<String, String> T) {
		for (Entry<String, String> e : T.entrySet()) {
			System.out.println(e.getKey() + ", " + e.getValue());
		}
		
	}
	public static void main(String[] args) {
		Map<String, String> T = new SeparateChainingHashMap<String, String>();
		
		T.put("Bob", "Bob");
		T.put("Ron", "Ron");
		T.put("Jim", "Jim");
		print(T);

	}

}
