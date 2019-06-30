package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * Strategy for adding an arrow to the canvas. When a user left presses the
 * canvas, a new arrow is added. When the user drags, the arrow is being drawn,
 * and finally added to the canvwas when the user releases their press
 * 
 * @author fagutimo
 *
 */
public class ArrowManipulatorStrategy implements ShapeManipulatorStrategy {
	private ShapePoint startPoint;
	private ShapePoint endPoint;
	private Arrow arrow;
	private PaintModel model;

	/**
	 * 
	 * @param model
	 *            sets model
	 */
	public ArrowManipulatorStrategy(PaintModel model) {
		this.model = model;
	}

	/**
	 * Handles event when user presses mouse That is, create a new arrow
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		this.startPoint = new ShapePoint(e.getX(), e.getY());
		this.arrow = new Arrow(startPoint, startPoint);
	}

	/**
	 * Handles event when user drags the muse. That is, give feedback to user as
	 * they draw their arrow
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		this.endPoint = new ShapePoint(e.getX(), e.getY());
		this.arrow.setEndingPoint(endPoint);

		this.arrow.setStyleToModel(this.model);
		this.model.addShape(arrow);
	}

	/**
	 * Handles event when user releases the mouse press. That is, add their drawn
	 * arrow to the canvwas
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		this.endPoint = new ShapePoint(e.getX(), e.getY());
		this.arrow.setEndingPoint(endPoint);

		this.arrow.setStyleToModel(this.model);
		this.model.addShape(arrow);

		// Disconnect
		this.arrow = null;
		this.startPoint = null;
		this.endPoint = null;
	}

	/* UNUSED */
	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
