package com.doctor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextArea;

public class ViewReport {

	public JFrame frame;
	public static JTextField patientID;
	public static JTextField healthStatus;
	public static JTextField drugs;
	public static JTextField date;
	public static JTextArea comment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReport window = new ViewReport();
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
	public ViewReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 299);
		frame.setDefaultCloseOperation(1);
		frame.getContentPane().setLayout(null);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 741, 386);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Id");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(42, 54, 87, 19);
		panel.add(lblNewLabel);
		
		patientID = new JTextField();
		patientID.setBounds(127, 49, 173, 33);
		panel.add(patientID);
		patientID.setColumns(10);
		patientID.setEditable(false);
		
		healthStatus = new JTextField();
		healthStatus.setColumns(10);
		healthStatus.setBounds(461, 49, 173, 33);
		panel.add(healthStatus);
		healthStatus.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Health Status");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(346, 56, 109, 19);
		panel.add(lblNewLabel_1);
		
		drugs = new JTextField();
		drugs.setColumns(10);
		drugs.setBounds(127, 114, 173, 33);
		panel.add(drugs);
		drugs.setEditable(false);
		
		JLabel lblDrugs = new JLabel("Drugs");
		lblDrugs.setForeground(Color.WHITE);
		lblDrugs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDrugs.setBounds(42, 123, 87, 19);
		panel.add(lblDrugs);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setForeground(Color.WHITE);
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComment.setBounds(346, 123, 87, 19);
		panel.add(lblComment);
		
		comment = new JTextArea();
		comment.setBounds(461, 118, 173, 93);
		panel.add(comment);
		comment.setEditable(false);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(42, 175, 87, 19);
		panel.add(lblDate);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(127, 170, 173, 33);
		panel.add(date);
		date.setEditable(false);
	}
}
