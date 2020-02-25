package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CoordinateTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructorBehavior(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
		Assert.assertTrue(Double.isNaN(c.getX()));
		Assert.assertTrue(Double.isNaN(c.getY()));
	}

	@Test
	public void testXYConstructor(){
		Coordinate c = new Coordinate(3.0,4.0);
		Assert.assertFalse(c.isEmpty());
		Assert.assertEquals(3.0,c.getX(),EPSILON);
		Assert.assertEquals(4.0,c.getY(),EPSILON);
	}

	
	@Test
	public void testGetType() {
		Point g = new Point();
		Assert.assertEquals("Point",g.getType());
	}

	@Test
	public void testIsEmpty() {
		Coordinate c = Mockito.mock(Coordinate.class);
		Mockito.when(c.isEmpty()).thenReturn(true);
		Point g = new Point(c);
		Assert.assertTrue(g.isEmpty());
	}

}