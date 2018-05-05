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

import Clients.AdminClient;
import Clients.StudentClient;

		
public class ExerciseFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Student Login Frame");
	
	 JLabel userLbl = new JLabel("email");
	 JTextField userTxt = new JTextField();
	 JLabel passLbl = new JLabel("password");
	 JPasswordField passTxt = new JPasswordField();
	 
	 JButton login = new JButton("Login");
	 JButton register = new JButton("Register");
	 
	public ExerciseFrame()
	{
		
		frame.setSize(300, 350);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
		
		panel.add(userLbl);
		panel.add(userTxt);
		panel.add(passLbl);
		panel.add(passTxt);
		panel.add(login);
		panel.add(register);
		
		userLbl.setBounds(10, 50, 80, 25);
		userTxt.setBounds(70, 50, 160, 25);
		passLbl.setBounds(10, 90, 80, 25);
		passTxt.setBounds(70, 90, 160, 25);
		login.setBounds(90, 150, 80, 25);
		register.setBounds(90,180,80,25);
		
		
		login.addActionListener(this);
		register.addActionListener(this);

//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			boolean succesfulForAdmin = false;
			boolean succesfulForStudent = false;
			AdminClient a1 = new AdminClient();
			StudentClient c1 = new StudentClient();
			
			try {
				a1.login(userTxt.getText(), passTxt.getText());
				succesfulForAdmin = true;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				succesfulForAdmin = false;
			}
			
			try {
				c1.getStudentByEmailAndPassword(userTxt.getText(), passTxt.getText());
				succesfulForStudent = true;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				succesfulForStudent = false;
			
			}
			
			if (succesfulForStudent && !succesfulForAdmin) 
			{
				StudMainFrame f1 = new StudMainFrame();
			}
			else 
			{
				if(!succesfulForStudent && succesfulForAdmin) 
				{
					ProfMainFrame f1 = new ProfMainFrame();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid username/password!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			
			
			
		}		
		if(e.getSource() == register) 
		{
			StudRegisterFrame g1 = new StudRegisterFrame();
		}
	}
	

	}