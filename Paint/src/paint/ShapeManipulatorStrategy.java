package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

/**	Main component of the Strategy design pattern. This interface is to be implemented to give
 * 	each ShapeManiupulator strategy access to mouse event listeners to allow users to draw
 * 	on the canvas
 * @author fagutimo
 *
 */
public interface ShapeManipulatorStrategy {
	public abstract void mouseDragged(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
}
