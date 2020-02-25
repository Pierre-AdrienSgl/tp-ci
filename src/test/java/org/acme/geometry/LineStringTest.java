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
	

	@Test
	public void testClone() {
		LineString g = TestGeometryFactory.createLineStringAB();
		LineString copy = g.clone();
		Assert.assertNotSame(g.getPointN(0), copy.getPointN(0));
	}	

	@Test
	public void testTranslate() {
		LineString g = TestGeometryFactory.createLineStringAB();

		g.translate(2.0, 3.0);
		{
			Point p = g.getPointN(0);
			Assert.assertEquals(2.0,p.getX(),EPSILON);
			Assert.assertEquals(3.0,p.getY(),EPSILON);
		}
		{
			Point p = g.getPointN(1);
			Assert.assertEquals(5.0,p.getX(),EPSILON);
			Assert.assertEquals(7.0,p.getY(),EPSILON);
		}
	}
	
	@Test
	public void testGetEnvelopeEmpty() {
		LineString g = new LineString();
		Envelope bbox = g.getEnvelope();
		Assert.assertTrue(bbox.isEmpty());
	}
	
	@Test
	public void testGetEnvelope() {
		LineString g = TestGeometryFactory.createLineStringAB();
		
		Envelope bbox = g.getEnvelope();
		Assert.assertFalse(bbox.isEmpty());
		Assert.assertEquals(0.0, bbox.getXMin(), 1.0e-9);
		Assert.assertEquals(3.0, bbox.getXMax(), 1.0e-9);
		Assert.assertEquals(0.0, bbox.getYMin(), 1.0e-9);
		Assert.assertEquals(4.0, bbox.getYMax(), 1.0e-9);
	}
	
	
}