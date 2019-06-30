package ca.utoronto.utm.paint;

import java.util.ArrayList; 

/** An AbitraryShape is a shape that does not require specific
 * dimensions when being constructed. It adds sequences of points which
 * constitute the polygon to create the shape
 * 
 * @author 
 *
 */
public abstract class ArbitraryShape extends Shape {
	// Arraylist of a sequence of points which constitute the
	// polygon.
	private ArrayList<ShapePoint> pointSequence = new ArrayList<ShapePoint>();
	
	public void addPoint(int x, int y) {
		ShapePoint newPoint = new ShapePoint(x, y);
		this.pointSequence.add(newPoint);
	}
	
	public void addPoint(ShapePoint newPoint) {
		this.pointSequence.add(newPoint);
	}
	
	public int numOfPoints() {
		return this.pointSequence.size();
	}
	
	public ShapePoint getPoint(int k) {
		return this.pointSequence.get(k);
	}
	
	public ArrayList<ShapePoint> getPointSequence() {
		return this.pointSequence;
	}
	
	public String toString() {
		String str = "";
		for (int k = 0; k < this.pointSequence.size(); k++) {
			ShapePoint point = this.pointSequence.get(k);
			str += "(" + point.getX() + "," + point.getY() + ")";
		}
		return str;
	}
}
