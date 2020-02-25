package org.acme.geometry;

/**
 * 
 * Illustration du principe de décorateur sur la mise en cache de l'enveloppe
 * 
 * Remarque : On sent que la classe est trop complexe pour être décorée en situation réelle (trop de responsabilité difficile à "forwarder")
 * 
 *
 *
 */
public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {
	
	private Geometry original;
	
	private Envelope cachedEnvelope;
	
	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.original.addListener(this);
	}

	@Override
	public String getType() {
		return this.original.getType();
	}

	@Override
	public boolean isEmpty() {
		return this.original.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		this.original.translate(dx, dy);
	}

	@Override
	public Geometry clone() {
		// limite...
		return this.original.clone();
	}

	@Override
	public Envelope getEnvelope() {
		if ( cachedEnvelope == null ) {
			this.cachedEnvelope = this.original.getEnvelope();
		}
		return this.cachedEnvelope;
	}

	@Override
	public String asText() {
		return this.original.asText();
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		this.original.accept(visitor);
	}

	@Override
	public void triggerChange() {
		this.original.triggerChange();
	}

	@Override
	public void addListener(GeometryListener listener) {
		// limite...
		this.original.addListener(listener);
	}

	@Override
	public void onChange(Geometry geometry) {
		// nettoyage du cache
		this.cachedEnvelope = null;
	}

}