package com.account;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.module.InvalidModuleDescriptorException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import com.Admin.Dashboard;
import com.Admin.Login;
import com.connection.sqlqueries;

public class PaymentProcess {

	static  JPanel contentPane;
	JLabel logout;
	private JLabel Admin_Title;
	private JPanel panel_1;
	private JLabel dashboardTitle;
	private JPanel doctors_panel;
	private JPanel doctors_panel_2;
	private JPanel doctors_panel_1;
	private JPanel patients_panel_1;
	private JPanel doctors_panel_3;
	private JPanel doctors_panel_4;
	private JLabel NumberOfDoctor;
	private JLabel lblDoctors;
	private JLabel NumberOfPharmacist;
	private JLabel Pharmacist;
	public static JLabel NumberOfPatients;
	private JLabel Patients;
	private JLabel NumberOfAccountant;
	private JLabel Accountants;
	private JLabel lblPayment;
	public static JLabel NumberOfAccountant_1;
	private JLabel report;
	private JLabel operationReport;
	private JLabel copyright_footer, copyright_footer2;
	private JLabel designedBy;
	private JSeparator separator_1;
	private JPanel image_panel;
	private JLabel welcome;
	private JLabel userTitle;
	private JPanel menuBar1;
	private JPanel menuBar1_1;
	private JPanel menuBar1_2;
	private JPanel menuBar1_3;
	private JPanel menuBar1_4;
	private JPanel menuBar1_5;
	private JPanel menuBar1_10;
	private JLabel dashboard_menu;
	private JLabel departments_menu;
	private JLabel doctor_menu;
	private JLabel patient_menu;
	private JLabel nurses_menu;
	private JLabel hr_menu_1;
	private JLabel report_menu;

	public static JFrame frame;
	private JLabel doctor_icon;

