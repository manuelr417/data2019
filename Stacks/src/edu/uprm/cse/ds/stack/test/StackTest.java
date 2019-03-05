package edu.uprm.cse.ds.stack.test;

import edu.uprm.cse.ds.stack.ArrayStack;
import edu.uprm.cse.ds.stack.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> S = new ArrayStack<String>();
		
		S.push("Apu");
		S.push("Joe");
		S.push("Ned");
		S.push("Jil");
		System.out.println("Top: " + S.top());
		System.out.println("Size: " + S.size());
		System.out.println("Pop: " + S.pop());
		S.push("Ken");
		System.out.println(S.top());


	}

}
