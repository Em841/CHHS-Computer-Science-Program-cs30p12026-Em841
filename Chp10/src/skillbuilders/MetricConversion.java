package skillbuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MetricConversion {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversion window = new MetricConversion();
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
	public MetricConversion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea dis = new JTextArea();
		dis.setBackground(new Color(240, 240, 240));
		dis.setBounds(113, 159, 188, 44);
		panel.add(dis);
		
		JComboBox con = new JComboBox();
		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(con.getSelectedItem().equals("Select a conversion type")) {
					dis.setText("");
				}
				if(con.getSelectedItem().equals("inch to centimeters")) {
					dis.setText("1 inch = 2.54 centimeters");
				}
				if (con.getSelectedItem().equals("foot to meters")) {
					dis.setText("1 foot = 0.3048 meters");	
					}
				if (con.getSelectedItem().equals("gallon to liters")) {
					dis.setText("1 gallon = 4.5461 liters");	
					}
				if (con.getSelectedItem().equals("pound to kilograms")) {
					dis.setText("1 pound = 0.4536 kilograms");	
					
			}
			}});
		con.setFont(new Font("Tahoma", Font.PLAIN, 15));
		con.setModel(new DefaultComboBoxModel(new String[] {"Select a conversion type", "inch to centimeters", "foot to meters", "gallon to liters", "pound to kilograms"}));
		con.setBounds(98, 73, 227, 44);
		panel.add(con);
		
		
		JTextArea title = new JTextArea();
		title.setText("METRIC CONVERSION");
		title.setBounds(128, 40, 141, 22);
		panel.add(title);
	
		/*inch to centimeters
		foot to meters
		gallon to liters
		pound to kilograms
		*/
		
		
		
		
		
		
		
		
		
	}}
