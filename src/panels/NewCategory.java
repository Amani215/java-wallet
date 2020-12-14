package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dataObjects.CategoryData;
import ui.*;

@SuppressWarnings("serial")
public class NewCategory extends JPanel{
	//Attributes
	private CategoryData data = new CategoryData();
	
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Category name: ");
	private JTextField text = new JTextField(20);
	private JButton addButton = new JButton("Add");
	
	//Constructor
	public NewCategory() {
		this.setLayout(new BorderLayout());
		
		//Table containing the current categories
		JTable t = new JTable(data);
        JScrollPane scrollPane = new JScrollPane(t);
        	this.add(scrollPane);
        
        //To make the JScrollPane as small as the JTable
    	t.setPreferredScrollableViewportSize(new Dimension(t.getPreferredSize().width, t.getRowHeight() * t.getRowCount()));
    	
    	//Adding  the components to the "Add a Category" panel
    	panel.add(label);
		panel.add(text);
		panel.add(addButton);
		
		//Style the button
		Styles.styleButton(addButton);
				
		//Button listener
		addButton.setActionCommand("newEntry");
    	ActionListener addButtonAL = new ButtonActionListener();
    	addButton.addActionListener(addButtonAL);
		
    	//Add the last panel to the main panel
		this.add(panel, BorderLayout.SOUTH);
	}
	
	//Action listener for the Add button
	final class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//add the entry to the table and save it to the database
			data.addCategory(text.getText());
		}
	}
}