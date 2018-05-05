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
import models.Laboratory;

		
public class LabsFrame extends JFrame implements ActionListener {

	 JFrame frame = new JFrame("Laboratories Frame");
	
	 JLabel createLbl = new JLabel("Create Laboratory");
	 
	 JLabel labsLbl = new JLabel("Available Labs");
	 
	 JLabel curriculaLbl = new JLabel("Curricula");
	 JTextField curriculaTxt = new JTextField();
	 
	 JLabel dateLbl = new JLabel("Date");
	 JTextField dateTxt = new JTextField();
	 
	 JLabel descriptionLbl = new JLabel("Descr.");
	 JTextField descriptionTxt = new JTextField();
	 
	 JLabel numberLbl = new JLabel("Number");
	 JTextField numberTxt = new JTextField();
	 
	 JLabel titleLbl = new JLabel("Title");
	 JTextField titleTxt = new JTextField();
	 
	 JButton createLabBtn = new JButton("Create");
	 
	 
	 JLabel delLbl = new JLabel("Delete Laboratory");
	 JTextField delTxt = new JTextField();
	 JButton delBtn = new JButton("Delete");
	 
	 JComboBox labsList = new JComboBox();

	 {
		 try {
			    Long[] titleCmb = new Long[10];
			    int i = 0;
			    
			    LaboratoryClient c1 = new LaboratoryClient();
				List<Laboratory> lista = c1.getAllLaboratories();
				for (Laboratory iterator : lista) {
					Long da = iterator.getLaboratoryUid();
					
					titleCmb[i] = da;
					i++;

				}
				
				labsList = new JComboBox(titleCmb);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }
//	 JComboBox labsList = new JComboBox();

	 
	public LabsFrame()
	{
		

		
		frame.setSize(1000, 600);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setLayout(null);
//		
		panel.add(dateLbl);
		panel.add(dateTxt);
		panel.add(descriptionLbl);
		panel.add(descriptionTxt);
		panel.add(numberLbl);
		panel.add(numberTxt);
		panel.add(titleLbl);
		panel.add(titleTxt);
		
		panel.add(curriculaLbl);
		panel.add(curriculaTxt);
		panel.add(createLabBtn);
		panel.add(createLbl);
		panel.add(labsLbl);
		panel.add(labsList);
		
		panel.add(delLbl);
		panel.add(delTxt);
		panel.add(delBtn);

		
		labsLbl.setBounds(370,20,160,25);;
		createLbl.setBounds(80,20,160,25);;
		curriculaLbl.setBounds(10, 50, 80, 25);
		curriculaTxt.setBounds(70, 50, 160, 25);
		createLabBtn.setBounds(90, 220, 80, 25);
		
		curriculaTxt.setBounds(70, 50, 160, 25);
		dateTxt.setBounds(70, 80, 160, 25);
		descriptionTxt.setBounds(70, 110, 160, 25);
		numberTxt.setBounds(70, 140, 160, 25);
		titleTxt.setBounds(70, 170, 160, 25);
		
		curriculaLbl.setBounds(10, 50, 80, 25);
		dateLbl.setBounds(10, 80, 80, 25);
		descriptionLbl.setBounds(10, 110, 80, 25);
		numberLbl.setBounds(10, 140, 80, 25);
		titleLbl.setBounds(10, 170, 80, 25);
		
		labsList.setBounds(350, 50, 160, 25);
		
		delLbl.setBounds(680,20,160,25);
		delTxt.setBounds(660,50,160,25);
		delBtn.setBounds(700,100,80,25);

		delBtn.addActionListener(this);
		createLabBtn.addActionListener(this);
		//JOptionPane.showMessageDialog(null, "Welcome to the Nation Teather fom Cluj-Napoca!", "Info", JOptionPane.INFORMATION_MESSAGE);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delBtn) {
			
			if (delTxt.getText().trim().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "No field can be left empty!", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			else
			{
				LaboratoryClient c1 = new LaboratoryClient();
				
				try {
					c1.getLabById(delTxt.getText());
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Laboratory does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					c1.deleteLaboratoryById(delTxt.getText());
					JOptionPane.showMessageDialog(null, "Laboratory succesfuly deleted!", "Info", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
		if (e.getSource() == createLabBtn) {
			LaboratoryClient c1 = new LaboratoryClient();
			
			if (curriculaTxt.getText().trim().isEmpty() || dateTxt.getText().trim().isEmpty() || descriptionTxt.getText().trim().isEmpty() || titleTxt.getText().trim().isEmpty() ) 
			{
				JOptionPane.showMessageDialog(null, "No field can be left empty!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else 
			{
				try {
					c1.postLab(curriculaTxt.getText(), dateTxt.getText(), descriptionTxt.getText(), Long.parseLong(numberTxt.getText()), titleTxt.getText());
					JOptionPane.showMessageDialog(null, "Laboratory succesfuly created!", "Info", JOptionPane.INFORMATION_MESSAGE);

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Invalid format!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
			

	}
}