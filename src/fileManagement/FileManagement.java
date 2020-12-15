package fileManagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManagement {
	//attributes
	private String filename;
	
	//constructor
	public FileManagement(String filename) {
		this.filename = filename;
	}
	
	//Loads the data from the database file
	@SuppressWarnings("unchecked")
	public ArrayList<Object[]> load(ArrayList<Object[]> categories) {
		try { 
			FileInputStream f = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(f);
			categories = ((ArrayList<Object[]>)in.readObject());
			in.close();
		} 
		catch(IOException ex) { 
			System.out.println("There was a problem. (IOException in load function)\r\n");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("There was a problem. (ClassNotFoundException in load function)\r\n");
		}
		return(categories);
	}
	
	//Saves the data in the database file
	public void save(ArrayList<Object[]> categories) {
		try {
			FileOutputStream f = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(categories);
			out.close();
		}
		catch(IOException e) {
			System.out.println("There was a problem...");
		}
	}

}
