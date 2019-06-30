package ca.utoronto.utm.paint;

/**A Polyline is a sequence of points in which it is drawn
 * by connecting lines through all the points in order from
 * first to last.
 * 
 * It is one form of ArbitraryShape.
 * @author fagutimo
 */
public class Polyline extends AbstractPolyline {
	// Arraylist of a sequence of points which constitute the
	// polyline.
	public Polyline() {
		super();
	}

	@Override
	public char getShapeType() {
		return ShapeType.POLYLINE;
	}
}

