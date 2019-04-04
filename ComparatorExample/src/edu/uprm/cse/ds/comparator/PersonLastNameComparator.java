package edu.uprm.cse.ds.comparator;

public class PersonLastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person a, Person b) {
		return a.getLastName().compareTo(b.getLastName());
	}

}
