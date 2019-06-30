package ca.utoronto.utm.paint;

import java.awt.Graphics2D;

/**
 * Command for executing feedback for polyline, polygon, and squiggle. Given those shapes,
 * draw them to the canvas
 * @author timothyfagu
 *
 */
public class DrawTempShape implements DrawingCommands {
	Shape tempShape;
	public DrawTempShape(Shape tempShape) {
		this.tempShape = tempShape;
	}
	
	/**
	 * Draw squiggle, polyline, or polygon to the canvas
	 */
	@Override
	public void execute(Graphics2D g, Shape s) {
		if (tempShape.getShapeType() == ShapeType.SQUIGGLE) {
			g = DrawingCommandsStyle.matchStyle(g, s.getColor(), s.getThickness());
			Squiggle sq = (Squiggle) tempShape;
			int x1, y1, x2, y2;
			int n = sq.numOfPoints();
			for (int k = 1; k < n; k++) {
				x1 = sq.getPoint(k - 1).getX();
				y1 = sq.getPoint(k - 1).getY();
				x2 = sq.getPoint(k).getX();
				y2 = sq.getPoint(k).getY();
				g.drawLine(x1, y1, x2, y2);
			}
		} else if (tempShape.getShapeType() == ShapeType.POLYLINE 
				|| tempShape.getShapeType() == ShapeType.POLYGON) {
			g = DrawingCommandsStyle.previewMode(g);
			AbstractPolyline pl = (AbstractPolyline) tempShape;
			int x1, y1, x2, y2;
			int n = pl.numOfPoints();
			n = pl.numOfPoints();
			// Connect the points in sequential order.
			x1 = pl.getPoint(0).getX();
			y1 = pl.getPoint(0).getY();
			g.fillOval(x1, y1, 3, 3);
			for (int k = 0; k < n - 1; k++) {
				x1 = pl.getPoint(k).getX();
				y1 = pl.getPoint(k).getY();
				x2 = pl.getPoint(k + 1).getX();
				y2 = pl.getPoint(k + 1).getY();
				g.drawOval(x1, y1, 3, 3);
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
