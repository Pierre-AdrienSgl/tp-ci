package org.acme.geometry;

public interface Geometry {
	
	/**
	 * Renvoie le type géométrique
	 * @return
	 */
	public String getType();

	/**
	 * Indique si la géométrie est vide
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Translate la géométrie
	 * @param dx
	 * @param dy
	 */
	public void translate(double dx, double dy);
	
	/**
	 * Renvoie une copie de la géométrie
	 * @return
	 */
	public Geometry clone() ;
	
	/**
	 * Renvoie la bbox de la géométrie
	 * @return
	 */
	public Envelope getEnvelope() ;

}