package ca.utoronto.utm.paint;

/**Used to represent each shape as a char.
 * @author Hao Mack Yang Li (lihaoya2/mulliganaceous)
 */
public interface ShapeType {
	/* 1D */
	char DOT = 1;
	char LINE = 'L';
	char ARROW = 'a';
	/* 2D */
	char CIRCLE = 'C';
	char RECTANGLE = 'R';
	char SQUARE = 'S';
	/* ARBITRARY */
	char SQUIGGLE = 'X';
	char POLYLINE = 'p';
	char POLYGON = 'P';
}
