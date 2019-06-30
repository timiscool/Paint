package ca.utoronto.utm.paint;
import java.awt.Graphics2D;

/**
 * Main component of the Command design pattern. Give implementers 
 * a command to execute
 * 
 * @author timothyfagu
 *
 */
public interface DrawingCommands {
	public abstract void execute(Graphics2D g, Shape s);
}
