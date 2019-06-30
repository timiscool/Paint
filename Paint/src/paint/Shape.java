package ca.utoronto.utm.paint;

import java.awt.Color;

/**A shape is a shape that can have a set color, 
 * and thickness, and can be filled in
 * You can reset the colors, and thicknesses, as
 * well as having access to them.
 * @author fagutimo
 */
public abstract class Shape {
	/* ATTRIBUTES UNIVERSAL TO SHAPES */
	private Color color = Color.WHITE; // default color
	private int thickness = 1; // default thickness
	private boolean filled = false; // default filled state
	
	public Color getColor() {
		return this.color;
	}
	
	public int getThickness() {
		return this.thickness;
	}
	
	public boolean isFilled() {
		return this.filled;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	/**Set the shape style to the current selection of styles
	 * from the model.
	 * @param model The referred model.
	 */
	public void setStyleToModel(PaintModel model) {
		this.color = model.getColor();
		this.thickness = model.getThickness();
		this.filled = model.isFilled();
	}
	
	/**Each shape type has an associated character for 
	 * other methods to recognize the type of shape.
	 * @return The char representing the shape type.
	 */
	public abstract char getShapeType();
}
