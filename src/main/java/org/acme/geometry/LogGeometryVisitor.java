package org.acme.geometry;

import java.io.PrintStream;

/**
 * Rendre testable quelque chose du type "écrire dans la console" :
 * 
 * Ajouter une variable membre passée au constructeur
 * 
 * 
 *
 */
public class LogGeometryVisitor implements GeometryVisitor {

	private PrintStream out;
	
	public LogGeometryVisitor() {
		this(System.out);
	}
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public void visit(Point point) {
		out.print("Je suis un point avec x="+point.getX()+" et y="+point.getY());
	}

	@Override
	public void visit(LineString lineString) {
		out.print("Je suis une polyligne définie par "+lineString.getNumPoints()+" point(s)");
	}

	@Override
	public void visit(GeometryCollection geometryCollection) {
		out.print("Je suis une collection contenant "+geometryCollection.getNumGeometries()+" géométrie(s)");
	}
	

}