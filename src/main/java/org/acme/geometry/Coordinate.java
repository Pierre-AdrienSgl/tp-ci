package org.acme.geometry;

/**
 * 
 * Classe coordonnée à l'étape 0.1
 * 
 * 
 *
 */
public class Coordinate {
	
	private double x;
	
	private double y;
	
	public Coordinate() {
		this(Double.NaN,Double.NaN);
	}
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isEmpty() {
		return Double.isNaN(x) || Double.isNaN(y);
	}

}