package com.records;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;

import com.connection.sqlqueries;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Button;

public class Patientadd {

	public static JFrame frame;

	public static JFrame viewframe;
	static JTextField patientID;
	static JTextField fName;
	static JTextField lName;
	static JTextField numOfChild;
	static JTextField maritalStatus;
	static JTextField dateOfBirth;
	static JTextField emailID;
	static JTextField phoneNumber;
	static JTextField nokEmail;
	static JTextField nokPhone;
	static JTextField nokName;
	static JTextField date;
	static JButton AddNew;

	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];
	
	DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
	
	DateFormat df2 = DateFormat.getTimeInstance(DateFormat.LONG, new Locale("en","de"));
	
	Object rowGet;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patientadd window = new Patientadd();
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
	public Patientadd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 738, 613);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(1);
		frame.setTitle("Add new Patient");
		frame.getContentPane().setLayout(null);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 74, 692, 414);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		patientID = new JTextField();
		patientID.setBounds(66, 43, 165, 27);
		panel.add(patientID);
		patientID.setColumns(10);
		patientID.setEditable(false);

		fName = new JTextField();
		
		
		fName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[A-Za-z]{4,22}");
				Matcher math = pt.matcher(fName.getText());

				if (math.matches()) {
					fName.setForeground(new Color(0, 128, 0));
				} else {
					fName.setForeground(Color.RED);
				}

			}
		});
		fName.setColumns(10);
		fName.setBounds(271, 43, 165, 27);
		panel.add(fName);

		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(465, 43, 165, 27);
		panel.add(lName);
		lName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[A-Za-z]{4,22}");
				Matcher math = pt.matcher(lName.getText());

				if (math.matches()) {
					lName.setForeground(new Color(0, 128, 0));
				} else {
					lName.setForeground(Color.RED);
				}

			}
		});

		numOfChild = new JTextField();
		numOfChild.setColumns(10);
		numOfChild.setBounds(465, 113, 165, 27);
		panel.add(numOfChild);
		numOfChild.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[0-9]{1,22}");
				Matcher math = pt.matcher(numOfChild.getText());

				if (math.matches()) {
					numOfChild.setForeground(new Color(0, 128, 0));
				} else {
					numOfChild.setForeground(Color.RED);
				}

			}
		});

		maritalStatus = new JTextField();
		maritalStatus.setColumns(10);
		maritalStatus.setBounds(271, 113, 165, 27);
		panel.add(maritalStatus);
		maritalStatus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[A-Za-z]{5,22}");
				Matcher math = pt.matcher(maritalStatus.getText());

				if (math.matches()) {
					maritalStatus.setForeground(new Color(0, 128, 0));
				} else {
					maritalStatus.setForeground(Color.RED);
				}

			}
		});

		dateOfBirth = new JTextField();
		dateOfBirth.setColumns(10);
		dateOfBirth.setBounds(66, 113, 159, 27);
		panel.add(dateOfBirth);
		dateOfBirth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[0-9-]{10,11}");
				Matcher math = pt.matcher(dateOfBirth.getText());

				if (math.matches()) {
					dateOfBirth.setForeground(new Color(0, 128, 0));
				} else {
					dateOfBirth.setForeground(Color.RED);
				}

			}
		});

		emailID = new JTextField();
		emailID.setColumns(10);
		emailID.setBounds(271, 186, 165, 27);
		panel.add(emailID);
		emailID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{3}");
				Matcher math = pt.matcher(emailID.getText());

				if (math.matches()) {
					emailID.setForeground(new Color(0, 128, 0));
				} else {
				
					emailID.setForeground(Color.RED);
				}

			}
		});

		phoneNumber = new JTextField();
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(66, 186, 165, 27);
		panel.add(phoneNumber);
		phoneNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("0+[789]{1}[01]{1}[0-9]{8}");
				Matcher math = pt.matcher(phoneNumber.getText());

				if (math.matches()) {
					phoneNumber.setForeground(new Color(0, 128, 0));
				} else {
					phoneNumber.setForeground(Color.RED);
				}

			}
		});

		nokEmail = new JTextField();
		nokEmail.setColumns(10);
		nokEmail.setBounds(465, 261, 165, 27);
		panel.add(nokEmail);
		nokEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{3}");
				Matcher math = pt.matcher(nokEmail.getText());

				if (math.matches()) {
					nokEmail.setForeground(new Color(0, 128, 0));
				} else {
					nokEmail.setForeground(Color.RED);
				}

			}
		});

		nokPhone = new JTextField();
		nokPhone.setColumns(10);
		nokPhone.setBounds(271, 261, 165, 27);
		panel.add(nokPhone);
		nokPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("0+[789]{1}[01]{1}[0-9]{8}");
				Matcher math = pt.matcher(nokPhone.getText());

				if (math.matches()) {
					nokPhone.setForeground(new Color(0, 128, 0));
					
				} else {
					nokPhone.setForeground(Color.RED);
					
					
				}

			}
		});

		nokName = new JTextField();
		nokName.setColumns(10);
		nokName.setBounds(66, 261, 165, 27);
		panel.add(nokName);
		nokName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[A-Za-z]{4,22}");
				Matcher math = pt.matcher(nokName.getText());

				if (math.matches()) {
					nokName.setForeground(new Color(0, 128, 0));
				} else {
					nokName.setForeground(Color.RED);
					
				}

			}
		});

		date = new JTextField();
		date.setColumns(10);
		String mydate = df.format(new Date());
		date.setText(mydate);
		date.setEditable(false);
		date.setBounds(66, 332, 165, 27);
		panel.add(date);
		date.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Pattern pt = Pattern.compile("[1-9]{1,11}");
				Matcher math = pt.matcher(date.getText());

				if (math.matches()) {
					date.setForeground(new Color(0, 128, 0));
				} else {
					date.setForeground(Color.RED);
					
				}

			}
		});
		
		//Enabling buttons for submission
		

		JLabel patientid = new JLabel("PatientID");
		patientid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		patientid.setBounds(112, 21, 86, 14);
		panel.add(patientid);

		JLabel firstname = new JLabel("First Name");
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstname.setBounds(307, 23, 86, 14);
		panel.add(firstname);

		JLabel lastname = new JLabel("Last Name");
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastname.setBounds(506, 23, 86, 14);
		panel.add(lastname);

		JLabel dob = new JLabel("Date of Birth");
		dob.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dob.setBounds(101, 91, 97, 14);
		panel.add(dob);

		JLabel mStatus = new JLabel("Marital Status");
		mStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mStatus.setBounds(296, 93, 111, 14);
		panel.add(mStatus);

		JLabel NumberOfChildren = new JLabel("Number of Children");
		NumberOfChildren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumberOfChildren.setBounds(471, 93, 159, 14);
		panel.add(NumberOfChildren);

		JLabel lblNextOfKin = new JLabel("Next of Kin Name");
		lblNextOfKin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNextOfKin.setBounds(78, 239, 143, 14);
		panel.add(lblNextOfKin);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(296, 161, 111, 14);
		panel.add(lblEmail);

		JLabel lblPhonenum = new JLabel("Phone Number");
		lblPhonenum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhonenum.setBounds(101, 159, 117, 27);
		panel.add(lblPhonenum);

		JLabel lblNextOfKinPhone = new JLabel("Next of Kin Phone");
		lblNextOfKinPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNextOfKinPhone.setBounds(293, 241, 143, 14);
		panel.add(lblNextOfKinPhone);

		JLabel lblNextOfKinEmail = new JLabel("Next of Kin Email");
		lblNextOfKinEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNextOfKinEmail.setBounds(471, 241, 143, 14);
		panel.add(lblNextOfKinEmail);

		JLabel dateOfVisit = new JLabel("Date Submitted");
		dateOfVisit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateOfVisit.setBounds(78, 310, 143, 14);
		panel.add(dateOfVisit);

		JSeparator separator = new JSeparator();
		separator.setBounds(76, 223, 554, 5);
		panel.add(separator);

		JButton chooseDate_1 = new JButton("^");
		chooseDate_1.setBounds(226, 113, 33, 28);
		panel.add(chooseDate_1);

		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBounds(211, 500, 117, 35);
		frame.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				patientID.setText("");
				fName.setText("");
				lName.setText("");
				numOfChild.setText("");
				maritalStatus.setText("");
				dateOfBirth.setText("");
				emailID.setText("");
				phoneNumber.setText("");
				nokEmail.setText("");
				nokPhone.setText("");
				nokName.setText("");

			}

		});

		AddNew = new JButton("Add New");
		AddNew.setBounds(379, 500, 117, 35);
		frame.getContentPane().add(AddNew);	
		AddNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] patient = new String[12];

				if (patientID.getText().isEmpty() || fName.getText().isEmpty() || lName.getText().isEmpty() || lName.getText().isEmpty() || dateOfBirth.getText().isEmpty()
						|| maritalStatus.getText().isEmpty() || numOfChild.getText().isEmpty() || phoneNumber.getText().isEmpty() || phoneNumber.getText().length()<=10 || 
						emailID.getText().isEmpty()|| !emailID.getText().contains("@")|| nokName.getText().isEmpty() || nokPhone.getText().isEmpty() || nokEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please complete the form");
					
				} else {
					patient[0] = patientID.getText();
					patient[1] = fName.getText();
					patient[2] = lName.getText();
					patient[3] = dateOfBirth.getText();
					patient[4] = maritalStatus.getText();
					patient[5] = numOfChild.getText();
					patient[6] = phoneNumber.getText();
					patient[7] = emailID.getText();
					patient[8] = nokName.getText();
					patient[9] = nokPhone.getText();
					patient[10] = nokEmail.getText();
					patient[11] = date.getText();
				}
				
				try {
					sqlqueries post = new sqlqueries();
					post.addPatient(patient);					
				} catch (Exception ex) {
					
						JOptionPane.showMessageDialog(null, "Invalid Entry Please try again");
						
				}
				int i;
				for (i = 0; i < Records.table.getRowCount(); i++) {

					rowGet = Records.table.getValueAt(i, 0);	
				}
				System.out.println(rowGet);
					
					if (rowGet!=patientID.getText()) {						
						Records.model.addRow(new Object[] { patient[0], patient[1], patient[2], patient[3], patient[4], patient[5],
								patient[5], patient[6], patient[7], patient[8], patient[9], patient[10], patient[11] });
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Patient Already in the table");
				}

			}

		});
		JButton genID = new JButton("Generate ID");
		genID.setBounds(498, 20, 188, 42);
		frame.getContentPane().add(genID);
		genID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double num = Math.floor(Math.random() * 1600);
				int runout = (int) num;
				patientID.setText("EMR" + runout);

			}

		});

		JLabel lblNewLabel = new JLabel("Patient Record ");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(30, 25, 117, 29);
		frame.getContentPane().add(lblNewLabel);
	}
}
