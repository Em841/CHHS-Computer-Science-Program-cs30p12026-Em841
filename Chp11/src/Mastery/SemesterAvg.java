
/*
 * Program:Semester average
 * Purpose:the purpose of this code is to make a file where the user inputs the name of the student their grades and semester and can keep adding the students until they want to clear the file and restart it if they want.
 * Author: Eman Abid
 * School:CHHS
 * Course: computer science 4 OB
  */


package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class SemesterAvg {

	private JFrame frame;
	private JTextField stuname;
	private JTextField grdlvl;
	private JTextField semnum;
	private JTextField grd1;
	private JTextField grd2;
	private JTextField grd3;
	private JTextField grd4;
	private static final String FILE_NAME = "Grades.txt";
	private File dataFile = new File(FILE_NAME);

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
	private void initialize() {
		
		DecimalFormat decimalFormatter = new DecimalFormat("0.#");
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 150, 253));
		panel.setBounds(0, 0, 538, 574);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 142, 25);
		panel.add(lblNewLabel);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGradeLevel.setBounds(10, 43, 142, 25);
		panel.add(lblGradeLevel);
		
		JLabel lblSemesterNumber = new JLabel("Semester Number:");
		lblSemesterNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSemesterNumber.setBounds(10, 79, 142, 25);
		panel.add(lblSemesterNumber);
		
		JLabel lblGrade = new JLabel("Grade 1:");
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrade.setBounds(10, 115, 142, 25);
		panel.add(lblGrade);
		
		JLabel lblGrade_5 = new JLabel("Grade 2:");
		lblGrade_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrade_5.setBounds(10, 151, 142, 25);
		panel.add(lblGrade_5);
		
		JLabel lblGrade_1 = new JLabel("Grade 3:");
		lblGrade_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrade_1.setBounds(10, 187, 142, 25);
		panel.add(lblGrade_1);
		
		JLabel lblGrade_2 = new JLabel("Grade 4:");
		lblGrade_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrade_2.setBounds(10, 223, 142, 25);
		panel.add(lblGrade_2);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAverage.setBounds(10, 259, 64, 25);
		panel.add(lblAverage);
		
		stuname = new JTextField();
		stuname.setBounds(162, 13, 366, 25);
		panel.add(stuname);
		stuname.setColumns(10);
		
		grdlvl = new JTextField();
		grdlvl.setColumns(10);
		grdlvl.setBounds(162, 43, 366, 25);
		panel.add(grdlvl);
		
		semnum = new JTextField();
		semnum.setColumns(10);
		semnum.setBounds(162, 79, 366, 25);
		panel.add(semnum);
		
		grd1 = new JTextField();
		grd1.setColumns(10);
		grd1.setBounds(162, 115, 366, 25);
		panel.add(grd1);
		
		grd2 = new JTextField();
		grd2.setColumns(10);
		grd2.setBounds(162, 151, 366, 25);
		panel.add(grd2);
		
		grd3 = new JTextField();
		grd3.setColumns(10);
		grd3.setBounds(162, 187, 366, 25);
		panel.add(grd3);
		
		grd4 = new JTextField();
		grd4.setColumns(10);
		grd4.setBounds(162, 223, 366, 25);
		panel.add(grd4);
		
		JLabel avg = new JLabel("");
		avg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		avg.setBounds(84, 259, 64, 25);
		panel.add(avg);
		
		JTextArea dis = new JTextArea();
		dis.setEditable(false);
		dis.setBounds(10, 289, 518, 240);
		panel.add(dis);
		
		JButton savebtn = new JButton("Save To File");
		savebtn.setForeground(new Color(255, 255, 255));
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//take inputs
				String studentname = stuname.getText().trim();
				String gradelevel = grdlvl.getText().trim();
				String semesternum = semnum.getText().trim();
				String grade1 = grd1.getText().trim();
				String grade2 = grd2.getText().trim();
				String grade3 = grd3.getText().trim();
				String grade4 = grd4.getText().trim();

				//check if user left any fields empty
				if (studentname.isEmpty() ||gradelevel.isEmpty() || semesternum.isEmpty() || grade1.isEmpty() || grade2.isEmpty() 
					|| grade3.isEmpty()|| grade4.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "1 or More Fields are Empty, Please enter a value",
							"Input Error", JOptionPane.WARNING_MESSAGE);
				}

				try
				{
					//find average
					double avgGrade = ((Double.parseDouble(grade1)) + (Double.parseDouble(grade2)) + 
							(Double.parseDouble(grade3)) + (Double.parseDouble(grade4))) / 4;
					
					avg.setText(decimalFormatter.format(avgGrade) + "%");

					//file writing tools
					StringBuilder output = new StringBuilder();
					FileWriter out = new FileWriter(dataFile, true);
					BufferedWriter writeFile = new BufferedWriter(out);
					
					//turn the grade inputs from string to doubles
					double grd1 = Double.parseDouble(grade1);
					double grd2 = Double.parseDouble(grade2);
					double grd3 = Double.parseDouble(grade3);
					double grd4 = Double.parseDouble(grade4);
					
					//write the information
					output.append("Name: ").append(studentname);
					output.append(" Grade Level: ");
					output.append(gradelevel).append(" Semester: ");
					output.append(semesternum);
					output.append(" Grades: ");
					output.append(decimalFormatter.format(grd1)).append("%, ");
					output.append(decimalFormatter.format(grd2)).append("%, ");
					output.append(decimalFormatter.format(grd3)).append("%, ");
					output.append(decimalFormatter.format(grd4)).append("%, ");
					output.append(" Average: ").append(decimalFormatter.format(avgGrade)).append("%");

					writeFile.write(output.toString());
					writeFile.newLine();

					writeFile.close();
					out.close();
					
					//confirmation pop up
					JOptionPane.showMessageDialog(null, "Data saved to file " + FILE_NAME,
							"Message", JOptionPane.INFORMATION_MESSAGE);
					
					//prompt user to press button
					dis.setText("Press 'Display File Content' to read data of file " + FILE_NAME);

				}//error messages if something goes wrongVVV
				catch (IOException err)
				{
					
					JOptionPane.showMessageDialog(null, "File could not be created\n" + err.getMessage(),
							"File Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (NumberFormatException err)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid numbers for grades",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		
			
		});
		
		savebtn.setBackground(new Color(0, 128, 192));
		savebtn.setBounds(10, 540, 131, 23);
		panel.add(savebtn);
		
		JButton showbtn = new JButton("Display File Content");
		showbtn.setForeground(new Color(255, 255, 255));
		showbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			//reset display text
			dis.setText(null);
			
			try 
			{
				//file reader tools
				FileReader in = new FileReader(dataFile);
				BufferedReader readFile = new BufferedReader(in);
				String line;
				StringBuilder output = new StringBuilder();
				
				//reads file and makes a new line whenever there is text
				while ((line = readFile.readLine()) != null)
				{
					output.append(line).append("\n");
				}
				readFile.close();
				in.close();

				dis.setText(output.toString());
			}
			
			//error messages if something goes wrong VV
			catch (FileNotFoundException err)
			{
				JOptionPane.showMessageDialog(null, "File could not be found!\n" + err.getMessage(),
						"File Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (IOException err)
			{
				JOptionPane.showMessageDialog(null, "Error reading file:\n" + err.getMessage(),
						"File Error", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		showbtn.setBackground(new Color(0, 128, 192));
		showbtn.setBounds(193, 540, 152, 23);
		panel.add(showbtn);
		
		JButton clearbtn = new JButton("Clear File");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//clears the file
				try {
					FileOutputStream fos = new FileOutputStream(dataFile);
					JOptionPane.showMessageDialog(null, "Data cleared from file " + FILE_NAME, "Message", JOptionPane.INFORMATION_MESSAGE);
					dis.setText("Data has been cleared from file " + FILE_NAME);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		clearbtn.setForeground(Color.WHITE);
		clearbtn.setBackground(new Color(0, 128, 192));
		clearbtn.setBounds(397, 540, 131, 23);
		panel.add(clearbtn);
	}
}