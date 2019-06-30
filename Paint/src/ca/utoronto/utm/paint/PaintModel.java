package ca.utoronto.utm.paint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/**
 * This class manages the shapes, and notifies the View of changes made in the
 * model.
 * 
 * @author Rosenbloomers
 */
public class PaintModel extends Observable {
	/* LIST OF SHAPES */
	private String mode;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/* TEMPORARY SHAPES FOR FEEDBACK */
	private Shape tempShape = null;

	public static final Color BACKGROUND = Color.WHITE;
	private Color curColor = Color.BLACK; // default color
	private int curThickness = 1; // default thickness
	private boolean curFilled = false; // default filled state

	/**
	 * 
	 * @param s
	 *            add shape to canvas
	 */
	public void addShape(Shape s) {
		this.shapes.add(s);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * 
	 * @return shapes on the canvas
	 */
	public ArrayList<Shape> getShapes() {
		return this.shapes;
	}

	/**
	 * remove all the shapes on the canvas
	 */
	public void removeShapes() {
		this.shapes.clear();
		this.setChanged();
		this.notifyObservers();

	}

	public void setTempShape(Shape newShape) {
		this.tempShape = newShape;
		this.setChanged();
		this.notifyObservers();
	}

	public void resetTempShape() {
		this.tempShape = null;
		this.setChanged();
		this.notifyObservers();
	}

	public Shape getTempShape() {
		return this.tempShape;
	}

	/* STYLES */

	/**
	 * 
	 * @return color of shape
	 */
	public Color getColor() {
		return this.curColor;
	}

	/**
	 * 
	 * @return thickness of shape
	 */
	public int getThickness() {
		return this.curThickness;
	}

	/**
	 * 
	 * @return fill status of shape
	 */
	public boolean isFilled() {
		return this.curFilled;
	}

	/**
	 * 
	 * @param color
	 *            set color of shape
	 */
	public void setColor(Color color) {
		this.curColor = color;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * 
	 * @param thickness
	 *            set thickness of shape
	 */
	public void setThickness(int thickness) {
		this.curThickness = thickness;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * 
	 * @param filled
	 *            set filled status of shape
	 */
	public void setFilled(boolean filled) {
		this.curFilled = filled;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setShape(String mode) {
		this.mode = mode;
		this.setChanged();
		this.notifyObservers();
	}
}
