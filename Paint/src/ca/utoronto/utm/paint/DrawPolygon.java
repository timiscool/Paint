package ca.utoronto.utm.paint;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Command for drawing a polygon to the canvas. Given a canvas and a shape
 * (polygon), add this shape to the canvas.
 * 
 * @author fagutimo
 *
 */
public class DrawPolygon implements DrawingCommands {
	private Polygon polyg;

	/**
	 * 
	 * @param p
	 *            set polygon
	 */
	public DrawPolygon(Polygon p) {
		this.polyg = p;
	}

	/**
	 * Draw polyline to the canvas in selected style
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		g = DrawingCommandsStyle.matchStyle(g, s.getColor(), s.getThickness());
		if (polyg.isFilled()) {
			ArrayList<ShapePoint> points = polyg.getPointSequence();
			int nPoints = points.size();
			int[] xPoints = new int[nPoints];
			int[] yPoints = new int[nPoints];
			for (int k = 0; k < nPoints; k++) {
				xPoints[k] = points.get(k).getX();
				yPoints[k] = points.get(k).getY();
			}
			g.fillPolygon(xPoints, yPoints, nPoints);
		} else {
			int x1, y1, x2, y2;
			int n = polyg.numOfPoints();
			n = polyg.numOfPoints();
			// Connect the points in sequential order
			for (int k = 0; k < n - 1; k++) {
				x1 = polyg.getPoint(k).getX();
				y1 = polyg.getPoint(k).getY();
				x2 = polyg.getPoint(k + 1).getX();
				y2 = polyg.getPoint(k + 1).getY();
				g.drawLine(x1, y1, x2, y2);
			}
			// Connect the first and last point of the polygon
			x1 = polyg.getPoint(0).getX();
			y1 = polyg.getPoint(0).getY();
			x2 = polyg.getPoint(n - 1).getX();
			y2 = polyg.getPoint(n - 1).getY();
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
