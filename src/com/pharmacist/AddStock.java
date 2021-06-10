package com.pharmacist;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.connection.sqlqueries;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStock {

	public JFrame frame;
	private JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	
	String[] inventory = {"Drug ID", "Drug Name", "Grammage", "Expiry Date", "Unity Price", "Qty Sold", "Qty Remaining", "Total Stock","Date"};
	private JTextField drugIDGen;
	private JTextField exDate;
	private JTextField date;
	private JTextField drugname;
	private JTextField uPrice;
	private JTextField qSold;
	private JTextField grammage;
	private JTextField qRemaining;
	private JLabel drugidTxt;
	private JLabel drugnameTxt_1;
	private JLabel drugnameTxt;
	private JLabel lblExpiryDate;
	private JLabel unitpriceTxt;
	private JLabel lblQtySold;
	private JLabel lblQtyReamin;
	private JLabel lblPurchDate;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnAddDrugs;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStock window = new AddStock();
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
	public AddStock() {
		initialize();
		displayInventory();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 499);
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
		panel.setBounds(0, 243, 790, 217);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 770, 169);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.setColumnIdentifiers(inventory);
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(110);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);

//
//		table.setShowGrid(false);
//		table.setShowHorizontalLines(true);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add New Item", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_1.setBounds(10, 11, 770, 194);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		drugIDGen = new JTextField();
		drugIDGen.setBounds(123, 32, 146, 26);
		panel_1.add(drugIDGen);
		drugIDGen.setColumns(10);
		
		exDate = new JTextField();
		exDate.setColumns(10);
		exDate.setBounds(123, 143, 146, 26);
		panel_1.add(exDate);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(388, 143, 146, 26);
		panel_1.add(date);
		
		drugname = new JTextField();
		drugname.setColumns(10);
		drugname.setBounds(123, 69, 146, 26);
		panel_1.add(drugname);
		
		uPrice = new JTextField();
		uPrice.setColumns(10);
		uPrice.setBounds(388, 32, 146, 26);
		panel_1.add(uPrice);
		
		qSold = new JTextField();
		qSold.setColumns(10);
		qSold.setBounds(388, 69, 146, 26);
		panel_1.add(qSold);
		qSold.setText(0+"");
		qSold.setEditable(false);
		
		grammage = new JTextField();
		grammage.setColumns(10);
		grammage.setBounds(123, 106, 146, 26);
		panel_1.add(grammage);
		
		qRemaining = new JTextField();
		qRemaining.setColumns(10);
		qRemaining.setBounds(388, 106, 146, 26);
		panel_1.add(qRemaining);
		
		drugidTxt = new JLabel("Drug ID");
		drugidTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		drugidTxt.setBounds(10, 33, 103, 20);
		panel_1.add(drugidTxt);
		
		drugnameTxt_1 = new JLabel("Drug Name");
		drugnameTxt_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		drugnameTxt_1.setBounds(10, 75, 103, 20);
		panel_1.add(drugnameTxt_1);
		
		drugnameTxt = new JLabel("Grammage");
		drugnameTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		drugnameTxt.setBounds(10, 112, 103, 20);
		panel_1.add(drugnameTxt);
		
		lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExpiryDate.setBounds(10, 149, 103, 20);
		panel_1.add(lblExpiryDate);
		
		unitpriceTxt = new JLabel("Unit Price");
		unitpriceTxt.setFont(new Font("Tahoma", Font.BOLD, 15));
		unitpriceTxt.setBounds(279, 32, 103, 20);
		panel_1.add(unitpriceTxt);
		
		lblQtySold = new JLabel("QTY Sold");
		lblQtySold.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQtySold.setBounds(279, 69, 103, 20);
		panel_1.add(lblQtySold);
		
		lblQtyReamin = new JLabel("Drug QTY ");
		lblQtyReamin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQtyReamin.setBounds(275, 107, 103, 20);
		panel_1.add(lblQtyReamin);
		
		lblPurchDate = new JLabel("Purch. Date");
		lblPurchDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPurchDate.setBounds(279, 144, 103, 20);
		panel_1.add(lblPurchDate);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 205)));
		panel_2.setBounds(544, 32, 216, 138);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		btnNewButton = new JButton("Generate ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double num = Math.floor(Math.random() * 1600);
				int runout = (int) num;
				String coll = drugname.getText();
				String output = "";
				
				if(drugname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Drug Name in order to generate ID");
				}
				else {				
				if(coll.length()>=4) {
					output = coll.substring(0, 4);
					drugIDGen.setText(output + runout+"");
				}
				else {
					output = coll.substring(0, 3);
					drugIDGen.setText(output + runout+"");
				}
			
			}
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 20, 196, 29);
		panel_2.add(btnNewButton);
		
		btnAddDrugs = new JButton("Add New");
		btnAddDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewDrug();
			}
		});
		btnAddDrugs.setBackground(new Color(50, 205, 50));
		btnAddDrugs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddDrugs.setBounds(10, 60, 196, 29);
		panel_2.add(btnAddDrugs);
		
		btnNewButton_2 = new JButton("View Details");
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(10, 100, 196, 29);
		panel_2.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Enter drug name to generate drug ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(544, 11, 216, 20);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(78, 210, 199, 26);
		frame.getContentPane().add(textField);
		
		lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSearch.setBounds(20, 212, 63, 20);
		frame.getContentPane().add(lblSearch);
		model.setColumnIdentifiers(inventory);
	}
	
	public void displayInventory() {
		
		ResultSet rs = null;
		
		sqlqueries getInvent  = new sqlqueries();
		
		rs = getInvent.displayInvent();
		
		try {
			while(rs.next()) {
				
			String $drugID = rs.getString("DrugID");
			String $drugName = rs.getString("drugName");
			String $grammage = rs.getString("DrugGrammage");
			String $expDate = rs.getString("ExpiryDate");
			String $unitPrice = rs.getString("UnitPrice");
			int $QtySold = rs.getInt("QtySold");
			int $QtyRemaining = rs.getInt("QtyRemaining");
			int $totalStock = rs.getInt("TotalStock");
			String $date = rs.getString("date");
			
			int val = $QtyRemaining -  $QtySold;
			
			//checking to know the quantity of  stock remaining
//			int i;
//			for(i=0; i<table.getRowCount(); i++) {
//			if($QtyRemaining<=12) {
//			Object row=	table.getSelectedRow();
//			}
//			
//			}
						
			Object[] inventData = {$drugID, $drugName,$grammage,$expDate,$unitPrice,$QtySold,$totalStock,$QtyRemaining, $date};
			DefaultTableModel model1 = new DefaultTableModel();table.getModel();
			model.addRow(inventData);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	public void addNewDrug() {
		
		String[] inventory=new String[8];
		
		if(drugIDGen.getText().isEmpty() || drugname.getText().isEmpty() || exDate.getText().isEmpty() || grammage.getText().isEmpty()
				|| uPrice.getText().isEmpty() || qRemaining.getText().isEmpty() || date.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Complete all neccesary fields");
		}
		else {
			inventory[0] = drugIDGen.getText();
			inventory[1] = drugname.getText();
			inventory[2] = exDate.getText();
			inventory[3] = grammage.getText();
			inventory[4] = uPrice.getText();
			inventory[5] = qSold.getText();
			inventory[6] = qRemaining.getText();
			inventory[7] = date.getText();
			
			PharmacyDash sub = new PharmacyDash();
			
		//int val1 = PharmacyDash.table_1.getValueAt(0, 0)
			
			sqlqueries newdrug  = new sqlqueries();
			newdrug.addingInventory(inventory);
			
			String[] tableData = {inventory[0],inventory[1],inventory[2],inventory[3],
					inventory[4],inventory[5],inventory[6],inventory[7] };
			table.getModel();
			model.addRow(tableData);
		}
		
	}

}
