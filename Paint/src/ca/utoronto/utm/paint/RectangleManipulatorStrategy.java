package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/** The strategy to draw a rectangle. This constructs a rectangle based on actionlisteners.
 * 	A rectangle has a corner, width, height.
 * 
 * @author fagutimo
 *
 */
public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {
	private Rectangle rectangle; //rectangle to work with
	private PaintModel model; // to communicate with out model
	
	/**
	 * 
	 * @param model sets model
	 */
	public RectangleManipulatorStrategy(PaintModel model) {
		this.model = model;
	}
	
	/**
	 * 
	 * @param rectangle sets rectangle
	 */
	public RectangleManipulatorStrategy(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	/**
	 * Draws the current rectangle and updates the canvas as the mouse is being dragged
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		
		// Get click corner based on users clickPoint
		int minX = Math.min(this.rectangle.getClickPoint().getX(), e.getX());
		int minY = Math.min(this.rectangle.getClickPoint().getY(), e.getY());

		// Set rectangle's new corner
		ShapePoint corner = new ShapePoint(minX, minY);
		this.rectangle.setCorner(corner);

		// Calculate rectangles widths(x) and heights(y) - Cannot be negative
		int width = Math.abs(this.rectangle.getClickPoint().getX() - e.getX());
		int height = Math.abs(this.rectangle.getClickPoint().getY() - e.getY());

		// Set widths, and heights to respective rectangle
		this.rectangle.setX(width);
		this.rectangle.setY(height);

		// Add the modified rectangles to model
		this.rectangle.setStyleToModel(this.model);
		this.model.addShape(rectangle);
	}

	
	/**
	 *  Adds rectangle to canvas when mouse is released
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		this.rectangle.setColor(this.model.getColor());
		this.rectangle.setThickness(this.model.getThickness());

		this.model.addShape(this.rectangle);// Add rectangle to model
		this.rectangle = null; // Reset our rectangle instance

	}

	/**
	 *  Creates a new instance of a rectangle to work with 
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		ShapePoint corner = new ShapePoint(e.getX(), e.getY()); // Get click corner of rectangle
		this.rectangle = new Rectangle(corner, 0, 0); // Create a new rectangle from corner point

		ShapePoint clickPoint = new ShapePoint(e.getX(), e.getY());
		this.rectangle.setClickPoint(clickPoint);

	}
}
