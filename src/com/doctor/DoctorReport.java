package com.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.connection.sqlqueries;

import javax.swing.JTextArea;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import com.doctor.DoctorWindow;


public class DoctorReport {

	public JFrame frame;
	private JTextField healthStatus;
	private JTextField drugs;
	private JTextField date;
	
	JComboBox comboBox ;
	Object patientCode;
	
	
	JTextArea doctorComment;
	private JTextField patientID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorReport window = new DoctorReport();
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
	public DoctorReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Doctor's Comment");		
		frame.setDefaultCloseOperation(1);
		frame.setBounds(200, 200, 700, 450);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel patientIdTxt = new JLabel("Patient ID");
		patientIdTxt.setForeground(Color.WHITE);
		patientIdTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		patientIdTxt.setBounds(97, 42, 92, 28);
		frame.getContentPane().add(patientIdTxt);
		
		healthStatus = new JTextField();
		healthStatus.setColumns(10);
		healthStatus.setBounds(246, 89, 249, 40);
		frame.getContentPane().add(healthStatus);
		
		JLabel healthTxt = new JLabel("Health Status");
		healthTxt.setForeground(Color.WHITE);
		healthTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		healthTxt.setBounds(97, 93, 118, 28);
		frame.getContentPane().add(healthTxt);
		
		drugs = new JTextField();
		drugs.setColumns(10);
		drugs.setBounds(246, 140, 249, 40);
		frame.getContentPane().add(drugs);
		
		JLabel drugTxt = new JLabel("Drugs");
		drugTxt.setForeground(Color.WHITE);
		drugTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		drugTxt.setBounds(97, 144, 68, 28);
		frame.getContentPane().add(drugTxt);
		
		JLabel docttorTxt = new JLabel("Doctor Comment");
		docttorTxt.setForeground(Color.WHITE);
		docttorTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		docttorTxt.setBounds(97, 193, 139, 28);
		frame.getContentPane().add(docttorTxt);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(246, 272, 249, 40);
		frame.getContentPane().add(date);
		
		JLabel dateTxt = new JLabel("Date");
		dateTxt.setForeground(Color.WHITE);
		dateTxt.setFont(new Font("Tahoma", Font.BOLD, 16));
		dateTxt.setBounds(97, 276, 92, 28);
		frame.getContentPane().add(dateTxt);
		
		doctorComment = new JTextArea();
		doctorComment.setBounds(246, 191, 249, 70);
		frame.getContentPane().add(doctorComment);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addComment();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(304, 332, 123, 43);
		frame.getContentPane().add(btnNewButton);
		
		patientID = new JTextField();
		patientID.setBounds(246, 38, 249, 40);
		frame.getContentPane().add(patientID);
		patientID.setColumns(10);
		
		
	}
	
		
	
	public void addComment() {
		
		String[] comment = new String[5];
		
		//Full Name", "Health Status", "Recommended Drugs", "Doctor's Overall Report", "Date
		
		String $pID =patientID.getText();
		String $healthStatus = healthStatus.getText();
		String $recommendedDrugs = drugs.getText();
		String $doctorComment = doctorComment.getText();
		String $date = date.getText();
		
		
		if($pID.isEmpty() ||$healthStatus.isEmpty() || $recommendedDrugs.isEmpty() 
				|| $doctorComment.isEmpty() || $date.isEmpty()){
			JOptionPane.showMessageDialog(null, "Fill compulsory field");
		}
		else {
			comment[0] = $pID;
			
			comment[1] = $healthStatus;
			comment[2] = $recommendedDrugs;
			comment[3] = $doctorComment;
			comment[4] = $date;
			
		}
		
		ResultSet rs = null;		
		sqlqueries add = new sqlqueries();
		
		rs = add.displayBookedData();
		
		try {
			while(rs.next()) {
				
				String getID = rs.getString("patientID");
				
				String[] myID = {getID};
				
				//System.out.println(myID);
				int i;
				for(i=0; i<myID.length; i++) {
					
					if(myID[i].equals($pID)) {
						add.addDoctorComment(comment);
						break;
						//String col = rs.getString("patientID");
					}
						else {
							//JOptionPane.showMessageDialog(null, "Patient has not been booked");
							//break;
						}
					}
						
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
