package dataObjects;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fileManagement.FileManagement;

@SuppressWarnings("serial")
public class EntryData extends AbstractTableModel implements Serializable{
	//Attributes
		public ArrayList<Object[]> entries = new ArrayList<Object[]>();
		private FileManagement fm = new FileManagement("wallet.txt");
		
		//Constructor
		public EntryData(){
			File f = new File("wallet.txt");
			//If the file exists load existing data
			if(f.exists() && !f.isDirectory()) { 
				entries = fm.load(entries);
			}
		}
		
		//Returns the number of entries
		@Override
		public int getRowCount() { return entries.size(); }

		//Returns the number of fields for a category
		@Override
		public int getColumnCount() { return 4; }//type, category, date, amount

		//Returns the name of a certain attribute in a certain row
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) { return entries.get(rowIndex)[columnIndex]; }

		//Sets the value of a certain attribute in a certain row
		public void setValueAt(Object value,int row,int column) {
			entries.get(row)[column]=value;
		}
		
		//Adds a category to the list and saves it to the file
		public void addEntry(String type, LocalDate date, String category, double amount) {
			Object[] entry={type,date,category,amount};
			entries.add(entry);
			fm.save(entries);
			fireTableRowsInserted(0, getRowCount());
		}
}
