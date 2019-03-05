package edu.uprm.cse.ds.queue.test;

import edu.uprm.cse.ds.queue.DLLQueue;
import edu.uprm.cse.ds.queue.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> Q = new DLLQueue<String>();
		
		Q.enqueue("Apu");
		Q.enqueue("Joe");
		Q.enqueue("Ned");
		Q.enqueue("Jil");
		System.out.println("Front: " + Q.front());
		System.out.println("Size: " + Q.size());
		System.out.println("Dequeue: " + Q.dequeue());
		Q.enqueue("Ken");
		System.out.println(Q.front());

	}

}
