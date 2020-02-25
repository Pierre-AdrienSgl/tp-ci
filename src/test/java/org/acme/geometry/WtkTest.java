package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktTest {

	@Test
	public void testEmptyPoint() {
		Geometry g = new Point();
		Assert.assertEquals("POINT EMPTY", g.asText());
	}

	@Test
	public void testPointOrigin() {
		String wkt = TestGeometryFactory.createSamplePointA().asText();
		Assert.assertEquals("POINT(0.0 0.0)", wkt);
	}

	@Test
	public void testPointB() {
		String wkt = TestGeometryFactory.createSamplePointB().asText();
		Assert.assertEquals("POINT(3.0 4.0)", wkt);
	}

	@Test
	public void testEmptyLineString() {
		String wkt = (new LineString()).asText();
		Assert.assertEquals("LINESTRING EMPTY", wkt);
	}

	@Test
	public void testLineStringAB() {
		String wkt = TestGeometryFactory.createLineStringAB().asText();
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", wkt);
	}

	@Test
	public void testEmptyCollection() {
		String wkt = (new GeometryCollection()).asText();
		Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", wkt);
	}

	@Test
	public void testCollectionA() {
		String wkt = TestGeometryFactory.createCollectionA().asText();
		Assert.assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(0.0 0.0,3.0 4.0))", wkt);
	}
}