package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Clients.StudentClient;
import Services.ReadFromFile;

		
public class UpdateStudentFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Update Student Frame");
	
	 JLabel userLbl = new JLabel("fullname");
	 JTextField userTxt = new JTextField();
	 
	 
	 JLabel passLbl = new JLabel("grupa");
	 JTextField passTxt = new JTextField();
	 
	 JLabel hobbyLbl = new JLabel("hobby");
	 JTextField hobbyTxt = new JTextField();
	 
	 JLabel passwLbl = new JLabel("password");
	 JTextField passwTxt = new JTextField();
	 
	 JButton register = new JButton("Update");
	 
	public UpdateStudentFrame()
	{
		
		frame.setSize(300, 350);
		frame.getRootPane().setDefaultButton(register);
		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
		
		panel.add(userLbl);
		panel.add(userTxt);
		panel.add(passLbl);
		panel.add(passTxt);
		panel.add(register);
		
		panel.add(hobbyLbl);
		panel.add(hobbyTxt);
		panel.add(passwLbl);
		panel.add(passwTxt);

		
		userLbl.setBounds(10, 50, 80, 25);
		userTxt.setBounds(70, 50, 160, 25);
		passLbl.setBounds(10, 90, 80, 25);
		passTxt.setBounds(70, 90, 160, 25);
		register.setBounds(90,220,80,25);
		
		hobbyLbl.setBounds(10, 130, 80, 25);
		passwLbl.setBounds(10, 170, 80, 25);

		
		
		hobbyTxt.setBounds(70, 130, 160, 25);
		passwTxt.setBounds(70, 170, 160, 25);
		
		register.addActionListener(this);

//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == register) 
		{
			StudentClient c1 = new StudentClient();
			
			ReadFromFile a1 = new ReadFromFile();
			String pe = a1.readFrom("idUpdate.txt");
			System.out.println("-->"+pe+"<--");
			
			try {
				c1.putStudent(pe, userTxt.getText(), Long.parseLong(passTxt.getText()), hobbyTxt.getText(), passwTxt.getText());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Invalid numeric format!", "Error", JOptionPane.ERROR_MESSAGE);			}
			
			StudLoginFrame stud1 = new StudLoginFrame();
			
		}
	

	}
	}