package dataObjects;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import fileManagement.FileManagement;

@SuppressWarnings("serial")
public class UserData implements Serializable{
	private ArrayList<Object[]> users = new ArrayList<Object[]>();
	private FileManagement fm = new FileManagement("users.txt");
	
	//Constructor
	public UserData(){
		File f = new File("users.txt");
		//If the file exists load existing data
		if(f.exists() && !f.isDirectory()) { 
			users = fm.load(users);
		}
		//If not, initialize it with the default user
		else {
			addUser("User","Password");	
		}
	}
		
	//Adds a user to the list and saves it to the file
	public void addUser(String username, String password) {
		Object[] user={username,password};
		users.add(user);
		fm.save(users);
		users=fm.load(users);
		
		String entriesFilename = new String(username+"_wallet.txt");
		String categoriesFilename = new String(username+"_categories.txt");
		
		File entriesFile = new File(entriesFilename);
		try { entriesFile.createNewFile(); } 
		catch (IOException e) { e.printStackTrace();}
		
		File categoriesFile = new File(categoriesFilename);
		try { categoriesFile.createNewFile(); } 
		catch (IOException e) { e.printStackTrace();}
	}
	
	//Returns the row on which the given username exists (if it does not return -1)
	public int userRow(String username) {
		for(int i=0;i<users.size();i++) {
			if(users.get(i)[0].toString().equals(username)) {
				return i;
			}
		}
		return -1;
	}
	
	//Returns true if the password corresponds to the given username
	public boolean checkPassword(String username, String password) {
		return (password.equals(users.get(userRow(username))[1].toString()));
	}
}
