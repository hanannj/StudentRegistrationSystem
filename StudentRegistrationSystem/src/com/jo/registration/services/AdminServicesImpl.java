package com.jo.registration.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jo.registration.bo.Course;
import com.jo.registration.bo.Department;
import com.jo.registration.bo.Instructor;
import com.jo.registration.bo.Student;
import com.jo.registration.data.*;
import com.jo.registration.errorHandling.ErrorHandling;

public class AdminServicesImpl implements AdminServices{
	
	public static void registerStudent() throws ErrorHandling {
		// enter student info
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Student First Name: ");
			String firstName = input.nextLine();
			System.out.println("Student Last Name: ");
			String lastName = input.nextLine();
			System.out.println("Student Department: ");
			String department = input.nextLine();
			System.out.println("Student Nationality: ");
			String address = input.nextLine();
			System.out.println("Student Address: ");
			String nationality = input.nextLine();
			String password = "12345678"; 
			
			// add the student to database
			Student newStudent = new Student(firstName,lastName,password);
			try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "INSERT INTO users ('first_name', 'last_name', 'password') VALUES ('" + firstName + "', '" + lastName + "', '" +
							password + "')";
				stmt.execute(query);
				String query2 = "INSERT INTO student ('nationality','address','department') VALUES "
						+ "('" + nationality + "', '" + address +"', '" + department + "')";
				stmt.execute(query2);
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
			input.close();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred during student registration", ex);
        }
	}
	
	
	public static void addCourse() throws ErrorHandling{ 
		// enter course info
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Course Name: ");
			String courseName = input.nextLine();
			
			System.out.print("Course ID: ");
			String courseID = input.nextLine();
			
			//System.out.println("Course Instructor: ");
			//String courseInstructor = input.nextLine();
			
			System.out.print("Max # of Students: ");
			int maxStudents = input.nextInt();
			
			System.out.print("Department ID: ");
			int departmentID = input.nextInt();
			
			// add the course to database
			try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "INSERT INTO course VALUES ('"+ courseName + "', " + courseID + ", " +
				maxStudents + ", " + departmentID +");";
				stmt.execute(query);}
			catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while adding course", ex);
        }
	}
	
	public static void deleteCourse() throws ErrorHandling {
		// enter course info
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter course ID: ");
			String courseID = input.nextLine();
			//remove the department from database
			try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "DELETE FROM course WHERE course_id = "+ courseID;
				stmt.execute(query);}
			catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
					}
				}
		catch (Exception ex) {
			throw new ErrorHandling("Error occurred while deleting department", ex);
		        }
	}
	
	public static void viewCourses() throws ErrorHandling {
		ResultSet rs = null;
		PreparedStatement p = null;
		try {
			Statement stmt = MySQLConnection.conn.createStatement();
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
	public static void editCourse() throws ErrorHandling {
		try (Scanner input = new Scanner(System.in)) {
			//Scanner input2 = new Scanner(System.in);
			System.out.print("Course ID: ");
			String courseID = input.nextLine();
			
			//Ask user what they want to edit
			System.out.print("What would you like to edit?\n");
			System.out.print("1. Max number of students\n");
			System.out.print("2. Course Instructor\n");
			
			int choice = input.nextInt();
			
			if (choice == 1) {
				System.out.print("Enter new max number of students\n");
				int maxNo = input.nextInt();
				try {
					Statement stmt = MySQLConnection.conn.createStatement();
					String query = "UPDATE course SET max_students = "+ maxNo +"WHERE course_id = " + courseID;
					stmt.execute(query);}
				catch (SQLException e) {
					throw new ErrorHandling("Error occurred during accessing SQL tables", e);
				}
			}
			if (choice == 2) {
				System.out.print("Enter new instructor\n");
				String instructor = input.nextLine();
				try {
					Statement stmt = MySQLConnection.conn.createStatement();
					String query = "UPDATE instructorcourse SET instructor_id = "+ instructor +
							"WHERE course_id = " + courseID;
					stmt.execute(query);}
				catch (SQLException e) {
					throw new ErrorHandling("Error occurred during accessing SQL tables", e);
				}
			}
			
			/*for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				courseIndex = Department.courses.indexOf(Department.courses.get(i));
				
					if (choice == 1 && courseID.equals(course.getCourseID())) {
						System.out.print("New max amount of students: ");
						int newMax = input.nextInt();
						Department.courses.get(courseIndex);
						course.setMaxStudents(newMax);
						break;
					}
					if (choice == 2 && courseID.equals(course.getCourseID())) {
						System.out.println("New course instructor: ");
						String newInstructor = input.nextLine();
						course.setCourseInstructor(newInstructor);
						break;
					}
				
			}*/
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while editing course", ex);
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
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);}}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while displaying information", ex);
        }
	}
	
	public static void studentNamesInCourse() throws ErrorHandling {
		//Print out list of names 
		//Ask user for courseID 
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
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while displaying students names in course", ex);
        }
	}
	public static void addDepartment() throws ErrorHandling {
		// enter department info
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Department Name: ");
			String departmentName = input.nextLine();
					
			System.out.print("Department ID: ");
			String departmentID = input.nextLine();
				
			// add the department to database
			try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "INSERT INTO department VALUES ("+ departmentName + "," + departmentID + ");";
				stmt.execute(query);}
			catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
			}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while adding department", ex);
        }
	}
	
	public static void deleteDepartment() throws ErrorHandling {
		// enter department info
		Department department = new Department();
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter department ID: ");
			String departmentID = input.nextLine();
			//remove the department from database
			try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "DELETE FROM department WHERE department_id = "+ departmentID;
				stmt.execute(query);}
			catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while deleting department", ex);
        }
	}
	
	public static void editDepartment() throws ErrorHandling {
		try (Scanner input = new Scanner(System.in)) {
			//Scanner input2 = new Scanner(System.in);
			System.out.print("Department ID: ");
			String departmentID = input.nextLine();
			
			//Ask user what they want to edit
			System.out.print("What would you like to edit?\n");
			System.out.print("1. Department name\n");
			
			int choice = input.nextInt();
			
			if (choice == 1) {
				System.out.print("Enter a new name\n");
				int name = input.nextInt();
				try {
					Statement stmt = MySQLConnection.conn.createStatement();
					String query = "UPDATE department SET department_name = '"+ name + "' WHERE department_id = "
							+ departmentID;
					stmt.execute(query);}
				catch (SQLException e) {
					throw new ErrorHandling("Error occurred during accessing SQL tables", e);
				}
			}
			
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while editing department", ex);
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
	                                   + "\t\t" + lastName + "\t\t"); }
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
	            }} 
			catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
			}}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while viewing a student", ex);
        }
	}
	
	public static void addInstructor() throws ErrorHandling {
		// enter instructor info
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Instructor First Name: ");
			String firstName = input.nextLine();
			System.out.println("Instructor Last Name: ");
			String lastName = input.nextLine();
			System.out.println("Instructor Department: ");
			String department = input.nextLine();
			System.out.println("Instructor Nationality: ");
			String nationality = input.nextLine();
			System.out.println("Instructor Address: ");
			String address = input.nextLine();
			String password = "12345678"; 
					
			// add the instructor to database
			try {
				Statement stmt = MySQLConnection.conn.createStatement();
				String query = "INSERT INTO users VALUES ('" + firstName + "', '" + lastName + "', " + password + "')";
				stmt.execute(query);
				String query2 = "INSERT INTO instructor ('nationality','address','department') VALUES ('" 
				+ nationality + "', '" + address + "', '" + department + "')";
				stmt.execute(query2);
			} catch (SQLException e) {
				throw new ErrorHandling("Error occurred during accessing SQL tables", e);
					}
			input.close();
				}
		catch (Exception ex) {
	           throw new ErrorHandling("Error occurred during student registration", ex);	}
}}