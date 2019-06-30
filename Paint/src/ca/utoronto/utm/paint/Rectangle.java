package ca.utoronto.utm.paint;

/**Blueprint for rectangles. Rectangles are a polygon that have four sides
 * Widthx22, and heightx2. Each rectangle gives access to their corners,
 * and widths/heights. 
 * 
 * @author fagutimo
 */
public class Rectangle extends Shape {
	private int x; // widths of rectangle
	private int y; // heights of rectangle
	private ShapePoint corner; //corner of rectangle
	private ShapePoint clickPoint; //clickPoint of rectangle
	
	/**
	 * Constructs a rectangle from given corner, width, height
	 * @param corner clickPoint of rectangle
	 * @param x widths of rectangle
	 * @param y heights of rectangle
	 */
	public Rectangle(ShapePoint corner, int x, int y){
		this.x=x;
		this.y=y;
		this.corner = corner;}

	// Getters
	
	/**
	 * 
	 * @return corner of rectangle
	 */
	public ShapePoint getCorner() {
		return corner;
	}
	
	/**
	 * 
	 * @return  rectangles width
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return rectangles height
	 */
	public int getY() {
		return y;
	}
	
	/** 
	 * 
	 * @param x - Sets rectangles width
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @param y - Sets rectangles height
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @param corner - Sets rectangles corner
	 */
	public void setCorner(ShapePoint corner) {
		this.corner = corner;
	}

	/**
	 * 
	 * @param clickPoint - Sets rectangles click point
	 */
	public void setClickPoint(ShapePoint clickPoint) {
		this.clickPoint = clickPoint;
	}
	
	/**
	 * 
	 * @return rectangles clickPoint
	 */
	public ShapePoint getClickPoint() {
		return this.clickPoint;
	}
	
	public ShapePoint clickPoint(ShapePoint clickPoint2) {
		return clickPoint;
	}

	@Override
	public char getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}



}