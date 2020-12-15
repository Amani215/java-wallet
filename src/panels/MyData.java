package panels;
//Add a filter option and a sort option
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataObjects.CategoryData;
import dataObjects.EntryData;
import subPanels.FilterEntries;
import ui.Styles;

@SuppressWarnings("serial")
public class MyData extends JPanel{
	EntryData data = new EntryData();
	CategoryData categories = new CategoryData();
	private JButton filterButton = new JButton("Filter");
	private JButton applyButton = new JButton("Apply Filters");
	
	public JPanel panel = this;
	private JPanel filterPanel = new JPanel();
		private JPanel buttonsPanel = new JPanel();
		private JPanel subFilterPanel = new JPanel();
	
		private String typeFilter = new String();
		private ArrayList<String> categoriesFilter = new ArrayList<String>();
		
		private FilterEntries filters = new FilterEntries();
	
	private JLabel totalIncome = new JLabel();
	private JLabel totalExpenses = new JLabel();
	private JLabel currentBalance = new JLabel();
	private JLabel expensiveCategory = new JLabel();
		
	//Constructor
	public MyData() {
		this.setLayout(new BorderLayout());
		
		//filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
		Styles.styleButton(filterButton); Styles.styleButton(applyButton);
		
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		buttonsPanel.add(filterButton);
		filterPanel.add(buttonsPanel);
		this.add(filterPanel,BorderLayout.NORTH);
		
		filterButton.setActionCommand("filter");
		filterButton.addActionListener(new ButtonActionListener());
		
		applyButton.setActionCommand("apply");
		applyButton.addActionListener(new ButtonActionListener());
		
		//Table containing the entries
		final JTable t = new JTable(data);
			//change the column names
			for(int i=0;i<4;i++) {
				t.getColumnModel().getColumn(i).setHeaderValue(data.columnNames[i]);
			}
        JScrollPane scrollPane = new JScrollPane(t);
        	this.add(scrollPane,BorderLayout.CENTER);
        
    	t.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 2) {   
                  JTable target = (JTable)me.getSource();
                  int row = target.getSelectedRow(); 
                 int reply =JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this entry?");
                 if(reply==JOptionPane.YES_OPTION) {
                	 data.removeRow(row);
                	 setLabels();
                 }
               }
               else if(me.getClickCount() == 1) {
            	   JTable target = (JTable)me.getSource();
                   int row = target.getSelectedRow(); 
                   int col = target.getSelectedColumn();
                   data.setValueAt(t.getValueAt(row, col), row, col);
               }
            }
        });
    	
        //To make the JScrollPane as small as the JTable
    	t.setPreferredScrollableViewportSize(new Dimension(t.getPreferredSize().width, t.getRowHeight() * t.getRowCount()));
        
        setLabels();
        
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(new JLabel(" "));
        labelsPanel.add(totalIncome);
        labelsPanel.add(totalExpenses);
        labelsPanel.add(currentBalance);
        labelsPanel.add(new JLabel(" "));
        labelsPanel.add(expensiveCategory);
        this.add(labelsPanel,BorderLayout.SOUTH);
        
    	
	}
	
	private final class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()=="filter") {
				//Add the apply filters button
				buttonsPanel.removeAll();
				buttonsPanel.add(filterButton);
				buttonsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
				buttonsPanel.add(applyButton);
				
				//Add the filters panel
				subFilterPanel.removeAll();
				subFilterPanel.add(filters);
				filterPanel.add(subFilterPanel);
				panel.add(filterPanel,BorderLayout.NORTH);
				panel.revalidate();
			}
			else if(e.getActionCommand()=="apply") {
				if(filters.incomeRB.isSelected()) typeFilter="Income";
				else if (filters.expenseRB.isSelected()) typeFilter="Expense";
				
				for(int i=0;i<filters.checkBoxes.length;i++) {
					if(filters.checkBoxes[i].isSelected()) categoriesFilter.add(filters.checkBoxes[i].getText());
					if((categoriesFilter.contains(filters.checkBoxes[i].getText()))&&(!filters.checkBoxes[i].isSelected()))
						categoriesFilter.remove(filters.checkBoxes[i].getText());
				}
				
				data.filterEntries(typeFilter, categoriesFilter);
			}
		}
	}

	//Sets the general statistics labels
	private void setLabels() {
		double income = data.calculateTotal("Income");
		double expenses = data.calculateTotal("Expense");
		totalIncome.setText("Total Income: "+income);
		totalExpenses.setText("Total Expenses: "+expenses);
		currentBalance.setText("Current Balance: "+(income-expenses));
		
		double max = data.calculateTotalInCategory("Expense",categories.getValueAt(0,0).toString());
		expensiveCategory.setText("The most expensive category is: "+categories.getValueAt(0,0).toString()+" with expenses = "+max);
		for(int i=1; i<categories.categories.size(); i++) {
			if(data.calculateTotalInCategory("Expense",categories.getValueAt(i,0).toString())>max) {
				max = data.calculateTotalInCategory("Expense",categories.getValueAt(i,0).toString());
				expensiveCategory.setText("The most expensive category is '"+categories.getValueAt(i,0).toString()+"' with expenses = "+max);
				}
		}
	}
}