	private Image doc = new ImageIcon(Dashboard.class.getResource("/com/res/7254349241561032519-128.png")).getImage()
			.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image nurse = new ImageIcon(Dashboard.class.getResource("/com/res/3144210831606252954-128.png")).getImage()
			.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image menu = new ImageIcon(Dashboard.class.getResource("/com/res/16743131341543238854-128.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

	private Image pharm = new ImageIcon(Dashboard.class.getResource("/com/res/7455466111606252955-128.png")).getImage()
			.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image patientIcon = new ImageIcon(Dashboard.class.getResource("/com/res/8720809901557740366-128.png"))
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image accountantIcon = new ImageIcon(Dashboard.class.getResource("/com/res/4664092721557740377-128.png"))
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image paymentIcon = new ImageIcon(Dashboard.class.getResource("/com/res/885494661557740359-128.png"))
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image birthreportIcon = new ImageIcon(Dashboard.class.getResource("/com/res/18548243231558965368-128.png"))
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image deathreportICon = new ImageIcon(Dashboard.class.getResource("/com/res/18548243231558965368-128.png"))
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image generalReportIcon = new ImageIcon(Dashboard.class.getResource("/com/res/3964551591557740336-128.png"))
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

	private Image userIcon = new ImageIcon(Dashboard.class.getResource("/com/res/18674310921561032515-128.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

	private Image logoImage = new ImageIcon(Dashboard.class.getResource("/com/res/2943866061606252959-128.png"))
			.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
	private JLabel pharm_icon;
	private JLabel accountant;
	private JLabel paymentcell;
	private JLabel generalReport;
	private JLabel userImage;
	private JPanel panel_2;
	private JLabel Logo;
	private JLabel logoText;
	private JTable table;
	
	static DefaultTableModel mode = new DefaultTableModel();
	
	String[] tableName = {"Payment Code", "Patient ID", "Last Name", "Status", "Payment Description", "Amount"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentProcess window = new PaymentProcess();
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
	public PaymentProcess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Account Dashboard");
		frame.setBounds(1, 1, 1400, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		contentPane = new JPanel();
		frame.getContentPane().add(contentPane);
		contentPane.setBounds(0, 0, 1380, 750);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 301, 711);
		contentPane.add(panel);
		panel.setLayout(null);

		separator_1 = new JSeparator();
		separator_1.setBounds(0, 88, 301, 23);
		panel.add(separator_1);

		image_panel = new JPanel();
		image_panel.setBounds(49, 122, 71, 68);
		panel.add(image_panel);
		image_panel.setLayout(null);

		userImage = new JLabel("");
		userImage.setBounds(4, 3, 60, 68);
		image_panel.add(userImage);
		userImage.setIcon(new ImageIcon(userIcon));
		userImage.setFont(new Font("Tahoma", Font.PLAIN, 6));

		welcome = new JLabel("Welcome,");
		welcome.setForeground(new Color(255, 255, 240));
		welcome.setFont(new Font("Tahoma", Font.ITALIC, 14));
		welcome.setBounds(132, 122, 71, 14);
		panel.add(welcome);

		userTitle = new JLabel();
		userTitle.setForeground(new Color(255, 255, 240));
		userTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userTitle.setBounds(132, 147, 71, 14);
		panel.add(userTitle);
	
		
		

		menuBar1 = new JPanel();
		menuBar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dashboard_menu.setForeground(Color.white);
				menuBar1.setBackground(new Color(65, 105, 225));
				menuBar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				dashboard_menu.setForeground(new Color(0, 191, 255));
				menuBar1.setBackground(new Color(0, 0, 139));
				menuBar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});
		menuBar1.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1.setBackground(new Color(0, 0, 139));
		menuBar1.setBounds(0, 223, 301, 41);
		panel.add(menuBar1);
		menuBar1.setLayout(null);

		dashboard_menu = new JLabel("Dashboard");
		dashboard_menu.setForeground(new Color(0, 191, 255));
		dashboard_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dashboard_menu.setBounds(64, 16, 98, 14);
		menuBar1.add(dashboard_menu);

		menuBar1_1 = new JPanel();
		menuBar1_1.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_1.setBackground(new Color(0, 0, 139));
		menuBar1_1.setBounds(0, 263, 301, 41);
		panel.add(menuBar1_1);
		menuBar1_1.setLayout(null);

		departments_menu = new JLabel("Patient ");
		departments_menu.setForeground(new Color(0, 191, 255));
		departments_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		departments_menu.setBounds(64, 11, 98, 19);
		menuBar1_1.add(departments_menu);
		menuBar1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				departments_menu.setForeground(Color.white);
				menuBar1_1.setBackground(new Color(65, 105, 225));
				menuBar1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				departments_menu.setForeground(new Color(0, 191, 255));
				menuBar1_1.setBackground(new Color(0, 0, 139));
				menuBar1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_2 = new JPanel();
		menuBar1_2.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_2.setBackground(new Color(0, 0, 139));
		menuBar1_2.setBounds(0, 303, 301, 41);
		panel.add(menuBar1_2);
		menuBar1_2.setLayout(null);

		doctor_menu = new JLabel("Pharmacy");
		doctor_menu.setForeground(new Color(0, 191, 255));
		doctor_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		doctor_menu.setBounds(64, 11, 98, 19);
		menuBar1_2.add(doctor_menu);
		menuBar1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_2.setBackground(new Color(65, 105, 225));
				doctor_menu.setForeground(Color.white);
				menuBar1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				doctor_menu.setForeground(new Color(0, 191, 255));
				menuBar1_2.setBackground(new Color(0, 0, 139));
				menuBar1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				PaymentProcess doc = new PaymentProcess();
				// doc.initialize();
				doc.frame.setVisible(true);
				doc.frame.setDefaultCloseOperation(1);
			}
		});

		menuBar1_3 = new JPanel();
		menuBar1_3.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_3.setBackground(new Color(0, 0, 139));
		menuBar1_3.setBounds(0, 343, 301, 41);
		panel.add(menuBar1_3);
		menuBar1_3.setLayout(null);

		patient_menu = new JLabel("Lab");
		patient_menu.setForeground(new Color(0, 191, 255));
		patient_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		patient_menu.setBounds(64, 11, 98, 19);
		menuBar1_3.add(patient_menu);
		menuBar1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				patient_menu.setForeground(Color.white);
				menuBar1_3.setBackground(new Color(65, 105, 225));
				menuBar1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				patient_menu.setForeground(new Color(0, 191, 255));
				menuBar1_3.setBackground(new Color(0, 0, 139));
				menuBar1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_4 = new JPanel();
		menuBar1_4.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_4.setBackground(new Color(0, 0, 139));
		menuBar1_4.setBounds(0, 383, 301, 41);
		panel.add(menuBar1_4);
		menuBar1_4.setLayout(null);

