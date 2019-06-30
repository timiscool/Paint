package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * Command for drawing rectangles. Given a canvas, and a shape ( rectangle ),
 * draw this rectangle to the canvas.
 * 
 * @author fagutimo
 *
 */
public class DrawRectangle implements DrawingCommands {

	private Rectangle r;
	private Graphics2D g;

	/**
	 * 
	 * @param r
	 *            set rectangle
	 */
	public DrawRectangle(Rectangle r) {
		this.r = r;
	}

	public char getShapeType() {
		return ShapeType.RECTANGLE;
	}

	/**
	 * Given a canvas, and shape ( rectangle ), draw the rectangle on the canvas
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s.getColor(), s.getThickness()); // selected style
		int x1 = r.getCorner().getX();
		int y1 = r.getCorner().getY();
		int x2 = r.getX();
		int y2 = r.getY();
		if (r.isFilled()) // fill style
			g.fillRect(x1, y1, x2, y2);
		else
			g.drawRect(x1, y1, x2, y2);
	}
}
