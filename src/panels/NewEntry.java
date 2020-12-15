package panels;

//Consider changing the box of types to radio buttons
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataObjects.CategoryData;
import dataObjects.EntryData;
import ui.*;

@SuppressWarnings("serial")
public class NewEntry extends JPanel {
	private CategoryData categories = new CategoryData();
	private EntryData entries = new EntryData();

	public NewEntry() {
		//General settings
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Creating the components
			//Types combo box
			String tableOfTypes[]= {"Income","Expense"};
			final JComboBox<String> boxOfTypes = new JComboBox<String>(tableOfTypes);
		
			//categories combo box
			String tableOfCategories[] = new String[categories.getRowCount()];
			for(int i=0;i<categories.getRowCount();i++) {
				tableOfCategories[i]=(String) categories.getValueAt(i, 0);
			}
			final JComboBox<String> boxOfCategories = new JComboBox<String>(tableOfCategories);
			
			//Date combo boxes and panel
			JPanel datePanel = new JPanel();
			
			Integer[] tableOfDays = new Integer[31];
			for(int i=0;i<31;i++) {
				tableOfDays[i]=i+1;
			}
			final JComboBox<Integer> boxOfDays = new JComboBox<Integer>(tableOfDays);
			
			String[] tableOfMonths = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			final JComboBox<String> boxOfMonths = new JComboBox<String>(tableOfMonths);
			
			Integer[] tableOfYears = new Integer[101];
			for(int i=2000;i<2100;i++) {
				tableOfYears[i-2000]=i;
			}
			final JComboBox<Integer> boxOfYears = new JComboBox<Integer>(tableOfYears);
			
			datePanel.add(boxOfDays);
			datePanel.add(boxOfMonths);
			datePanel.add(boxOfYears);
			
			final JTextField amount = new JTextField(20);
			JButton addButton = new JButton("Add");
		
		//Styling the components
		Styles.styleButton(addButton);
		
		//Button action listener
    	addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	String entryType = (String) boxOfTypes.getSelectedItem();
            	
            	int y = (int) boxOfYears.getSelectedItem();
            	int m = ((int) boxOfMonths.getSelectedIndex()) +1;
            	int d = (int) boxOfDays.getSelectedItem();
            	LocalDate date = LocalDate.of(y, m, d);
            	
            	String entryCategory = (String) boxOfCategories.getSelectedItem();
            	try
            	{
            	  double entryAmount = Double.parseDouble(amount.getText());
            	  entries.addEntry(entryType, date, entryCategory, entryAmount);
            	  amount.setText("");
            	}
            	catch(NumberFormatException e)
            	{
            	  JOptionPane.showMessageDialog(null, 
                          "The value in amount is not a double", 
                          "Error in amount", 
                          JOptionPane.WARNING_MESSAGE);
            	}
            }
    });
		
		//Adding  the components to the panel
    	this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(boxOfTypes);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(boxOfCategories);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(datePanel);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(amount);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(addButton);
	}
}
