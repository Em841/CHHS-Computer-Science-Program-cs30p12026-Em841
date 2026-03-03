package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class SemesterAvg {

	private JFrame frame;
	private JTextField grade1;
	private JTextField grade2;
	private JTextField grade3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
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
	public SemesterAvg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea txtrEnterTheFirst = new JTextArea();
		txtrEnterTheFirst.setFont(new Font("Georgia", Font.PLAIN, 17));
		txtrEnterTheFirst.setText("Enter the first grade:");
		txtrEnterTheFirst.setBackground(new Color(240, 240, 240));
		txtrEnterTheFirst.setBounds(30, 15, 189, 29);
		panel.add(txtrEnterTheFirst);
		
		JTextArea txtrEnterTheSecond = new JTextArea();
		txtrEnterTheSecond.setFont(new Font ("Georgia",Font.PLAIN, 17));
		txtrEnterTheSecond.setText("Enter the second grade:");
		txtrEnterTheSecond.setBackground(UIManager.getColor("Button.background"));
		txtrEnterTheSecond.setBounds(30, 59, 189, 29);
		panel.add(txtrEnterTheSecond);
		
		JTextArea txtrEnterTheThird = new JTextArea();
		txtrEnterTheThird.setFont(new Font ("Georgia",Font.PLAIN, 17));
		txtrEnterTheThird.setText("Enter the third grade:");
		txtrEnterTheThird.setBackground(UIManager.getColor("Button.background"));
		txtrEnterTheThird.setBounds(30, 103, 189, 29);
		panel.add(txtrEnterTheThird);
		
		JLabel total = new JLabel("");
		total.setFont(new Font("Georgia", Font.PLAIN, 17));
		total.setBounds(268, 162, 73, 48);
		panel.add(total);
		
		
		JButton avg = new JButton("Find Average");
		avg.setFont(new Font ("Georgia", Font.PLAIN, 17));
		avg.setBackground(new Color(246,165, 219));
		avg.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			String firstgrade = grade1.getText();
			String secondgrade = grade2.getText();
			String thirdgrade = grade3.getText();
			
				double gradeavg = (Double.parseDouble(firstgrade) + Double.parseDouble(secondgrade) + Double.parseDouble(thirdgrade))/3;
				
				total.setText(Double.toString(gradeavg));
			}
		});
		avg.setBounds(10, 162, 189, 48);
		panel.add(avg);
		
		grade1 = new JTextField();
		grade1.setBounds(239, 17, 141, 27);
		panel.add(grade1);
		grade1.setColumns(10);
		
		grade2 = new JTextField();
		grade2.setColumns(10);
		grade2.setBounds(239, 61, 141, 27);
		panel.add(grade2);
		
		grade3 =new JTextField();
		grade3.setColumns(10);
		grade3.setBounds(239, 105, 141, 27);
		panel.add(grade3);
		
	
		
		
	}
}