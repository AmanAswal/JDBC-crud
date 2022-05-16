package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Welcome to Student Management App");
			System.out.println("press 1 to add students");
			System.out.println("press 2 to delete students");
			System.out.println("press 3 to display students");
			System.out.println("press 4 to update students");
			System.out.println("press 9 to exit");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				// add
				System.out.println("Enter user name: ");
				String name = br.readLine();
				
				System.out.println("Enter user phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter user city: ");
				String city = br.readLine();
				
				// create student object
				Student st = new Student(name, phone, city);
				
				boolean ans = StudentDAO.insertStudentToDB(st);
				if(ans) {
					System.out.println("student is added successfully");
				}
				else {
					System.out.println("Something went wrong, try again!");
				}
				
				System.out.println(st);
			}
			else if(c == 2) {
				// delete
				System.out.println("Enter student's Id: ");
				int userId = Integer.parseInt(br.readLine());
				
				boolean ans = StudentDAO.deleteStudent(userId);
				if(ans) {
					System.out.println("Deleted...");
				}
				else {
					System.out.println("Something went wrong!");
				}
			}
			else if(c == 3) {
				// display
				StudentDAO.showAllStudents();
			}
			else if(c == 4) {
				// update
				System.out.println("Enter student's Id: ");
				int userId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter user name: ");
				String name = br.readLine();
				
				System.out.println("Enter user phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter user city: ");
				String city = br.readLine();
				
				boolean ans = StudentDAO.updateStudent(userId, name, phone, city);
				if(ans) {
					System.out.println("Updated...");
				}
				else {
					System.out.println("Something went wrong!");
				}
			}
			else if(c == 9){
				break;
			}
			else {
				// do nothing and repeat the loop
			}
		}
	}

}
