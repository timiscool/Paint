package ca.utoronto.utm.paint;

/**
 * Blueprint for a line. A line is a shape made of two points , a start point
 * and end point.
 * 
 * @author fagutimo
 *
 */
public class Line extends Shape {
	private ShapePoint p1, p2; // end point & start point of line, respectively

	/**
	 * Constructor for a Line shape given two points
	 * 
	 * @param p1
	 *            Starting point (where mouse first clicked)
	 * @param p2
	 *            Ending point
	 */
	public Line(ShapePoint p1, ShapePoint p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Constructor for a Line shape given coordinates
	 * 
	 * @param x1
	 *            x-coordinate of starting point
	 * @param y1
	 *            y-coordinate of starting point
	 * @param x2
	 *            x-coordinate of ending point
	 * @param y2
	 *            y-coordinate of ending point
	 */
	public Line(int x1, int y1, int x2, int y2) {
		this.p1 = new ShapePoint(x1, y1);
		this.p2 = new ShapePoint(x2, y2);
	}

	/**
	 * @return Obtain the starting point of this line
	 */
	public ShapePoint getStartingPoint() {
		return this.p1;
	}

	/**
	 * @return Obtain the ending point of this line
	 */
	public ShapePoint getEndPoint() {
		return this.p2;
	}

	/**
	 * Set the new ending point of this line.
	 * 
	 * @param p2
	 *            location of new endpoint
	 */
	public void setEndingPoint(ShapePoint newP2) {
		this.p2 = newP2;
	}

	@Override
	public char getShapeType() {
		return ShapeType.LINE;
	}
}
