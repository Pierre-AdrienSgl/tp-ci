package org.acme.geometry;

/**
 * 
 * Permet d'appliquer un traitement 
 * 
 * 
 *
 */
public interface GeometryVisitor {

	public void visit(Point point);
	
	public void visit(LineString lineString);

	public void visit(GeometryCollection geometryCollection);

}