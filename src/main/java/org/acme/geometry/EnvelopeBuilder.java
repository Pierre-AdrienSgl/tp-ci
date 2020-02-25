package org.acme.geometry;

/**
 * Calcul d'une bbox
 * 
 * 
 *
 */
public class EnvelopeBuilder implements GeometryVisitor {
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

	@Override
	public void visit(Point point) {
		insert(point.getCoordinate());	
	}

	@Override
	public void visit(LineString lineString) {
		for ( int i = 0; i < lineString.getNumPoints(); i++ ) {
			visit(lineString.getPointN(i));
		}
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
		for ( int i = 0; i < geometryCollection.getNumGeometries(); i++ ) {
			geometryCollection.getGeometryN(i).accept(this);
		}
	}


}