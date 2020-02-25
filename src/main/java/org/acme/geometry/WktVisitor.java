package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder s ;
	
	public WktVisitor() {
		this.s = new StringBuilder();
	}

	public void visit(Point point) {
		s.append("POINT");
		if ( point.isEmpty() ) {
			s.append(" EMPTY");
			return;
		}
		s.append("(");
		write(s,point.getCoordinate());
		s.append(")");
	}

	/**
	 * Ecriture d'une LineString
	 * @param s
	 * @param g
	 */
	public void visit(LineString lineString) {
		s.append("LINESTRING");
		if ( lineString.isEmpty() ) {
			s.append(" EMPTY");
			return;
		}
		s.append("(");
		for ( int i = 0; i < lineString.getNumPoints(); i++) {
			if ( i != 0 ) {
				s.append(",");
			}
			write(s,lineString.getPointN(i).getCoordinate());
		}
		s.append(")");
	}


	@Override
	public void visit(GeometryCollection geometryCollection) {
		s.append("GEOMETRYCOLLECTION");
		if ( geometryCollection.isEmpty() ) {
			s.append(" EMPTY");
			return;
		}
		s.append("(");
		for ( int i = 0; i < geometryCollection.getNumGeometries(); i++ ) {
			if ( i != 0 ) {
				s.append(",");
			}
			geometryCollection.getGeometryN(i).accept(this);
		}
		s.append(")");		
	}
	
	/**
	 * Ecriture d'une coordonnées
	 * @param s
	 * @param coordinate
	 */
	private void write(StringBuilder s, Coordinate coordinate) {
		s.append(coordinate.getX());
		s.append(" ");
		s.append(coordinate.getY());
	}
	
	/**
	 * Renvoie le résultat
	 * @return
	 */
	public String getResult(){
		return s.toString();
	}


}