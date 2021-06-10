package com.records;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.connection.sqlqueries;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BookPatient {

	public static JFrame frame;
	public static JTextField $firstName;
	public static JTextField $dateOfBirth;
	public static JTextField $lastName;
	public static JTextField $maritalStatus;
	public static JTextField $numOfChildren;
	public static JTextField $dayOfVisit;
	public static JTextField search;
	public static JButton book, searchBox;
	private JTextField $paymentCode;
	private JLabel lblPaymentCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPatient window = new BookPatient();
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
	public BookPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private JTextField $firstName;
//	private JTextField $dateOfBirth;
//	private JTextField $lastName;
//	private JTextField $maritalStatus;
//	private JTextField $paymentStatus;
//	private JTextField $numOfVisit;
//	private JTextField search;

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 476);
		frame.setTitle("Book Patient");
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
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 506, 415);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		$firstName = new JTextField();
		$firstName.setBounds(85, 163, 145, 30);
		panel.add($firstName);
		$firstName.setColumns(10);

		$dateOfBirth = new JTextField();
		$dateOfBirth.setColumns(10);
		$dateOfBirth.setBounds(85, 227, 145, 30);
		panel.add($dateOfBirth);

		$lastName = new JTextField();
		$lastName.setColumns(10);
		$lastName.setBounds(254, 163, 145, 30);
		panel.add($lastName);

		$maritalStatus = new JTextField();
		$maritalStatus.setColumns(10);
		$maritalStatus.setBounds(254, 227, 145, 30);
		panel.add($maritalStatus);

		$numOfChildren = new JTextField();
		$numOfChildren.setColumns(10);
		$numOfChildren.setBounds(85, 289, 145, 30);
		panel.add($numOfChildren);

		$dayOfVisit = new JTextField();
		$dayOfVisit.setColumns(10);
		$dayOfVisit.setBounds(254, 289, 145, 30);
		panel.add($dayOfVisit);

		searchBox = new JButton("Generate Data");
		searchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booked gt = new Booked();
				gt.generateBaseOnID();

			}
		});
		searchBox.setBounds(256, 85, 142, 30);
		panel.add(searchBox);

		search = new JTextField();
		search.setColumns(10);
		search.setBounds(84, 85, 145, 30);
		panel.add(search);

		JSeparator separator = new JSeparator();
		separator.setBounds(76, 127, 333, 22);
		panel.add(separator);

		book = new JButton("Book Now");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booked tx = new Booked();
				// tx.pushBookedData();
				
				populateBookedData();


			}
		});
		book.setBounds(165, 360, 159, 31);
		panel.add(book);

		JLabel patID = new JLabel("Patient ID");
		patID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		patID.setBounds(85, 64, 145, 25);
		panel.add(patID);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(86, 138, 145, 25);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(254, 138, 145, 25);
		panel.add(lblLastName);

		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(85, 204, 145, 25);
		panel.add(lblDateOfBirth);

		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMaritalStatus.setBounds(254, 204, 145, 25);
		panel.add(lblMaritalStatus);

		JLabel lblNumberOfChildren = new JLabel("Number of Children");
		lblNumberOfChildren.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumberOfChildren.setBounds(85, 268, 145, 25);
		panel.add(lblNumberOfChildren);

		JLabel dayOfVisit = new JLabel("Day of Visit");
		dayOfVisit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dayOfVisit.setBounds(254, 268, 145, 25);
		panel.add(dayOfVisit);
		
		$paymentCode = new JTextField();
		$paymentCode.setBounds(195, 11, 206, 30);
		panel.add($paymentCode);
		$paymentCode.setColumns(10);
		
		lblPaymentCode = new JLabel("Payment Code");
		lblPaymentCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaymentCode.setBounds(85, 11, 145, 25);
		panel.add(lblPaymentCode);

	}

	public void populateBookedData() {
		String[] bookPatient = new String[8];

		if (search.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Payment Code Name cannot be empty");
		} else {
			bookPatient[0] = search.getText();
		}
		if ($firstName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " First Name cannot be empty");
		} else {
			bookPatient[1] = $firstName.getText();
		}
		if ($lastName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Last Name cannot be empty");
		} else {
			bookPatient[2] = $lastName.getText();
		}
		if ($dateOfBirth.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Date of Birth cannot be empty");
		} else {
			bookPatient[3] = $dateOfBirth.getText();
		}
		if ($maritalStatus.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Marital Status cannot be empty");
		} else {
			bookPatient[4] = $maritalStatus.getText();
		}
		if ($numOfChildren.getText().isEmpty()) {

		} else {
			bookPatient[5] = $numOfChildren.getText();
		}

		if ($dayOfVisit.getText().isEmpty()) {

		} else {
			bookPatient[7] = $dayOfVisit.getText();
		}
		if ($paymentCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Payment Code cannot be empty: get your paymentcode from account");

		} else {
			
			bookPatient[6] = $paymentCode.getText();
		}
		ResultSet rs = null;
		sqlqueries val = new sqlqueries();
		
		ResultSet bk = null;
		sqlqueries mybk = new sqlqueries();
		

		try {
			
			

			rs = val.displayNewPayment();
			String $code = $paymentCode.getText();
			String pID = search.getText();
			
			bk = mybk.displayBookedData();
			
		

			try {
				// We need a while loop to go through each line on the table
				while (rs.next()) {

					// Here I assigned a column name PatientID to a string $patientID
					String $patientID = rs.getString("PatientID");
					/*
					 * I then pass the String into an array, bcos we will be retrieving multiple
					 * data from the PatientID column
					 */
					String[] $newpatientID = { $patientID };
					int i;
				
					// after that we need a for loop to go through the data
					for (i = 0; i < $newpatientID.length; i++) {

						// here if the data matches with the displayed PatientID
						if ($newpatientID[i].equals(pID)) {
							// then its meant to return the payment status of the PatientID
							String rel = rs.getString("paymentCode");

							// We can then display the payment status here
							if (rel.equals($code)) {
								 
								while(bk.next()) {
									
									String $payCode = bk.getString("paymentCode");
									
									String[] $newCode = {$payCode};
									
									int j;
									
									for (j=0; j<$newCode.length; j++) {
										
										if($newCode[i].equals($paymentCode.getText())) {
										JOptionPane.showMessageDialog(null, "PaymentCode already exist");
										break;
										}
										else if(!$newCode[i].equals($paymentCode.getText())){
											
											val.bookPatient(bookPatient);
											Records.model2.addRow(new Object[] { bookPatient[0], bookPatient[1], bookPatient[2], bookPatient[3],
											bookPatient[4], bookPatient[5], bookPatient[7] });
											JOptionPane.showMessageDialog(null, "Patient payment was successful");
											break;
										}
										else {
											
											JOptionPane.showMessageDialog(null, "Patient has not made any payment");
										}
										
									}
									
								}
								
								
							}break;
													

						}
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid Entry Please try again");
		}
//		Records.model2.addRow(new Object[] { bookPatient[0], bookPatient[1], bookPatient[2], bookPatient[3],
//				bookPatient[4], bookPatient[5], bookPatient[6] });
	}

	public static void retrieveBookedData() {
		ResultSet rs = null;
		sqlqueries getBooked = new sqlqueries();
		rs = getBooked.displayBookedData();

		try {
			/*
			 * We need a while look to iterate through the database table and pass in the
			 * values to our declared String
			 * 
			 */
			while (rs.next()) {
				String patientID = rs.getString("patientID");
				String fname = rs.getString("firstName");
				String lname = rs.getString("lastName");
				String dateOfBirth = rs.getString("dateOfBirth");
				String maritalStatus = rs.getString("maritalStatus");
				String NumofChildren = rs.getString("NumofChildren");
				String lastdateVisit = rs.getString("lastDateVisit");

				// here we pass in all the data in to an array
				String[] patientData = { patientID, fname, lname, dateOfBirth, maritalStatus, NumofChildren,
						lastdateVisit };
				DefaultTableModel model = (DefaultTableModel) Records.table2.getModel();

				// here populate the table with recent data from the database
				model.addRow(patientData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			}
			catch(Exception e) {
				
			}
		}
	}

}

