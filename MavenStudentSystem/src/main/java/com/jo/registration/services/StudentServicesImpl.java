package com.jo.registration.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.jo.registration.boo.Course;
import com.jo.registration.boo.Department;
import com.jo.registration.boo.Student;
import com.jo.registration.errorHandling.ErrorHandling;

public class StudentServicesImpl implements StudentServices{
	
	public static void registerCourse() throws ErrorHandling {
		Course course = new Course();
		//ArrayList<String> regCourse = new ArrayList<String>();
		try (Scanner input = new Scanner(System.in)) {
			//Enter course ID
			System.out.print("Enter courseID: ");
			String courseID = input.nextLine();
			//Add course to student's list of registered courses
			//Add student name to registered students of the course
			System.out.println("Verify ID: ");
			String id = input.nextLine();
			
			/*try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "INSERT INTO studentcourses VALUES ("+ id + ", " + courseID + ");";
				stmt.execute(query);
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}		
		catch (Exception ex) {
			throw new ErrorHandling("Error occurred during course registration", ex);}*/
			
			/*for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					if (course.getEnrolledStudents() == course.getMaxStudents()) {
						System.out.println("Course is full.");
						break;}
					course.enrolledStudents++;
					course.students.add(firstName + " " + lastName);
					}
				}*/
		
	}
	}
	
	public static void dropCourse() throws ErrorHandling {
		Course course = new Course();
		ArrayList<String> regCourse = new ArrayList<String>();
		try (Scanner input = new Scanner(System.in)) {
			//Enter course ID
			System.out.print("Enter courseID: ");
			String courseID = input.nextLine();
			//delete course from student's list of registered courses
			//Add student name to registered students of the course
			System.out.println("Verify ID: ");
			String id = input.nextLine();}
			
			/*try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "DELETE FROM studentcourses WHERE student_id ="+ id + "AND course_id = "
				+ courseID + ";";
				stmt.execute(query);
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}		*/
		//catch (Exception ex) {
			//throw new ErrorHandling("Error occurred during course registration", ex);}
					
		
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred during dropping the course", ex);
        }		}
	
	public static void viewRegisteredCourses() throws ErrorHandling {
		/*ResultSet rs = null;
		PreparedStatement p = null;
		try(Scanner input = new Scanner(System.in);){
			try {	
				System.out.println("Verify ID: ");
				String id = input.nextLine();
				String query = "SELECT * FROM studentcourses WHERE student_id = " + id;
				p = MySQLConnection.conn.prepareStatement(query);
				rs = p.executeQuery();
				while (rs.next()) {
	                int student_id = rs.getInt("student_id");
	                String course_id = rs.getString("course_id");
	                System.out.println(course_id);
	            }
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}	
}
		catch (Exception ex) {
			throw new ErrorHandling("Error occurred during course registration", ex);}*/}
		
		
	public static void viewAllCourses() throws ErrorHandling {
		/*ResultSet rs = null;
		PreparedStatement p = null;
		try {
			String query = "SELECT * FROM course";
			p = MySQLConnection.conn.prepareStatement(query);
			rs = p.executeQuery();
			
			while (rs.next()) {
				String courseName = rs.getString("course_name");
                int courseID = rs.getInt("course_id");
                int maxStudents = rs.getInt("max_students");
                int enrolledStudents = rs.getInt("enrolled_students");
                int departmentID = rs.getInt("department_id");
                System.out.println(courseName + "\t\t" + courseID
                                   + "\t\t" + maxStudents + "\t\t" + enrolledStudents + "\t\t" + departmentID);
            }
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}*/
	
}

}
