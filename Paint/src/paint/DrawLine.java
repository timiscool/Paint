package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Comamand for drawing lines. Given a shape (line), and a canvas, draw the
 * given line to the canvas
 * 
 * @author fagutimo
 *
 */
public class DrawLine implements DrawingCommands {
	private Line l;

	/**
	 * 
	 * @param l
	 *            set line
	 */
	public DrawLine(Line l) {
		this.l = l;
	}

	/**
	 * Draw line to canvas
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s);
		int x1 = l.getStartingPoint().getX();
		int y1 = l.getStartingPoint().getY();
		int x2 = l.getEndPoint().getX();
		int y2 = l.getEndPoint().getY();
		g.drawLine(x1, y1, x2, y2);
	}
}
