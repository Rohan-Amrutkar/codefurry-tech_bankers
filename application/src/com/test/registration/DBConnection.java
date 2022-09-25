package com.test.registration;

import java.sql.*;

public class DBConnection {
	Connection conn = null;
	public Connection getConn() {
		String url = "jdbc:mysql://localhost:3306/codefury";
		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
//				DriverManager.registerDriver (new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection (url, "root", "Rnay@75078");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}
