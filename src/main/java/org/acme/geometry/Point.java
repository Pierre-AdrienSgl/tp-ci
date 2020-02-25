package org.acme.geometry;

public class Point implements Geometry {

	public static final String TYPE = "Point";

	private Coordinate coordinate ;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public double getX() {
		return coordinate.getX();
	}

	public double getY() {
		return coordinate.getY();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.coordinate = new Coordinate(
			this.coordinate.getX()+dx, 
			this.coordinate.getY()+dy
		);
	}

	@Override
	public Point clone() {
		// Remarque : coordinate est immuable
		return new Point(coordinate);
	}
	
	@Override
	public Envelope getEnvelope() {
		return new Envelope(coordinate,coordinate);
	}
	
}