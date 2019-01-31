package edu.uprm.cse.ds.vector;

public interface Vector {
	
	public int getDimensions();
	public double getCoordinate(int idx);
	public double magnitude();
	public Vector scalarProduct(double c);
	public double innerProduct(Vector v2);
	public Vector sum(Vector v2);
	public Vector substract(Vector v2);
	
}
