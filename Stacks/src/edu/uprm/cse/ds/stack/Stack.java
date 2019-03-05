package edu.uprm.cse.ds.stack;

public interface Stack<T> {
	
	public int size();
	
	public boolean isEmpty();
	
	public T top();
	
	public T pop();
	
	public void push(T e);
	
	public void makeEmpty();
	

}
