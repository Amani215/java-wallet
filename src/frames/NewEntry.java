package frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.*;

public class NewEntry extends JPanel {
	public NewEntry() {
		//General settings
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Creating the components
		String tableOfEntry[]= {"Income","Expense"};
		JComboBox<String> boxOfEntry = new JComboBox<String>(tableOfEntry);
		String tableOfCategory[]= {"Work","Food","Gift"};
		JComboBox<String> boxOfCategory = new JComboBox<String>(tableOfCategory);
		JTextField amount = new JTextField(20);
		JButton addButton = new JButton("Add");
		
		//Styling the components
		Styles.styleButton(addButton);
		
		//Button action listener
		addButton.setActionCommand("newEntry");
    	ActionListener addButtonAL = new ButtonActionListener();
    	addButton.addActionListener(addButtonAL);
		
		//Adding  the components to the panel
    	this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(boxOfEntry);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(boxOfCategory);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(amount);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(addButton);
	}
	
	final private class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
