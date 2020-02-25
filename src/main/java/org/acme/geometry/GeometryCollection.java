package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {

	public static final String TYPE = "GeometryCollection";
	
	private List<Geometry> geometries ;

	public GeometryCollection() {
		this(new ArrayList<Geometry>());
	}
	
	public GeometryCollection(List<Geometry> geometries) {
		this.geometries = geometries;
	}


	@Override
	public String getType() {
		return TYPE;
	}
	
	/**
	 * Renvoie le nombre de géométrie
	 * @return
	 */
	public int getNumGeometries() {
		return geometries.size();
	}
	
	/**
	 * Renvoie la n-ième géométrie
	 * @param n
	 * @return
	 */
	public Geometry getGeometryN(int n) {
		return geometries.get(n);
	}


	@Override
	public boolean isEmpty() {
		return geometries.isEmpty();
	}
	
		@Override
	public void translate(double dx, double dy) {
		for (Geometry geometry : geometries) {
			geometry.translate(dx, dy);
		}
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Geometry clone() {
		// Il faut copier le tableau
		List<Geometry> newGeometries = new ArrayList<>(geometries.size());
		for (Geometry geometry : geometries) {
			// les points ne sont pas immuable
			newGeometries.add(geometry.clone());
		}
		return new GeometryCollection(newGeometries);
	}
	
	
	
}