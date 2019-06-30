package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

/** Strategy for constructing a polyline. A polyline is a collection of points that
 * 	are conneted by their end points. The polyline is set to the canvas when the user
 * 	right clicks
 * 
 * @author timothyfagu
 *
 */
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintModel model;
	private Polyline curPolyline;

	/**
	 * 
	 * @param model sets model
	 */
	public PolylineManipulatorStrategy(PaintModel model) {
		this.model = model;
		// Let the temporary shape be the current polyline.
		this.curPolyline = (Polyline) this.model.getTempShape();
	}

	/**
	 * Handles the mouse pressed events when polyline is selected
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) { // If you click left button, set point
			if (this.curPolyline == null) // Create new Polyline if null
				this.curPolyline = new Polyline();
			ShapePoint polygonVertex = new ShapePoint(e.getX(), e.getY());
			curPolyline.addPoint(polygonVertex);
			// Set the current temporary polyline to be added.
			this.model.setTempShape(this.curPolyline);
		} else 
			if (this.curPolyline != null) { // All other buttons confirm that polyline has been placed
			// Match style and add
			this.curPolyline.setColor(this.model.getColor());
			this.curPolyline.setThickness(this.model.getThickness());
			this.model.addShape(this.curPolyline);
			// Reset the current polyline
			this.model.resetTempShape();
			this.curPolyline = null;
		}
	}

	/* UNUSED */
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

