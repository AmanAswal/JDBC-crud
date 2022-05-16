package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

	public static boolean insertStudentToDB(Student st) {
		boolean flag = false;
		try {
			// jdbc code
			Connection con = ConnectionProvider.createConnection();

			// query
			String q = "insert into students(sName, sPhone, sCity) values(?,?,?)";

			// PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);

			// set values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			// execute the update
			pstmt.executeUpdate();
			flag = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {

		boolean flag = false;
		try {
			// jdbc code
			Connection con = ConnectionProvider.createConnection();

			// query
			String q = "delete from students where sId=?";

			// PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);

			// set values of parameters
			pstmt.setInt(1, userId);

			// execute the update
			pstmt.executeUpdate();
			flag = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}

	public static void showAllStudents() {
		try {
			// jdbc code
			Connection con = ConnectionProvider.createConnection();

			// query
			String q = "select * from students";

			// Statement
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("sCity");
				
				System.out.println("ID : " + id);
				System.out.println("Name : " + name);
				System.out.println("Phone : " + phone);
				System.out.println("City : " + city);
				
				System.out.println("------------------------------");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static boolean updateStudent(int userId, String name, String phone, String city) {

		boolean flag = false;
		try {
			// jdbc code
			Connection con = ConnectionProvider.createConnection();

			// query
			String q = "update students set sName=?, sPhone=?, sCity=? where sId=?";

			// PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);

			// set values of parameters
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, city);
			pstmt.setInt(4, userId);

			// execute the update
			pstmt.executeUpdate();
			flag = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}
}
