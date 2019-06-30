package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * Strategy for adding a circle to the canvas. This strategy will update an
 * instance of a circle as the user presses, and drags the mouse, and will add
 * the desired circle when the user releases the mouse press.
 * 
 * 
 * @author fagutimo
 *
 */
public class CircleManipulatorStrategy implements ShapeManipulatorStrategy {
	private ShapePoint centre;
	private ShapePoint dragClick;
	private Circle circle;
	private PaintModel model;

	/**
	 * 
	 * @param model
	 *            set model
	 */
	public CircleManipulatorStrategy(PaintModel model) {
		this.model = model;
	}

	/**
	 * Handles event when mouse is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// Get centre of circle
		ShapePoint centre = new ShapePoint(e.getX(), e.getY());
		this.circle = new Circle(centre, 0);
	}

	/**
	 * Handles events when mouse is Dragged That is, this method will present the
	 * user with feedback regarding how their circle looks like
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		centre = this.circle.getCentre(); // Original click
		dragClick = new ShapePoint(e.getX(), e.getY()); // Current drag

		// Calculate and set appropriate radius
		int x = dragClick.getX() - centre.getX();
		int y = dragClick.getY() - centre.getY();
		int radius = (int) Math.sqrt(x * x + y * y);
		radius = Math.abs(radius);
		this.circle.setRadius(radius);

		// Add modified circles to the model
		this.circle.setStyleToModel(this.model);
		this.model.addShape(this.circle);
	}

	/**
	 * 
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

		// Set circle styles
		this.circle.setColor(this.model.getColor());
		this.circle.setThickness(this.model.getThickness());

		// add circle to model
		this.model.addShape(this.circle);

		// Disconnect circle & centre
		this.circle = null;
		this.centre = null;
		this.dragClick = null;
	}

	// UNSUED methods
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
