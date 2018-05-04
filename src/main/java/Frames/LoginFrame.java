package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clients.StudentClient;

		
public class LoginFrame extends JFrame implements ActionListener {

	 JButton proffBtn = new JButton("Prof");
	 JButton studBtn = new JButton("Student");
	 JFrame frame = new JFrame("Login Frame");
	
	 
	 
	public LoginFrame()
	{
		

		
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
		
		proffBtn.setBounds(120, 50, 80, 25);
		panel.add(proffBtn);
		
		studBtn.setBounds(10, 50, 80, 25);
		panel.add(studBtn);
		
		proffBtn.addActionListener(this);
		studBtn.addActionListener(this);
//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == proffBtn) {
			ProfLoginFrame p1 = new ProfLoginFrame();
		}
		if (e.getSource() == studBtn) {
			StudLoginFrame s1 = new StudLoginFrame();
		}
	}
	

	}