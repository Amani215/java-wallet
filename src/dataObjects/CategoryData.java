package dataObjects;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fileManagement.FileManagement;
import mainProgram.Main;

@SuppressWarnings("serial")
public class CategoryData extends AbstractTableModel implements Serializable{
	//Attributes
	public ArrayList<Object[]> categories = new ArrayList<Object[]>();
	private FileManagement fm = new FileManagement(Main.categoriesFile);
	
	//Constructor
	public CategoryData(){
		File f = new File(Main.categoriesFile);
		//If the file exists load existing data
		if(f.exists() && !f.isDirectory()) { 
			categories = fm.load(categories);
		}
		//If not, initialize it with three basic categories
		else {
			addCategory("Food");
			addCategory("Work");
			addCategory("Gift");	
		}
	}
	
	//Returns the number of categories
	@Override
	public int getRowCount() { return categories.size(); }

	//Returns the number of fields for a category
	@Override
	public int getColumnCount() { return 1; }

	//Returns the name of a certain attribute in a certain row
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) { return categories.get(rowIndex)[columnIndex]; }

	@Override
	public boolean isCellEditable(int row, int column) {
			return true;
	}
	
	//Sets the value of a certain attribute in a certain row
	public void setValueAt(Object value,int row,int column) {
		categories.get(row)[column]=value;
		fm.save(categories);
		this.fireTableCellUpdated(row, column);
	}
	
	//removes the ith row from the table
			public void removeRow(int row) {
				categories.remove(row);
				fm.save(categories);
				this.fireTableRowsDeleted(row, row);
	}

	//Adds a category to the list and saves it to the file
	public void addCategory(String name) {
		Object[] category={name};
		categories.add(category);
		fm.save(categories);
		fireTableRowsInserted(0, getRowCount());
	}
}
