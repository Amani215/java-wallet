package subPanels;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import dataObjects.CategoryData;

@SuppressWarnings("serial")
public class FilterEntries extends JPanel{
	CategoryData categories = new CategoryData();
	public JRadioButton incomeRB = new JRadioButton("Income");
    public JRadioButton expenseRB = new JRadioButton("Expense");
    public JCheckBox[] checkBoxes = new JCheckBox[categories.categories.size()];
    
	//Constructor
	public FilterEntries() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/*Radio buttons to filter the type of entries*/
		    //Group the radio buttons.
		    ButtonGroup typeGroup = new ButtonGroup();
		    typeGroup.add(incomeRB);
		    typeGroup.add(expenseRB);
		    
		    JPanel typePanel = new JPanel();
		    typePanel.add(incomeRB); typePanel.add(expenseRB);
		    
		    JPanel categoryPanel = new JPanel();
		/*Check boxes to filter categories*/
		    for (int i = 0; i < checkBoxes.length; i++) {
		    	String s = (String) categories.getValueAt(i, 0);
		        checkBoxes[i] = new JCheckBox(s); 
		        checkBoxes[i].setActionCommand(s);
		        categoryPanel.add(checkBoxes[i]);
		    }
		
		    this.add(typePanel);
		    this.add(categoryPanel);
	}
}
