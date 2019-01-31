package edu.uprm.cse.ds.vector;

public class Vector2D implements Vector {
	// fields
	
	private double x;
	
	private double y;
	
	

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getDimensions() {
		return 2;
	}

	@Override
	public double getCoordinate(int idx) {
		if (idx == 0) {
			return this.x;
		}
		else if (idx == 1) {
			return this.y;
		}
		else {
			throw new IllegalArgumentException("idx out of bounds");
		}
	}

	@Override
	public double magnitude() {
		//return Math.sqrt(this.x*this.x + this.y*this.y);
		return Math.sqrt(this.innerProduct(this));
	}

	@Override
	public Vector scalarProduct(double c) {
		return new Vector2D(c*this.x, c*this.y);
	}

	@Override
	public double innerProduct(Vector v2) {
		//return this.x*v2.getCoordinate(0) + this.y * v2.getCoordinate(1);
		return this.getCoordinate(0) * v2.getCoordinate(0) + 
				this.getCoordinate(1) * v2.getCoordinate(1);
	}

	@Override
	public Vector sum(Vector v2) {
		return new Vector2D(this.getCoordinate(0) + 
				v2.getCoordinate(0), 
				this.getCoordinate(1) + v2.getCoordinate(1));
	}

	@Override
	public Vector substract(Vector v2) {
//		return new Vector2D(this.getCoordinate(0) - 
//				v2.getCoordinate(0), 
//				this.getCoordinate(1) - v2.getCoordinate(1));
		
		return this.sum(v2.scalarProduct(-1));

	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	
}
