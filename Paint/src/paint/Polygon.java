package ca.utoronto.utm.paint;

/**A polygon is a constitution of points. It is a polyline that connects the clickPoint
 * and endPoint to create polygon
 * 
 * @author fagutimo
 *
 */
public class Polygon extends AbstractPolyline {
	// Arraylist of a sequence of points which constitute the
	// polyline.
	public Polygon() {
		super();
	}

	@Override
	public char getShapeType() {
		return ShapeType.POLYGON;
	}
}
