package edu.uprm.cse.ds.priorityqueue.test;

import edu.uprm.cse.ds.priorityqueue.HeapPriorityQueue;
import edu.uprm.cse.ds.priorityqueue.PriorityQueue;

public class HeapTest {
	public static void main(String[] args) {
		PriorityQueue<Integer,String> Q = new HeapPriorityQueue<Integer, String>();
		
		Q.insert(4, "Tom");
		Q.insert(1, "Amy");
		Q.insert(5, "Red");
		Q.insert(0, "Joe");
		Q.insert(2, "Tim");
		Q.insert(20, "Rex");
		Q.insert(3, "Xi");
		Q.insert(0, "Kim");

		
		while (!Q.isEmpty()) {
			System.out.println(Q.removeMin());
		}
		System.out.println("Done!");
		
	}

}
