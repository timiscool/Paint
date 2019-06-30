package ca.utoronto.utm.paint;

/**A point is constructed (x,y) of two integers, x and y, representing
 * it's location in the GUI. x is the width, y is the depth.
 * All shapes of a given type can be represented in term of its points.
 * @author fagutimo
 */
public class ShapePoint {
	int x, y;
	ShapePoint(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * 
	 * @return the points horizontal location
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x sets the points horizontal location
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the points vertical location
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y sets the points vertical location
	 */
	public void setY(int y) {
		this.y = y;
	}
}
