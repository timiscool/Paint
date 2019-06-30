package ca.utoronto.utm.paint;

/**
 * Main component of the factory design pattern. Create a new strategy based on
 * the mode the user selects
 * 
 * @author fagutimo
 *
 */
public class ShapeFactory {
	private PaintModel model;

	/**
	 * 
	 * @param model
	 *            set model
	 */
	public ShapeFactory(PaintModel model) {
		this.model = model;
	}

	/**
	 * @param mode
	 *            selected mode
	 * @return a strategsy based on the users selected mode
	 * Default mode is Squiggle
	 */
	public ShapeManipulatorStrategy createStrategy(String mode) {
		if (mode == null)
			mode = "Eraser";
		switch (mode) {
		case "Dot":
			return new DotManipulatorStrategy(this.model);
		case "Line":
			return new LineManipulatorStrategy(this.model);
		case "Arrow":
			return new ArrowManipulatorStrategy(this.model);
		case "Circle":
			return new CircleManipulatorStrategy(this.model);
		case "Rectangle":
			return new RectangleManipulatorStrategy(this.model);
		case "Square":
			return new SquareManipulatorStrategy(this.model);
		case "Squiggle":
			return new SquiggleManipulatorStrategy(this.model);
		case "Polyline":
			return new PolylineManipulatorStrategy(this.model);
		case "Polygon":
			return new PolygonManipulatorStrategy(this.model);
		case "Eraser":
			return new EraserManipulatorStrategy(this.model);
		default:
			return new SquiggleManipulatorStrategy(this.model);
		}
	}
}