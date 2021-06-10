package com.Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;

import com.connection.sqlqueries;
import com.doctor.DoctorWindow;

import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;

public class Dashboard{

	private JPanel contentPane;
	JLabel logout;
	private JLabel Admin_Title;
	private JPanel panel_1;
	private JLabel dashboardTitle;
	private JPanel doctors_panel;
	private JPanel patients_panel;
	private JPanel doctors_panel_2;
	private JPanel doctors_panel_1;
	private JPanel patients_panel_1;
	private JPanel doctors_panel_3;
	private JPanel doctors_panel_4;
	private JPanel patients_panel_2;
	private JPanel doctors_panel_5;
	private JLabel NumberOfDoctor;
	private JLabel lblDoctors;
	private JLabel NumberOfNurses;
	private JLabel Nurses;
	private JLabel NumberOfPharmacist;
	private JLabel Pharmacist;
	private JLabel NumberOfPatients;
	private JLabel Patients;
	private JLabel NumberOfAccountant;
	private JLabel Accountants;
	private JLabel lblPayment;
	private JLabel NumberOfAccountant_1;
	private JLabel Birth;
	private JLabel NumberOfBirth;
	private JLabel Deth;
	private JLabel NumberOfDeath;
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
	private JPanel menuBar1_6;
	private JPanel menuBar1_7;
	private JPanel menuBar1_8;
	private JPanel menuBar1_9;
	private JPanel menuBar1_10;
	private JLabel dashboard_menu;
	private JLabel departments_menu;
	private JLabel doctor_menu;
	private JLabel patient_menu;
	private JLabel nurses_menu;
	private JLabel hr_menu_1;
	private JLabel Pharmacist_menu_2;
	private JLabel Payment_menu;
	private JLabel Accoutant_menu_1;
	private JLabel report_menu;
	private JLabel Settings_menu_1;

	static JFrame frame;
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

