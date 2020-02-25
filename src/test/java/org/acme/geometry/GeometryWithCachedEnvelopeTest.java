package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GeometryWithCachedEnvelopeTest {

	@Test
	public void testUseCache() {
		Geometry original = Mockito.mock(Geometry.class);
		Envelope bbox = new Envelope();
		Mockito.when(original.getEnvelope()).thenReturn(bbox);

		GeometryWithCachedEnvelope cached = new GeometryWithCachedEnvelope(original);
		Assert.assertSame( bbox, cached.getEnvelope() );
		Assert.assertSame( bbox, cached.getEnvelope() );
		
		// On vérifie que getEnvelope a été appelé une seule fois
		Mockito.verify(original, Mockito.times(1)).getEnvelope();	
	}

	/**
	 * Test fonctionnel en cas de translation
	 */
	@Test
	public void testTranslate() {
		Geometry original = TestGeometryFactory.createLineStringAB();
		GeometryWithCachedEnvelope geometry = new GeometryWithCachedEnvelope(original);
		Envelope bboxA = geometry.getEnvelope();
		Assert.assertEquals("0.0 0.0 3.0 4.0", bboxA.toString());
		geometry.translate(1.0, 1.0);
		Envelope bboxB = geometry.getEnvelope();
		Assert.assertNotSame(bboxA, bboxB);
		Assert.assertEquals("1.0 1.0 4.0 5.0", bboxB.toString());
	}

	
}