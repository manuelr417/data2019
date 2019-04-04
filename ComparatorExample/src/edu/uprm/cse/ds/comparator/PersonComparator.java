package edu.uprm.cse.ds.comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person a, Person b) {
		return a.getId() - b.getId();
	}

}