	private JLabel nurses_icon;
	private JLabel menu_icon;
	private JLabel pharm_icon;
	private JLabel accountant;
	private JLabel paymentcell;
	private JLabel reportBirth;
	private JLabel reportDeath;
	private JLabel generalReport;
	private JLabel userImage;
	private JPanel panel_2;
	private JLabel Logo;
	private JLabel logoText;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1380, 750);
		frame.setVisible(true);
		frame.setTitle("iHospital Management System - Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		userGreetings();
		
		

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

		departments_menu = new JLabel("Department");
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

		doctor_menu = new JLabel("Users");
		doctor_menu.setForeground(new Color(0, 191, 255));
		doctor_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		doctor_menu.setBounds(64, 11, 61, 19);
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
				Users doc = new Users();
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

		patient_menu = new JLabel("Patients");
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

		hr_menu_1 = new JLabel("Human Resource");
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

		menuBar1_6 = new JPanel();
		menuBar1_6.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_6.setBackground(new Color(0, 0, 139));
		menuBar1_6.setBounds(0, 462, 301, 41);
		panel.add(menuBar1_6);
		menuBar1_6.setLayout(null);

		Pharmacist_menu_2 = new JLabel("Pharmacist");
		Pharmacist_menu_2.setForeground(new Color(0, 191, 255));
		Pharmacist_menu_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Pharmacist_menu_2.setBounds(64, 11, 113, 19);
		menuBar1_6.add(Pharmacist_menu_2);
		menuBar1_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_6.setBackground(new Color(65, 105, 225));
				Pharmacist_menu_2.setForeground(Color.white);
				menuBar1_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Pharmacist_menu_2.setForeground(new Color(0, 191, 255));
				menuBar1_6.setBackground(new Color(0, 0, 139));
				menuBar1_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_7 = new JPanel();
		menuBar1_7.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_7.setBackground(new Color(0, 0, 139));
		menuBar1_7.setBounds(0, 502, 301, 41);
		panel.add(menuBar1_7);
		menuBar1_7.setLayout(null);

		Payment_menu = new JLabel("Payment");
		Payment_menu.setForeground(new Color(0, 191, 255));
		Payment_menu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Payment_menu.setBounds(64, 11, 81, 19);
		menuBar1_7.add(Payment_menu);
		menuBar1_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_7.setBackground(new Color(65, 105, 225));
				Payment_menu.setForeground(Color.white);
				menuBar1_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Payment_menu.setForeground(new Color(0, 191, 255));
				menuBar1_7.setBackground(new Color(0, 0, 139));
				menuBar1_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_8 = new JPanel();
		menuBar1_8.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_8.setBackground(new Color(0, 0, 139));
		menuBar1_8.setBounds(0, 542, 301, 41);
		panel.add(menuBar1_8);
		menuBar1_8.setLayout(null);

		Accoutant_menu_1 = new JLabel("Accoutant");
		Accoutant_menu_1.setForeground(new Color(0, 191, 255));
		Accoutant_menu_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Accoutant_menu_1.setBounds(62, 11, 93, 19);
		menuBar1_8.add(Accoutant_menu_1);
		menuBar1_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuBar1_8.setBackground(new Color(64, 105, 225));
				Accoutant_menu_1.setForeground(Color.white);
				menuBar1_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Accoutant_menu_1.setForeground(new Color(0, 191, 255));
				menuBar1_8.setBackground(new Color(0, 0, 139));
				menuBar1_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_9 = new JPanel();
		menuBar1_9.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_9.setBackground(new Color(0, 0, 139));
		menuBar1_9.setBounds(0, 621, 301, 41);
		panel.add(menuBar1_9);
		menuBar1_9.setLayout(null);

		Settings_menu_1 = new JLabel("Settings");
		Settings_menu_1.setForeground(new Color(0, 191, 255));
		Settings_menu_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Settings_menu_1.setBounds(64, 11, 72, 19);
		menuBar1_9.add(Settings_menu_1);
		menuBar1_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Settings_menu_1.setForeground(Color.white);
				menuBar1_9.setBackground(new Color(65, 105, 225));
				menuBar1_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Settings_menu_1.setForeground(new Color(0, 191, 255));
				menuBar1_9.setBackground(new Color(0, 0, 139));
				menuBar1_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});

		menuBar1_10 = new JPanel();
		menuBar1_10.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 205)));
		menuBar1_10.setBackground(new Color(0, 0, 139));
		menuBar1_10.setBounds(0, 581, 301, 41);
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

		menu_icon = new JLabel("");
		menu_icon.setBounds(241, 26, 50, 41);
		panel_2.add(menu_icon);
		menu_icon.setBackground(new Color(0, 128, 0));
		menu_icon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		menu_icon.setIcon(new ImageIcon(menu));
		menu_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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

		Admin_Title = new JLabel("Admin");
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

		patients_panel = new JPanel();
		patients_panel.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		patients_panel.setBounds(377, 68, 269, 110);
		panel_1.add(patients_panel);
		patients_panel.setLayout(null);

		NumberOfNurses = new JLabel("5");
		NumberOfNurses.setForeground(new Color(0, 0, 205));
		NumberOfNurses.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfNurses.setBounds(24, 25, 53, 39);
		patients_panel.add(NumberOfNurses);

		Nurses = new JLabel("Nurses");
		Nurses.setForeground(new Color(0, 0, 205));
		Nurses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Nurses.setBounds(24, 60, 112, 39);
		patients_panel.add(Nurses);

		nurses_icon = new JLabel("");
		nurses_icon.setFont(new Font("Tahoma", Font.PLAIN, 6));
		nurses_icon.setIcon(new ImageIcon(nurse));
		nurses_icon.setBounds(168, 11, 91, 88);
		patients_panel.add(nurses_icon);

		doctors_panel_2 = new JPanel();
		doctors_panel_2.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_2.setBounds(733, 68, 269, 110);
		panel_1.add(doctors_panel_2);
		doctors_panel_2.setLayout(null);

		NumberOfPharmacist = new JLabel("10");
		NumberOfPharmacist.setForeground(new Color(148, 0, 211));
		NumberOfPharmacist.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfPharmacist.setBounds(22, 27, 53, 39);
		doctors_panel_2.add(NumberOfPharmacist);

		Pharmacist = new JLabel("Pharmacist");
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
		doctors_panel_1.setBounds(733, 209, 269, 110);
		panel_1.add(doctors_panel_1);
		doctors_panel_1.setLayout(null);

		lblPayment = new JLabel("Payment");
		lblPayment.setForeground(new Color(255, 20, 147));
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPayment.setBounds(10, 60, 112, 39);
		doctors_panel_1.add(lblPayment);

		NumberOfAccountant_1 = new JLabel("35");
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
		patients_panel_1.setBounds(377, 209, 269, 110);
		panel_1.add(patients_panel_1);
		patients_panel_1.setLayout(null);

		NumberOfAccountant = new JLabel("4");
		NumberOfAccountant.setForeground(new Color(210, 105, 30));
		NumberOfAccountant.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfAccountant.setBounds(10, 23, 53, 39);
		patients_panel_1.add(NumberOfAccountant);

		Accountants = new JLabel("Accountants");
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

		NumberOfPatients = new JLabel("56");
		NumberOfPatients.setForeground(new Color(65, 105, 225));
		NumberOfPatients.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfPatients.setBounds(10, 23, 53, 39);
		doctors_panel_3.add(NumberOfPatients);

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
		doctors_panel_4.setBounds(733, 361, 269, 110);
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

		patients_panel_2 = new JPanel();
		patients_panel_2.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		patients_panel_2.setBounds(377, 361, 269, 110);
		panel_1.add(patients_panel_2);
		patients_panel_2.setLayout(null);

		Deth = new JLabel("Death Report");
		Deth.setForeground(new Color(255, 0, 0));
		Deth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Deth.setBounds(10, 60, 139, 39);
		patients_panel_2.add(Deth);

		NumberOfDeath = new JLabel("0");
		NumberOfDeath.setForeground(new Color(255, 0, 0));
		NumberOfDeath.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfDeath.setBounds(10, 23, 53, 39);
		patients_panel_2.add(NumberOfDeath);

		reportDeath = new JLabel("");
		reportDeath.setFont(new Font("Tahoma", Font.PLAIN, 6));
		reportDeath.setIcon(new ImageIcon(deathreportICon));
		reportDeath.setBounds(168, 11, 91, 88);
		patients_panel_2.add(reportDeath);

		doctors_panel_5 = new JPanel();
		doctors_panel_5.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		doctors_panel_5.setBounds(29, 361, 269, 110);
		panel_1.add(doctors_panel_5);
		doctors_panel_5.setLayout(null);

		Birth = new JLabel("Birth Report");
		Birth.setForeground(new Color(50, 205, 50));
		Birth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Birth.setBounds(10, 60, 112, 39);
		doctors_panel_5.add(Birth);

		NumberOfBirth = new JLabel("22");
		NumberOfBirth.setForeground(new Color(50, 205, 50));
		NumberOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 35));
		NumberOfBirth.setBounds(10, 23, 53, 39);
		doctors_panel_5.add(NumberOfBirth);

		reportBirth = new JLabel("");
		reportBirth.setFont(new Font("Tahoma", Font.PLAIN, 6));
		reportBirth.setIcon(new ImageIcon(birthreportIcon));
		reportBirth.setBounds(168, 11, 91, 88);
		doctors_panel_5.add(reportBirth);

		copyright_footer = new JLabel("");
		copyright_footer.setBounds(29, 598, 100, 14);
		panel_1.add(copyright_footer);
		copyright_footer.setText("Copyright \u00a9 2014: ");

		designedBy = new JLabel("DESIGNED BY DENNIS SHABA");
		designedBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		designedBy.setForeground(new Color(0, 0, 128));
		designedBy.setBounds(122, 598, 202, 14);
		panel_1.add(designedBy);

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
	
	public void userGreetings() {
	}
}
