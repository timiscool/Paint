package ca.utoronto.utm.paint;

/**Blueprint of a circle. A circle has a centre, which is its clickPoint
 * A circle has a radius, which is pre given. A circle gives access
 * to its radius and centre,
 * @author fagutimo
 */
public class Circle extends Shape {
	private ShapePoint centre; // centre of circle
	private int radius; // radius of circle
	
	/**Constructs a Circle with a given centre and radius.
	 * @param centre The location of the centre of the circle.
	 * @param radius The radius of the circle (distance from centre).
	 */
	public Circle(ShapePoint centre, int radius){
		this.centre = centre;
		this.radius = radius;
	}
	
	/**
	 * 
	 * @return centre of circle
	 */
	public ShapePoint getCentre() {
		return centre;
	}

	/**
	 * 
	 * @param sets centre of circle
	 */
	public void setCentre(ShapePoint centre) {
		this.centre = centre;
	}

	/**
	 * 
	 * @return radius of circle
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius sets radius of circle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public char getShapeType() {
		return ShapeType.CIRCLE;
	}

}