		nurses_menu = new JLabel("Nurses");
		nurses_menu.setForeground(new Color(0, 191, 255));
		nurses_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nurses_menu.setBounds(64, 11, 68, 19);
		menuBar1_4.add(nurses_menu);
		menuBar1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_4.setBackground(new Color(65, 105, 225));
				nurses_menu.setForeground(Color.white);
				menuBar1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nurses_menu.setForeground(new Color(0, 191, 255));
				menuBar1_4.setBackground(new Color(0, 0, 139));
				menuBar1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_5 = new JPanel();
		menuBar1_5.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_5.setBackground(new Color(0, 0, 139));
		menuBar1_5.setBounds(0, 423, 301, 41);
		panel.add(menuBar1_5);
		menuBar1_5.setLayout(null);

		hr_menu_1 = new JLabel("Daily Report");
		hr_menu_1.setForeground(new Color(0, 191, 255));
		hr_menu_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hr_menu_1.setBounds(64, 11, 148, 19);
		menuBar1_5.add(hr_menu_1);
		menuBar1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_5.setBackground(new Color(65, 105, 225));
				hr_menu_1.setForeground(Color.white);
				menuBar1_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hr_menu_1.setForeground(new Color(0, 191, 255));
				menuBar1_5.setBackground(new Color(0, 0, 139));
				menuBar1_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_10 = new JPanel();
		menuBar1_10.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_10.setBackground(new Color(0, 0, 139));
		menuBar1_10.setBounds(-1, 463, 301, 41);
		panel.add(menuBar1_10);
		menuBar1_10.setLayout(null);

