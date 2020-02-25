package org.acme.geometry;

/**
 * 
 * Remarque : une fois Interval créé, on se rend compte que bottonLeft et topRight
 * ne sont pas optimaux pour le stockage
 * 
 * 
 *
 */
public class Envelope {
	
	private Coordinate bottomLeft;
	
	private Coordinate topRight ;

	public Envelope() {
		this.bottomLeft = new Coordinate();
		this.topRight = new Coordinate();		
	}
	
	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		// Remarque : aucun garde fou ici
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	public boolean isEmpty() {
		return bottomLeft.isEmpty() || topRight.isEmpty() ;
	}
	
	public double getXMin() {
		return bottomLeft.getX();
	}
	
	public double getYMin() {
		return bottomLeft.getY();
	}
	
	public double getXMax() {
		return topRight.getX();
	}
	
	public double getYMax() {
		return topRight.getY();
	}

	@Override
	public String toString() {
		if ( isEmpty() ) {
			return "EMPTY";
		}
		return getXMin()+" "+getYMin()+" "+getXMax()+" "+getYMax();
	}
	
}