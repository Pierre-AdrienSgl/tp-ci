package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class TestGeometryFactory {

	/**
	 * Point A en [0.0,0.0]
	 */
	public static Point createSamplePointA() {
		return new Point(new Coordinate(0.0, 0.0));
	}

	/**
	 * Point B en [3.0,4.0]
	 */	
	public static Point createSamplePointB() {
		return new Point(new Coordinate(3.0, 4.0));
	}	

	/**
	 * LineString [AB]
	 * @return
	 */
	public static LineString createLineStringAB() {
		List<Point> points = new ArrayList<>();
		points.add(createSamplePointA());
		points.add(createSamplePointB());
		return new LineString(points);
	}

}