		report_menu = new JLabel("Report");
		report_menu.setForeground(new Color(0, 191, 255));
		report_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		report_menu.setBounds(64, 11, 93, 19);
		menuBar1_10.add(report_menu);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 301, 89);
		panel.add(panel_2);
		panel_2.setLayout(null);

		Logo = new JLabel("");
		Logo.setFont(new Font("Tahoma", Font.PLAIN, 6));
		Logo.setIcon(new ImageIcon(logoImage));
		Logo.setBounds(10, 11, 81, 67);
		panel_2.add(Logo);

		logoText = new JLabel("iHMS");
		logoText.setFont(new Font("Tahoma", Font.BOLD, 40));
		logoText.setBounds(71, 11, 109, 56);
		panel_2.add(logoText);

		menuBar1_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				report_menu.setForeground(Color.white);
				menuBar1_10.setBackground(new Color(65, 105, 225));
				menuBar1_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				report_menu.setForeground(new Color(0, 191, 255));
				menuBar1_10.setBackground(new Color(0, 0, 139));
				menuBar1_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		Admin_Title = new JLabel("Doctor");
		Admin_Title.setForeground(new Color(0, 0, 139));
		Admin_Title.setFont(new Font("Tahoma", Font.BOLD, 13));
		Admin_Title.setBounds(311, 51, 56, 25);
		contentPane.add(Admin_Title);

		panel_1 = new JPanel();
		panel_1.setBounds(311, 77, 1043, 623);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 11, 1043, 14);
		panel_1.add(separator);

		dashboardTitle = new JLabel("Admin Dashboard");
		dashboardTitle.setForeground(new Color(0, 0, 139));
		dashboardTitle.setFont(new Font("Book Antiqua", Font.BOLD, 19));
		dashboardTitle.setBounds(41, 23, 173, 25);
		panel_1.add(dashboardTitle);

		doctors_panel = new JPanel();
		doctors_panel.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel.setBounds(29, 68, 269, 110);
		panel_1.add(doctors_panel);
		doctors_panel.setLayout(null);

		NumberOfDoctor = new JLabel();
		NumberOfDoctor.setForeground(new Color(0, 128, 0));
		NumberOfDoctor.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfDoctor.setBounds(27, 23, 53, 39);
		doctors_panel.add(NumberOfDoctor);
		listOfDoctors();

		lblDoctors = new JLabel("Doctors");
		lblDoctors.setForeground(new Color(0, 128, 0));
		lblDoctors.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoctors.setBounds(27, 60, 112, 39);
		doctors_panel.add(lblDoctors);

		doctor_icon = new JLabel("");
		doctor_icon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		doctor_icon.setIcon(new ImageIcon(doc));
		doctor_icon.setBounds(168, 11, 91, 88);
		doctors_panel.add(doctor_icon);

		doctors_panel_2 = new JPanel();
		doctors_panel_2.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_2.setBounds(337, 68, 269, 110);
		panel_1.add(doctors_panel_2);
		doctors_panel_2.setLayout(null);

		NumberOfPharmacist = new JLabel("0");
		NumberOfPharmacist.setForeground(new Color(148, 0, 211));
		NumberOfPharmacist.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfPharmacist.setBounds(22, 27, 53, 39);
		doctors_panel_2.add(NumberOfPharmacist);

		Pharmacist = new JLabel("Prescription");
		Pharmacist.setForeground(new Color(148, 0, 211));
		Pharmacist.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Pharmacist.setBounds(22, 60, 112, 39);
		doctors_panel_2.add(Pharmacist);

		pharm_icon = new JLabel("");
		pharm_icon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		pharm_icon.setBounds(168, 11, 91, 88);
		pharm_icon.setIcon(new ImageIcon(pharm));
		doctors_panel_2.add(pharm_icon);

		doctors_panel_1 = new JPanel();
		doctors_panel_1.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_1.setBounds(29, 350, 269, 110);
		panel_1.add(doctors_panel_1);
		doctors_panel_1.setLayout(null);

		lblPayment = new JLabel("Payment");
		lblPayment.setForeground(new Color(255, 20, 147));
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPayment.setBounds(10, 60, 112, 39);
		doctors_panel_1.add(lblPayment);

		NumberOfAccountant_1 = new JLabel("");
		NumberOfAccountant_1.setForeground(new Color(255, 20, 147));
		NumberOfAccountant_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfAccountant_1.setBounds(10, 23, 53, 39);
		doctors_panel_1.add(NumberOfAccountant_1);

		paymentcell = new JLabel("");
		paymentcell.setFont(new Font("Tahoma", Font.PLAIN, 6));
		paymentcell.setBounds(168, 11, 91, 88);
		paymentcell.setIcon(new ImageIcon(paymentIcon));
		doctors_panel_1.add(paymentcell);

		patients_panel_1 = new JPanel();
		patients_panel_1.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		patients_panel_1.setBounds(337, 209, 269, 110);
		panel_1.add(patients_panel_1);
		patients_panel_1.setLayout(null);

		NumberOfAccountant = new JLabel("4");
		NumberOfAccountant.setForeground(new Color(210, 105, 30));
		NumberOfAccountant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfAccountant.setBounds(10, 23, 53, 39);
		patients_panel_1.add(NumberOfAccountant);

		Accountants = new JLabel("Lab");
		Accountants.setForeground(new Color(210, 105, 30));
		Accountants.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Accountants.setBounds(10, 60, 112, 39);
		patients_panel_1.add(Accountants);

		accountant = new JLabel("");
		accountant.setFont(new Font("Tahoma", Font.PLAIN, 6));
		accountant.setBounds(168, 11, 91, 88);
		accountant.setIcon(new ImageIcon(accountantIcon));
		patients_panel_1.add(accountant);

		doctors_panel_3 = new JPanel();
		doctors_panel_3.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_3.setBounds(29, 209, 269, 110);
		panel_1.add(doctors_panel_3);
		doctors_panel_3.setLayout(null);

		NumberOfPatients = new JLabel();
		NumberOfPatients.setForeground(new Color(65, 105, 225));
		NumberOfPatients.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfPatients.setBounds(10, 23, 53, 39);
		doctors_panel_3.add(NumberOfPatients);
		listOfPatient();

		Patients = new JLabel("Patients");
		Patients.setForeground(new Color(65, 105, 225));
		Patients.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Patients.setBounds(10, 60, 112, 39);
		doctors_panel_3.add(Patients);

		JLabel patient_icon = new JLabel("");
		patient_icon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		patient_icon.setBounds(168, 11, 91, 88);
		patient_icon.setIcon(new ImageIcon(patientIcon));
		doctors_panel_3.add(patient_icon);

		doctors_panel_4 = new JPanel();
		doctors_panel_4.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_4.setBounds(337, 350, 269, 110);
		panel_1.add(doctors_panel_4);
		doctors_panel_4.setLayout(null);

		report = new JLabel("Operation Report");
		report.setForeground(new Color(0, 128, 128));
		report.setFont(new Font("Tahoma", Font.PLAIN, 20));
		report.setBounds(10, 60, 203, 39);
		doctors_panel_4.add(report);

		operationReport = new JLabel("15");
		operationReport.setForeground(new Color(0, 128, 128));
		operationReport.setFont(new Font("Tahoma", Font.PLAIN, 35));
		operationReport.setBounds(10, 23, 53, 39);
		doctors_panel_4.add(operationReport);

		generalReport = new JLabel("");
		generalReport.setFont(new Font("Tahoma", Font.PLAIN, 6));
		generalReport.setIcon(new ImageIcon(generalReportIcon));
		generalReport.setBounds(168, 11, 91, 88);
		doctors_panel_4.add(generalReport);

		copyright_footer = new JLabel("");
		copyright_footer.setBounds(29, 598, 100, 14);
		panel_1.add(copyright_footer);
		copyright_footer.setText("Copyright \u00a9 2014: ");

		designedBy = new JLabel("DESIGNED BY DENNIS SHABA");
		designedBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		designedBy.setForeground(new Color(0, 0, 128));
		designedBy.setBounds(122, 598, 202, 14);
		panel_1.add(designedBy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(623, 68, 410, 392);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(mode);
		mode.setColumnIdentifiers(tableName);
		table.setShowGrid(false);
		table.setShowHorizontalLines(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.setDefaultEditor(Object.class, null);
		
	
		
		JButton addpayment = new JButton("Add Payment");
		addpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewPayment pay = new addNewPayment();
				pay.frame.setVisible(true);
			}
		});
		addpayment.setBounds(637, 24, 100, 33);
		panel_1.add(addpayment);
		
		JButton btnViewPayment = new JButton("View Payment");
		btnViewPayment.setBounds(763, 24, 123, 33);
		panel_1.add(btnViewPayment);
		
		JButton btnNewButton_1_1 = new JButton("Print Details");
		btnNewButton_1_1.setBounds(906, 24, 100, 33);
		panel_1.add(btnNewButton_1_1);

		logout = new JLabel("Logout");
		logout.setForeground(new Color(0, 0, 139));
		logout.setFont(new Font("Tahoma", Font.BOLD, 13));
		logout.setBounds(1284, 51, 56, 25);
		contentPane.add(logout);
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login logout = new Login();
				logout();

			}
		});
		allPayments();
		displayPayment();

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public void logout() {
		frame.dispose();
	}

	public void listOfDoctors() {
		int doctorList = 0;

		ResultSet rs = null;
		sqlqueries count = new sqlqueries();
		rs = count.displayDoctor();
		try {
			while (rs.next()) {

				rs.getRow();

				doctorList = rs.getRow();

				NumberOfDoctor.setText(doctorList + "");
			}
		} catch (SQLException e1) {

		}

	}
	
	public void listOfPatient() {
		
		int numOfPatient = 0;

		ResultSet rs = null;
		sqlqueries count = new sqlqueries();
		rs = count.displayPatient();
		try {
			while (rs.next()) {

				rs.getRow();

				numOfPatient = rs.getRow();

				NumberOfPatients.setText(numOfPatient + "");
			}
		} catch (SQLException e1) {

		}
	}
	
	public void allPayments() {

		ResultSet rs = null;
		sqlqueries getpatient = new sqlqueries();
		rs = getpatient.allPayments();

		try {
			/*
			 * We need a while look to iterate through the database table and pass in the
			 * values to our declared String
			 * 
			 */
			while (rs.next()) {
				
				String paymCode = rs.getString("paymentCode");
				String patientID = rs.getString("patientID");
				String lname = rs.getString("lastName");
				String status = rs.getString("status");
				String billTitle = rs.getString("billingTitle");
				String billingAmount = rs.getString("billingAmount");

				// here we pass in all the data in to an array
				String[] patientData = { paymCode, patientID, lname, status, billTitle,billingAmount};
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				// here populate the table with recent data from the database
				model.addRow(patientData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewPayment() {
		
	}
	
	public void displayPayment() {
		int payment = 0;

		ResultSet rs = null;
		sqlqueries count = new sqlqueries();
		rs = count.allPayments();
		try {
			while (rs.next()) {

				rs.getRow();

				payment = rs.getRow();

				NumberOfAccountant_1.setText(payment + "");
				
			}
			if(NumberOfAccountant_1.getText()=="") {
				NumberOfAccountant_1.setText(0+"");
			}
			else {
				NumberOfAccountant_1.setText(payment + "");
			}
		} catch (SQLException e1) {

		}
	}
}

