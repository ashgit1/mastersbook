package com.atl.mb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	/*
	private static String driver = "org.apache.derby.jdbc.ClientDriver";
	private static String url = "jdbc:derby://localhost:1527/timetracker";
	*/
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mb";
	private static String uname = "root";
	private static String passwd = "Root@123";

	static {
		try {
			Class.forName(driver);
			System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,uname,passwd);
			System.out.println("Connection to timetracker establish...");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
