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

		
public class GETStudentByIdFrame extends JFrame implements ActionListener {

	 JLabel idLbl = new JLabel("id");
	 JTextField idTxt = new JTextField(20);
	 JButton findBtn = new JButton("Find");
	 JFrame frame = new JFrame("Get Student By Id Frame");
	
	 
	 
	public GETStudentByIdFrame()
	{
		

		
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);

		
		idLbl.setBounds(10, 10, 80, 25);
		panel.add(idLbl);

		
		idTxt.setBounds(100, 10, 160, 25);
		panel.add(idTxt);

		
		findBtn.setBounds(100, 80, 80, 25);
		panel.add(findBtn);
		
		
		
		findBtn.addActionListener(this);
//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findBtn) {
			StudentClient client1 = new StudentClient();
			client1.getStudentById(idTxt.getText());
//			client1.postStudentAsProff("mrovidiupop@gmail.com");
		}
	}
	

	}