package ca.utoronto.utm.paint;

/**Basic information of a square
 * A square is a rectangle that has equal width and height
 * @author fagutimo
 */
public class Square extends Rectangle {
	/**Construct a square of equal length and height
	 * 
	 * @param square ClickPoint Corner of Square
	 * @param squareX	 Width of Square
	 * @param squareY	 Height of Square
	 */
	public Square(ShapePoint squareClickPoint, int squareX, int squareY) {
		super(squareClickPoint, squareX, squareY);
	}
}