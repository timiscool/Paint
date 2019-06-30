package ca.utoronto.utm.paint;
import java.awt.event.MouseEvent;

/**
 * Strategy for adding a line to the canvas. When a user presses on the canvas,
 * a line is created. When the user drags on the canvas, they see the updated
 * line. Finally, when a user releases their press, the line is added to the
 * canvwas
 * 
 * @author fagutimo
 *
 */
public class LineManipulatorStrategy implements ShapeManipulatorStrategy {
	private ShapePoint startPoint; // line startpoint
	private ShapePoint endPoint; // line endpoint
	private Line line; // line to work with
	private PaintModel model; // model to work with

	/**
	 * 
	 * @param model
	 *            set model
	 */
	public LineManipulatorStrategy(PaintModel model) {
		this.model = model;
	}

	/**
	 * Handles event when mouse is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		this.startPoint = new ShapePoint(e.getX(), e.getY()); // Make our start point our mousePressed x,y
		this.line = new Line(startPoint, startPoint); // create new line
	}

	/**
	 * Handles event when mouse is dragged (feedback of the line)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		this.endPoint = new ShapePoint(e.getX(), e.getY());
		this.line.setEndingPoint(endPoint);

		this.line.setStyleToModel(this.model);
		this.model.addShape(line);
	}

	/**
	 * Handles event when mouse is released - set end point and connect the line
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// get and set endpoints
		this.endPoint = new ShapePoint(e.getX(), e.getY());
		this.line.setEndingPoint(endPoint);

		this.line.setStyleToModel(this.model);
		this.model.addShape(line);

		// Disconnect
		this.line = null;
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
