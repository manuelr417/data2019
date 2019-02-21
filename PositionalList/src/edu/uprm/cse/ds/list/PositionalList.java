package edu.uprm.cse.ds.list;

public interface PositionalList<T> extends Iterable<T> {
	
	public int size();
	
	public boolean isEmpty();
	
	public Position<T> first();
	
	public Position<T> last();
	
	public Position<T> before(Position<T> p);
	
	public Position<T> after(Position<T> p);
	
	public void addFirst(T e);
	
	public void addLast(T e);
	
	public void addBefore(Position<T> p, T e);

	public void addAfter(Position<T> p, T e);
	
	public T set(Position<T> p, T e);
	
	public T remove(Position<T> p);
	

}
