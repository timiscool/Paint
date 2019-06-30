package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**Strategy for determining the coordinate of a Square based on its
 * initial click, the drag position, and the release position.
 * @author Rosenbloomers
 */
public class SquareManipulatorStrategy implements ShapeManipulatorStrategy {
	private Square square;
	private PaintModel model;

	public SquareManipulatorStrategy(PaintModel model) {
		this.model = model;
	}

	public SquareManipulatorStrategy(Square square) {
		this.square = square;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		ShapePoint corner = new ShapePoint(e.getX(), e.getY()); // Get click corner of square
		this.square = new Square(corner, 0, 0); // Create a new square from corner point

		ShapePoint clickPoint = new ShapePoint(e.getX(), e.getY());
		this.square.setClickPoint(clickPoint);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// squares point to draw from
		int minX, minY;

		// Get current squares x & y
		int dragX = e.getX();
		int dragY = e.getY();

		// Get squares original x & position
		int clickPointX = this.square.getClickPoint().getX();
		int clickPointY = this.square.getClickPoint().getY();

		// Set squares side length
		int width = (int) (Math.abs(dragX - this.square.getClickPoint().getX()));
		int height = (int) (Math.abs(dragY - this.square.getClickPoint().getY()));
		int length = Math.max(width, height);
		this.square.setX(length);
		this.square.setY(length);

		// Set new corner according to drag quadrant
		if ((dragX - clickPointX) < 0) {
			minX = (int) (clickPointX - length);
		} else
			minX = (int) (clickPointX);
		if ((dragY - clickPointY) < 0) {
			minY = (int) (clickPointY - length);
		} else
			minY = (int) (clickPointY);

		// Set new corner to update drag
		ShapePoint newCorner = new ShapePoint(minX, minY);
		this.square.setCorner(newCorner);

		// Match the style and add this square to the model
		this.square.setStyleToModel(this.model);
		this.model.addShape(square);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.square.setColor(this.model.getColor());
		this.square.setThickness(this.model.getThickness());

		this.model.addShape(this.square);// Add square to model
		this.square = null; // Reset our square instance

	}
}
