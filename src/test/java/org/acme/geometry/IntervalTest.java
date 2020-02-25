package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class IntervalTest {

	/**
	 * Test de regression sur expandToInclude
	 * (pas plus coûteux que des "main")
	 */
	@Test
	public void testExpandToInclude() {
		Interval bound = new Interval();
		Assert.assertTrue(bound.isEmpty());

		bound.expandToInclude(5.0);
		Assert.assertEquals(5.0, bound.getLower(), 1.0e-9);
		Assert.assertEquals(5.0, bound.getUpper(), 1.0e-9);

		bound.expandToInclude(-3.0);
		Assert.assertEquals(-3.0, bound.getLower(), 1.0e-9);
		Assert.assertEquals(5.0, bound.getUpper(), 1.0e-9);
		
		bound.expandToInclude(7.0);
		Assert.assertEquals(-3.0, bound.getLower(), 1.0e-9);
		Assert.assertEquals(7.0, bound.getUpper(), 1.0e-9);		
		
		// Double.NaN sans effet
		bound.expandToInclude(Double.NaN);
		Assert.assertTrue(!bound.isEmpty());
	}

}