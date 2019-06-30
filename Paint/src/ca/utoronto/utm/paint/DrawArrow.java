package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

 
/**
 * Command for drawing a arrow. Given a shape ( arrow ), and a canvas, execute
 * draw this arrow to the given canvas 
 * @author timothyfagu
 *
 */
public class DrawArrow implements DrawingCommands {
	private Arrow ar;
	
	/**
	 * 
	 * @param ar set arrow
	 */
	public DrawArrow(Arrow ar) {
		this.ar = ar;
	}
	
	/**
	 * draw arrow to canvas
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		// Main line
		g = DrawingCommandsStyle.matchStyle(g, s);
		int x1 = ar.getStartingPoint().getX();
		int y1 = ar.getStartingPoint().getY();
		int x2 = ar.getEndPoint().getX();
		int y2 = ar.getEndPoint().getY();
		g.drawLine(x1, y1, x2, y2);
		
		// Arrowhead
		int arrowSize = 4 + s.getThickness()*2;
		int x3, y3, x4, y4;
		double dx = x2 - x1;
		double dy = y2 - y1;
		double norm = Math.sqrt(dx*dx + dy*dy);
		if (norm > 0) { // Exceptional case can happen if length of arrow is 0.
			dx = dx / norm * arrowSize;
			dy = dy / norm * arrowSize;
		}
		x3 = (int) (x2 - dx + dy);
		y3 = (int) (y2 - dy - dx);
		x4 = (int) (x2 - dx - dy);
		y4 = (int) (y2 - dy + dx);
		
		// Arrowhead can be filled as well
		if (s.isFilled()) {
			int[] xcoords = new int[]{(int)(x2 + dx/2), x3, x4};
			int[] ycoords = new int[]{(int)(y2 + dy/2), y3, y4};
			g.fillPolygon(xcoords, ycoords, 3);
		} else {
			g.drawLine(x2, y2, x3, y3);
			g.drawLine(x2, y2, x4, y4);
		}
	}
}
