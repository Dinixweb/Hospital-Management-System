package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	private static Connection con = null;
	public static Connection getConnection() {
		
			try {
				Class.forName("org.sqlite.JDBC");
				
				try {
					con = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\User 5\\\\Java-Core\\\\Java Database\\\\mydb\\\\HMS.db");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				
			
				e.printStackTrace();
			}
			

		return con;
		
	}

}
