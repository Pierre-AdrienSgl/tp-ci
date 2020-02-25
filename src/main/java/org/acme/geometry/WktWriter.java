package org.acme.geometry;

/**
 * 
 * Classe d'écriture de la géométrie au format WKT
 * 
 * @author formation
 *
 */
public class WktWriter {
	
	/**
	 * Convertion d'une géométrie en texte
	 * @param geometry
	 * @return
	 */
	public String write(Geometry geometry) {
		StringBuilder s = new StringBuilder();
		if ( geometry instanceof Point ) {
			write(s,(Point)geometry);
		}else if ( geometry instanceof LineString ) {
			write(s,(LineString)geometry);
		}else {
			throw new RuntimeException("geometry type not supported");
		}
		return s.toString();
	}
	
	/**
	 * Ecriture d'un point
	 * @param s
	 * @param g
	 */
	private void write(StringBuilder s, Point point) {
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
	private void write(StringBuilder s, LineString lineString) {
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

}