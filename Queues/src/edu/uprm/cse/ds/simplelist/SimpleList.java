package edu.uprm.cse.ds.simplelist;

public interface SimpleList<T> {
    int size();                    // get current size
    boolean isEmpty();     // verify if empty
    T first();                       // return ref to first element; null if empty
    T last();                       // return ref to last element; null if empty
    void addFirst(T e);     // insert element e as first element
    void addLast(T e);     // insert element e as last element
    T removeFirst();        // remove and return first element; null if empty        
    T removeLast() ;       // remove and return last element; null if empty  
}
