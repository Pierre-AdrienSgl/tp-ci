package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructorBehavior(){
		Point g = new Point();
		Assert.assertNotNull(g.getCoordinate());
		Assert.assertEquals(0.0, g.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(0.0, g.getCoordinate().getY(), EPSILON);		
	}

	@Test
	public void testGetType() {
		Point g = new Point();
		Assert.assertEquals("Point",g.getType());
	}

}