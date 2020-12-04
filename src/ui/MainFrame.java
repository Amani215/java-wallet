package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MainFrame extends JFrame{
		JMenuBar menubar =new JMenuBar();	  
	    	JMenu addIncome=new JMenu("Add Income");
	    	JMenu addExpense=new JMenu("Add Expense");
	    	JMenu addCategory=new JMenu("Add Category");
	    	JMenu moneyInWallet=new JMenu("Money In My Wallet");
	    	JMenu statistics=new JMenu("Statistics");
	    final JFrame frame=this;
	    	
		//style the buttons
		private static void styleButton(JButton button) {
			  button.setForeground(Color.WHITE);
			  button.setBackground(Color.DARK_GRAY);
			  Border line = new LineBorder(Color.DARK_GRAY);
			  Border margin = new EmptyBorder(5, 15, 5, 15);
			  Border compound = new CompoundBorder(line, margin);
			  button.setBorder(compound);
		}
		
		//Constructor
		public MainFrame() {
			super("WALLET");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			menubar.add(addIncome);
	        menubar.add(addExpense);
	        menubar.add(addCategory);
	        menubar.add(moneyInWallet);
	        menubar.add(statistics);
	        
	        addIncome.addMenuListener(new MenuListener() {
	            @Override
	            public void menuSelected(MenuEvent e) {
	               addIncome.setSelected(false);
	               frame.add(new AddIncomeFrame());
	               frame.getContentPane().validate();
	               frame.getContentPane().repaint();
	            }
	            @Override
	            public void menuDeselected(MenuEvent e) {
	                throw new UnsupportedOperationException("Not supported yet.");
	            } 
	            @Override
	            public void menuCanceled(MenuEvent e) {
	                throw new UnsupportedOperationException("Not supported yet.");
	            }
	        });
	        
	        addExpense.addMenuListener(new MenuListener() {
	            @Override
	            public void menuSelected(MenuEvent e) {
	               addExpense.setSelected(false);
	               frame.add(new JLabel("Expense"));
	               frame.getContentPane().validate();
	               frame.getContentPane().repaint();
	            }
	            @Override
	            public void menuDeselected(MenuEvent e) {
	                throw new UnsupportedOperationException("Not supported yet.");
	            } 
	            @Override
	            public void menuCanceled(MenuEvent e) {
	                throw new UnsupportedOperationException("Not supported yet.");
	            }
	        });
	        
			//Build the window
			setMinimumSize(new Dimension(630,330));
			//initComponents();
			//pack();
			
	        setBackground(Color.LIGHT_GRAY);
	        this.setJMenuBar(menubar);    
	         
	        this.setLayout(new BorderLayout());
	        this.setVisible(true);
		}
}

//initializes the window
/*private void initComponents() {
	//main menu
	JPanel options = new JPanel();
	JPanel menu = new JPanel();
	
	/*buttons*/
/*	JButton addIncome = new JButton("Add Income");
		styleButton(addIncome);
		addIncome.setActionCommand("ok");
    	ActionListener addIncomeAL = new ButtonActionListener();
    	addIncome.addActionListener(addIncomeAL);
    	
	JButton addExpense = new JButton("Add Expense");
		styleButton(addExpense);
		addExpense.setActionCommand("addExpense");
    	ActionListener addExpenseAL = new ButtonActionListener();
    	addExpense.addActionListener(addExpenseAL);
    	
	JButton addCategory = new JButton("Add Category");
		styleButton(addCategory);
		addCategory.setActionCommand("addCategory");
    	ActionListener addCategoryAL = new ButtonActionListener();
    	addCategory.addActionListener(addCategoryAL);
    	  
	JButton moneyInWallet = new JButton("Money In My Wallet");
		styleButton(moneyInWallet);
		moneyInWallet.setActionCommand("moneyInWallet");
    	ActionListener moneyInWalletAL = new ButtonActionListener();
    	moneyInWallet.addActionListener(moneyInWalletAL);
    	  
	JButton statistics = new JButton("Statistics");
		styleButton(statistics);
		statistics.setActionCommand("statistics");
    	ActionListener statisticsAL = new ButtonActionListener();
    	statistics.addActionListener(statisticsAL);
    	
    /*adding buttons to the menu*/	  
/*		options.add(addIncome);
		options.add(addExpense);
		options.add(addCategory);
		options.add(moneyInWallet);
		options.add(statistics);
		options.setLayout(new GridBagLayout());
/*	menu.add(options,BorderLayout.CENTER);
	
	/*whole window*/
//	panel1.add(menu);
	//panel2.add(new JButton("here"));
//	this.add(panel1, BorderLayout.NORTH);
	//this.add(panel2);
//}
