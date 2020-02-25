package org.acme.geometry;

/**
 * 
 * Classe coordonnée à l'étape 0.1
 * 
 * @author MBorne
 *
 */
public class Coordinate {
	
	private double x;
	
	private double y;
	
	public Coordinate() {
		this(0.0,0.0);
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

}