package org.acme.geometry;

/**
 * 
 * 
 *
 */
public class EnvelopeBuilder {
	private Interval boundsX = new Interval();
	private Interval boundsY = new Interval();
	
	public void insert(Coordinate c) {
		this.boundsX.expandToInclude(c.getX());
		this.boundsY.expandToInclude(c.getY());
	}

	public Envelope build() {
		Coordinate bottomLeft = new Coordinate(
			boundsX.getLower(),
			boundsY.getLower()
		);
		Coordinate topRight = new Coordinate(
			boundsX.getUpper(),
			boundsY.getUpper()
		);		
		return new Envelope(bottomLeft,topRight);
	}

}