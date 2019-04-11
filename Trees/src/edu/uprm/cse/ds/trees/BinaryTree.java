package edu.uprm.cse.ds.trees;

public interface BinaryTree<E> extends Tree<E> {
	
	public Position<E> left(Position<E> p);
	public Position<E> right(Position<E> p);
	public Position<E> sibling(Position<E> p);
	// Manuel's
	public Iterable<Position<E>> PreOrderIterable();
	public Iterable<Position<E>> InOrderIterable();
	public Iterable<Position<E>> PostOrderIterable();
	public Iterable<Position<E>> bfsIterable();


}
