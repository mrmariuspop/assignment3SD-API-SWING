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
import models.Student;

		
public class ProfMainFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Prof Main Frame");
	
	 JLabel createLbl = new JLabel("Create Student");
	 JLabel emailLbl = new JLabel("email");
	 JTextField emailTxt = new JTextField();
	 
	 JButton createStudBtn = new JButton("Create");
	 JButton labsBtn = new JButton("Labs");

	 
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
	 
	 JButton gradeBtn = new JButton("Grade");
	 
	public ProfMainFrame()
	{
		
		frame.setSize(1200, 600);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
		
		panel.add(emailLbl);
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
		
		submLbl.setBounds(80+600,20,160,25);;
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
		labsBtn.setBounds(690, 400, 80, 25);
		
		createStudBtn.addActionListener(this);
		deleteStudBtn.addActionListener(this);
		GetStudBtn.addActionListener(this);
		gradeBtn.addActionListener(this);
		labsBtn.addActionListener(this);


//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createStudBtn) {
			StudentClient c1 = new StudentClient();
			
			String aux = emailTxt.getText();
			if (aux.contains("@")) 
			{
			try {
				c1.postStudentAsProff(aux);
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
			StudentClient c1 = new StudentClient();
			Student auxiliar = new Student();
			
			try {
				auxiliar = c1.getStudentById(idTxt.getText());
			} catch (Exception e1) {

				JOptionPane.showMessageDialog(null, "Student not found in the database", "Error", JOptionPane.ERROR_MESSAGE);			
				return;
				}
			
			try {
				c1.deleteStudentById(idTxt.getText());
				JOptionPane.showMessageDialog(null, "Student succesfuly deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == GetStudBtn) 
		{
			StudentClient c1 = new StudentClient();
			try {
				Student retrieved = new Student();
				
				retrieved = c1.getStudentById(getIdTxt.getText());
				JOptionPane.showMessageDialog(null, "Student Id = "+retrieved.getStudentId()+"\n" +"Student Fullname = "+retrieved.getFullname()+"\n" + "Student Email = " + retrieved.getEmail()+ " " , "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == gradeBtn) 
		{
			//wait for implement
			
		}
		if (e.getSource() == labsBtn) 
		{
			LabsFrame l1 = new LabsFrame();
			
		} 
		
	}
	

	}