package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructorBehavior() {
		Point g = new Point();
		Assert.assertNotNull(g.getCoordinate());
		Assert.assertTrue(Double.isNaN(g.getCoordinate().getX()));
		Assert.assertTrue(Double.isNaN(g.getCoordinate().getY()));
	}

	@Test
	public void testGetType() {
		Point g = new Point();
		Assert.assertEquals("Point", g.getType());
	}

	@Test
	public void testTranslate() {
		Point g = TestGeometryFactory.createSamplePointB();
		g.translate(2.0, 3.0);
		Assert.assertEquals(5.0, g.getX(), EPSILON);
		Assert.assertEquals(7.0, g.getY(), EPSILON);
	}

	@Test
	public void testClone() {
		Point g = new Point(new Coordinate(3.0, 4.0));
		Point copy = g.clone();
		// nouvelle instance de point
		Assert.assertNotSame(g, copy);
		// pas de copie de la coordonnée
		Assert.assertSame(g.getCoordinate(), copy.getCoordinate());
	}

}