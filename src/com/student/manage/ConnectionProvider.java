package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;

	public static Connection createConnection() {

		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// create the connection
			String url = "jdbc:mysql://localhost:3306/student_manage?autoReconnect=true&useSSL=false";
			String user = "root";
			String password = "1199";

			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
}
