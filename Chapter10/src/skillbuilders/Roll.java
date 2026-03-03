package skillbuilders;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class Roll {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roll window = new Roll();
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
	public Roll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon d1 = new ImageIcon("../skillbuilders/die1.gif");
		ImageIcon d2 = new ImageIcon("../skillbuilders/die2.gif");
		ImageIcon d3 = new ImageIcon("../skillbuilders/die3.gif");
		ImageIcon d4 = new ImageIcon("../skillbuilders/die4.gif");
		ImageIcon d5 = new ImageIcon("../skillbuilders/die5.gif");
		ImageIcon d6 = new ImageIcon("../skillbuilders/die6.gif");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 488, 287);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel dice = new JLabel("");
		dice.setBounds(123, 57, 137, 113);
		panel.add(dice);
		
		JLabel dice2 = new JLabel("");
		dice2.setBounds(270, 57, 137, 113);
		panel.add(dice2);
		
		JButton rol = new JButton("Roll");
		rol.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//first dice
				int r = (int)(6 * Math.random() + 1);
				
				if(r == 1){
					dice.setIcon(d1);
				}
				
				if(r == 2){
					dice.setIcon(d2);
				}
				
				if(r == 3){
				dice.setIcon(d3);
				}
				
				if(r == 4){
					dice.setIcon(d4);
				}
				if(r == 5){
					dice.setIcon(d5);
				}
				
				if(r == 6){
					dice.setIcon(d6);
				}
				
				//second dice
				int r2 = (int)(6 * Math.random() + 1);
				
				if(r2 == 1){
					dice2.setIcon(d1);
				}
				
				if(r == 2){
					dice2.setIcon(d2);
				}
				
				if(r2 == 3){
					dice.setIcon(d3);
				}
				
				if(r2 == 4){
					dice2.setIcon(d4);
				}
				
				if(r2 == 5){
					dice2.setIcon(d5);
				}
				
				if(r2 == 6){
					dice2.setIcon(d6);
				}
			}
		});
		rol.setBounds(189, 203, 121, 33);
		panel.add(rol);
		
		JLabel lblNewLabel = new JLabel("Roll for double dice");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBackground(new Color(128, 255, 0));
		lblNewLabel.setBounds(189, 0, 121, 33);
		panel.add(lblNewLabel);
	}
}


