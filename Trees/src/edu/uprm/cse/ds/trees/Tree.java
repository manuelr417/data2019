package edu.uprm.cse.ds.trees;

public interface Tree<E> extends Iterable<E> {
	
	public Position<E> root();
	
	public Position<E> parent(Position<E> p);
	
	public Iterable<Position<E>> children(Position<E> p);
	
	public boolean isRoot(Position<E> p);
	public boolean isExternal(Position<E> p);
	public boolean isInternal(Position<E> p);

	public int numChildren(Position<E> p);
	 
	public int size(); 
	public boolean isEmpty();

}
