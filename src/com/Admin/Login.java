package com.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.account.PaymentProcess;
import com.connection.sqlqueries;
import com.doctor.DoctorWindow;
import com.pharmacist.PharmacyDash;
import com.records.Records;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Login {

	private JPanel contentPane;
	static JTextField staffID;
	private JPasswordField password;
	static JComboBox comboBox;

	String[] accessLevel = { "Admin", "Doctor", "Pharmacist", "Account", "Lab Scientist", "ICT", "Records" };

	/**
	 * Launch the application.
	 */
	static JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login open = new Login();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Login() {

		frame = new JFrame();
		frame.setBounds(250, 100, 900, 550);
		frame.setVisible(true);
		frame.setTitle("i Hospital Management System - Login");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		contentPane = new JPanel();
		frame.getContentPane().add(contentPane);
		// contentPane.setBounds(250, 100, 900, 550);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 11, 884, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("i-HOSPITAL MANAGEMENT  SYSTEM");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 20));
		lblNewLabel.setBounds(279, 15, 356, 27);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(0, 479, 884, 21);
		contentPane.add(panel_1);

		JLabel lblNewLabel_1 = new JLabel(
				"Electronic Medical Record: Design by Dennis Shaba - Twitter:realdinix | Github:dvix");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Adobe Garamond Pro", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(173, 0, 538, 27);
		panel_1.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 139));
		panel_2.setBounds(255, 89, 386, 306);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel innerPanel = new JPanel();
		innerPanel.setBounds(10, 15, 366, 278);
		panel_2.add(innerPanel);
		innerPanel.setLayout(null);

		staffID = new JTextField();
		staffID.setBounds(131, 41, 186, 37);
		innerPanel.add(staffID);
		staffID.setColumns(10);

		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(130, 94, 186, 37);
		innerPanel.add(password);

		JLabel staff_id = new JLabel("Staff ID");
		staff_id.setFont(new Font("SansSerif", Font.PLAIN, 18));
		staff_id.setBounds(42, 51, 68, 16);
		innerPanel.add(staff_id);

		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("SansSerif", Font.PLAIN, 18));
		pass.setBounds(41, 104, 92, 16);
		innerPanel.add(pass);

		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accessDefined();
			}
		});
		login.setFont(new Font("SansSerif", Font.PLAIN, 20));
		login.setBounds(172, 193, 95, 38);
		innerPanel.add(login);

		JCheckBox saveStaffID = new JCheckBox("Save Staff ID Information ");
		saveStaffID.setBounds(51, 243, 186, 18);
		innerPanel.add(saveStaffID);

		JLabel access = new JLabel("Access Level");
		access.setFont(new Font("SansSerif", Font.PLAIN, 15));
		access.setBounds(41, 161, 92, 16);
		innerPanel.add(access);

		comboBox = new JComboBox(accessLevel);
		comboBox.setBounds(130, 155, 186, 26);
		innerPanel.add(comboBox);

	}
	// this is position here cos I want to access it globally

	public void myLogin() {
		sqlqueries login = new sqlqueries();
		String check;
		String ustaffID = staffID.getText();
		String upassword = password.getText();
		check = login.Login(ustaffID, upassword);

		if (ustaffID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "email cannot be null");
		} else if (upassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "password cannot be null");
		} else if (check.equals("valid")) {
			JOptionPane.showMessageDialog(null, "Login Successful");

			Dashboard open = new Dashboard();
			open.setVisible(true);

			frame.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Invalid Details");
		}
	}

	public void accessDefined() {
		// checking and giving access to different level
		String $check = (String) comboBox.getSelectedItem();

		if ($check.equals("Admin")) {
			myLogin();
		} else if ($check.equals("Doctor")) {
			docValidation();
		} else if ($check.equals("Pharmacist")) {
			pharmValidation();

		} else if ($check.equals("Account")) {
			accValidation();

		} else if ($check.equals("Lab Scientist")) {

		} else if ($check.equals("ICT")) {

		} else if ($check.equals("Records")) {
			recValidation();
		} else {
			JOptionPane.showMessageDialog(null, "You do not have access to that level...");
		}
	}

	public void docValidation() {
		sqlqueries login = new sqlqueries();
		String check;
		String ustaffID = staffID.getText();
		String upassword = password.getText();
		check = login.Login(ustaffID, upassword);

		if (ustaffID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "email cannot be null");
		} else if (upassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "password cannot be null");
		} else if (check.equals("valid")) {

			JOptionPane.showMessageDialog(null, "Login Successful");
			DoctorWindow doc = new DoctorWindow();
			doc.frame.setVisible(true);
			frame.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Invalid Details");
		}
	}

	public void recValidation() {
		ResultSet rs = null;
		String $check = (String) comboBox.getSelectedItem();

		sqlqueries login = new sqlqueries();
		String check;
		String ustaffID = staffID.getText();
		String upassword = password.getText();
		sqlqueries dept = new sqlqueries();
		rs = dept.checkDept();

		check = login.Login(ustaffID, upassword);
		if (ustaffID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "email cannot be null");
		} else if (upassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "password cannot be null");
		} else if (check.equals("valid")) {
			// String checkDept = (String) comboBox.getSelectedItem();
			try {
				while (rs.next()) {

					String pull = rs.getString("dept");

					String[] alldept = { pull };
					int i;
					for (i = 0; i < alldept.length; i++) {
						if (alldept[i].equals($check)) {
							String sID = rs.getString("StaffID");
							if (ustaffID.equals(sID)) {
								// System.out.println("id: "+sID);
								JOptionPane.showMessageDialog(null, "Login Successful");
								Records rec = new Records();
								rec.frame.setVisible(true);
								frame.dispose();
							}
						} else if (!alldept[i].equals($check)) {
							JOptionPane.showMessageDialog(null, "You dont have access to that level");
							break;

						} else {
							JOptionPane.showMessageDialog(null, "Invalid Details");
						}

					}

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else

		{
			JOptionPane.showMessageDialog(null, "Invalid Details");
		}
	}

	public void accValidation() {
		sqlqueries login = new sqlqueries();
		String check;
		String ustaffID = staffID.getText();
		String upassword = password.getText();
		check = login.Login(ustaffID, upassword);
		if (ustaffID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "email cannot be null");
		} else if (upassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "password cannot be null");
		} else if (check.equals("valid")) {
			JOptionPane.showMessageDialog(null, "Login Successful");

			PaymentProcess rec = new PaymentProcess();
			rec.frame.setVisible(true);

			frame.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Invalid Details");
		}

	}

	public void pharmValidation() {
		sqlqueries login = new sqlqueries();
		String check;
		String ustaffID = staffID.getText();
		String upassword = password.getText();
		check = login.Login(ustaffID, upassword);
		if (ustaffID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "email cannot be null");
		} else if (upassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "password cannot be null");
		} else if (check.equals("valid")) {
			JOptionPane.showMessageDialog(null, "Login Successful");

			PharmacyDash rec = new PharmacyDash();
			rec.frame.setVisible(true);

			frame.dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Invalid Details");
		}

	}
}
