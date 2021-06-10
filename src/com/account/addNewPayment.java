package com.account;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.connection.sqlqueries;
import com.records.BookPatient;
import com.records.Records;

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
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class addNewPayment {

	public static JFrame frame;
	public static JTextField $patientID;
	public static JTextField $lastName;
	public static JTextField paymentCode;
	public static JButton book, searchBox;
	JComboBox $payStatus;

	static String[] payStatus = { "Paid", "Not Paid" };
	private JButton getPatientID;
	private JComboBox $billTitle;
	private JTextField billingAmount;

	static String[] billTitle = { "Select","Consultation Fee", "Medical Examination", "Malaria Test",
			"Full Blood Count", "Doctor", "HIV Test", "CT Scans", "X-Ray", "autopsy", "auscultation", "biopsy",
			"cardiac catheterization", "colposcopy", "blood analysis", "Child Birth", "Oxygen", "Blood" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNewPayment window = new addNewPayment();
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
	public addNewPayment() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 512);
		frame.setTitle("Add New Payment");
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
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 506, 451);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		$patientID = new JTextField();
		$patientID.setBounds(88, 129, 145, 30);
		panel.add($patientID);
		$patientID.setColumns(10);

		$lastName = new JTextField();
		$lastName.setColumns(10);
		$lastName.setBounds(88, 207, 145, 30);
		panel.add($lastName);

		searchBox = new JButton("Generate PayCode");
		searchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double min = Math.floor(Math.random() * 67310);
				int rex = (int) min;

				double max = Math.floor(Math.random() * 83390);
				int rel = (int) max;

				String[] array = { "BHO", "PA1", "XYAU1", "8JAD", "HAUW1", "GBAQ", "IPSQ", "2HAJS" };
				Random rand = new Random();

				String[] array2 = { "DQ", "LX", "SG2", "VW", "FD", "KF", "HG", "54FD" };
				Random rand2 = new Random();

				int ran = rand.nextInt(array.length);
				int ran2 = rand2.nextInt(array2.length);
				paymentCode.setText(rex + array[ran] + rel + array2[ran2]);

			}
		});
		searchBox.setBounds(258, 56, 142, 30);
		panel.add(searchBox);

		paymentCode = new JTextField();
		paymentCode.setColumns(10);
		paymentCode.setBounds(88, 56, 145, 30);
		panel.add(paymentCode);

		JSeparator separator = new JSeparator();
		separator.setBounds(64, 97, 358, 22);
		panel.add(separator);

		book = new JButton("Pay Now");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				processPayment();

			}
		});
		book.setBounds(182, 384, 145, 31);
		panel.add(book);

		JLabel patID = new JLabel("Patient ID");
		patID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		patID.setBounds(88, 104, 145, 25);
		panel.add(patID);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(88, 182, 145, 25);
		panel.add(lblLastName);

		JLabel lblPaymentCode = new JLabel("Payment Code");
		lblPaymentCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaymentCode.setBounds(89, 35, 145, 25);
		panel.add(lblPaymentCode);

		$payStatus = new JComboBox(payStatus);
		$payStatus.setBounds(88, 287, 145, 30);
		panel.add($payStatus);

		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaymentStatus.setBounds(88, 263, 145, 25);
		panel.add(lblPaymentStatus);

		getPatientID = new JButton("Generate Details");
		getPatientID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				sqlqueries count = new sqlqueries();
				rs = count.dipslayPatients();
				String dis = $patientID.getText();

				try {
					// We need a while loop to go through each line on the table
					while (rs.next()) {

						// Here I assigned a column name PatientID to a string $patientID
						String $_patientID = rs.getString("PatientID");

						/*
						 * I then pass the String into an array, bcos we will be retrieving multiple
						 * data from the PatientID column
						 */
						String[] $newpatientID = { $_patientID };
						int i;

						// after that we need a for loop to go through the data
						for (i = 0; i < $newpatientID.length; i++) {

							// here if the data matches with the displayed PatientID
							if ($newpatientID[i].equals(dis)) {
								// then its meant to return the payment status of the PatientID
								// String rel = rs.getString("firstName");
								String myfname = rs.getString("patientID");
								String mylname = rs.getString("lastName");

								// BookPatient.search.setText(Records.$_patientID + "");
								$patientID.setText(myfname);
								$lastName.setText(mylname);

							}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();

				}
			}
		});
		getPatientID.setBounds(258, 287, 142, 30);
		panel.add(getPatientID);

		$billTitle = new JComboBox(billTitle);
		$billTitle.setBounds(258, 129, 145, 30);
		panel.add($billTitle);
		$billTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//		    	{"Consultation Fee", "Medical Examination", 
