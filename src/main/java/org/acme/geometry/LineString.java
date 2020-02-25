package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {

	public static final String TYPE = "LineString";
	
	private List<Point> points ;
	
	public LineString() {
		this.points = new ArrayList<>();
	}
	
	public LineString(List<Point> points) {
		this.points = points;
	}
	
	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}
	
	public int getNumPoints() {
		return this.points.size();
	}

	public Point getPointN(int n) {
		return points.get(n);
	}

	@Override
	public void translate(double dx, double dy) {
		for (Point point : points) {
			point.translate(dx, dy);
		}
		triggerChange();
	}

	
	@Override
	public LineString clone() {
		// Il faut copier le tableau
		List<Point> newPoints = new ArrayList<>(getNumPoints());
		for (Point point : points) {
			// les points ne sont pas immuable
			newPoints.add(point.clone());
		}
		return new LineString(newPoints);
	}


	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}