package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clients.StudentClient;
import Services.WriteToFile;
import models.Student;

		
public class StudRegisterFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Student Register Frame");
	
	 JLabel userLbl = new JLabel("email");
	 JTextField userTxt = new JTextField();
	 JLabel passLbl = new JLabel("token");
	 JTextField passTxt = new JTextField();
	 
	 JButton register = new JButton("Register");
	 
	public StudRegisterFrame()
	{
		
		frame.setSize(300, 350);

		JPanel panel = new JPanel();
		frame.add(panel);
		frame.getRootPane().setDefaultButton(register);
		frame.setVisible(true);
		panel.setLayout(null);
		
		panel.add(userLbl);
		panel.add(userTxt);
		panel.add(passLbl);
		panel.add(passTxt);
		panel.add(register);
		
		userLbl.setBounds(10, 50, 80, 25);
		userTxt.setBounds(70, 50, 160, 25);
		passLbl.setBounds(10, 90, 80, 25);
		passTxt.setBounds(70, 90, 160, 25);
		register.setBounds(90,180,80,25);
		
		
		register.addActionListener(this);

//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == register) {
			
			StudentClient c1 = new StudentClient();
			try {
				Student aux = new Student();
				aux = c1.getStudentByEmailAndToken(userTxt.getText(), passTxt.getText());
				
				WriteToFile d1 = new WriteToFile();
				d1.whenWriteStringUsingBufferedWritter_thenCorrect(String.valueOf(aux.getStudentId()),"idUpdate.txt");
				
				UpdateStudentFrame a1 = new UpdateStudentFrame();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Invalid email/token!", "Error", JOptionPane.ERROR_MESSAGE);			}
		
	}
	}
	

	}