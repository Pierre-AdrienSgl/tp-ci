package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testEmptyPoint() {
		WktWriter writer = new WktWriter();
		String wkt = writer.write(new Point());
		Assert.assertEquals("POINT EMPTY", wkt);
	}

	@Test
	public void testPointOrigin() {
		WktWriter writer = new WktWriter();
		String wkt = writer.write(TestGeometryFactory.createSamplePointA());
		Assert.assertEquals("POINT(0.0 0.0)", wkt);
	}

	@Test
	public void testPointB() {
		WktWriter writer = new WktWriter();
		String wkt = writer.write(TestGeometryFactory.createSamplePointB());
		Assert.assertEquals("POINT(3.0 4.0)", wkt);
	}

	@Test
	public void testEmptyLineString() {
		WktWriter writer = new WktWriter();
		String wkt = writer.write(new LineString());
		Assert.assertEquals("LINESTRING EMPTY", wkt);
	}

	@Test
	public void testLineStringAB() {
		WktWriter writer = new WktWriter();
		String wkt = writer.write(TestGeometryFactory.createLineStringAB());
		Assert.assertEquals("LINESTRING(0.0 0.0,3.0 4.0)", wkt);
	}

}