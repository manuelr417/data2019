package edu.uprm.cse.ds.vector;

public class VectornD implements Vector {
	
	private double coordinates[];
	
	public VectornD(double coordinates[]) {
		if (coordinates == null) {
			throw new IllegalArgumentException("coodrdinates cannot be null");
		}
		this.coordinates = coordinates.clone();
	}
	

	@Override
	public int getDimensions() {
		return coordinates.length;
	}

	@Override
	public double getCoordinate(int idx) {
		if ((idx < 0) || (idx >= this.coordinates.length)){
			throw new IndexOutOfBoundsException();
		}
		return this.coordinates[idx];
	}

	@Override
	public double magnitude() {
		return Math.sqrt(this.innerProduct(this));
	}

	@Override
	public Vector scalarProduct(double c) {
		double newCoordinates[] = this.coordinates.clone();
		for (int i=0; i < this.getDimensions(); ++i) {
			newCoordinates[i] *= c; 
		}
		return new VectornD(newCoordinates);
	}

	@Override
	public double innerProduct(Vector v2) {
		double result = 0;
		if (v2.getDimensions() != this.getDimensions()) {
			throw new IllegalArgumentException("Dimensions do not match.");
			
		}
		for (int i=0; i < this.getDimensions(); ++i) {
			result += this.getCoordinate(i) * v2.getCoordinate(i);
		}
		return result;
	}

	@Override
	public Vector sum(Vector v2) {
		// TODO Auto-generated method stub
		if (v2.getDimensions() != this.getDimensions()) {
			throw new IllegalArgumentException("Dimensions do not match.");
			
		}	
		double newCoordinates[] = new double[this.getDimensions()];
		for (int i=0; i < this.getDimensions();++i) {
			newCoordinates[i] = this.getCoordinate(i) + 
					v2.getCoordinate(i);
		}
		return new VectornD(newCoordinates);
	}

	@Override
	public Vector substract(Vector v2) {
		return this.sum(v2.scalarProduct(-1));
	}

	@Override
	public String toString() {
		String result = "(";
		for (int i=0; i < this.getDimensions()-1; ++i) {
			result += this.getCoordinate(i) + ", ";
		}
		result += this.getCoordinate(this.getDimensions()-1);
		result += ")";
		return result;
	}
}
