package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clients.StudentClient;
import Clients.SubmissionClient;
import Services.EmailUtil;
import Services.Encrypt;
import models.Student;

		
public class ProfMainFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Prof Main Frame");
	
	 JLabel createLbl = new JLabel("Create Student");
	 JLabel emailLbl = new JLabel("email");
	 JTextField emailTxt = new JTextField();
	 
	 JButton createStudBtn = new JButton("Create");
	 JButton labsBtn = new JButton("Laboratories");
	 JButton assBtn = new JButton("Assignments");
	 JButton attBtn = new JButton("Attendences");

	 JLabel avaiLbl = new JLabel("Available Students");
	 
	 JComboBox studentsIds = new JComboBox();
	 
	 {
	 try {
		    Long[] idsArray = new Long[10];
		    int i = 0;
		    
		    StudentClient x = new StudentClient();
			List<Student> lista = x.getAllStudents();
			
			for (Student iterator : lista) {
				Long da = iterator.getStudentId();
				
				idsArray[i] = da;
				i++;

			}
			
			studentsIds = new JComboBox(idsArray);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
//	 
//	 JComboBox studentsIds = new JComboBox();

	 
//	 JComboBox subIds = new JComboBox();
//	 
//	 {
//	 try {
//		    Long[] idsArray = new Long[10];
//		    int i = 0;
//		    
//		    SubmissionClient x = new SubmissionClient();
//			List<Submission> lista = x.getAllSubmissions();
//			
//			for (Submission iterator : lista) {
//				Long da = iterator.getSubmissionId();
//				
//				idsArray[i] = da;
//				i++;
//
//			}
//			
//			subIds = new JComboBox(idsArray);
//
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	 }
	 
	 JComboBox subIds = new JComboBox();


	 JLabel deleteLbl = new JLabel("Delete Student");
	 JLabel idLbl = new JLabel("id");
	 JTextField idTxt = new JTextField();
	 
	 JButton deleteStudBtn = new JButton("Delete");
	 
	 JLabel getStudLbl = new JLabel("Get Student by Id");
	 JLabel getIdLbl = new JLabel("id");
	 JTextField getIdTxt = new JTextField();
	 
	 JButton GetStudBtn = new JButton("Get");
	 
	 JLabel submLbl = new JLabel("Grade Submission");
	 JLabel subIdLbl = new JLabel("submissionId");
	 JTextField subIdTxt = new JTextField();
	 
	 JLabel newGradelbl = new JLabel("grade");
	 JTextField newGradeTxt = new JTextField();
	 
	 
	 JLabel allSubLbl = new JLabel("Available Submissions");
	 
	 JButton gradeBtn = new JButton("Grade");
	 
	public ProfMainFrame()
	{
		
		frame.setSize(1200, 600);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
		
		panel.add(emailLbl);
		panel.add(allSubLbl);
		panel.add(emailTxt);
		panel.add(createStudBtn);
		panel.add(createLbl);
		
		panel.add(submLbl);
		panel.add(subIdLbl);
		panel.add(subIdTxt);
		panel.add(newGradelbl);
		panel.add(newGradeTxt);
		panel.add(gradeBtn);
		
		panel.add(deleteLbl);
		panel.add(idLbl);
		panel.add(idTxt);
		panel.add(deleteStudBtn);
		
		panel.add(getStudLbl);
		panel.add(getIdLbl);
		panel.add(getIdTxt);
		panel.add(GetStudBtn);
		
		panel.add(avaiLbl);
		panel.add(studentsIds);
		panel.add(labsBtn);
		panel.add(subIds);
		panel.add(assBtn);
		panel.add(attBtn);
		
		submLbl.setBounds(80+600,20,160,25);;
		allSubLbl.setBounds(80+900,20,160,25);;
		subIds.setBounds(80+900,60,160,25);;
		
		subIdLbl.setBounds(590, 50, 80, 25);
		subIdTxt.setBounds(70+600, 50, 160, 25);
		newGradelbl.setBounds(610, 100, 80, 25);
		newGradeTxt.setBounds(670, 100, 160, 25);
		gradeBtn.setBounds(90+600, 150, 80, 25);

		
		createLbl.setBounds(80,20,160,25);;
		emailLbl.setBounds(10, 50, 80, 25);
		emailTxt.setBounds(70, 50, 160, 25);
		createStudBtn.setBounds(90, 100, 80, 25);
		
		deleteLbl.setBounds(80+300,20,160,25);;
		idLbl.setBounds(10+300, 50, 80, 25);
		idTxt.setBounds(70+300, 50, 160, 25);
		deleteStudBtn.setBounds(90+300, 100, 80, 25);
		
		getStudLbl.setBounds(80,20+300,160,25);;
		getIdLbl.setBounds(10, 50+300, 80, 25);
		getIdTxt.setBounds(70, 50+300, 160, 25);
		GetStudBtn.setBounds(90, 100+300, 80, 25);
		
		
		avaiLbl.setBounds(80+300,320,160,25);
		studentsIds.setBounds(80+300,350,160,25);
		labsBtn.setBounds(690, 350, 120, 25);
		assBtn.setBounds(690, 390, 120, 25);
		attBtn.setBounds(690, 430, 120, 25);

		createStudBtn.addActionListener(this);
		deleteStudBtn.addActionListener(this);
		GetStudBtn.addActionListener(this);
		gradeBtn.addActionListener(this);
		labsBtn.addActionListener(this);
		attBtn.addActionListener(this);
		assBtn.addActionListener(this);

//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createStudBtn) {
			
			String aux = emailTxt.getText();
			if (aux.contains("@")) 
			{
			try {
				StudentClient.postStudentAsProff(aux);
				
				
				Student studentByEmail = StudentClient.getStudentByEmail(emailTxt.getText());
				
				EmailUtil em1 = new EmailUtil();
				Encrypt enc1 = new Encrypt();
				
				String from = "mpop993";
			        String pass = enc1.decrypt("A2ntJa4XkRksx9l5Fmf92A==");
			        String[] to = { aux }; // list of recipient email addresses
			        String subject = "JavaMailAPI";
			        String body = "Your token is : \n\n";
			        
			        em1.sendFromGMail(from, pass, to, subject, body+studentByEmail.getToken());
			        
			        
				JOptionPane.showMessageDialog(null, "Student succesfuly created!", "Info", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);			

			}
		}
		
		if (e.getSource() == deleteStudBtn) {
			Student auxiliar = new Student();
			
			try {
				auxiliar = StudentClient.getStudentById(idTxt.getText());
			} catch (Exception e1) {

				JOptionPane.showMessageDialog(null, "Student not found in the database", "Error", JOptionPane.ERROR_MESSAGE);			
				return;
				}
			
			try {
				StudentClient.deleteStudentById(idTxt.getText());
				JOptionPane.showMessageDialog(null, "Student succesfuly deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == GetStudBtn) 
		{
			try {
				Student retrieved = new Student();
				
				retrieved = StudentClient.getStudentById(getIdTxt.getText());
				JOptionPane.showMessageDialog(null, "Student Id = "+retrieved.getStudentId()+"\n" +"Student Fullname = "+retrieved.getFullname()+"\n" + "Student Email = " + retrieved.getEmail()+ " " , "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == gradeBtn) 
		{
			SubmissionClient c1 = new SubmissionClient();
			
			if (newGradeTxt.getText().trim().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "Grade can not be blank!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				if(Integer.parseInt(newGradeTxt.getText()) > 0 && Integer.parseInt(newGradeTxt.getText()) < 11) 
				{
					try {
						c1.gradeSubmission(subIdTxt.getText(), newGradeTxt.getText());
						JOptionPane.showMessageDialog(null, "Student succesfuly graded!", "Info", JOptionPane.INFORMATION_MESSAGE);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Submission id invalid!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid Grade!", "Error", JOptionPane.ERROR_MESSAGE);
					return;

				}
			}
			
			
			

		}
		if (e.getSource() == labsBtn) 
		{
			LabsFrame l1 = new LabsFrame();
			
		} 
		
		if (e.getSource() == assBtn) 
		{
			AssignmentFrame l1 = new AssignmentFrame();
			
		} 
		if (e.getSource() == attBtn) 
		{
			AttFrame l1 = new AttFrame();
			
		} 
		
	}
	

	}