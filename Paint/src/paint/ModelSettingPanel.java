package ca.utoronto.utm.paint;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**The ModelSettingpanel at the bottom of the window shows the
 * current shape, style, and color you are using. It can also
 * display hints on how to use it.
 * @author a
 */
public class ModelSettingPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 40;
	// Model and View where this panel will extract information.
	private PaintModel model;
	private View view;
	
	public String shape;
	public String tips;
	public Color modelColor;
	
	public JLabel curColorLabel, shapeModeLabel, outlineLabel, tipPanel;
	
	public ModelSettingPanel(PaintModel model, View view) {
		super(new GridLayout(2,2));
		this.model = model;
		this.model.addObserver(this);
		this.view = view;
		this.modelColor = model.getColor();
		
		// Current Color
		this.curColorLabel = new JLabel("Current color");
		this.curColorLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.curColorLabel.setOpaque(true);
		this.curColorLabel.setBackground(modelColor);
		if (modelColor.getRed() + modelColor.getGreen() + modelColor.getBlue() < 48)
			curColorLabel.setForeground(Color.WHITE);
		else
			curColorLabel.setForeground(Color.BLACK);
		
		// Current Shape
		this.shape = this.view.getPaintPanel().getMode();
		this.shapeModeLabel = new JLabel("Current shape: " + shape + ".");
		
		// Current Style and Thickness
		int thickness = this.model.getThickness();
		boolean filled = this.model.isFilled();
		this.outlineLabel = new JLabel(outlineString(thickness, filled));
		
		// Tips
		this.tipPanel = new JLabel("This is a Scribbler Program!");
		
		this.add(curColorLabel);
		this.add(shapeModeLabel);
		this.add(outlineLabel);
		this.add(tipPanel);
	}
	
	/**Static method to generate stroke thickness/fill information.
	 */
	private static String outlineString(int thickness, boolean filled) {
		String str = "Stroke Thickness: ";
		if (filled)
			return str + "Filled.";
		else
			return str + thickness;
	}
	
	/**Static method to generate tips for each shape.
	 * @param mode The String representing the mode.
	 * @return The tip text
	 */
	private static String tipString(String mode) {
		String str = "This is a Scribbler Program!";
		if (mode.equals("Polygon") || mode.equals("Polyline"))
			str = "Left click to set points. Right click to confirm shape.";
		else if (mode.equals("Squiggle") || mode.equals("Eraser"))
			str = "Drag mouse while clicked.";
		else if (mode.equals("Rectangle") || mode.equals("Square"))
			str = "Drag mouse to set corners.";
		else if (mode.equals("Circle"))
			str = "Click to set center. Drag to set radius.";
		else if (mode.equals("Line") || mode.equals("Arrow"))
			str = "Click to set starting point. Drag to set endpoint.";
		return str;
	}

	@Override
	/**This panel implements Observer, so it updates whenever it gets notified.
	 */
	public void update(Observable obj, Object arg) {
		this.shape = this.view.getPaintPanel().getMode();
		
		Color curColor = model.getColor();
		this.shapeModeLabel.setText("Current shape: " + shape + ".");
		this.curColorLabel.setBackground(curColor);
		if (curColor.getRed() + curColor.getGreen() + curColor.getBlue() < 48)
			this.curColorLabel.setForeground(Color.WHITE);
		else
			this.curColorLabel.setForeground(Color.BLACK);
		
		int thickness = this.model.getThickness();
		boolean filled = this.model.isFilled();
		this.outlineLabel.setText(outlineString(thickness, filled));
		
		String mode = this.view.getPaintPanel().getMode();
		this.tipPanel.setText(tipString(mode));
	}
}
