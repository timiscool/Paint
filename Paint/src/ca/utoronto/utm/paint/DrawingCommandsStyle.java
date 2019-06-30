package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author fagutimo
 *
 */
public abstract class DrawingCommandsStyle  {
	/**
	 * Set the Graphics to a given color and thickness based on the shape.
	 * 
	 * @param g2d
	 *            The referred Graphics2D context
	 * @param color
	 *            The color of the current shape
	 * @param thickness
	 *            The thickness of the current shape
	 * @return The edited Graphics2D
	 */
	public static Graphics2D matchStyle(Graphics2D g2d, Color color, int thickness) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(thickness, 
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1));
		return g2d;
	}
	
	public static Graphics2D matchStyle(Graphics2D g2d, Shape shape) {
		g2d.setColor(shape.getColor());
		g2d.setStroke(new BasicStroke(shape.getThickness(), 
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1));
		return g2d;
	}
	
	public static Graphics2D previewMode(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{5}, 10));
		return g2d;
	}
}
