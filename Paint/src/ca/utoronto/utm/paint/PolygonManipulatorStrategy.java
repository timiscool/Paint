package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

/**
 * Strategy for constructing a polygon. When a user presses around the canvas
 * with their mouse, points are conected between the clicks, and when a user
 * right presses the canvas, the polygon end and startpoints are both connected
 * 
 * @author fagutimo
 *
 */
public class PolygonManipulatorStrategy implements ShapeManipulatorStrategy {
	private PaintModel model;
	private AbstractPolyline curAPolyline;

	/**
	 * 
	 * @param model
	 *            set model
	 */
	public PolygonManipulatorStrategy(PaintModel model) {
		this.model = model;
		// Let the temporary Polyline be the current polyline.
		this.curAPolyline = (AbstractPolyline) this.model.getTempShape();
	}

	/**
	 * Handles events when user right clicks and left clicks for a polygon
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) { // If you click left button, set point
			if (this.curAPolyline == null) // Create new Polyline if null
				this.curAPolyline = new Polygon();
			ShapePoint polygonVertex = new ShapePoint(e.getX(), e.getY());
			curAPolyline.addPoint(polygonVertex);
			// Set the current temporary polyline to be added.
			this.model.setTempShape(this.curAPolyline);
		} else if (this.curAPolyline != null) { // All other buttons confirm that polyline has been placed
			// Match style and add
			this.curAPolyline.setStyleToModel(model);
			this.model.addShape(this.curAPolyline);
			// Reset the current polyline
			this.model.resetTempShape();
			this.curAPolyline = null;
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