package com.records;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class ViewPatient {

	public static JFrame frame;
	private JTextField patientID;
	private JTextField fName;
	private JTextField lName;
	private JTextField numOfChild;
	private JTextField maritalStatus;
	private JTextField dateOfBirth;
	private JTextField emailID;
	private JTextField phoneNumber;
	private JTextField nokEmail;
	private JTextField nokPhone;
	private JTextField nokName;
	private JTextField paymentStatus;
	private JTextField numOfVisit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPatient window = new ViewPatient();
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
	public ViewPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel.setBounds(10, 11, 692, 417);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		patientID = new JTextField();
		patientID.setBounds(66, 43, 165, 27);
		panel.add(patientID);
		patientID.setColumns(10);
		patientID.setEditable(false);
		
		fName = new JTextField();
		fName.setColumns(10);
		fName.setBounds(271, 43, 165, 27);
		panel.add(fName);
		fName.setEditable(false);
		
		lName = new JTextField();
		lName.setColumns(10);
		lName.setBounds(465, 43, 165, 27);
		panel.add(lName);
		lName.setEditable(false);
		
		
		numOfChild = new JTextField();
		numOfChild.setColumns(10);
		numOfChild.setBounds(465, 113, 165, 27);
		panel.add(numOfChild);
		numOfChild.setEditable(false);
		
		maritalStatus = new JTextField();
		maritalStatus.setColumns(10);
		maritalStatus.setBounds(271, 113, 165, 27);
		panel.add(maritalStatus);
		maritalStatus.setEditable(false);
		
		dateOfBirth = new JTextField();
		dateOfBirth.setColumns(10);
		dateOfBirth.setBounds(66, 113, 165, 27);
		panel.add(dateOfBirth);
		dateOfBirth.setEditable(false);
		
		emailID = new JTextField();
		emailID.setColumns(10);
		emailID.setBounds(271, 186, 165, 27);
		panel.add(emailID);
		emailID.setEditable(false);
		
		phoneNumber = new JTextField();
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(66, 186, 165, 27);
		panel.add(phoneNumber);
		phoneNumber.setEditable(false);
		
		nokEmail = new JTextField();
		nokEmail.setColumns(10);
		nokEmail.setBounds(465, 261, 165, 27);
		panel.add(nokEmail);
		nokEmail.setEditable(false);
		
		nokPhone = new JTextField();
		nokPhone.setColumns(10);
		nokPhone.setBounds(271, 261, 165, 27);
		panel.add(nokPhone);
		nokPhone.setEditable(false);
		
		nokName = new JTextField();
		nokName.setColumns(10);
		nokName.setBounds(66, 261, 165, 27);
		panel.add(nokName);
		nokName.setEditable(false);
		
		paymentStatus = new JTextField();
		paymentStatus.setColumns(10);
		paymentStatus.setBounds(271, 332, 165, 27);
		panel.add(paymentStatus);
		paymentStatus.setEditable(false);
		
		numOfVisit = new JTextField();
		numOfVisit.setColumns(10);
		numOfVisit.setBounds(66, 332, 165, 27);
		panel.add(numOfVisit);
		numOfVisit.setEditable(false);
		
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
		
		JLabel lblNumberOfVisit = new JLabel("Date Submitted");
		lblNumberOfVisit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumberOfVisit.setBounds(78, 310, 143, 14);
		panel.add(lblNumberOfVisit);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaymentStatus.setBounds(281, 307, 143, 14);
		panel.add(lblPaymentStatus);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(76, 223, 554, 5);
		panel.add(separator);
	}
}
