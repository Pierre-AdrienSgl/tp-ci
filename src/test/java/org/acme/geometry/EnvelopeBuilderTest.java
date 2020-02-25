package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {

	/**
	 * Test fonctionnel sur EnvelopeBuilder
	 */
	@Test
	public void testRegress() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		{
			Envelope bbox = builder.build();
			Assert.assertTrue(bbox.isEmpty());
		}

		builder.insert(new Coordinate(3.0, 4.0));
		{
			Envelope bbox = builder.build();
			Assert.assertFalse(bbox.isEmpty());
			Assert.assertEquals(3.0, bbox.getXMin(), 1.0e-9);
			Assert.assertEquals(3.0, bbox.getXMax(), 1.0e-9);
			Assert.assertEquals(4.0, bbox.getYMin(), 1.0e-9);
			Assert.assertEquals(4.0, bbox.getYMax(), 1.0e-9);
		}

		builder.insert(new Coordinate(2.0, 5.0));
		{
			Envelope bbox = builder.build();
			Assert.assertFalse(bbox.isEmpty());
			Assert.assertEquals(2.0, bbox.getXMin(), 1.0e-9);
			Assert.assertEquals(3.0, bbox.getXMax(), 1.0e-9);
			Assert.assertEquals(4.0, bbox.getYMin(), 1.0e-9);
			Assert.assertEquals(5.0, bbox.getYMax(), 1.0e-9);
		}
	}

}