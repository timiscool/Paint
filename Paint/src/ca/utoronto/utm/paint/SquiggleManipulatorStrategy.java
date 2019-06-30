package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**Strategy for constructing a Squiggle based on its initial click,
 * its position over time as you drag the mouse, and the release
 * of the mouse's button.
 * @author Rosenbloomers
 */
public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy {
	private Squiggle curSquiggle = null;
	private PaintModel model;
	
	public SquiggleManipulatorStrategy(PaintModel model) {
		this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (this.curSquiggle == null) {
			this.curSquiggle = new Squiggle();	
			// Set style and add
			this.curSquiggle.setColor(this.model.getColor());
			this.curSquiggle.setThickness(this.model.getThickness());
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		ShapePoint p = new ShapePoint(e.getX(), e.getY());
		curSquiggle.addPoint(p);
		this.model.setTempShape(curSquiggle);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.curSquiggle != null) {
			this.model.addShape(curSquiggle);
		}
		// The squiggle is no longer our current squiggle. Erase preview.
		this.model.resetTempShape();
		this.curSquiggle = null;		
	}
}
