package com.Admin;

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

public class newDump {

	public static JFrame frame;
	public static JTextField $firstName;
	public static JTextField $lastName;
	public static JTextField search;
	public static JButton book, searchBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newDump window = new newDump();
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
	public newDump() {
		initialize();
	}



	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 421);
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
		panel.setBounds(10, 11, 506, 360);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		$firstName = new JTextField();
		$firstName.setBounds(89, 181, 145, 30);
		panel.add($firstName);
		$firstName.setColumns(10);

		$lastName = new JTextField();
		$lastName.setColumns(10);
		$lastName.setBounds(258, 181, 145, 30);
		panel.add($lastName);

		searchBox = new JButton("Generate PayCode");
		searchBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

			}
		});
		searchBox.setBounds(260, 103, 142, 30);
		panel.add(searchBox);

		search = new JTextField();
		search.setColumns(10);
		search.setBounds(88, 103, 145, 30);
		panel.add(search);

		JSeparator separator = new JSeparator();
		separator.setBounds(80, 145, 333, 22);
		panel.add(separator);

		book = new JButton("Book Now");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		


			}
		});
		book.setBounds(258, 239, 145, 31);
		panel.add(book);

		JLabel patID = new JLabel("Patient ID");
		patID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		patID.setBounds(89, 156, 145, 25);
		panel.add(patID);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(258, 156, 145, 25);
		panel.add(lblLastName);
		
		JLabel lblPaymentCode = new JLabel("Payment Code");
		lblPaymentCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaymentCode.setBounds(89, 82, 145, 25);
		panel.add(lblPaymentCode);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(89, 239, 145, 30);
		panel.add(comboBox);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status");
		lblPaymentStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPaymentStatus.setBounds(89, 215, 145, 25);
		panel.add(lblPaymentStatus);

	}

}