package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Styles {
	//style the buttons
	public static void styleButton(JButton button) {
	  button.setForeground(Color.WHITE);
	  button.setBackground(Color.DARK_GRAY);
	  Border line = new LineBorder(Color.DARK_GRAY);
	  Border margin = new EmptyBorder(5, 15, 5, 15);
	  Border compound = new CompoundBorder(line, margin);
	  button.setBorder(compound);
	}
}
