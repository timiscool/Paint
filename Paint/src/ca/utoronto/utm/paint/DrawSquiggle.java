package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Command for drawing squiggles. Given a shape (squiggle) and a canvas, draw
 * the squiggle to the canvas
 * 
 * @author fagutimo
 *
 */
public class DrawSquiggle implements DrawingCommands {

	private Squiggle sq; // squiggle to work with

	/**
	 * 
	 * @param sq
	 *            set squiggle
	 */
	public DrawSquiggle(Squiggle sq) {
		this.sq = sq;
	}

	/**
	 * Draw squiggle to canvas based on its style
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s.getColor(), s.getThickness()); // squiggle's style
		int x1, y1, x2, y2;
		int n = sq.numOfPoints();
		for (int k = 1; k < n; k++) {
			x1 = sq.getPoint(k - 1).getX();
			y1 = sq.getPoint(k - 1).getY();
			x2 = sq.getPoint(k).getX();
			y2 = sq.getPoint(k).getY();
			g.drawLine(x1, y1, x2, y2);
		}

	}
}
