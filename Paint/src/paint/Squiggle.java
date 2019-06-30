package ca.utoronto.utm.paint;

/**A Squiggle can be defined as a sequence of points
 * that has been created by the drag of a mouse.
 */
public class Squiggle extends ArbitraryShape {
	public Squiggle() {
		super();
	}

	@Override
	public char getShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.SQUIGGLE;
	}
}
