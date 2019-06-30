package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**
 * Strategy for adding a dot to the canvas. A dot is added to the canvwas when
 * the user presses on the canvwas
 * 
 * @author timothyfagu
 *
 */
public class DotManipulatorStrategy implements ShapeManipulatorStrategy {
	private Dot d; // dot to work with
	private PaintModel model; // model to speak with

	/**
	 * 
	 * @param model
	 *            set model
	 */
	public DotManipulatorStrategy(PaintModel model) {
		this.model = model;
	}

	/**
	 * Handles event when mouse is pressed
	 */
	public void mousePressed(MouseEvent e) {
		// get clickpoint
		// add this dot to canvas
		this.d = new Dot(e.getX(), e.getY());
		this.d.setStyleToModel(this.model);
		this.model.addShape(this.d);
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}
