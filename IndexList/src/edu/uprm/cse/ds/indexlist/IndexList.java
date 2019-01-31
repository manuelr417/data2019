package edu.uprm.cse.ds.indexlist;

public interface IndexList<T> {
    int size(); 
    boolean isEmpty(); 
    T get(int index) throws IndexOutOfBoundsException; 
    T remove(int index) throws IndexOutOfBoundsException; 
    T set(int index, T e) throws IndexOutOfBoundsException; 
    void add(int index, T e) throws IndexOutOfBoundsException; 
    void add(T e); 

}
