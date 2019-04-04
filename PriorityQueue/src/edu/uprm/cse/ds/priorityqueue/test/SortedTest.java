package edu.uprm.cse.ds.priorityqueue.test;

import edu.uprm.cse.ds.priorityqueue.PriorityQueue;
import edu.uprm.cse.ds.priorityqueue.SortedPriorityQueue;

public class SortedTest {
	public static void main(String[] args) {
		PriorityQueue<Integer,String> Q = new SortedPriorityQueue<Integer, String>();
		
		Q.insert(4, "Tom");
		Q.insert(1, "Amy");
		Q.insert(5, "Red");
		Q.insert(0, "Joe");
		Q.insert(2, "Tim");
		
		while (!Q.isEmpty()) {
			System.out.println(Q.removeMin());
		}
		System.out.println("Done!");
		
	}

}
