package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Command for drawing dots to the canvas. Given a shape (dot) and canvas, draw
 * this shape to the canvas
 * 
 * @author fagutimo
 *
 */
public class DrawDot implements DrawingCommands {
	Dot d;

	public DrawDot(Dot d) {
		this.d = d;
	}

	/**
	 * Draw given shape (dot) to the canvas
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s.getColor(), s.getThickness());
		g.fillOval(d.getX(), d.getY(), s.getThickness() * 2, s.getThickness() * 2);
	}
}
