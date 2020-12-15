package panels;
/*THINGSTO FIX*/
//The setValueAt() functions are useless if you're not planning to make entries and categories updatable

/*TO DO*/
//Money in Wallet Panel
//Statistics Panel
//Login

/*IF YOU CAN*/
//Make entries deletable in Money in wallet panel (and updatable)
//Same for categories in New category panel

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{
		//Attributes
		private JPanel buttons = new JPanel();
			private JButton newEntry = new JButton("New Entry");
			private JButton newCategory = new JButton("New Category");
			private JButton myData = new JButton("My Data");
			private JButton statistics = new JButton("Statistics");
		private JPanel result = new JPanel();
		private final JPanel panel = this;
		
		//Constructor
		public MainPanel() {
			//general settings
			this.setLayout(new BorderLayout());
			setMinimumSize(new Dimension(630,330));
			
			//make the menu
			makeMenu();
			
			//Create GUI
			this.add(buttons, BorderLayout.NORTH);
		}
		
		//makes the menu
		private void makeMenu() {
			//Adding the buttons to the menu
			buttons.add(newEntry);
			buttons.add(newCategory);
			buttons.add(myData);
			buttons.add(statistics);
			
			//Adding action listeners to the menu buttons
			newEntry.setActionCommand("newEntry");
	    	ActionListener newEntryAL = new ButtonActionListener();
	    	newEntry.addActionListener(newEntryAL);
	    	
	    	newCategory.setActionCommand("newCategory");
	    	ActionListener newCategoryAL = new ButtonActionListener();
	    	newCategory.addActionListener(newCategoryAL);
	    	
	    	myData.setActionCommand("myData");
	    	ActionListener myDataAL = new ButtonActionListener();
	    	myData.addActionListener(myDataAL);
	    	
	    	statistics.setActionCommand("statistics");
	    	ActionListener statisticsAL = new ButtonActionListener();
	    	statistics.addActionListener(statisticsAL);
	    	
	    	//Styling the buttons
	    	Styles.styleButton(newEntry);
	    	Styles.styleButton(newCategory);
	    	Styles.styleButton(myData);
	    	Styles.styleButton(statistics);
		}
		
		//Action listener for the menu buttons
		final private class ButtonActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="newEntry") {
					//add the new entry panel to the main panel
					NewEntry newEntryPanel = new NewEntry();
					result.removeAll();
					result.add(newEntryPanel);
					panel.add(result);
					panel.validate();
					panel.repaint();
				}
				else if(e.getActionCommand()=="newCategory") {
					//add the new category panel to the main panel
					NewCategory newCategoryPanel = new NewCategory();
					result.removeAll();
					result.add(newCategoryPanel);
					panel.add(result);
					panel.validate();
					panel.repaint();
				}
				else if(e.getActionCommand()=="myData") {
					//add the my data panel to the main panel
					MyData myDataPanel = new MyData();
					result.removeAll();
					result.add(myDataPanel);
					panel.add(result);
					panel.validate();
					panel.repaint();
				}
				else if(e.getActionCommand()=="statistics") {
					//add the statistics panel to the main panel
					Statistics statisticsPanel = new Statistics();
					result.removeAll();
					result.add(statisticsPanel);
					panel.add(result);
					panel.validate();
					panel.repaint();
				}
			}
		}
}