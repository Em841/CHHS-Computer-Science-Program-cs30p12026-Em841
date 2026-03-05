/*
 * Program:LocalBankGUI
 * Purpose:Customers can create an account where they can input their account ID and be able to insert their money, check balance and withdraw money.
 * Author: Eman Abid
 * School:CHHS
 * Course: computing programming 30
  */

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalBankGUI {
	Bank lbank = new Bank();

	private JFrame frame;
	private JTextField anum;
	private JTextField adepowith;
	private JTextField fn;
	private JTextField ln;
	private JTextField beginbal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBankGUI window = new LocalBankGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocalBankGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 470, 603);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Select an action:");
		lblNewLabel.setBounds(33, 33, 278, 22);
		panel.add(lblNewLabel);
		
		anum = new JTextField();
		anum.setBounds(33, 150, 398, 27);
		panel.add(anum);
		anum.setColumns(10);
		
		adepowith = new JTextField();
		adepowith.setColumns(10);
		adepowith.setBounds(33, 188, 398, 27);
		panel.add(adepowith);
		
		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(33, 243, 398, 27);
		panel.add(fn);
		
		ln = new JTextField();
		ln.setColumns(10);
		ln.setBounds(33, 281, 398, 27);
		panel.add(ln);
		
		beginbal = new JTextField();
		beginbal.setColumns(10);
		beginbal.setBounds(33, 332, 398, 27);
		panel.add(beginbal);
		
		JLabel accountnumber = new JLabel("Account ID:");
		accountnumber.setForeground(new Color(0, 0, 0));
		accountnumber.setBounds(33, 137, 212, 14);
		panel.add(accountnumber);
		
		JLabel amountdepowith = new JLabel("Amount of deposit/withdrawal:");
		amountdepowith.setForeground(new Color(0, 0, 0));
		amountdepowith.setBounds(33, 176, 212, 14);
		panel.add(amountdepowith);
		
		JLabel firstname = new JLabel("First Name:");
		firstname.setForeground(new Color(255, 0, 0));
		firstname.setBounds(33, 229, 110, 14);
		panel.add(firstname);
		
		JLabel lastname = new JLabel("Last Name:");
		lastname.setForeground(new Color(255, 0, 0));
		lastname.setBounds(33, 269, 110, 14);
		panel.add(lastname);
		
		JLabel beginningbalance = new JLabel("Beginning Balance:");
		beginningbalance.setForeground(new Color(255, 0, 0));
		beginningbalance.setBounds(31, 319, 280, 14);
		panel.add(beginningbalance);
		
		JLabel lblNewLabel_4 = new JLabel("Complete the information in RED");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(33, 103, 259, 36);
		panel.add(lblNewLabel_4);
		
		JLabel accountdis = new JLabel("");
		accountdis.setBounds(33, 370, 398, 106);
		panel.add(accountdis);
		
		JComboBox action = new JComboBox();
		action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (action.getSelectedItem().equals("Add account")){
					accountnumber.setForeground(Color.black);
					amountdepowith.setForeground(Color.black);
					firstname.setForeground(Color.red);
					lastname.setForeground(Color.red);
					beginningbalance.setForeground(Color.red);
				}
				if (action.getSelectedItem().equals("Remove account")){
					accountnumber.setForeground(Color.red);
					amountdepowith.setForeground(Color.black);
					firstname.setForeground(Color.black);
					lastname.setForeground(Color.black);
					beginningbalance.setForeground(Color.black);
				}
				if (action.getSelectedItem().equals("Check balance")){
					accountnumber.setForeground(Color.red);
					amountdepowith.setForeground(Color.black);
					firstname.setForeground(Color.black);
					lastname.setForeground(Color.black);
					beginningbalance.setForeground(Color.black);
				}
				if (action.getSelectedItem().equals("Deposit")){
					accountnumber.setForeground(Color.red);
					amountdepowith.setForeground(Color.red);
					firstname.setForeground(Color.black);
					lastname.setForeground(Color.black);
					beginningbalance.setForeground(Color.black);
				}
				if (action.getSelectedItem().equals("Withdrawal")){
					accountnumber.setForeground(Color.red);
					amountdepowith.setForeground(Color.red);
					firstname.setForeground(Color.black);
					lastname.setForeground(Color.black);
					beginningbalance.setForeground(Color.black);
				}
				anum.setText(null);
				adepowith.setText(null);
				fn.setText(null);
				ln.setText(null);
				beginbal.setText(null);
			}
		});
		action.setFont(new Font("Tahoma", Font.PLAIN, 15));
		action.setModel(new DefaultComboBoxModel(new String[] {"Add account", "Remove account", "Check balance", "Deposit", "Withdrawal"}));
		action.setBounds(33, 56, 398, 36);
		panel.add(action);
		
		JButton finalbutton = new JButton("Process");
		finalbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (action.getSelectedItem().equals("Add account")) {
					String dis = lbank.addAccount(fn.getText(), ln.getText(), Double.parseDouble(beginbal.getText()));
					accountdis.setText(dis);
				}
				if (action.getSelectedItem().equals("Remove account")) {
					String dis = lbank.deleteAccount(anum.getText());
					accountdis.setText(dis);
				}
				if (action.getSelectedItem().equals("Check balance")) {
					String dis = lbank.checkBalance(anum.getText());
					accountdis.setText(dis);
				}
				
				
				if (action.getSelectedItem().equals("Deposit")) {
					String dis = lbank.transaction(1, anum.getText(), Double.parseDouble(adepowith.getText()));
					accountdis.setText(dis);
				}
				
				if (action.getSelectedItem().equals("Withdrawal")) {
					String dis = lbank.transaction(2, anum.getText(), Double.parseDouble(adepowith.getText()));
					accountdis.setText(dis);
					}
				
				
		}});
		finalbutton.setBounds(33, 531, 398, 44);
		panel.add(finalbutton);
	}
}