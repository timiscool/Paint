package ca.utoronto.utm.paint;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**The ColoredButton is an extension of a JButton
 * which also associates a color with it, for use
 * with ShapeChoosePanel.
 * @author Hao Mack Yang Li (mulliganaceous/lihaoya2)
 */
public class ColoredButton extends JButton {
	private static final long serialVersionUID = 170;
	private Color color;
	private static final Font font = new Font("Century Gothic", Font.BOLD, 12);
	public ColoredButton(String name, Color color) {
		super(name);
		this.color = color;
		this.setBackground(color);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		if (color.getRed() + color.getGreen() + color.getBlue() < 48)
			this.setForeground(Color.WHITE);
		else
			this.setForeground(Color.BLACK);
		this.setFont(font);
	}
	
	/**
	 * @return Get the color for this button, for use if ShapeChoosePanel.
	 */
	public Color getColor() {
		return this.color;
	}
}
