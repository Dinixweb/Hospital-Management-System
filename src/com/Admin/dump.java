//package com.Admin;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.lang.module.InvalidModuleDescriptorException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSeparator;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
//
//
//import javax.swing.RowFilter;
//import javax.swing.table.TableRowSorter;
//
//import com.connection.sqlqueries;
//
//public class DoctorWindow {
//
//	static JFrame frame;
//	static JTable table;
//	static JTextField firstName;
//	private JTextField department;
//	private JTextField staffID;
//	private JTextField lastName;
//	private JTextField ward;
//	private JTable table_1;
//	DefaultTableModel model = new DefaultTableModel();
//	Object[] mytable = { "Staff ID", "First Name", "Last Name", "Department", "Ward", "Session", "Status" };
//
//	double ran;
//	String[] docSession = { "Morning", "Afternoon", "Night" };
//	JComboBox sessionSelector;
//	ResultSet rs;
//	private JTextField searchBox;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DoctorWindow window = new DoctorWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public DoctorWindow() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	public void initialize() {
//		frame = new JFrame();
//		frame.setTitle("Doctor Information");
//		frame.setBounds(300, 100, 800, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		try {
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (ClassNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (InstantiationException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (IllegalAccessException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//	
//
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 784, 461);
//		frame.getContentPane().add(panel);
//		panel.setLayout(null);
//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(0, 0, 139));
//		panel_1.setBounds(0, 0, 784, 35);
//		panel.add(panel_1);
//		panel_1.setLayout(null);
//
//		JLabel addTitle = new JLabel("Add New");
//		addTitle.setForeground(new Color(0, 255, 255));
//		addTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		addTitle.setBounds(25, 6, 81, 23);
//		panel_1.add(addTitle);
//
//		JButton generate_id = new JButton("Generate ID");
//		generate_id.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//using the math function to generate a random number for staffID
//				if(firstName.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name cannot be null");
//				}
//				else if(lastName.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "Last Name cannot be null");
//				}
//				else {
//					ran = Math.floor(Math.random() * 10000);
//					int runOut = (int) ran;
//					staffID.setText("IHSM" + runOut);
//				}
//
//			}
//		});
//		generate_id.setBounds(644, 4, 130, 30);
//		panel_1.add(generate_id);
//
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(0, 36, 784, 176);
//		panel.add(panel_2);
//		panel_2.setLayout(null);
//
//		firstName = new JTextField();
//		firstName.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				//using regex to validate user input
//				Pattern checkName = Pattern.compile("[A-Za-z]{2,22}");
//				Matcher matchName = checkName.matcher(firstName.getText());
//				
//				if(matchName.matches()) {
//					firstName.setForeground(new Color(0, 128, 0));
//				}
//				else {
//					firstName.setForeground(Color.RED);
//				}
//			}
//		});
//		firstName.setBounds(108, 21, 144, 30);
//		panel_2.add(firstName);
//		firstName.setColumns(10);
//	
//
//
//		department = new JTextField();
//		department.setColumns(10);
//		department.setBounds(108, 76, 144, 30);
//		panel_2.add(department);
//		
//
//		staffID = new JTextField();
//		staffID.setColumns(10);
//		staffID.setBounds(606, 21, 144, 30);
//		panel_2.add(staffID);
//
//		lastName = new JTextField();
//		lastName.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				Pattern lname = Pattern.compile("[A-Za-z]{2,22}");
//				Matcher myLname = lname.matcher(lastName.getText());
//				
//				if(myLname.matches()) {
//					lastName.setForeground(new Color(0, 128, 0));
//				}
//				else {
//					lastName.setForeground(Color.RED);
//				}
//				
//			}
//		});
//		lastName.setColumns(10);
//		lastName.setBounds(354, 21, 144, 30);
//		panel_2.add(lastName);
//
//		ward = new JTextField();
//		ward.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				Pattern wardVal = Pattern.compile("[0-9]{1,50}");
//				Matcher  matchward = wardVal.matcher(ward.getText());
//				
//				if(matchward.matches()) {
//					ward.setForeground(new Color(0, 128, 0));
//				}
//				else {
//					ward.setForeground(Color.RED);
//				}
//				
//			
//			}
//		});
//		ward.setColumns(10);
//		ward.setBounds(354, 76, 144, 30);
//		panel_2.add(ward);
//
//		JLabel fname = new JLabel("First Name");
//		fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		fname.setBounds(21, 19, 77, 30);
//		panel_2.add(fname);
//
//		JLabel lname = new JLabel("Last Name");
//		lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		lname.setBounds(267, 21, 77, 30);
//		panel_2.add(lname);
//
//		JLabel dept = new JLabel("Department");
//		dept.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		dept.setBounds(21, 76, 86, 30);
//		panel_2.add(dept);
//
//		JLabel docward = new JLabel("Ward");
//		docward.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		docward.setBounds(272, 76, 41, 30);
//		panel_2.add(docward);
//
//		JLabel mysession = new JLabel("Session");
//		mysession.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		mysession.setBounds(533, 76, 64, 30);
//		panel_2.add(mysession);
//
//		sessionSelector = new JComboBox(docSession);
//		sessionSelector.setBounds(606, 76, 144, 30);
//		panel_2.add(sessionSelector);
//
//		JLabel myID = new JLabel("StaffID");
//		myID.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		myID.setBounds(532, 21, 64, 30);
//		panel_2.add(myID);
//
//		JSeparator separator = new JSeparator();
//		separator.setBounds(144, 142, 130, 11);
//		panel_2.add(separator);
//
//		JButton addButton = new JButton("Add Doctor");
//		addButton.setBounds(281, 130, 101, 23);
//		panel_2.add(addButton);
//		addButton.addActionListener(new ActionListener() {
//
//		
//			public void actionPerformed(ActionEvent e) {
//				String staffid = staffID.getText();
//				String f_name = firstName.getText();
//				String l_name = lastName.getText();
//				String dept = department.getText();
//				String warddata = ward.getText();
//				String sessionSelect = (String) sessionSelector.getSelectedItem();
//
//				String[] doctor = new String[6];
//				
//				/*
//				 * validating inputs from the users
//				 */
//				if (staffid.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name must not be empty");
//				} else {
//					doctor[0] = staffid;
//				}
//
//				if (f_name.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name must not be empty");
//					
//				} else {
//					
//					doctor[1] = f_name;
//					
//				}
//				if (l_name.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name must not be empty");
//				} else {
//					doctor[2] = l_name;
//				}
//				if (dept.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name must not be empty");
//				} else {
//					doctor[3] = dept;
//				}
//				if (warddata.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name must not be empty");
//				} else {
//					doctor[4] = warddata;
//				}
//				if (sessionSelect.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "First Name must not be empty");
//				} else {
//					doctor[5] = sessionSelect;
//				}
//				
//				
//				sqlqueries post = new sqlqueries();
//				
//				if(ward.getForeground().equals(Color.RED)) {
//				
//					JOptionPane.showMessageDialog(null, "Enter a valid number in Ward");
//				}
//				else {
//					post.addDoctor(doctor);
//				}
//				
//
//			}
//
//		});
//
//		JSeparator separator_1 = new JSeparator();
//		separator_1.setBounds(392, 142, 113, 11);
//		panel_2.add(separator_1);
//
//		JButton search = new JButton("Search ");
//		search.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					search();
//				} catch (ClassNotFoundException e1) {
//					
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//		search.setBounds(648, 130, 89, 23);
//		panel_2.add(search);
//
//		JButton refresh = new JButton("Refresh");
//		refresh.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//			
//			
//			}
//		});
//		refresh.setBounds(21, 130, 113, 23);
//		panel_2.add(refresh);
//		searchBox = new JTextField();
//		searchBox.setBounds(510, 130, 124, 25);
//		panel_2.add(searchBox);
//		searchBox.setColumns(10);
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 212, 768, 243);
//		panel.add(scrollPane);
//		table_1 = new JTable();
//		table_1.setModel(model);
//		model.setColumnIdentifiers(mytable);
//		scrollPane.setViewportView(table_1);
//		
//		/*Loading the data directly in the constructor will 
//		 * enable the current data in the database to 
//		 * load whenever the window is fired up
//		 */
//		loadData();
//	}
//
//	public void loadData() {//this method will retrieve all the information from the database
//		ResultSet rs = null;
//		sqlqueries get = new sqlqueries();
//		rs = get.displayDoctor();
//
//		try {
//			while (rs.next()) {//passing all data in the database into declared String
//				String sID = rs.getString("StaffID");
//				String _fname = rs.getString("firstName");
//				String _lname = rs.getString("lastName");
//				String _department = rs.getString("d_department");
//				String _ward = rs.getString("w_ward");
//				String _session = rs.getString("s_session");
//
//				String sessionSelect = (String) sessionSelector.getSelectedItem();
//
//				String status;
//				if (sessionSelect == "Morning") {
//					status = "Active";
//				} else if (sessionSelect == "Afternoon") {
//					status = "NotActive";
//				} else if (sessionSelect == "Evening") {
//					status = "Active";
//				} else {
//					status = "NotActive";
//				}
//
//				String[] mydata = { sID, "Dr " + _fname, _lname, _department, _ward, _session, status };
//				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
//				model.addRow(mydata);
//
//			}
//
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//	}
//
//	public void refreshData(){//this method will refresh the table when there is a new data 
//		ResultSet rs = null;
//		sqlqueries get = new sqlqueries();
//		rs = get.refreshSelect();
//		
//		try {
//			/*We need a while loop to iterate through the database 
//			  table and pass in the values to our declared String
//			 * 
//			 */
//			while(rs.next()) {
//				String sID = rs.getString("StaffID");
//				String _fname = rs.getString("firstName");
//				String _lname = rs.getString("lastName");
//				String _department = rs.getString("d_department");
//				String _ward = rs.getString("w_ward");
//				String _session = rs.getString("s_session");
//				
//				//retrieving data from the Combo box
//				String sessionSelect = (String) sessionSelector.getSelectedItem();
//				
//				//defining the different session
//				String status;
//				if (sessionSelect == "Morning") {
//					status = "Active";
//				} else if (sessionSelect == "Afternoon") {
//					status = "NotActive";
//				} else if (sessionSelect == "Evening") {
//					status = "Active";
//				} else {
//					status = "NotActive";
//				}
//				
//				//here we pass in all the data in to an array 
//				String[] mydata = { sID, "Dr " + _fname, _lname, _department, _ward, _session, status };
//					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
//					
//					//here populate the table with recent data from the database
//					model.addRow(mydata);
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	public void search () throws SQLException, ClassNotFoundException{
//
//
//	}
//
//}



