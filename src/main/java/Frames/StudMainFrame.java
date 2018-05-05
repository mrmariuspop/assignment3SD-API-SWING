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

import Clients.LaboratoryClient;
import Clients.StudentClient;
import Clients.SubmissionClient;
import Services.ReadFromFile;
import models.Laboratory;
import models.Submission;

		
public class StudMainFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Student Main Frame");
	
	 JLabel createLbl = new JLabel("Create Submission");
	 JLabel assIdLbl = new JLabel("assigId.");
	 JTextField assIdTxt = new JTextField();
	 
	 JLabel linkLbl = new JLabel("link");
	 JTextField linkTxt = new JTextField("www.github.com/mrmariuspop");
	 
	 JLabel remarkLbl = new JLabel("remark");
	 JTextField remarkTxt = new JTextField("Submission Sent");
	 
	 JButton createSubmissionBtn = new JButton("Create");

	 
//	 JComboBox studentsIds = new JComboBox();
//	 
//	 {
//	 try {
//		    Long[] idsArray = new Long[10];
//		    int i = 0;
//		    
//		    StudentClient x = new StudentClient();
//			List<Student> lista = x.getAllStudents();
//			
//			for (Student iterator : lista) {
//				Long da = iterator.getStudentId();
//				
//				idsArray[i] = da;
//				i++;
//
//			}
//			
//			studentsIds = new JComboBox(idsArray);
//
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	 }
	 JComboBox labs = new JComboBox();
//	 
	 {
	 try {
		    Long[] idsArray = new Long[10];
		    int i = 0;
		    
		    StudentClient x = new StudentClient();
			List<Laboratory> lista = x.getAllLaboratories();
			
			for (Laboratory iterator : lista) {
				Long da = iterator.getLaboratoryUid();
				
				idsArray[i] = da;
				i++;

			}
			
			labs = new JComboBox(idsArray);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
//	 JComboBox labs = new JComboBox();
	 
	 
	 JLabel deleteLbl = new JLabel("Available Laboratories");
	 
	 
	 JLabel getLabLbl = new JLabel("Get Laboratory by Id");
	 JLabel labIdTxt = new JLabel("labId");
	 JTextField getIdTxt = new JTextField();
	 
	 JButton getLabBtn = new JButton("Get");
	 
	 
	 
	 JLabel dateLbl = new JLabel("date");
	 JTextField dateTxt = new JTextField();
	 
	public StudMainFrame()
	{
		
		frame.setSize(1200, 600);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
		
		panel.add(dateLbl);
		panel.add(dateTxt);
		panel.add(assIdLbl);
		panel.add(assIdTxt);
		panel.add(createSubmissionBtn);
		panel.add(createLbl);
		panel.add(labs);
		
		
		panel.add(deleteLbl);
		
		panel.add(getLabLbl);
		panel.add(labIdTxt);
		panel.add(getIdTxt);
		panel.add(getLabBtn);
		
		panel.add(remarkLbl);
		panel.add(remarkTxt);
		panel.add(linkLbl);
		panel.add(linkTxt);
		
		

		
		createLbl.setBounds(80,20,160,25);;
		assIdLbl.setBounds(10, 50, 80, 25);
		assIdTxt.setBounds(70, 50, 160, 25);
		createSubmissionBtn.setBounds(90, 230, 80, 25);
		
		dateLbl.setBounds(10,90,80,25);
		linkLbl.setBounds(10,130,80,25);
		remarkLbl.setBounds(10,170,80,25);
		dateTxt.setBounds(70,90,160,25);
		linkTxt.setBounds(70,130,160,25);
		remarkTxt.setBounds(70,170,160,25);
		
		deleteLbl.setBounds(80+300,20,160,25);;
		labs.setBounds(70+300, 80, 160, 25);
		
		getLabLbl.setBounds(80,20+300,160,25);;
		labIdTxt.setBounds(10, 50+300, 80, 25);
		getIdTxt.setBounds(70, 50+300, 160, 25);
		getLabBtn.setBounds(90, 100+300, 80, 25);
		
		
		
		createSubmissionBtn.addActionListener(this);
		getLabBtn.addActionListener(this);


//		JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createSubmissionBtn) {
			
			SubmissionClient sub1 = new SubmissionClient();
			List <Submission> ll1 = sub1.getAllSubmissions();
			
			if (ll1.size() >3) 
			{
				JOptionPane.showMessageDialog(null, "Maximum submission no. reached!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				if(assIdTxt.getText().trim().isEmpty() || dateTxt.getText().trim().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "No field can be left empty!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else 
				{
					try {
						ReadFromFile a1 = new ReadFromFile();
						String pe = a1.readFrom("Login.txt");
						
						SubmissionClient.postSubmission(assIdTxt.getText(), dateTxt.getText(), pe);
						JOptionPane.showMessageDialog(null, "Submission succesfuly created!", "Info", JOptionPane.INFORMATION_MESSAGE);
						
						StudMainFrame p1 = new StudMainFrame();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		
			
			
		}
		
		if (e.getSource() == getLabBtn) {
			
			if (getIdTxt.getText().trim().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "Field can not be left empty!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				Laboratory aux = new Laboratory();
				try {
					aux = LaboratoryClient.getLabById(getIdTxt.getText());
					JOptionPane.showMessageDialog(null, "Laboratory title = " + aux.getTitle() + "\nLaboratory curricula ="+ aux.getCurricula() + "\nLaboratory description ="+ aux.getDescription()+"" , "Info", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Laboratory not found!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			

		}
		
		
	}
	

	}