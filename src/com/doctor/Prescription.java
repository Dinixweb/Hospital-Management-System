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

public class Prescription {

	public JFrame frame;
	private JTextField patientID;
	private JTextField drug;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prescription window = new Prescription();
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
	public Prescription() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 521, 261);
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
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 505, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(67, 16, 86, 24);
		panel.add(lblNewLabel);
		
		patientID = new JTextField();
		patientID.setBounds(33, 51, 158, 35);
		panel.add(patientID);
		patientID.setColumns(10);
		
		drug = new JTextField();
		drug.setColumns(10);
		drug.setBounds(291, 51, 175, 35);
		panel.add(drug);
		
		JLabel lblDrug = new JLabel("Drug");
		lblDrug.setForeground(Color.WHITE);
		lblDrug.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDrug.setBounds(356, 16, 48, 24);
		panel.add(lblDrug);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setForeground(Color.WHITE);
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblComment.setBounds(67, 97, 86, 24);
		panel.add(lblComment);
		
		JTextArea comment = new JTextArea();
		comment.setBounds(33, 132, 433, 66);
		panel.add(comment);
	}

}
