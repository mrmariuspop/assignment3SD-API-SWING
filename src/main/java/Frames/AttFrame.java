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

import Clients.AttendenceClient;
import Clients.LaboratoryClient;

		
public class AttFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Attendance Frame");
	
	 JLabel createLbl = new JLabel("Create Attendance");
	 
	 JLabel labsLbl = new JLabel("Available Attendances");
	 
	 JLabel curriculaLbl = new JLabel("LabId");
	 JTextField deadTxt = new JTextField();
	 
	
	 
	 
	 JButton createAttBtn = new JButton("Create");
	 
	 
	 JLabel delLbl = new JLabel("Delete Attendence");
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

	 
	public AttFrame()
	{
		

		
		frame.setSize(1000, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
//		
		
		panel.add(curriculaLbl);
		panel.add(deadTxt);
		panel.add(createAttBtn);
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
		createAttBtn.setBounds(90, 100, 80, 25);
		
		deadTxt.setBounds(70, 50, 160, 25);
		
		curriculaLbl.setBounds(10, 50, 80, 25);
		
		labsList.setBounds(350, 50, 160, 25);
		
		delLbl.setBounds(680,20,160,25);
		delTxt.setBounds(660,50,160,25);
		delBtn.setBounds(700,100,80,25);

		delBtn.addActionListener(this);
		createAttBtn.addActionListener(this);
		//JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createAttBtn) {
			LaboratoryClient l1 = new LaboratoryClient();
			
			
			if (deadTxt.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Field can not be left empty!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				AttendenceClient c1 = new AttendenceClient();
				try {
					try {
						l1.getLabById(deadTxt.getText());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Laboratory not found!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					c1.postAttendence(deadTxt.getText());
					JOptionPane.showMessageDialog(null, "Attendence succesfuly created!", "Info", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		if (e.getSource() == delBtn) {
			AttendenceClient c1 = new AttendenceClient();
			
			try {
				c1.getAttendencetById(delTxt.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Attendence not found!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(delTxt.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Field can not be left empty!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				c1.deleteAttendenceById(delTxt.getText());;
				JOptionPane.showMessageDialog(null, "Attendence succesfuly deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
	}
}