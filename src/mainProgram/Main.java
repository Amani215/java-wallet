package mainProgram;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dataObjects.UserData;
import panels.*;
import ui.Styles;

@SuppressWarnings("serial")
public class Main extends JFrame{
	//attributes
	public static String entriesFile = new String();
	public static String categoriesFile = new String();
	
	private JPanel currentPanel = new JPanel();
	private Login login = new Login();
	private JButton loginButton = new JButton("Login");
	private MainPanel mainPanel = new MainPanel();
	
	private JFrame frame = this;
	
	//constructor
	public Main() {
		//general settings
		super("WALLET");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(630,500));
		
		//add the login panel and the login button
		currentPanel.add(login);
		
		Styles.styleButton(loginButton);
		currentPanel.add(loginButton,BorderLayout.SOUTH);
		
		//login button action listener
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usr = login.usernameField.getText();
				String psw = login.passwordField.getText();
				
				File f = new File(usr+"_wallet.txt");
				UserData data = new UserData();
				
				//if the user does not exist
				if(!f.exists()) {
					if(usr.length()<3) 
						JOptionPane.showMessageDialog(null,"The username is too short!","Username too short",JOptionPane.WARNING_MESSAGE);
					else if(psw.length()<5)
						JOptionPane.showMessageDialog(null,"The password is too short!","Password too short",JOptionPane.WARNING_MESSAGE);	
					else if(data.userRow(usr)==-1) {
						//sign the user up
						data.addUser(usr, psw);
						entriesFile = usr+"_wallet.txt";
						categoriesFile = usr+"_categories.txt";
						login.usernameField.setText("");
						login.passwordField.setText("");
						
						frame.remove(currentPanel);
						frame.add(mainPanel);
						validate();
						repaint();
					}
				}
				//if the user exists
				else {
					if(data.checkPassword(usr, psw)==true) {
						//log the user in
						entriesFile = usr+"_wallet.txt";
						categoriesFile = usr+"_categories.txt";
						login.usernameField.setText("");
						login.passwordField.setText("");
						
						frame.remove(currentPanel);
						frame.add(mainPanel);
						validate();
						repaint();
					}
					else
						JOptionPane.showMessageDialog(null,"Wrong password!","Wrong password",JOptionPane.WARNING_MESSAGE);	
				}
          	}
			});
		
		this.add(currentPanel);
		
	}
	
	/*ENTRY POINT OF THE PROGRAM*/
	public static void main(String[] args) {
		Main mainFrame = new Main();
		mainFrame.setVisible(true);
	}
}
