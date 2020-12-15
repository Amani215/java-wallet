package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JPanel {
	public String entriesFile = new String();
	public String categoriesFile = new String();
	public boolean loggedIn = false;
	
	private JLabel username = new JLabel("Username");
	public JTextField usernameField = new JTextField(20);
	
	private JLabel password = new JLabel("Password");
	public JTextField passwordField = new JTextField(20);
	
	//Constructor
	public Login() {
		this.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("If you're using this for the first time you can still login with a new username and password!");
		JLabel label2= new JLabel("Please secure your password as there won't be any possibility to change it afterwards.");
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		labelPanel.add(label); labelPanel.add(label2);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.add(username); usernamePanel.add(usernameField);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.add(password); passwordPanel.add(passwordField);
		
		JPanel coordinatesPanel = new JPanel();
		coordinatesPanel.setLayout(new BorderLayout());
		coordinatesPanel.add(usernamePanel,BorderLayout.NORTH);
		coordinatesPanel.add(passwordPanel,BorderLayout.CENTER);
		
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(labelPanel,BorderLayout.NORTH);
		this.add(Box.createRigidArea(new Dimension(0, 15)));
		this.add(coordinatesPanel,BorderLayout.CENTER);
	}
}
