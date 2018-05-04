package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Clients.AssigClient;

		
public class AssignmentFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Assignment Frame");
	
	 JLabel createLbl = new JLabel("Create Assignment");
	 
	 JLabel labsLbl = new JLabel("Available Assignments");
	 
	 JLabel curriculaLbl = new JLabel("Deadline");
	 JTextField deadTxt = new JTextField();
	 
	 JLabel dateLbl = new JLabel("Descr.");
	 JTextField descTxt = new JTextField();
	 
	 JLabel descriptionLbl = new JLabel("LabId.");
	 JTextField labTxt = new JTextField();
	 
	 JLabel numberLbl = new JLabel("Name");
	 JTextField nameTxt = new JTextField();
	 
	 
	 JButton createAssBtn = new JButton("Create");
	 
	 
	 JLabel delLbl = new JLabel("Delete Assignment");
	 JTextField delTxt = new JTextField();
	 JButton delBtn = new JButton("Delete");
	 
//	 JComboBox labsList = new JComboBox();
//
//	 {
//		 try {
//			    Long[] titleCmb = new Long[10];
//			    int i = 0;
//			    
//			    LaboratoryClient c1 = new LaboratoryClient();
//				List<Laboratory> lista = c1.getAllLaboratories();
//				for (Laboratory iterator : lista) {
//					Long da = iterator.getLaboratoryUid();
//					
//					titleCmb[i] = da;
//					i++;
//
//				}
//				
//				labsList = new JComboBox(titleCmb);
//
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		 }
	 JComboBox labsList = new JComboBox();

	 
	public AssignmentFrame()
	{
		

		
		frame.setSize(1000, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
//		
		panel.add(dateLbl);
		panel.add(descTxt);
		panel.add(descriptionLbl);
		panel.add(labTxt);
		panel.add(numberLbl);
		panel.add(nameTxt);
		
		panel.add(curriculaLbl);
		panel.add(deadTxt);
		panel.add(createAssBtn);
		panel.add(createLbl);
		panel.add(labsLbl);
		panel.add(labsList);
		
		panel.add(delLbl);
		panel.add(delTxt);
		panel.add(delBtn);

		
		labsLbl.setBounds(350,20,160,25);;
		createLbl.setBounds(80,20,160,25);;
		curriculaLbl.setBounds(10, 50, 80, 25);
		deadTxt.setBounds(70, 50, 160, 25);
		createAssBtn.setBounds(90, 220, 80, 25);
		
		deadTxt.setBounds(70, 50, 160, 25);
		descTxt.setBounds(70, 80, 160, 25);
		labTxt.setBounds(70, 110, 160, 25);
		nameTxt.setBounds(70, 140, 160, 25);
		
		curriculaLbl.setBounds(10, 50, 80, 25);
		dateLbl.setBounds(10, 80, 80, 25);
		descriptionLbl.setBounds(10, 110, 80, 25);
		numberLbl.setBounds(10, 140, 80, 25);
		
		labsList.setBounds(350, 50, 160, 25);
		
		delLbl.setBounds(680,20,160,25);
		delTxt.setBounds(660,50,160,25);
		delBtn.setBounds(700,100,80,25);

		delBtn.addActionListener(this);
		createAssBtn.addActionListener(this);
		//JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createAssBtn) {
			
			
			if (deadTxt.getText().trim().isEmpty() || descTxt.getText().trim().isEmpty() || labTxt.getText().trim().isEmpty() || nameTxt.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "No field can be left empty", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				AssigClient c1 = new AssigClient();
				c1.postAssig(deadTxt.getText(),	descTxt.getText(), Long.parseLong(labTxt.getText()), nameTxt.getText());
				JOptionPane.showMessageDialog(null, "Assignment succesfuly created", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			

		}
			
		if (e.getSource() == delBtn) {
			AssigClient c1 = new AssigClient();
			try {
				c1.getAssignmentById(delTxt.getText());
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Assignment not found!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (delTxt.getText().trim().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "Field can not be left empty", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				try {
					c1.deleteAssById(delTxt.getText());
					JOptionPane.showMessageDialog(null, "Assignment succesfuly deleted", "Info", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
	}
}