package com.records;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.Admin.Dashboard;
import com.Admin.Login;
import com.account.PaymentProcess;
import com.connection.dbconnection;
import com.connection.sqlqueries;
import com.doctor.DoctorWindow;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.JTabbedPane;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class Records {

	private JPanel contentPane;
	JLabel logout;
	private JLabel Admin_Title;
	private JPanel panel_1;
	private JLabel dashboardTitle;
	private JPanel doctors_panel;
	private JPanel patients_panel;
	private JPanel doctors_panel_3;
	private JPanel doctors_panel_4;
	private JLabel NumberOfDoctor;
	private JLabel lblDoctors;
	public static JLabel NumberOfPatients;
	private JLabel Patients;
	private JLabel lblPayment;
	private JLabel NumberOfAccountant_1;
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
	private JLabel payment;
	private JLabel addPatient;
	private JLabel labResult;
	private JLabel nurses_menu;
	private JLabel dailyReport;
	private JLabel report_menu;
	JPanel chartPanel;

	// Properties for setting up new JFrame
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
	static JTextField paymentStatus;
	static JTextField numOfVisit;

	// Object for viewing patient details
	static Object $pID, $fname, $lName, $dob, $mStatus, $numofChildren, $phonNum, $email, $nokName, $nokPhone,
			$nokEmail, $numOfVisit;

	// object for booking table
	static Object $_patientID, $_fname, $_lname, $_dateOfBirth, $_maritalStatus, $_numOfChildren, $_numOfVisit;

	public static JFrame frame, recordsFrame;
	private JLabel doctor_icon;

	static TableRowSorter sorter;

	String[] patientdata = { "PatientID", "First Name", "Last Name", "Date of Birth", "Marital Status",
			"Number of Children", "Phone", "Email", "Next of Kin Name", "NOK Phone", "NOK Email", "Date" };

	String[] booked = { "PatientID", "First Name", "Last Name", "Date of Birth", "Marital Status", "Number of Children", "Date of Visit" };

	static DefaultTableModel model = new DefaultTableModel();
	static DefaultTableModel model2 = new DefaultTableModel();

	int[] list = { 1, 2, 3 };

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
	private JLabel paymentcell;
	private JLabel generalReport;
	private JLabel userImage;
	private JPanel panel_2;
	private JLabel Logo;
	private JLabel logoText;
	public static JTable table, table2;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextField searchBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Records window = new Records();
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
	public Records() {
		initialize();
		displayPatient();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	// Record frame
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1, 1, 1400, 800);
		frame.setTitle("Records Dashboard");
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
		menuBar1_1.setBounds(0, 303, 301, 41);
		panel.add(menuBar1_1);
		menuBar1_1.setLayout(null);

		payment = new JLabel("Payment");
		payment.setForeground(new Color(0, 191, 255));
		payment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		payment.setBounds(64, 11, 98, 19);
		menuBar1_1.add(payment);
		menuBar1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				payment.setForeground(Color.white);
				menuBar1_1.setBackground(new Color(65, 105, 225));
				menuBar1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				payment.setForeground(new Color(0, 191, 255));
				menuBar1_1.setBackground(new Color(0, 0, 139));
				menuBar1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_2 = new JPanel();
		menuBar1_2.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_2.setBackground(new Color(0, 0, 139));
		menuBar1_2.setBounds(0, 263, 301, 41);
		panel.add(menuBar1_2);
		menuBar1_2.setLayout(null);

		addPatient = new JLabel("Add Patient");
		addPatient.setForeground(new Color(0, 191, 255));
		addPatient.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addPatient.setBounds(64, 11, 98, 19);
		menuBar1_2.add(addPatient);
		menuBar1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_2.setBackground(new Color(65, 105, 225));
				addPatient.setForeground(Color.white);
				menuBar1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {

				addPatient.setForeground(new Color(0, 191, 255));
				menuBar1_2.setBackground(new Color(0, 0, 139));
				menuBar1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Patientadd doc = new Patientadd();
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

		labResult = new JLabel("Lab Result");
		labResult.setForeground(new Color(0, 191, 255));
		labResult.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labResult.setBounds(64, 11, 98, 19);
		menuBar1_3.add(labResult);
		menuBar1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labResult.setForeground(Color.white);
				menuBar1_3.setBackground(new Color(65, 105, 225));
				menuBar1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labResult.setForeground(new Color(0, 191, 255));
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

		dailyReport = new JLabel("Daily Report");
		dailyReport.setForeground(new Color(0, 191, 255));
		dailyReport.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dailyReport.setBounds(64, 11, 148, 19);
		menuBar1_5.add(dailyReport);
		menuBar1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_5.setBackground(new Color(65, 105, 225));
				dailyReport.setForeground(Color.white);
				menuBar1_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dailyReport.setForeground(new Color(0, 191, 255));
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

		Admin_Title = new JLabel("Records");
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

		dashboardTitle = new JLabel("Records Dashboard");
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

		patients_panel = new JPanel();
		patients_panel.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		patients_panel.setBounds(29, 335, 269, 110);
		panel_1.add(patients_panel);
		patients_panel.setLayout(null);

		JLabel patient_icon = new JLabel("");
		patient_icon.setBounds(168, 11, 91, 88);
		patients_panel.add(patient_icon);
		patient_icon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		patient_icon.setIcon(new ImageIcon(patientIcon));

		Patients = new JLabel("Patients");
		Patients.setBounds(10, 60, 112, 39);
		patients_panel.add(Patients);
		Patients.setForeground(new Color(65, 105, 225));
		Patients.setFont(new Font("Tahoma", Font.PLAIN, 20));

		NumberOfPatients = new JLabel();
		NumberOfPatients.setBounds(10, 11, 53, 39);
		patients_panel.add(NumberOfPatients);
		NumberOfPatients.setForeground(new Color(65, 105, 225));
		NumberOfPatients.setFont(new Font("Tahoma", Font.PLAIN, 35));

		doctors_panel_3 = new JPanel();
		doctors_panel_3.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_3.setBounds(29, 200, 269, 110);
		panel_1.add(doctors_panel_3);
		doctors_panel_3.setLayout(null);

		NumberOfAccountant_1 = new JLabel("35");
		NumberOfAccountant_1.setBounds(10, 23, 53, 39);
		doctors_panel_3.add(NumberOfAccountant_1);
		NumberOfAccountant_1.setForeground(new Color(255, 20, 147));
		NumberOfAccountant_1.setFont(new Font("Tahoma", Font.PLAIN, 35));

		lblPayment = new JLabel("Payment");
		lblPayment.setBounds(10, 60, 112, 39);
		doctors_panel_3.add(lblPayment);
		lblPayment.setForeground(new Color(255, 20, 147));
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));

		paymentcell = new JLabel("");
		paymentcell.setBounds(168, 11, 91, 88);
		doctors_panel_3.add(paymentcell);
		paymentcell.setFont(new Font("Tahoma", Font.PLAIN, 6));
		paymentcell.setIcon(new ImageIcon(paymentIcon));
		listOfPatient();

		doctors_panel_4 = new JPanel();
		doctors_panel_4.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_4.setBounds(29, 470, 269, 110);
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

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(308, 69, 725, 285);
		panel_1.add(tabbedPane);

		scrollPane = new JScrollPane();
		tabbedPane.addTab("Patient Data", null, scrollPane, null);

		table = new JTable();
		table.setModel(model);
		model.setColumnIdentifiers(patientdata);
		// Setting table column width
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
		table.getColumnModel().getColumn(10).setPreferredWidth(150);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);
		table.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(table);
		table.setShowGrid(false);
		table.setShowHorizontalLines(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Booked Patient", null, scrollPane_2, null);

		table2 = new JTable();
		table2.setModel(model2);
		model2.setColumnIdentifiers(booked);
		// Setting table column width
		table2.getColumnModel().getColumn(0).setPreferredWidth(80);
		table2.getColumnModel().getColumn(1).setPreferredWidth(150);
		table2.getColumnModel().getColumn(2).setPreferredWidth(150);
		table2.getColumnModel().getColumn(3).setPreferredWidth(150);
		table2.getColumnModel().getColumn(4).setPreferredWidth(150);
		table2.getColumnModel().getColumn(5).setPreferredWidth(150);
		table2.getColumnModel().getColumn(6).setPreferredWidth(150);
		table2.setDefaultEditor(Object.class, null);

		scrollPane_2.setViewportView(table2);
		table2.setShowGrid(false);
		table2.setShowHorizontalLines(true);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(586, 15, 447, 71);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		final JButton view = new JButton("View Data");
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				generateData();
				
				//new Booked().chartDisplay();;
				
				//chartDisplay();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				view.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				view.setBackground(null);
			}
		});
		view.setBounds(10, 11, 122, 35);
		panel_3.add(view);

		final JButton bookeddata = new JButton("Booked Data");
		bookeddata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispayBooked();

			}
		});

		bookeddata.setBounds(156, 11, 122, 35);
		panel_3.add(bookeddata);
		bookeddata.addMouseListener(new MouseAdapter() {

			public void actionPerformed(ActionEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				bookeddata.setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bookeddata.setBackground(null);
			}

		});

		final JButton print = new JButton("Print Slip");
		print.addMouseListener(new MouseAdapter() {
			public void actionPerformed(ActionEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
				print.setBackground(Color.ORANGE);
			}

			public void mouseExited(MouseEvent e) {
				print.setBackground(null);
			}
		});
		print.setBounds(298, 11, 122, 35);
		panel_3.add(print);

		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchMain();
			}
		});
		searchBox.setBounds(308, 27, 138, 31);
		panel_1.add(searchBox);
		searchBox.setColumns(10);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMain();
			}

		});
		searchButton.setBounds(456, 26, 89, 32);
		panel_1.add(searchButton);
		
		chartPanel = new JPanel();
		chartPanel.setBounds(308, 365, 725, 215);
		panel_1.add(chartPanel);
		chartPanel.setLayout(null);

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
		
		BookPatient.retrieveBookedData();
		displayPayment();
		

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	// Logout function
	public void logout() {
		frame.dispose();
	}

	// Retrieving list of doc in database method
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

	// Retrieving list of patient in database method
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

	// Displaying patient data in a table
	public static void displayPatient() {

		ResultSet rs = null;
		sqlqueries getpatient = new sqlqueries();
		rs = getpatient.dipslayPatients();

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
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				String nextOfKinName = rs.getString("nextOfKinName");
				String nextOfKinPhone = rs.getString("nextOfKinPhone");
				String nextOfKinEmail = rs.getString("nextOfKinEmail");
				String date = rs.getString("date");

				// here we pass in all the data in to an array
				String[] patientData = { patientID, fname, lname, dateOfBirth, maritalStatus, NumofChildren,
						phoneNumber, email, nextOfKinName, nextOfKinPhone, nextOfKinEmail, date };
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				// here populate the table with recent data from the database
				model.addRow(patientData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void generateData() {

		frame = new JFrame();
		frame.setBounds(100, 100, 728, 480);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(1);
		frame.setTitle("Patient Bio Data");
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

		JLabel lblNumberOfVisit = new JLabel("Date Visited");
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

		pushData();
		

	}

	public void pushData() {
		int get = table.getSelectedRow();
		
		if (get >= 0) {
			try {

				$pID = table.getValueAt(get, 0);
				$fname = table.getValueAt(get, 1);
				$lName = table.getValueAt(get, 2);
				$dob = table.getValueAt(get, 3);
				$mStatus = table.getValueAt(get, 4);
				$numofChildren = table.getValueAt(get, 5);
				$phonNum = table.getValueAt(get, 6);
				$email = table.getValueAt(get, 7);
				$nokName = table.getValueAt(get, 8);
				$nokPhone = table.getValueAt(get, 9);
				$nokEmail = table.getValueAt(get, 10);
				$numOfVisit = table.getValueAt(get, 11);

				patientID.setText($pID + "");
				fName.setText($fname + "");
				lName.setText($lName + "");
				dateOfBirth.setText($dob + "");
				maritalStatus.setText($mStatus + "");
				numOfChild.setText($numofChildren + "");
				emailID.setText($phonNum + "");
				phoneNumber.setText($email + "");
				nokName.setText($nokName + "");
				nokPhone.setText($nokPhone + "");
				nokEmail.setText($nokEmail + "");
				numOfVisit.setText($numOfVisit + "");

//		paymentStatus.setText("Paid");

				/*
				 * in order to retrieving payment status from the database we need to connect to
				 * the table
				 */
//				ResultSet rs = null;
//				sqlqueries count = new sqlqueries();
//				rs = count.displayPayment();
//				String dis = patientID.getText();
//
//				try {
//					// We need a while loop to go through each line on the table
//					while (rs.next()) {
//
//						// Here I assigned a column name PatientID to a string $patientID
//						String $patientID = rs.getString("PatientID");
//
//						/*
//						 * I then pass the String into an array, bcos we will be retrieving multiple
//						 * data from the PatientID column
//						 */
//						String[] $newpatientID = { $patientID };
//						int i;
//
//						// after that we need a for loop to go through the data
//						for (i = 0; i < $newpatientID.length; i++) {
//
//							// here if the data matches with the displayed PatientID
//							if ($newpatientID[i].equals(dis)) {
//								// then its meant to return the payment status of the PatientID
//								String rel = rs.getString("paymentStatus");
//
//								// We can then display the payment status here
//								paymentStatus.setText(rel);
//
//								if (paymentStatus.getText().equals("Paid")) {
//									paymentStatus.setForeground(new Color(0, 128, 0));
//								} else {
//									paymentStatus.setForeground(Color.RED);
//								}
//
//							}
//						}
//					}
//					
//				} catch (SQLException e1) {
//
//				}
//				finally {
//					try {
//						rs.close();
//					}
//					catch(Exception e) {
//						
//					}
//				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Select a data");
		}

	}

	public void dispayBooked() {//this methods is use to view the details of patients
		
		BookPatient bok = new BookPatient();
		bok.frame.setDefaultCloseOperation(1);

		int post = table.getSelectedRow();
		if (post >= 0) {
			BookPatient.frame.setVisible(true);
			$_patientID = table.getValueAt(post, 0);
			$_fname = table.getValueAt(post, 1);
			$_lname = table.getValueAt(post, 2);
			$_dateOfBirth = table.getValueAt(post, 3);
			$_maritalStatus = table.getValueAt(post, 4);
			$_numOfChildren = table.getValueAt(post, 5);
			$_numOfVisit = table.getValueAt(post, 11);

			BookPatient.search.setText($_patientID + "");
			BookPatient.$firstName.setText($_fname + "");
			BookPatient.$lastName.setText($_lname + "");
			BookPatient.$dateOfBirth.setText($_dateOfBirth + "");
			BookPatient.$maritalStatus.setText($_maritalStatus + "");
			BookPatient.$numOfChildren.setText($_numOfChildren + "");
			BookPatient.$dayOfVisit.setText($_numOfVisit + "");

		} else {
			BookPatient.frame.setVisible(true);
		}

	}

	// This method will search through the table
	public void searchMain() {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		TableRowSorter<DefaultTableModel> tr2 = new TableRowSorter<DefaultTableModel>(model2);
		table.setRowSorter(tr);
		table2.setRowSorter(tr2);
		tr.setRowFilter(RowFilter.regexFilter(searchBox.getText().trim()));
		tr2.setRowFilter(RowFilter.regexFilter(searchBox.getText().trim()));

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


class Booked {

	public void pushBookedData() {
		DefaultTableModel mymodel = (DefaultTableModel) Records.table2.getModel();
		Records.table2.setModel(mymodel);

		Object[] mybookeddata = { BookPatient.search.getText(), BookPatient.$firstName.getText(),
				BookPatient.$lastName.getText(), BookPatient.$dateOfBirth.getText(),
				BookPatient.$maritalStatus.getText(), BookPatient.$dayOfVisit.getText(),
				BookPatient.$numOfChildren.getText() };

		mymodel.addRow(mybookeddata);
	}

	public void generateBaseOnID() {

		ResultSet rs = null;
		sqlqueries count = new sqlqueries();
		rs = count.dipslayPatients();
		String dis = BookPatient.search.getText();

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
					if ($newpatientID[i].equals(dis)) {
						// then its meant to return the payment status of the PatientID
						//String rel = rs.getString("firstName");
						String myfname = rs.getString("firstName");
						String mylname = rs.getString("lastName");
						String dob = rs.getString("dateOfBirth");
						String mStatus =rs.getString("maritalStatus");
						String numofChild = rs.getString("NumOfChildren");
						String numvisit = rs.getString("date");

						//BookPatient.search.setText(Records.$_patientID + "");
						BookPatient.$firstName.setText(myfname);
						BookPatient.$lastName.setText(mylname);
						BookPatient.$dateOfBirth.setText(dob);
						BookPatient.$maritalStatus.setText(mStatus);
						BookPatient.$numOfChildren.setText(numofChild);
						BookPatient.$dayOfVisit.setText(numvisit);

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	
	public void chartDisplay() {
		
		
		String query = "SELECT Patient.patientID, BookedData.patientID FROM Patient JOIN BookedData ON Patient.patientID = BookedData.patientID";
		
		try {
			JDBCCategoryDataset cht = new JDBCCategoryDataset(dbconnection.getConnection(), query);
			JFreeChart mychart =ChartFactory.createLineChart("Patient Data", "Patient ID", "Booked Data", cht, PlotOrientation.VERTICAL, false, true, true);
			BarRenderer render = null;
			CategoryPlot plot = null;
			render = new BarRenderer();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
