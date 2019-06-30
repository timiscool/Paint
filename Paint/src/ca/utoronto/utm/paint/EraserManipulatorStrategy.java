package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 * Strategy for creating an eraser. Default color will be white. An eraser is a white squiggle.
 * @author timothyfagu
 *
 */
public class EraserManipulatorStrategy implements ShapeManipulatorStrategy {
	private Squiggle curSquiggle = null;
	private PaintModel model;
	
	/**
	 * 
	 * @param model set model
	 */
	public EraserManipulatorStrategy(PaintModel model) {
		this.model = model;
	}
	
	/**
	 * Make new eraser when mouse is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (this.curSquiggle == null) {
			this.curSquiggle = new Squiggle();	
			// Set style and add
			this.curSquiggle.setColor(PaintModel.BACKGROUND);
			this.curSquiggle.setThickness(this.model.getThickness());
		}
	}
	
	/**
	 * Add eraser to panel
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		ShapePoint p = new ShapePoint(e.getX(), e.getY());
		curSquiggle.addPoint(p);
		this.model.setTempShape(curSquiggle);		
	}

	/**
	 * Release eraser to panel
	 */
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