//					"Malaria Test", "Full Blood Count", "Doctor", "HIV Test", "CT Scans", "X-Ray", 
//					"autopsy", "auscultation", "biopsy", "cardiac catheterization", 
//					"colposcopy", "blood analysis", "Child Birth", "Oxygen", "Blood" };

				String sel = (String) $billTitle.getSelectedItem();

				if (sel.equals("Select")) {
					billingAmount.setText("");
				} else if (sel.equals("Consultation Fee")) {
					billingAmount.setText(2500 + "");
				} else if (sel.equals("Medical Examination")) {
					billingAmount.setText(4800 + "");
				} else if (sel.equals("Malaria Test")) {
					billingAmount.setText(2000 + "");
				} else if (sel.equals("Full Blood Count")) {
					billingAmount.setText(6500 + "");
				} else if (sel.equals("Doctor")) {
					billingAmount.setText(3000 + "");
				} else if (sel.equals("HIV Test")) {
					billingAmount.setText(2800 + "");
				} else if (sel.equals("CT Scans")) {
					billingAmount.setText(11000 + "");
				} else if (sel.equals("X-Ray")) {
					billingAmount.setText(13000 + "");
				} else if (sel.equals("auscultation")) {
					billingAmount.setText(5000 + "");
				} else if (sel.equals("biopsy")) {
					billingAmount.setText(20000 + "");
				} else if (sel.equals("cardiac catheterization")) {
					billingAmount.setText(40000 + "");
				} else if (sel.equals("colposcopy")) {
					billingAmount.setText(35000 + "");
				} else if (sel.equals("blood analysis")) {
					billingAmount.setText(28000 + "");
				} else if (sel.equals("Child Birth")) {
					billingAmount.setText(10000 + "");
				} else if (sel.equals("Oxygen")) {
					billingAmount.setText(11000 + "");
				} else if (sel.equals("Blood")) {
					billingAmount.setText(15000 + "");
				}

				else {
					JOptionPane.showInternalMessageDialog(null, "Select an Item");
				}

			}
		});

		billingAmount = new JTextField();
		billingAmount.setColumns(10);
		billingAmount.setBounds(255, 207, 145, 30);
		panel.add(billingAmount);

	}

	public void processPayment()  {
		
	
		String[] payment = new String[6];
		
		
		String payCode = paymentCode.getText();
		String lname = $lastName.getText();
		String patientID = $patientID.getText();
		String option = (String) $payStatus.getSelectedItem();
		String bill = (String)$billTitle.getSelectedItem();
		String amount = billingAmount.getText();
		
	
		if(payCode.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Generate Payment Code");
		}
		else {
			payment[0] = payCode;
		}
		if(patientID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Enter Patient Last Name");
		}
		else {
			payment[1] = patientID;
			
		}
		if(lname.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Patient ID cannot be empty");
		}
		else {
			payment[2] = lname;
		}
		if(option.equals("Paid") || option.equals("Not Paid")) {
			payment[3] = option;
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Payment");
		}
		
		if(bill.equals("Select")) {
			JOptionPane.showMessageDialog(null, "Invalid Selection");
		}
		
		else {
			payment[4] = bill;
		}
		
		if(amount.equals("")) {
			JOptionPane.showMessageDialog(null, "Invalid Amount");
		}
		else {
			payment[5] = amount;
		}
		
		
		
		
		ResultSet rs = null;
		sqlqueries pay = new sqlqueries();
	
		rs = pay.dipslayPatients();
		//rs = pay.allPayments();
		
			String $code = $patientID.getText();
			//String pID = search.getText();
			
			String $payCode = paymentCode.getText();

			try {
				// We need a while loop to go through each line on the table
				while (rs.next()) {

					// Here I assigned a column name to a string $patientID
					String $patientID = rs.getString("patientID");

					/*
					 * I then pass the String into an array, bcos we will be retrieving multiple
					 * data from the PatientID column
					 */
					String[] $newpatientID = { $patientID };
					int i;

					// after that we need a for loop to go through the data
					for (i = 0; i < $newpatientID.length; i++) {

						// here if the data matches with the displayed PatientID
						if ($newpatientID[i].equals($code)) {
							// then its meant to return the payment status of the PatientID
							String rel = rs.getString("patientID");

							
							if (rel.equals($code)) {
								//JOptionPane.showMessageDialog(null, "Patient payment was successful");
								pay.dumpPayment(payment);
								PaymentProcess.mode.addRow(new Object[] { payment[0], payment[1], payment[2], payment[3],
										payment[4], payment[5] });
							}
							else {
								JOptionPane.showMessageDialog(null, "Patient has not been registered");
							}
													

						}
					}
				}
			} catch (SQLException e1) {
				if(e1.toString().contains("paymentCode")) {
					JOptionPane.showMessageDialog(null, "PaymentCode already exist");
				}
				e1.printStackTrace();

			} 	
		
	}

}