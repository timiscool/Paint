package ca.utoronto.utm.paint;

/**An arrow is a type of Line, except that the markers
 * are clearly indicated. The tip of the arrow is the endpoint.
 * The arrow is drawn differently from the line.
 * @author HaoMackYang (mulliganaceous)
 */
public class Arrow extends Line {
	/**Constructor for an Arrow shape given two points
	 * @param p1 Starting point (where mouse first clicked)
	 * @param p2 Ending point
	 */
	public Arrow(ShapePoint p1, ShapePoint p2) {
		super(p1, p2);
	}
	
	/**Constructor for a Arrow shape given coordinates
	 * @param x1 x-coordinate of starting point
	 * @param y1 y-coordinate of starting point
	 * @param x2 x-coordinate of ending point
	 * @param y2 y-coordinate of ending point
	 */
	public Arrow(int x1, int y1, int x2, int y2) {
		super(x1, x2, y1, y2);
	}
	
	@Override
	public char getShapeType() {
		return ShapeType.ARROW;
	}
}
