package edu.uprm.cse.ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	
	@Override
	public Position<E> sibling(Position<E> p){
		Position<E> parent = parent(p); 
	       
		if (parent == null) 
			return null; 
		// which node is p
	    if (p== left(parent)) 
	    	return right(parent); 
	    else 
	    	return left(parent); 
	
	}
	
	@Override
	public int numChildren(Position<E> p) {
		int count = 0;
		if (this.left(p) != null) {
			count++;
		}
		if (this.right(p) != null) {
			count++;
		}
		return count;
	
	}
	
	@Override
	public Iterable<Position<E>> children(Position<E> p){
		ArrayList<Position<E>> list = new ArrayList<Position<E>>(2);
		
		if (this.left(p) != null) {
			list.add(this.left(p));
		}
		if (this.right(p) != null) {
			list.add(this.right(p));
		}
		return list;

		
	}
	@Override
	public Iterable<Position<E>> InOrderIterable(){
		List<Position<E>> list =
				new LinkedList<Position<E>>();
		Position<E> r = this.root();
		if (r == null) {
			return list;
		}
		InOrderAuxiliary(r, list);
		return list;
	}

	private void InOrderAuxiliary(Position<E> p, List<Position<E>> list) {
		if (p == null) {
			return;
		}
		else {
			InOrderAuxiliary(this.left(p), list);
			list.add(p);
			InOrderAuxiliary(this.right(p), list);
		}
	}

	@Override
	public Iterable<Position<E>> PreOrderIterable(){
		List<Position<E>> list =
				new LinkedList<Position<E>>();
		Position<E> r = this.root();
		if (r == null) {
			return list;
		}
		PreOrderAuxiliary(r, list);
		return list;
	}

	private void PreOrderAuxiliary(Position<E> p, List<Position<E>> list) {
		if (p == null) {
			return;
		}
		else {
			list.add(p);
			PreOrderAuxiliary(this.left(p), list);
			PreOrderAuxiliary(this.right(p), list);
		}
		
	}

	@Override
	public Iterable<Position<E>> PostOrderIterable(){
		List<Position<E>> list =
				new LinkedList<Position<E>>();
		Position<E> r = this.root();
		if (r == null) {
			return list;
		}
		PostOrderAuxiliary(r, list);
		return list;
	}

	private void PostOrderAuxiliary(Position<E> p, List<Position<E>> list) {
		if (p == null) {
			return;
		}
		else {
			PostOrderAuxiliary(this.left(p), list);
			PostOrderAuxiliary(this.right(p), list);
			list.add(p);
		}
		
	}
	
	@Override
	public Iterable<Position<E>> bfsIterable(){
		List<Position<E>> list =
				new LinkedList<Position<E>>();
	
		List<Position<E>> queue =
				new LinkedList<Position<E>>();
		
		Position<E> r = this.root();
		if (r == null) {
			return list; //empty list
		}
		queue.add(r);
		Position<E> p = null;
		while(!queue.isEmpty()) {
			p = queue.remove(0);
			list.add(p);
			for (Position<E> child : this.children(p)){
				queue.add(child);
			}
		}
		return list;
	}


}
