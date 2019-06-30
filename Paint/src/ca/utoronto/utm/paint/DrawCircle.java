package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Command to draw a circle to the canvas. Given a canvas, and a shape (circle),
 * draw it to the canvas.
 * 
 * @author fagutimo
 *
 */
public class DrawCircle implements DrawingCommands {
	private Circle c;

	/**
	 * 
	 * @param c
	 *            set circle
	 */
	public DrawCircle(Circle c) {
		this.c = c;
	}

	/**
	 * Draw given shape (circle) on to canvas
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s);
		int x = c.getCentre().getX();
		int y = c.getCentre().getY();
		int r = c.getRadius();
		if (s.isFilled())
			g.fillOval(x - r, y - r, r * 2, r * 2);
		else
			g.drawOval(x - r, y - r, r * 2, r * 2);
	}
}
