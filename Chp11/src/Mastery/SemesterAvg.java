
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

	// GUI components and input fields
	private JFrame frame;
	private JTextField stuname;
	private JTextField grdlvl;
	private JTextField semnum;
	private JTextField grd1;
	private JTextField grd2;
	private JTextField grd3;
	private JTextField grd4;

	// Constant file name and file object
	private static final String FILE_NAME = "Grades.txt";
	private File dataFile = new File(FILE_NAME);

	/**
	 * Launch the application (main method)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
					window.frame.setVisible(true); // display window
				} catch (Exception e) {
					e.printStackTrace(); // print errors if any
				}
			}
		});
	}

	/**
	 * Constructor - calls initialize method
	 */
	public SemesterAvg() {
		initialize();
	}

	/**
	 * Builds and initializes the GUI
	 */
	private void initialize() {

		// Formatter for displaying decimal values
		DecimalFormat decimalFormatter = new DecimalFormat("0.#");

		// Formatter for percentages (not used directly but available)
		NumberFormat percent = NumberFormat.getPercentInstance();

		// Create main window frame
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Main panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 548, 574);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Labels for inputs
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 11, 142, 25);
		panel.add(lblNewLabel);

		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblGradeLevel.setBounds(10, 43, 142, 25);
		panel.add(lblGradeLevel);

		JLabel lblSemesterNumber = new JLabel("Semester Number:");
		lblSemesterNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblSemesterNumber.setBounds(10, 79, 142, 25);
		panel.add(lblSemesterNumber);

		// Grade labels
		JLabel lblGrade = new JLabel("Grade 1:");
		lblGrade.setBounds(10, 115, 142, 25);
		panel.add(lblGrade);

		JLabel lblGrade_5 = new JLabel("Grade 2:");
		lblGrade_5.setBounds(10, 151, 142, 25);
		panel.add(lblGrade_5);

		JLabel lblGrade_1 = new JLabel("Grade 3:");
		lblGrade_1.setBounds(10, 187, 142, 25);
		panel.add(lblGrade_1);

		JLabel lblGrade_2 = new JLabel("Grade 4:");
		lblGrade_2.setBounds(10, 223, 142, 25);
		panel.add(lblGrade_2);

		// Average label
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(10, 259, 87, 25);
		panel.add(lblAverage);

		// Text fields for user input
		stuname = new JTextField();
		stuname.setBounds(162, 13, 366, 25);
		panel.add(stuname);

		grdlvl = new JTextField();
		grdlvl.setBounds(162, 43, 366, 25);
		panel.add(grdlvl);

		semnum = new JTextField();
		semnum.setBounds(162, 79, 366, 25);
		panel.add(semnum);

		grd1 = new JTextField();
		grd1.setBounds(162, 115, 366, 25);
		panel.add(grd1);

		grd2 = new JTextField();
		grd2.setBounds(162, 151, 366, 25);
		panel.add(grd2);

		grd3 = new JTextField();
		grd3.setBounds(162, 187, 366, 25);
		panel.add(grd3);

		grd4 = new JTextField();
		grd4.setBounds(162, 223, 366, 25);
		panel.add(grd4);

		// Label to display calculated average
		JLabel avg = new JLabel("");
		avg.setBounds(84, 259, 64, 25);
		panel.add(avg);

		// Text area to display file contents
		JTextArea dis = new JTextArea();
		dis.setEditable(false);
		dis.setBounds(20, 289, 481, 240);
		panel.add(dis);

		// SAVE BUTTON
		JButton savebtn = new JButton("Save To File");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get user input and remove extra spaces
				String studentname = stuname.getText().trim();
				String gradelevel = grdlvl.getText().trim();
				String semesternum = semnum.getText().trim();
				String grade1 = grd1.getText().trim();
				String grade2 = grd2.getText().trim();
				String grade3 = grd3.getText().trim();
				String grade4 = grd4.getText().trim();

				// Check for empty fields
				if (studentname.isEmpty() || gradelevel.isEmpty() || semesternum.isEmpty()
						|| grade1.isEmpty() || grade2.isEmpty()
						|| grade3.isEmpty() || grade4.isEmpty()) {

					JOptionPane.showMessageDialog(null,
							"1 or More Fields are Empty, Please enter a value",
							"Input Error", JOptionPane.WARNING_MESSAGE);
				}

				try {
					// Calculate average grade
					double avgGrade = ((Double.parseDouble(grade1))
							+ (Double.parseDouble(grade2))
							+ (Double.parseDouble(grade3))
							+ (Double.parseDouble(grade4))) / 4;

					// Display average
					avg.setText(decimalFormatter.format(avgGrade) + "%");

					// Prepare file writing
					StringBuilder output = new StringBuilder();
					FileWriter out = new FileWriter(dataFile, true);
					BufferedWriter writeFile = new BufferedWriter(out);

					// Convert grades to double
					double grd1 = Double.parseDouble(grade1);
					double grd2 = Double.parseDouble(grade2);
					double grd3 = Double.parseDouble(grade3);
					double grd4 = Double.parseDouble(grade4);

					// Build output string
					output.append("Name: ").append(studentname);
					output.append(" Grade Level: ").append(gradelevel);
					output.append(" Semester: ").append(semesternum);
					output.append(" Grades: ");
					output.append(decimalFormatter.format(grd1)).append("%, ");
					output.append(decimalFormatter.format(grd2)).append("%, ");
					output.append(decimalFormatter.format(grd3)).append("%, ");
					output.append(decimalFormatter.format(grd4)).append("%, ");
					output.append(" Average: ").append(decimalFormatter.format(avgGrade)).append("%");

					// Write to file
					writeFile.write(output.toString());
					writeFile.newLine();

					// Close file writers
					writeFile.close();
					out.close();

					// Confirmation message
					JOptionPane.showMessageDialog(null,
							"Data saved to file " + FILE_NAME,
							"Message", JOptionPane.INFORMATION_MESSAGE);

					// Prompt user to display file
					dis.setText("Press 'Display File Content' to read data of file " + FILE_NAME);

				}
				// Handle file writing errors
				catch (IOException err) {
					JOptionPane.showMessageDialog(null,
							"File could not be created\n" + err.getMessage(),
							"File Error", JOptionPane.ERROR_MESSAGE);
				}
				// Handle invalid number input
				catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null,
							"Please enter valid numbers for grades",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel.add(savebtn);

		// DISPLAY BUTTON
		JButton showbtn = new JButton("Display File Content");
		showbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Clear display area
				dis.setText(null);

				try {
					// Read file
					FileReader in = new FileReader(dataFile);
					BufferedReader readFile = new BufferedReader(in);

					String line;
					StringBuilder output = new StringBuilder();

					// Read each line and append
					while ((line = readFile.readLine()) != null) {
						output.append(line).append("\n");
					}

					// Close readers
					readFile.close();
					in.close();

					// Display file content
					dis.setText(output.toString());
				}
				// File not found error
				catch (FileNotFoundException err) {
					JOptionPane.showMessageDialog(null,
							"File could not be found!\n" + err.getMessage(),
							"File Error", JOptionPane.ERROR_MESSAGE);
				}
				// General read error
				catch (IOException err) {
					JOptionPane.showMessageDialog(null,
							"Error reading file:\n" + err.getMessage(),
							"File Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel.add(showbtn);

		// CLEAR FILE BUTTON
		JButton clearbtn = new JButton("Clear File");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Clears file contents by opening FileOutputStream
				try {
					FileOutputStream fos = new FileOutputStream(dataFile);

					JOptionPane.showMessageDialog(null,
							"Data cleared from file " + FILE_NAME,
							"Message", JOptionPane.INFORMATION_MESSAGE);

					dis.setText("Data has been cleared from file " + FILE_NAME);

				} catch (FileNotFoundException e1) {
					e1.printStackTrace(); // print error if file not found
				}
			}
		});

		panel.add(clearbtn);
	}
}