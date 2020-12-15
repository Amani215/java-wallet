package subPanels;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataObjects.CategoryData;
import dataObjects.EntryData;

@SuppressWarnings("serial")
public class CategoriesStatistics extends JPanel {
	CategoryData categories = new CategoryData();
	ArrayList<JLabel> array = new ArrayList<JLabel>();
	
	//Constructor
	public CategoriesStatistics(EntryData data) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    			
		//for each category (all categories) put statistics
    	for(int i=0; i<categories.categories.size(); i++) {
    		array.add(new JLabel(categories.getValueAt(i, 0).toString()));
    		array.add(new JLabel("    Total income: "+data.calculateTotalInCategory("Income", categories.getValueAt(i, 0).toString())));
    		array.add(new JLabel("    Total expenses: "+data.calculateTotalInCategory("Expense", categories.getValueAt(i, 0).toString())));
    	}
    	
    	for(int i=0; i<array.size(); i++)
    		this.add(array.get(i));
	}
}
