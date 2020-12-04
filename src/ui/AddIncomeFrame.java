package ui;

import javax.swing.*;

public class AddIncomeFrame extends JPanel{
	public AddIncomeFrame() {
		String table[]= {"Income","Expense"};
		JComboBox box = new JComboBox(table);
		
		JTextField amount = new JTextField(20);
		JButton addButton = new JButton("Add");
		
		this.add(box);
		this.add(amount);
		this.add(addButton);
	}
}
