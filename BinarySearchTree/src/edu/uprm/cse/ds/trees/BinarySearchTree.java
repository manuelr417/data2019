package edu.uprm.cse.ds.trees;

import java.util.List;

public interface BinarySearchTree<K, V> {
	/**Finds all entries in the BST that have the given key. 
	 * @param key The key to search for. 
	 * @return ArrayList<Entry<K, V>> containing all those entries (in increasing order of the key) 
	 * in the bst that have the given key. That array list will be empty if none. 
	 */
	List<Entry<K, V>> getAll(K key);  
	
	/**Finds any entry in the bst having the given key. 
	 * @param key the key to search for
	 * @return null if no such entry; otherwise, reference to one of those
	 * entries with the given key. 
	 */
	Entry<K, V> get(K key); 
	
	/**Adds to the BST the new pair key-value as an entry. 
	 * @param key the key of the new entry
	 * @param value the value of the new entry
	 */
	void add(K key, V value); 
	
	/**Removes any copy found of entry with given key in the tree, if any. 
	 * @param key the key to search from
	 * @return null if no such entry is found; otherwise, reference to 
	 * the entry being removed from the tree.
	 */
	Entry<K, V> remove(K key); 
	
	int size();
	
	boolean isEmpty();

}
