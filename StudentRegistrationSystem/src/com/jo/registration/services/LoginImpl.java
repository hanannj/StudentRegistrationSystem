package com.jo.registration.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jo.registration.bo.Admin;
import com.jo.registration.bo.Department;
import com.jo.registration.bo.Instructor;
import com.jo.registration.bo.Student;
import com.jo.registration.data.Data;
import com.jo.registration.data.MySQLConnection;
import com.jo.registration.errorHandling.ErrorHandling;
import com.jo.registration.logging.Logging;

public class LoginImpl implements Login{
	static Connection conn = MySQLConnection.conn;
	public static void Login(int choice, String id, String password) throws ErrorHandling{
			boolean rs = false;
			//Check if username and password are correct
			if (choice == 1) {
				try {
					Statement stmt = conn.createStatement();
					String query = "SELECT * FROM users WHERE id = '"+ id +"' AND password = '"+ password+"';";
					rs = stmt.execute(query);
					if (rs)
						adminChoices();
					else //{System.out.println("Wrong username or password");
						Logging.logger.info("Wrong username or password");
				} catch (SQLException e) {
					throw new ErrorHandling("Error occurred during accessing SQL tables", e);
					}}
		
			if (choice == 2) {
				try {
					Statement stmt = conn.createStatement();
					String query = "SELECT * FROM users WHERE id = '"+ id +"' AND password = '"+ password+"';";
					rs = stmt.execute(query);
					if (rs)
						studentChoices();
					else //{System.out.println("Wrong username or password");
						Logging.logger.info("Wrong username or password");
				} catch (SQLException e) {
					throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		        }}
			
			if (choice == 3) {  
				try {
					Statement stmt = conn.createStatement();
					String query = "SELECT * FROM users WHERE id = '"+ id +"' AND password = '"+ password+"';";
					rs = stmt.execute(query);
					if (rs)
						instructorChoices();
					else //{System.out.println("Wrong username or password");
						Logging.logger.info("Wrong username or password");
				} catch (SQLException e) {
					throw new ErrorHandling("Error occurred during accessing SQL tables", e);
					}
				/*for (int i = 0; i<Department.instructors.size(); i++) {
					instructor = Department.instructors.get(i);
					if (username.equals(instructor.getUsername()) && password.equals(instructor.getPassword()))
						instructorChoices();
					else //System.out.println("Wrong username or password");
						Logging.logger.info("Wrong username or password");
			}*/}
			
			if (choice == 4)
				System.exit(0);
			
			}

	public static void adminChoices() throws ErrorHandling {
		System.out.print("1. Register a student\n"
				+ "2. Create a new course\n"
				+ "3. Delete a course\n"
				+ "4. View Courses\n"
				+ "5. Exit\n");
		
		try (Scanner input = new Scanner(System.in)) {
			int choice = input.nextInt();
			
			switch (choice) {
			case 1: AdminServicesImpl.registerStudent(); break;
			case 2: AdminServicesImpl.addCourse(); break;
			case 3: AdminServicesImpl.deleteCourse(); break;
			case 4: AdminServicesImpl.viewCourses(); break;
			case 5: System.exit(0); //break;
			default:
				System.out.println("Invalid choice, please try again");
				adminChoices();
			}
			input.close();
			//adminChoices();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while choosing", ex);
        }}
	
	public static void studentChoices() throws ErrorHandling {
		System.out.print("1. Register a course\n"
				+ "2. Drop a course\n"
				+ "3. View registered courses\n"
				+ "4. View all courses\n"
				+ "5. Exit\n");
		
		try (Scanner input = new Scanner(System.in)) {
			int choice = input.nextInt();
			
			switch (choice) {
			case 1: StudentServicesImpl.registerCourse(); break;
			case 2: StudentServicesImpl.dropCourse(); break;
			case 3: StudentServicesImpl.viewRegisteredCourses(); break;
			case 4: StudentServicesImpl.viewAllCourses(); break;
			case 5: System.exit(0);
			default:
				System.out.println("Invalid choice, please try again");
				studentChoices();
			}
			input.close();
			//studentChoices();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while choosing", ex);
        }
	}
	
	public static void instructorChoices() throws ErrorHandling {
		System.out.print("1. View student\n"
				+ "2. Students names in course\n"
				+ "3. Display information\n"
				+ "4. View courses\n"
				+ "5. Exit\n");
		
		try (Scanner input = new Scanner(System.in)) {
			int choice = input.nextInt();
			
			switch (choice) {
			case 1: InstructorServicesImpl.viewStudent(); break;
			case 2: InstructorServicesImpl.studentsNamesInCourse(); break;
			case 3: InstructorServicesImpl.displayInfo(); break;
			case 4: InstructorServicesImpl.viewCourses(); break;
			case 5: System.exit(0);
			default:
				System.out.println("Invalid choice, please try again");
				instructorChoices();
			}
			input.close();
			//instructorChoices();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while choosing", ex);
        }
	}
}
