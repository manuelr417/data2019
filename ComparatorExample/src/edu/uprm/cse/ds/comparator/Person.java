package edu.uprm.cse.ds.comparator;

public class Person {
	private int id;
	private String firstName;
	private String lastName;
	
	public Person(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

}
