package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogGeometryVisitorTest {
	private ByteArrayOutputStream os;
	private PrintStream ps ;
	
	@Before
	public void setUp() {
		this.os = new ByteArrayOutputStream();
		this.ps = new PrintStream(this.os);
	}
	
	@Test
	public void testPointB() throws UnsupportedEncodingException {
		LogGeometryVisitor visitor = new LogGeometryVisitor(ps);
		Geometry g = TestGeometryFactory.createSamplePointB();
		g.accept(visitor);
		
		String output = os.toString("UTF8");
		Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0",output);
	}
	
	@Test
	public void testLineStringAB() throws UnsupportedEncodingException {
		LogGeometryVisitor visitor = new LogGeometryVisitor(ps);
		Geometry g = TestGeometryFactory.createLineStringAB();
		g.accept(visitor);
		
		String output = os.toString("UTF8");
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s)",output);
	}
	
}