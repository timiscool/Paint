package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Constructs the panel that is added to the View, to allow
 * users to select a shape.
 * @author Rosenbloomers
 */
public class ShapeChooserPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 30L;
	// So we can talk to our parent or other components of the view
	private View view;
	
	// Components
	private String[] shapeLabels = {
			"Dot", "Line", "Arrow", 
			"Circle", "Rectangle", "Square", 
			"Squiggle", "Polyline", "Polygon", "Eraser"
			};
	private ColoredButton[] colorButtons;
	// Custom Components
	private JButton customColorButton;
	// Notes
	private int red, green, blue;
	private JTextField rightNum;
	
	/**Adds buttons to panel, and hooks them up to the view
	 * @param view model
	 */
	public ShapeChooserPanel(View view) {	
		super(new BorderLayout());
		this.view = view;
		
		/* Buttons and controls (subpanel) */
		JPanel topPanel = new JPanel(new GridLayout(1,2));
		topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		
		/* Thickness Panel (subpanel) */
		JPanel strokePanel = new JPanel();
		strokePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		strokePanel.setLayout(new BoxLayout(strokePanel, BoxLayout.PAGE_AXIS));
		strokePanel.add(new JLabel("Select Outline Thickness"));
		strokePanel.add(new JLabel("Enter numbers 1-10:"));
		
		/* Shape buttons (for TopPanel) */
		JPanel shapePanel = new JPanel(new GridLayout(shapeLabels.length,1));
		ButtonGroup buttonGroup = new ButtonGroup();
		for (String label : shapeLabels) {
			JButton button = new JButton(label);
			buttonGroup.add(button);
			shapePanel.add(button);
			button.addActionListener(this);
		}
		topPanel.add(shapePanel, BorderLayout.WEST);
		
		/* Color buttons (for TopPanel) */
		colorButtons = new ColoredButton[10];
		JPanel colorPanel = new JPanel(new GridLayout(colorButtons.length,1));
		// ButtonGroup of color buttons
		ButtonGroup colorButtonGroup = new ButtonGroup();
		colorButtons[0] = new ColoredButton("Black", Color.BLACK);
		colorButtons[1] = new ColoredButton("Red", Color.RED);
		colorButtons[2] = new ColoredButton("Orange", new Color(255,102,0));
		colorButtons[3] = new ColoredButton("Yellow", Color.YELLOW);
		colorButtons[4] = new ColoredButton("Green", Color.GREEN);
		colorButtons[5] = new ColoredButton("Cyan", Color.CYAN);
		colorButtons[6] = new ColoredButton("Blue", Color.BLUE);
		colorButtons[7] = new ColoredButton("Purple", Color.MAGENTA);
		colorButtons[8] = new ColoredButton("Brown", new Color(153,51,0));
		colorButtons[9] = new ColoredButton("Gray", Color.GRAY);
		// Add color button listeners
		for (ColoredButton cb : colorButtons) {
			cb.addActionListener(new ColorChoiceListener(cb.getColor()));
			colorButtonGroup.add(cb);
			colorPanel.add(cb);
		}
		topPanel.add(colorPanel, BorderLayout.EAST);
		
		/* Thickness (from strokePanel) */
		JTextField thicknessField = new JTextField(3);
		JButton thicknessButton = new JButton("Set thickness"); // button
		thicknessButton.addActionListener(new ThicknessListener(thicknessField));
		// Filled or outline
		ButtonGroup outlineGroup = new ButtonGroup();
		JRadioButton drawMode = new JRadioButton("Outline");
		JRadioButton fillMode = new JRadioButton("Filled");
		outlineGroup.add(drawMode); // draw
		drawMode.addActionListener(new OutlineListener(drawMode));
		outlineGroup.add(fillMode); // fill
		fillMode.addActionListener(new OutlineListener(fillMode));
		
		/* Custom color panel */
		JPanel customColorPanel = new JPanel(new GridLayout(4,1));
		JLabel redLabel, greenLabel, blueLabel;
		JTextField rTF, gTF, bTF;
		// Component values for current color
		red = this.view.getModel().getColor().getRed();
		green = this.view.getModel().getColor().getGreen();
		blue = this.view.getModel().getColor().getBlue();
		// JLabels for instruction
		redLabel = new JLabel("Set Red (0-255)");
		greenLabel = new JLabel("Set Green (0-255)");
		blueLabel = new JLabel("Set Blue (0-255)");
		// JTextField for input
		rTF = new JTextField(3);
		gTF = new JTextField(3);
		bTF = new JTextField(3);
		// Subpanels for each color
		JPanel redPanel = new JPanel();
		redPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
		redPanel.add(redLabel);
		redPanel.add(rTF);
		JPanel greenPanel = new JPanel();
		greenPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
		greenPanel.add(greenLabel);
		greenPanel.add(gTF);
		JPanel bluePanel = new JPanel();
		bluePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		bluePanel.add(blueLabel);
		bluePanel.add(bTF);
		// Add these components
		customColorPanel.add(redPanel);
		customColorPanel.add(greenPanel);
		customColorPanel.add(bluePanel);
		// Custom Color button, with ActionListener using Textfields
		customColorButton = new ColoredButton("Set Color!", Color.WHITE);
		customColorButton.addActionListener(
				new CustomColorListener(rTF, gTF, bTF));
		customColorPanel.add(customColorButton);
	
		// Notes
		this.rightNum = new JTextField(10);
		rightNum.setEditable(false);
		// Add the components
		strokePanel.add(thicknessField);
		strokePanel.add(thicknessButton);
		strokePanel.add(drawMode);
		strokePanel.add(fillMode);
		strokePanel.add(rightNum);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(customColorPanel, BorderLayout.CENTER);
        this.add(strokePanel, BorderLayout.SOUTH);
	}
	
	/**ActionListener for Shape buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		this.view.getModel().setShape(e.getActionCommand());
		this.view.getPaintPanel().setMode(e.getActionCommand()); // REMOVE
		System.out.println(e.getActionCommand() + "Selected.");
		// Reset temporary shape (shape set but not added) if left behind.
		this.view.getModel().resetTempShape();
	}
	
	/**ActionListener for Color buttons.
	 */
	public class ColorChoiceListener implements ActionListener {
		private Color colormode;
		public ColorChoiceListener(Color colormode) {
			this.colormode = colormode;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			view.getModel().setColor(colormode);
		}
	}
	
	/**ActionListener used to for the user to set a user-defined color.
	 * It extracts information from three JTextField inputs
	 * to create a new color, and set the model to this color.
	 * @author mulliganaceous (lihaoya2)
	 */
	private class CustomColorListener implements ActionListener {
		private JTextField rTF, gTF, bTF;
		/**Constructor for a CustomColorListener 
		 * @param rTF Textfield for Red
		 * @param gTF Textfield for Green
		 * @param bTF TextField for Blue
		 */
		private CustomColorListener(JTextField rTF, JTextField gTF, JTextField bTF) {
			this.rTF = rTF;
			this.gTF = gTF;
			this.bTF = bTF;
		}
		/**Read the input, and set the model's color parameter to this color
		 * if the input is valid.
		 */
		public void actionPerformed(ActionEvent arg0) {
			try {
				int red = Integer.parseInt(this.rTF.getText());
				int green = Integer.parseInt(this.gTF.getText());
				int blue = Integer.parseInt(this.bTF.getText());
				Color newColor = new Color(red, green, blue);
				view.getModel().setColor(newColor);
				rightNum.setText("Color set!");
			} catch (NumberFormatException e) {
				rightNum.setText("Invalid color!");
			} catch (IllegalArgumentException e) {
				rightNum.setText("Color values out of bounds!");
			}
		}
	}
	
	/**ActionListener for Thicknees buttons.
	 */
	private class ThicknessListener implements ActionListener {
		private JTextField thickness;
		
		/**Constructor for a ThicknessListener with a given
		 * thickness to set.
		 * @param thickness The thickness to be set
		 */
		private ThicknessListener(JTextField thickness) {
			this.thickness = thickness;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			try {
				int n=Integer.parseInt(thickness.getText());
				if (n >= 0 && n <= 10) {
					view.getModel().setThickness(n);
					rightNum.setText("Thickness set");
				}
				else
					rightNum.setText("Number out of range");
			}
			catch(NumberFormatException e) {
				rightNum.setText("Invalid number");
			}
		}
	}
	
	/**ActionListener for Outline buttons. Sets whenever
	 * it will draw or fill the shapes.
	 */
	private class OutlineListener implements ActionListener{
		private JRadioButton filled;
		/**Constructor for an OutlineListener
		 * @param filled If the mode is "filled" 
		 */
		private OutlineListener(JRadioButton filled) {
			this.filled = filled;
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Filled") {
				view.getModel().setFilled(true);
				System.out.println("Filled");
			}
			else {
				view.getModel().setFilled(false);
				System.out.println("Outline");
			}
		}
	}
}
