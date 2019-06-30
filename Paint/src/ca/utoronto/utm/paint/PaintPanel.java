package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * PaintPanel is responsible for adding objects/shapes to the model. PaintPanel
 * draws constructs, and draws specified shapes. PaintPanel responds to drags,
 * presses, clicks, and releases of the Mouse to do this.
 * 
 * @author fagutimo
 */
public class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener {
	private static final long serialVersionUID = 101L;
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can communicate with other methods in View.
	
	private String mode = "Squiggle";
	private DrawingCommands drawingCommand; // access to command design pattern
	private ShapeFactory shapeFactory; // access to factory design pattern
	private ShapeManipulatorStrategy currentStrategy; // current strategy

	/**
	 * Hooks view up to model Hooks up mouseListeners
	 * 
	 * @param model
	 *            The panel we are building
	 * @param view
	 *            The User infance
	 */
	public PaintPanel(PaintModel model, View view) {
		this.setBackground(PaintModel.BACKGROUND);
		this.setPreferredSize(new Dimension(600, 400));

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.model = model;
		this.model.addObserver(this);
		this.view = view;

		shapeFactory = new ShapeFactory(this.model); // create shape factory
	}

	/**
	 * View aspect of this COMMAND PATTERN
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		g2d.setColor(Color.black);

		/* DRAW SHAPES */
		ArrayList<Shape> shapesCommandList = this.model.getShapes();
		//
		for (Shape shape : shapesCommandList) {
			if (shape.getShapeType() == ShapeType.DOT) {
				drawingCommand = new DrawDot((Dot) shape);
			} else if (shape.getShapeType() == ShapeType.LINE) {
				drawingCommand = new DrawLine((Line) shape);
			} else if (shape.getShapeType() == ShapeType.ARROW) {
				drawingCommand = new DrawArrow((Arrow) shape);
			} else if (shape.getShapeType() == ShapeType.SQUIGGLE) {
				drawingCommand = new DrawSquiggle((Squiggle) shape);
			} else if (shape.getShapeType() == ShapeType.RECTANGLE) {
				drawingCommand = new DrawRectangle((Rectangle) shape);
			} else if (shape.getShapeType() == ShapeType.CIRCLE) {
				drawingCommand = new DrawCircle((Circle) shape);
			} else if (shape.getShapeType() == ShapeType.POLYLINE) {
				drawingCommand = new DrawPolyline((Polyline) shape);
			} else if (shape.getShapeType() == ShapeType.POLYGON) {
				drawingCommand = new DrawPolygon((Polygon) shape);
			}
			drawingCommand.execute(g2d, shape);
		}
		// If there is a preview, also draw it.
		if (this.model.getTempShape() != null) {
			Shape tempShape = this.model.getTempShape();
			drawingCommand = new DrawTempShape(tempShape);
			drawingCommand.execute(g2d, tempShape);
		}
	}
	public String getMode() {
		return mode;
	}

	/**
	 * Method to remove all shapes from the canvas
	 */
	public void clearAll() {
		this.model.removeShapes();
	}

	/**
	 * Updates GUI
	 */
	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}

	/**
	 * set Mode of shape
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.currentStrategy = shapeFactory.createStrategy(mode);
		this.currentStrategy.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.currentStrategy.mouseReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.currentStrategy.mouseDragged(e);
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}
}
