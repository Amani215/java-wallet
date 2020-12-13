package frames;

/* THINGS TO FIX */
//the categories come from the categories.txt file
//the add button adds the entry to the wallet.txt file with the given date
//if the user types wrong entries make an alert and don't add the entry

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.*;

public class MainFrame extends JFrame{
		//Attributes
		private JPanel buttons = new JPanel();
			private JButton newEntry = new JButton("New Entry");
			private JButton newCategory = new JButton("New Category");
			private JButton moneyInWallet = new JButton("Money In Wallet");
			private JButton statistics = new JButton("Statistics");
		private JPanel result = new JPanel();
		private JTextField test = new JTextField(20);
		private final JFrame frame = this;
		
		//Constructor
		public MainFrame() {
			//general settings
			super("WALLET");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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
			buttons.add(moneyInWallet);
			buttons.add(statistics);
			
			//Adding action listeners to the menu buttons
			newEntry.setActionCommand("newEntry");
	    	ActionListener newEntryAL = new ButtonActionListener();
	    	newEntry.addActionListener(newEntryAL);
	    	
	    	newCategory.setActionCommand("newCategory");
	    	ActionListener newCategoryAL = new ButtonActionListener();
	    	newCategory.addActionListener(newCategoryAL);
	    	
	    	moneyInWallet.setActionCommand("moneyInWallet");
	    	ActionListener moneyInWalletAL = new ButtonActionListener();
	    	moneyInWallet.addActionListener(moneyInWalletAL);
	    	
	    	statistics.setActionCommand("statistics");
	    	ActionListener statisticsAL = new ButtonActionListener();
	    	statistics.addActionListener(statisticsAL);
	    	
	    	//Styling the buttons
	    	Styles.styleButton(newEntry);
	    	Styles.styleButton(newCategory);
	    	Styles.styleButton(moneyInWallet);
	    	Styles.styleButton(statistics);
		}
		
		//Action listener for the menu buttons
		final private class ButtonActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="newEntry") {
					//add the new entry panel to the main frame
					NewEntry newEntryPanel = new NewEntry();
					result.removeAll();
					result.add(newEntryPanel);
					frame.add(result);
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
				}
				else if(e.getActionCommand()=="newCategory") {
					//add the new category panel to the main frame
					NewCategory newCategoryPanel = new NewCategory();
					result.removeAll();
					result.add(newCategoryPanel);
					frame.add(result);
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
				}
				else if(e.getActionCommand()=="moneyInWallet") {
					test.setText("money in wallet");
					result.removeAll();
					result.add(test);
					frame.add(result);
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					//add the money in wallet panel to the main frame
				}
				else if(e.getActionCommand()=="statistics") {
					test.setText("statistics");
					result.removeAll();
					result.add(test);
					frame.add(result);
					frame.getContentPane().validate();
					frame.getContentPane().repaint();
					//add the statistics panel to the main frame
				}
			}
		}
}