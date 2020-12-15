package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataObjects.CategoryData;
import dataObjects.EntryData;
import mainProgram.Main;
import subPanels.CategoriesStatistics;
import ui.Styles;

@SuppressWarnings("serial")
public class Statistics extends JPanel{
	EntryData data = new EntryData(Main.entriesFile);
	CategoryData categories = new CategoryData(Main.categoriesFile);
	JLabel label = new JLabel("Please choose the dates.");
	JButton validate = new JButton("Validate");
	JPanel result = new JPanel();
	JPanel panel = this;
	
	//Constructor
	public Statistics() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Date combo boxes and panel
		JPanel datesPanel = new JPanel();
		JPanel datePanel1 = new JPanel();
		JPanel datePanel2 = new JPanel();
		
		Integer[] tableOfDays = new Integer[31];
		for(int i=0;i<31;i++) {
			tableOfDays[i]=i+1;
		}
		final JComboBox<Integer> boxOfDays1 = new JComboBox<Integer>(tableOfDays);
		final JComboBox<Integer> boxOfDays2 = new JComboBox<Integer>(tableOfDays);
		
		String[] tableOfMonths = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		final JComboBox<String> boxOfMonths1 = new JComboBox<String>(tableOfMonths);
		final JComboBox<String> boxOfMonths2 = new JComboBox<String>(tableOfMonths);
		
		Integer[] tableOfYears = new Integer[101];
		for(int i=2000;i<2100;i++) {
			tableOfYears[i-2000]=i;
		}
		final JComboBox<Integer> boxOfYears1 = new JComboBox<Integer>(tableOfYears);
		final JComboBox<Integer> boxOfYears2 = new JComboBox<Integer>(tableOfYears);
		
		datePanel1.add(boxOfDays1);
		datePanel1.add(boxOfMonths1);
		datePanel1.add(boxOfYears1);
		
		datePanel2.add(boxOfDays2);
		datePanel2.add(boxOfMonths2);
		datePanel2.add(boxOfYears2);
		
		datesPanel.add(datePanel1);
		datesPanel.add(datePanel2);
		datesPanel.add(validate);
		
		Styles.styleButton(validate);
		validate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int y1 = Integer.parseInt(boxOfYears1.getSelectedItem().toString());
	        	int m1 = boxOfMonths1.getSelectedIndex() +1;
	        	int d1 = Integer.parseInt(boxOfDays1.getSelectedItem().toString());
	        	LocalDate date1 = LocalDate.of(y1, m1, d1);
	        	
	        	int y2 = Integer.parseInt(boxOfYears2.getSelectedItem().toString());
	        	int m2 = ((int) boxOfMonths2.getSelectedIndex()) +1;
	        	int d2 = Integer.parseInt(boxOfDays2.getSelectedItem().toString());
	        	LocalDate date2 = LocalDate.of(y2, m2, d2);
	        	
	        	if(date1.isAfter(date2))
	        		JOptionPane.showMessageDialog(null,"The dates are in incorrect order!","Incorrect order",JOptionPane.WARNING_MESSAGE);
	        	
				//filter the dates
	        	data.filterDates(date1, date2);
	        	
	        	CategoriesStatistics statPanel = new CategoriesStatistics(data);
	        	result.add(statPanel);
				panel.add(result);
				panel.revalidate();
				panel.repaint();
			}
			
		});
		
		this.add(datesPanel);
		this.add(result);
	}
}
