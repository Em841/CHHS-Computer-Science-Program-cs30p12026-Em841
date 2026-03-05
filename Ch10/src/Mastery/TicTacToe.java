
/*
 * Program:TicTacToe
 * Purpose:Two players click to place "X" and "O", the game checks for a winner or tie. The purpose is to let two people play TicTacToe on a computer.
 * Author: Eman Abid
 * School:CHHS
 * Course: computing programming 30
  */

package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {
	static int r;
	static String[] board = new String[9];
    static String turn;

    // CheckWinner method will decide the winner
    public static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            // For X winner
            if (line.equals("XXX")) {
                return "The winner is X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "The winner is O";
                }
        }
        if (r == 9) { 
        	return "Tie";}
        return null;
    }
        
	private JFrame frame;
	public static void checkwinner() {
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
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
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 459, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel msg = new JLabel("The winner is ");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		msg.setBounds(24, 249, 148, 14);
		panel.add(msg);
		
		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 1) {
				b1.setText("X");
				board[0] = "X";
				}
				else if (r % 2 == 0) {
					b1.setText("O");
					board[0] = "O";
				}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
			}
		});
		b1.setBounds(10, 11, 136, 62);
		panel.add(b1);
		
		JButton b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 01) {
				b2.setText("X");
				board[1] = "X";
				}
				else if (r % 2 == 0) {
					b2.setText("O");
					board[1] = "O";
				}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
			}
		});
		b2.setBounds(156, 11, 136, 62);
		panel.add(b2);
		
		JButton b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 01) {
				b3.setText("X");
				board[2] = "X";
				}
				else if (r % 2 == 0) {
					b3.setText("O");
					board[2] = "O";
			}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
		}});
		b3.setBounds(302, 11, 136, 62);
		panel.add(b3);
		
		JButton b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 01) {
				b6.setText("X");
				board[5] = "X";
				}
				else if (r % 2 == 0) {
					b6.setText("O");
					board[5] = "O";
			}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
		}});
		b6.setBounds(302, 84, 136, 62);
		panel.add(b6);
		
		JButton b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 01) {
				b5.setText("X");
				board[4] = "X";
				}
				else if (r % 2 == 0) {
					b5.setText("O");
					board[4] = "O";
			}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
		}});
		b5.setBounds(156, 84, 136, 62);
		panel.add(b5);
		
		JButton b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			r += 1;
			if (r % 2 == 1) {
			b4.setText("X");
			board[3] = "X";
			}
			else if (r % 2 == 0) {
				b4.setText("O");
				board[3] = "O";
			}
			String winner = checkWinner();
			if (winner == null) {
				return;
			}
			msg.setText(winner);
		}});
		b4.setBounds(10, 84, 136, 62);
		panel.add(b4);
		
		JButton b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 01) {
				b7.setText("X");
				board[6] = "X";
				}
				else if (r % 2 == 0) {
					b7.setText("O");
					board[6] = "O";
			}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
		}});
		b7.setBounds(10, 157, 136, 62);
		panel.add(b7);
		
		JButton b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 01) {
				b8.setText("X");
				board[7] = "X";
				}
				else if (r % 2 == 0) {
					b8.setText("O");
					board[7] = "O";
			}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
		}});
		b8.setBounds(156, 157, 136, 62);
		panel.add(b8);
		
		JButton b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r += 1;
				if (r % 2 == 1) {
				b9.setText("X");
				board[8] = "X";
				}
				else if (r % 2 == 0) {
					b9.setText("O");
					board[8] = "O";
			}
				String winner = checkWinner();
				if (winner == null) {
					return;
				}
				msg.setText(winner);
		}});
		b9.setBounds(302, 157, 136, 62);
		panel.add(b9);
		
		
	}
}