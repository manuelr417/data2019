package edu.uprm.cse.ds.trees;

import java.util.Iterator;

public abstract class AbstractTree<E> implements Tree<E> {

	@Override
	public boolean isRoot(Position<E> p) {
		return this.parent(p) == null;    // validation of p is done in parent(...)
	}
	
	@Override
	public boolean isInternal(Position<E> p) {
		return this.numChildren(p) > 0;      // validation of p is done in numChildren(...)
	}
	
	@Override
	public boolean isExternal(Position<E> p)  { 
		return this.numChildren(p) == 0;   // validation of p is done in numChildren(...)
	}
	
	@Override
	public boolean isEmpty() { 
		return size() == 0; 
	}


}
