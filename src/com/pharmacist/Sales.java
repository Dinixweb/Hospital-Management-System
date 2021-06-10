package com.pharmacist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.connection.sqlqueries;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class Sales {

	public JFrame frame;

	String[] drugCode = { "Drug Name", "Code" };

	String[] qty = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
	DefaultTableModel model = new DefaultTableModel();
	static JTextField drugCodeGen;
	static JTable table;
	static JTextField patientID;
	static JTextField drugName;
	static JTextField pharmacistName;
	static JTextField unitPrice;
	static JTextField totalCost;
	static JTextField date;
	public JComboBox comboBox;
	
	DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales window = new Sales();
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
	public Sales() {
		initialize();
		
		DrugCode();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 440);
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
		panel.setBounds(0, 0, 848, 72);
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(577, 72, 271, 282);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 251, 261);
		panel_1.add(scrollPane);

		table = new JTable();

		table.setModel(model);
		model.setColumnIdentifiers(drugCode);
		scrollPane.setViewportView(table);

		table.setShowGrid(false);
		table.setShowHorizontalLines(true);
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//table.setDefaultEditor(Object.class, null);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JLabel drugcode = new JLabel("Drug Code");
		drugcode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		drugcode.setBounds(30, 91, 118, 19);
		frame.getContentPane().add(drugcode);

		drugCodeGen = new JTextField();
		drugCodeGen.setBounds(143, 83, 236, 35);
		frame.getContentPane().add(drugCodeGen);
		drugCodeGen.setColumns(10);

		JButton btnNewButton = new JButton("Get Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				generateData();
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(397, 83, 144, 35);
		frame.getContentPane().add(btnNewButton);

		JLabel patientidtxt = new JLabel("Patient ID");
		patientidtxt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		patientidtxt.setBounds(30, 150, 105, 19);
		frame.getContentPane().add(patientidtxt);

		patientID = new JTextField();
		patientID.setBounds(141, 136, 123, 35);
		frame.getContentPane().add(patientID);
		patientID.setColumns(10);

		JLabel lblDrugName = new JLabel("Drug Name");
		lblDrugName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDrugName.setBounds(284, 148, 89, 19);
		frame.getContentPane().add(lblDrugName);

		drugName = new JTextField();
		drugName.setColumns(10);
		drugName.setBounds(395, 134, 146, 35);
		frame.getContentPane().add(drugName);

		JLabel lblPharmacist = new JLabel("Pharmacist");
		lblPharmacist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPharmacist.setBounds(30, 215, 105, 19);
		frame.getContentPane().add(lblPharmacist);

		pharmacistName = new JTextField();
		pharmacistName.setColumns(10);
		pharmacistName.setBounds(141, 201, 123, 35);
		frame.getContentPane().add(pharmacistName);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblQuantity.setBounds(284, 211, 89, 19);
		frame.getContentPane().add(lblQuantity);

		comboBox = new JComboBox(qty);
		comboBox.setBounds(397, 201, 144, 28);
		frame.getContentPane().add(comboBox);

		JLabel lblUnityPrice = new JLabel("Unity Price");
		lblUnityPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblUnityPrice.setBounds(30, 276, 105, 19);
		frame.getContentPane().add(lblUnityPrice);

		unitPrice = new JTextField();
		unitPrice.setColumns(10);
		unitPrice.setBounds(141, 262, 123, 35);
		frame.getContentPane().add(unitPrice);

		totalCost = new JTextField();
		totalCost.setColumns(10);
		totalCost.setBounds(397, 262, 144, 35);
		frame.getContentPane().add(totalCost);

		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCost.setBounds(284, 276, 89, 19);
		frame.getContentPane().add(lblCost);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(143, 321, 123, 35);
		frame.getContentPane().add(date);
		String mydate = df.format(new Date());
		date.setText(mydate);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDate.setBounds(30, 331, 89, 19);
		frame.getContentPane().add(lblDate);

		JButton btnNewButton_1 = new JButton("Sale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewSale();
			}
		});
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(284, 319, 123, 35);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Click to Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqlqueries update = new sqlqueries();
				String drugid = drugCodeGen.getText();
				update.updateSales(drugid);
			}
		});
		btnNewButton_1_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(417, 321, 140, 35);
		frame.getContentPane().add(btnNewButton_1_1);
		model.setColumnIdentifiers(drugCode);

	}

	public void addNewSale() {
		String[] sales = new String[8];

		if (drugCodeGen.getText().isEmpty() || patientID.getText().isEmpty() || drugName.getText().isEmpty()
				|| pharmacistName.getText().isEmpty() || unitPrice.getText().isEmpty() || totalCost.getText().isEmpty()
				|| date.getText().isEmpty()) {
			// JOptionPane.showMessageDialog(null, "Complete all fields");

		} else {
			sales[0] = drugCodeGen.getText();
			sales[1] = patientID.getText();
			sales[2] = drugName.getText();
			sales[3] = pharmacistName.getText();
			sales[4] = unitPrice.getText();
			sales[7] = (String) comboBox.getSelectedItem();
			sales[6] = date.getText();
			sales[5] = totalCost.getText();
			
			

			DefaultTableModel newModel = new DefaultTableModel();
			table.getModel();
			newModel.addRow(sales);
			sqlqueries push = new sqlqueries();
			push.addSales(sales);
		}
	}

	public void updateSales() {
		String[] salesUpdate = new String[2];
		
		//salesUpdate[0] = 

	}

	public void generateData() {

		ResultSet rs = null;
		sqlqueries getData = new sqlqueries();
		rs = getData.generateData();
		String getID = drugCodeGen.getText();

		try {
			while (rs.next()) {

				String dID = rs.getString("DrugID");
				// generateData
				String[] drugNo = { dID };
				int i;
				for (i = 0; i < drugNo.length; i++) {

					if (getID.equals(drugNo[i])) {

						String dName = rs.getString("drugName");
						String unitP = rs.getString("unitPrice");

						drugName.setText(dName);
						unitPrice.setText(unitP);

					} else {

					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String qty = (String) comboBox.getSelectedItem();
		if (qty.equals("1")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 1;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			
		} else if (qty.equals("2")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 2;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("3")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 3;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("4")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 4;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("5")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 5;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("6")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 6;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("7")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 7;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("8")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 8;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("9")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 9;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		} else if (qty.equals("10")) {
			double Price = Double.parseDouble(unitPrice.getText());

			Double mytotal = Price * 10;
			// uble finalTotal = Double.parseDouble(totalCost.setText(""));
			String finalOutput;
			finalOutput = String.format("%.2f", mytotal);
			// String cost =totalCost.setText(Price*1+"");
			totalCost.setText(finalOutput);
			//sales[5] = totalCost.getText();
		}

	}
	public void DrugCode() {
		ResultSet rs = null;
		sqlqueries viewCode = new sqlqueries();
		rs = viewCode.generateData();
		
		try {
		while(rs.next()) {
			String code = rs.getString("DrugID");
			String name  = rs.getString("drugName");
			
			String[]  drugData = {name, code};
			DefaultTableModel mymode = new DefaultTableModel();table.getModel();
			model.addRow(drugData);
			
		}
		}catch(SQLException x) {
			
		}
	}
}
