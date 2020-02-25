package org.acme.geometry;

public class Interval {

	private double lower = Double.NaN ;
	
	private double upper = Double.NaN ;

	public boolean isEmpty() {
		return Double.isNaN(lower) || Double.isNaN(upper) ;
	}
	
	public double getLower() {
		return lower;
	}

	public double getUpper() {
		return upper;
	}

	public void expandToInclude(double v) {
		if ( Double.isNaN(v) ) {
			return;
		}
		if ( isEmpty() ) {
			this.lower = v ;
			this.upper = v ;
		}else {
			this.lower = Double.min(lower, v);
			this.upper = Double.max(upper, v);			
		}
	}

}