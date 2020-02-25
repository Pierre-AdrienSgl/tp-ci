package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructorBehavior(){
		LineString g = new LineString();
		Assert.assertEquals(0, g.getNumPoints());
	}

	@Test
	public void testGetType() {
		LineString g = new LineString();
		Assert.assertEquals("LineString",g.getType());
	}

}