package panels;
//Add a filter option and a sort option
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
		JTable t = new JTable(data);
			//change the column names
			for(int i=0;i<4;i++) {
				t.getColumnModel().getColumn(i).setHeaderValue(data.columnNames[i]);
			}
        JScrollPane scrollPane = new JScrollPane(t);
        	this.add(scrollPane,BorderLayout.CENTER);
        
        //To make the JScrollPane as small as the JTable
    	t.setPreferredScrollableViewportSize(new Dimension(t.getPreferredSize().width, t.getRowHeight() * t.getRowCount()));
    	
	}
	
	public final class ButtonActionListener implements ActionListener{
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
}
