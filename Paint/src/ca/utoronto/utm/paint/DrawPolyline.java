package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**Command for drawing polyline to canvas. Given a canvas, and a shape (polyline), draw
 * that polyline to the canvas
 * 
 * @author fagutimo
 *
 */
public class DrawPolyline implements DrawingCommands {
	private Polyline p;
	
	/**
	 * 
	 * @param p set polyline
	 */
	public DrawPolyline(Polyline p) {
		this.p = p;
	}
	
	/**
	 * Draw poyline to the canvas
	 */
	//@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s.getColor(), s.getThickness());
		int x1, y1, x2, y2;
		int n = p.numOfPoints();
		n = p.numOfPoints();
		// Connect the points in sequential order.
		for (int k = 0; k < n - 1; k++) {
			x1 = p.getPoint(k).getX();
			y1 = p.getPoint(k).getY();
			x2 = p.getPoint(k + 1).getX();
			y2 = p.getPoint(k + 1).getY();
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
