package ca.utoronto.utm.paint;

/**
 * A dot is a shape that is a dot. A dot cannot be dragged. It is
 * initialized on the event of press
 * @author fagutimo
 *
 */
public class Dot extends Shape {
	private int x, y;
	
	/**
	 * 
	 * @param x horizontal location
	 * @param y vertical location
	 */
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return horizontal location
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @return vertical location
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * return the dot shape type
	 */
	public char getShapeType() {
		return ShapeType.DOT;
	}
}
