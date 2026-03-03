package Mastery;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class BreakAPlate {
private JFrame frame;
private JLabel lblPlates, lblPrize; // Labels to display plates and prize
public static void main(String[] args) {
// Launching the application
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
public BreakAPlate() {
initialize();
}
private void initialize() {
frame = new JFrame();
frame.setBounds(100, 100, 450, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel = new JPanel();
panel.setBackground(new Color(188, 180, 220));
frame.getContentPane().add(panel, BorderLayout.CENTER);
panel.setLayout(null);

// Button to start the game
JButton btnNewButton = new JButton("Click to Play");
btnNewButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
btnNewButton.setBounds(130, 201, 182, 35);
panel.add(btnNewButton);

// Label to display plates
lblPlates = new JLabel("");
lblPlates.setIcon(new ImageIcon(BreakAPlate.class.getResource("/Mastery/plates.gif")));
lblPlates.setBounds(82, 11, 279, 102);
panel.add(lblPlates);


lblPrize = new JLabel("");
lblPrize.setBounds(160, 120, 120, 70);
panel.add(lblPrize);

// Button click action
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

// Reset to 3 unbroken plates, clear prize
lblPlates.setIcon(new ImageIcon(BreakAPlate.class.getResource("../Mastery/plates.gif")));
lblPrize.setIcon(null);

// Loading the images
ImageIcon imgAllBroken = new ImageIcon(BreakAPlate.class.getResource("../Mastery/plates_all_broken.gif"));
ImageIcon imgTwoBroken = new ImageIcon(BreakAPlate.class.getResource("../Mastery/plates_two_broken.gif"));
ImageIcon sticker = new ImageIcon(BreakAPlate.class.getResource("../Mastery/sticker.gif"));
ImageIcon tiger = new ImageIcon(BreakAPlate.class.getResource("../Mastery/tiger_plush.gif"));

// Random outcomes
if (Math.random() < 0.5) {
lblPlates.setIcon(imgTwoBroken);
lblPrize.setIcon(sticker);
} else {
lblPlates.setIcon(imgAllBroken);
lblPrize.setIcon(tiger);
}
}
});
}
}
