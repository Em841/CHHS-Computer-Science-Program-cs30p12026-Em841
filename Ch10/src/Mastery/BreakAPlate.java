
/*
 * Program:BreakAplate
 * Purpose:Users choose a conversion type a from a combo box, and the matching formula appears in a label.
 * Author: Eman Abid
 * School:CHHS
 * Course: computing programming 30
  */
 

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BreakAPlate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
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
	public BreakAPlate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		//make the gifs into image icons
		ImageIcon p = new ImageIcon("../Ch10/src/Mastery/plates.gif");
		ImageIcon pb2 = new ImageIcon("../Ch10/src/Mastery/plates_two_broken.gif");
		ImageIcon pb3 = new ImageIcon("../Ch10/src/Mastery/plates_all_broken.gif");
		ImageIcon s = new ImageIcon("../Ch10/src/Mastery/sticker.gif");
		ImageIcon tp = new ImageIcon("../Ch10/src/Mastery/tiger_plush.gif");
		
		//create frame and frame dimensions
		frame = new JFrame();
		frame.setBounds(100, 100, 518, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//creates panel and panel dimensions
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 502, 380);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//creates label and label dimensions
		JLabel plates = new JLabel("");
		plates.setBounds(113, 68, 275, 100);
		panel.add(plates);
		
		//creates label and label dimensions
		JLabel prize = new JLabel("");
		prize.setBounds(190, 280, 117, 100);
		panel.add(prize);
		
		//sets Jlabel plate into the picture plates.gif
		plates.setIcon(p);
		
		//Create Jbutton "play" and sets text to "play"
		JButton play = new JButton("Play");
		
		//adds actionperformed for when jbutton is clicked
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//randomizer for plate game
				int r = (int)(2 * Math.random() + 1);
				
					//loop for play again in game
					if (play.getText().equals("Play again")){
						//reset
						play.setText("Play");
						plates.setIcon(p);
						prize.setIcon(null);
						return;
				
				}
				// if r=1 break 2 plates and user wins sticker
				if(r == 1){
					//sets Jlabel plates icon to plates_two_broken.gif 
						plates.setIcon(pb2);
						//sets Jlabel prize icon to sticker.gif 
						prize.setIcon(s);
						//reset condition
						play.setText("Play again");
						}
				
				// if r=2 break all plates and user wins tiger plush
				if(r == 2){
					//sets Jlabel plates icon to plates_all_broken.gif
						plates.setIcon(pb3);
						//sets Jlabel prize icon to tiger_plush.gif
						prize.setIcon(tp);
						//reset condition
						play.setText("Play again");
					
		}}
			});
		play.setBounds(175, 216, 154, 23);
		panel.add(play);
		
		JLabel lblNewLabel = new JLabel("You won:");
		lblNewLabel.setBounds(230, 250, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Break A Plate");
		lblNewLabel_1.setBounds(207, 11, 132, 14);
		panel.add(lblNewLabel_1);
		
	}
}