package frames;
/////////////////////////////////////////*CHECK LAB FOR IO MANAGEMENT*//////////////////////////////////
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.*;

public class NewCategory extends JPanel{
	//Attributes
	ArrayList<String> categories = new ArrayList<String>();
	
	//Constructor
	public NewCategory() {
		//Show the available categories
		
		//Add category
		JTextField text = new JTextField(20);
		JButton addButton = new JButton("Add");
		Styles.styleButton(addButton);
		
		addButton.setActionCommand("newEntry");
    	ActionListener addButtonAL = new ButtonActionListener();
    	addButton.addActionListener(addButtonAL);
    	
    	//Adding  the components to the panel
    	this.add(Box.createRigidArea(new Dimension(0, 15)));
    	this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(text);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(addButton);
	}
	
	final private class ButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//If the category already exists make an alert
			fillTable("food");
		}
	}
	
	private void fillTable() throws IOException {
		try {
			FileReader fr = new FileReader("categories.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line==null) break;
				categories.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void fillTable(String input) {
		try {
			FileWriter fw = new FileWriter("categories.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println(input);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
