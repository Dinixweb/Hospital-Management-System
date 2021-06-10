package com.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.connection.sqlqueries;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;

public class Users {

	public JFrame frame;
	public JTable table;
	String[] userList = {"First Name", "Last Name","Department", "StaffID", "Password"};
	DefaultTableModel model = new DefaultTableModel();
	private JTextField staffCode;
	private JTextField firstname;
	private JTextField password;
	private JTextField lastName;
	
	static JComboBox $dept;
	
	String[] userDept= {"Select","Account","Doctor", "ICT","Lab", "Records"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users window = new Users();
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
	public Users() {
		initialize();
		displayAllUsers();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Add New User");
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 175, 752, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 732, 247);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(34, 28, 72, 30);
		frame.getContentPane().add(lblNewLabel);
		
		staffCode = new JTextField();
		staffCode.setBounds(104, 30, 146, 30);
		frame.getContentPane().add(staffCode);
		staffCode.setColumns(10);
		
		firstname = new JTextField();

		firstname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
		});
		firstname.setColumns(10);
		firstname.setBounds(348, 30, 155, 30);
		frame.getContentPane().add(firstname);
		
		
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(104, 80, 146, 30);
		frame.getContentPane().add(password);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(348, 80, 155, 30);
		frame.getContentPane().add(lastName);
		
		JButton btnNewButton = new JButton("GenerateID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateID();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(588, 28, 136, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerUser();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(588, 84, 136, 32);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(34, 80, 72, 30);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblFullName = new JLabel("First Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFullName.setBounds(260, 28, 81, 30);
		frame.getContentPane().add(lblFullName);
		
		JLabel lblDepartment = new JLabel("Last Name");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartment.setBounds(260, 80, 88, 30);
		frame.getContentPane().add(lblDepartment);
		
		JLabel lblDepartment_1 = new JLabel("Dept");
		lblDepartment_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartment_1.setBounds(260, 130, 88, 30);
		frame.getContentPane().add(lblDepartment_1);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetPassword.setBounds(588, 132, 136, 32);
		frame.getContentPane().add(btnResetPassword);
		
		$dept = new JComboBox(userDept);
		$dept.setBounds(348, 130, 155, 28);
		frame.getContentPane().add($dept);
		model.setColumnIdentifiers(userList);
	}
	
	public void displayAllUsers() {
		ResultSet rs = null;
		sqlqueries users = new sqlqueries();
		
		rs = users.displayUsers();
		
		try {
			while(rs.next()) {
				
				String $firstName = rs.getString("firstName"); 
				String $lastName = rs.getString("lastName");
				String $dept = rs.getString("dept");
				String $staffid = rs.getString("StaffID");
				String $password  = rs.getString("Password");
				
				
				String[] $users = {$firstName,$lastName,$dept,$staffid,$password.replace($password, "*********")};
				table.getModel();
				model.addRow($users);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void GenerateID() {
		double num = Math.floor(Math.random() * 1205);
		int output = (int) num;
		staffCode.setText("IHSM" + output);
	}
	
	public void registerUser() {
		
		String uDept = (String)$dept.getSelectedItem();
		
		
		//Pattern pt = Pattern.compile("[A-Za-z]{5,22}");
		//Matcher math = pt.matcher(maritalStatus.getText());
		
		String[] users = new String[5];
		
		if(staffCode.getText().isEmpty()|| firstname.getText().isEmpty() || 
				lastName.getText().isEmpty() || password.getText().isEmpty() || password.getText().length()<=10 ||uDept.isEmpty() ) {
				JOptionPane.showMessageDialog(null, "Complete compulsory fields");
		}
		else {
			users[0] = staffCode.getText();
			users[1] = firstname.getText();
			users[2] = lastName.getText();
			users[3] = password.getText();
			users[4] = uDept;
			
			
			sqlqueries addUsers = new sqlqueries();	
			addUsers.AddUser(users);
			
			String[] post = {users[0],users[1],users[2],users[3],users[4] };
			DefaultTableModel model = new DefaultTableModel();table.getModel();
			model.addRow(post);
			
		}
	}
}
