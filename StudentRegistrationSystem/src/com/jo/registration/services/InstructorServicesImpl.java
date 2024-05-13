package com.jo.registration.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jo.registration.bo.Course;
import com.jo.registration.bo.Department;
import com.jo.registration.bo.Student;
import com.jo.registration.data.Data;
import com.jo.registration.data.MySQLConnection;
import com.jo.registration.errorHandling.ErrorHandling;

public class InstructorServicesImpl implements InstructorServices{
	
	public static void viewCourses() throws ErrorHandling {
		ResultSet rs = null;
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
		}
	}
	
	public static void displayInfo() throws ErrorHandling {
		ResultSet rs = null;
		PreparedStatement p = null;
		try (Scanner input = new Scanner(System.in)) {
			//Ask user for Course ID
			System.out.print("Enter course ID: ");
			String courseID = input.nextLine();
			
			try {
				String query = "SELECT * FROM course WHERE course_id ="+courseID;
				p = MySQLConnection.conn.prepareStatement(query);
				rs = p.executeQuery();
				
				while (rs.next()) {
					String courseName = rs.getString("course_name");
	                int courseID2 = rs.getInt("course_id");
	                int maxStudents = rs.getInt("max_students");
	                int enrolledStudents = rs.getInt("enrolled_students");
	                int departmentID = rs.getInt("department_id");
	                System.out.println(courseName + "\t\t" + courseID2
	                                   + "\t\t" + maxStudents + "\t\t" + enrolledStudents + "\t\t" + departmentID);
	            }
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
			/*for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					System.out.println(Department.courses.get(i));
				}
			}*/
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while displaying information", ex);
        }
	}
	
	public static void studentsNamesInCourse() throws ErrorHandling {
		PreparedStatement p = null;
		ResultSet rs = null;
		try (Scanner input = new Scanner(System.in)) {
			String courseID = input.nextLine();

			try {
				String query = "SELECT * FROM studentcourses WHERE course_id = "+courseID;
				p = MySQLConnection.conn.prepareStatement(query);
				rs = p.executeQuery();
				while (rs.next()) {
					int studentID = rs.getInt("max_students");
	                int courseID2 = rs.getInt("course_id");
	                System.out.println(studentID + "\t\t" + courseID2);
	            }
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
			/*for (int i = 0; i<Data.students.size(); i++) {
				course = Department.courses.get(i);
				courseIndex = Department.courses.indexOf(Department.courses.get(i));
					if (courseID.equals(course.getCourseID()))
						course.getEnrolledStudents();
}*/
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while displaying students names in course", ex);
        }
	}
	
	public static void viewStudent() throws ErrorHandling {
		ResultSet rs = null;
		PreparedStatement p = null;
		try (Scanner enterID = new Scanner(System.in)) {
			System.out.print("Enter student's ID to view:\n");
			String id = enterID.nextLine();

			try {
				String query = "SELECT id, first_name, last_name FROM users WHERE student_id = " + id;
				p = MySQLConnection.conn.prepareStatement(query);
				rs = p.executeQuery();
				while (rs.next()) {
					int studentID = rs.getInt("id");
					String firstName = rs.getString("first_name");
	                String lastName = rs.getString("last_name");
	                System.out.println(studentID + "\t\t" + firstName
	                                   + "\t\t" + lastName + "\t\t");
	            }
				rs = null;
				String query2 = "SELECT nationality, address, department_id FROM student WHERE student_id = " + id;
				p = MySQLConnection.conn.prepareStatement(query);
				rs = p.executeQuery();
				while (rs.next()) {
					String nationality = rs.getString("nationality");
	                String address = rs.getString("address");
	                int departmentID = rs.getInt("department_id");
	                System.out.println(departmentID + "\t\t" + nationality
	                                   + "\t\t" + address + "\t\t");
	            }
				
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
			/*for (int i = 0; i<Data.students.size(); i++) {
				Student studentIndex = Data.students.get(i);
				if (studentIndex.getStudentID().equals(id)) {
					System.out.println(studentIndex.toString());
				}
			}*/
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while viewing a student", ex);
        }
		
	}
	//assign grades & assign to course
}
