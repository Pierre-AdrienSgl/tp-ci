package org.acme.geometry;

/**
 * 
 * Interface pour l'écoute de modification sur les géométries
 * 
 *
 *
 */
public interface GeometryListener {
	
	/**
	 * Traitement en cas de changement sur une géométrie
	 */
	public void onChange(Geometry geometry);
	
}