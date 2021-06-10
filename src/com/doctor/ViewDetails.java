package com.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewDetails {

	public JFrame frame;
	static JTextField patientID;
	static JTextField $firstName;
	static JTextField $noChild;
	static JTextField $mStatus;
	static JTextField $age;
	static JTextField $date;
	static JLabel dateTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetails window = new ViewDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewDetails() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 680, 359);
		frame.setDefaultCloseOperation(1);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 664, 320);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		patientID = new JTextField();
		patientID.setBounds(74, 53, 211, 33);
		panel.add(patientID);
		patientID.setColumns(10);
		patientID.setEditable(false);

		
		$firstName = new JTextField();
		$firstName.setColumns(10);
		$firstName.setBounds(371, 53, 211, 33);
		panel.add($firstName);
		$firstName.setEditable(false);
		
		$noChild = new JTextField();
		$noChild.setColumns(10);
		$noChild.setBounds(371, 135, 211, 33);
		$noChild.setEditable(false);
		panel.add($noChild);
		
		$mStatus = new JTextField();
		$mStatus.setColumns(10);
		$mStatus.setBounds(74, 135, 211, 33);
		panel.add($mStatus);
		$mStatus.setEditable(false);
		
		$age = new JTextField();
		$age.setColumns(10);
		$age.setBounds(74, 218, 211, 33);
		$age.setEditable(false);
		panel.add($age);
		
		JLabel patientIDTxt = new JLabel("Patient ID");
		patientIDTxt.setForeground(Color.WHITE);
		patientIDTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		patientIDTxt.setBounds(92, 23, 92, 23);
		panel.add(patientIDTxt);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setForeground(Color.WHITE);
		firstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		firstName.setBounds(399, 23, 126, 23);
		panel.add(firstName);
		
		JLabel RecommendedDrugs = new JLabel("Marital Status");
		RecommendedDrugs.setForeground(Color.WHITE);
		RecommendedDrugs.setFont(new Font("Tahoma", Font.BOLD, 16));
		RecommendedDrugs.setBounds(92, 111, 126, 23);
		panel.add(RecommendedDrugs);
		
		JLabel ageTxt = new JLabel("Age");
		ageTxt.setForeground(Color.WHITE);
		ageTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		ageTxt.setBounds(92, 195, 50, 23);
		panel.add(ageTxt);
		
		JLabel RecommendedDrugs_2 = new JLabel("No of Children");
		RecommendedDrugs_2.setForeground(Color.WHITE);
		RecommendedDrugs_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		RecommendedDrugs_2.setBounds(399, 111, 126, 23);
		panel.add(RecommendedDrugs_2);
		
		$date = new JTextField();
		$date.setColumns(10);
		$date.setBounds(371, 218, 211, 33);
		$date.setEditable(false);
		panel.add($date);
		
		dateTxt = new JLabel("Date");
		dateTxt.setForeground(Color.WHITE);
		dateTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		dateTxt.setBounds(389, 195, 58, 23);
		panel.add(dateTxt);
		
		//viewPatient();
	}
	
	public void viewPatient() {
//		DoctorWindow view = new DoctorWindow();
//		int viewData = view.table.getSelectedRow();
		
//		if(viewData>=0) {
//			
//			System.out.println(viewData);
//		
//			Object pID = view.table.getValueAt(viewData, 0);
//			patientID.setText(pID+"hello");
			
			
//			$firstName;
//			$noChild;
//			$mStatus;
//			$age;
//			$date;
			
						
		
		
		
		
	}

}
