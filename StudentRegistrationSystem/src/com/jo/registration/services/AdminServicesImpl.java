package com.jo.registration.services;

import java.util.Scanner;

import com.jo.registration.bo.Course;
import com.jo.registration.bo.Department;
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
			String username = firstName+lastName;
			String password = "1234"; 
			
			// add the student to database
			Student newStudent = new Student(firstName,lastName,username,password);
			int in = Data.students.indexOf(newStudent);
			System.out.println(Data.students.get(in).toString());
			
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
			
			System.out.println("Course Instructor: ");
			String courseInstructor = input.nextLine();
			
			System.out.print("Max # of Students: ");
			int maxStudents = input.nextInt();		
			// add the course to database
			Course newCourse = new Course (courseName,courseID,maxStudents,null);
			Department.courses.add(newCourse);
			System.out.println("Course added");
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while adding course", ex);
        }
	}
	
	public static void deleteCourse() throws ErrorHandling {
		// enter course info
		Course course = new Course();
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter course ID: ");
			String courseID = input.nextLine();
			//remove the course from database
			for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					Department.courses.remove(i);
					System.out.println("Course deleted");
				}
				else System.out.println("Course not found");
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while deleting course", ex);
        }
	}
	
	public static void viewCourses() {

		System.out.println(Department.courses.toString());
	
}
	public static void editCourse() throws ErrorHandling {
		Course course = new Course();
		try (Scanner input = new Scanner(System.in)) {
			//Scanner input2 = new Scanner(System.in);
			System.out.print("Course ID: ");
			String courseID = input.nextLine();
			int courseIndex = 0;
			
			//Ask user what they want to edit
			System.out.print("What would you like to edit?\n");
			System.out.print("1. Max number of students\n");
			System.out.print("2. Course Instructor\n");
			
			int choice = input.nextInt();
			
			for (int i = 0; i<Department.courses.size(); i++) {
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
				
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while editing course", ex);
        }
		System.out.println(Department.courses.toString());	
	}
	public static void displayInfo() throws ErrorHandling {
		Course course = new Course(); 
		try (Scanner input = new Scanner(System.in)) {
			//Ask user for Course ID
			System.out.print("Enter course ID: ");
			String courseID = input.nextLine();
			
			for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					System.out.println(Department.courses.get(i));
				}
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while deleting course", ex);
        }
	}
	public static void studentNamesInCourse() throws ErrorHandling {
		//Print out list of names 
		//Ask user for courseID 
		Course course = new Course();
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter course ID: ");
			String courseID = input.nextLine();
					//Remove index from ArrayList of courses
							
			for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					System.out.println(course.getStudents().toString());
				}
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while deleting course", ex);
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
			Department newDepartment = new Department (departmentID,departmentName);
			Data.departments.add(newDepartment);
			System.out.println("Department added");
			}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while adding department", ex);
        }
	}
	
	public static void deleteDepartment() throws ErrorHandling {
		// enter department info
		Department department = new Department();
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter course ID: ");
			String departmentID = input.nextLine();
			//remove the course from database
			for (int i = 0; i<Department.courses.size(); i++) {
				department = Data.departments.get(i);
				if (department.getDepartmentID().equals(departmentID)) { /////////////////////////////
					Department.courses.remove(i);
					System.out.println("Course deleted");
				}
				else System.out.println("Course not found");
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while deleting department", ex);
        }
	}
	public static void editDepartment() throws ErrorHandling {
		Department department = new Department();
		try (Scanner input = new Scanner(System.in)) {
			//Scanner input2 = new Scanner(System.in);
			System.out.print("Department ID: ");
			String departmentID = input.nextLine();
			int departmentIndex = 0;
			
			//Ask user what they want to edit
			System.out.print("What would you like to edit?\n");
			System.out.print("1. Department instructors\n");
			
			int choice = input.nextInt();
			
			for (int i = 0; i<Data.departments.size(); i++) {
				department = Data.departments.get(i);
				departmentIndex = Data.departments.indexOf(Data.departments.get(i));
				
					if (choice == 1 && departmentID.equals(department.getDepartmentID())) {
						System.out.print("Department instructors:");
						String instructorID = input.nextLine();
						Data.departments.get(departmentIndex);
						//department.setMaxStudents(newMax);
						//break;
					}
				
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while deleting course", ex);
        }
		System.out.println(Department.courses.toString());
	}
	public static void viewStudent() throws ErrorHandling {
		try (Scanner enterID = new Scanner(System.in)) {
			System.out.print("Enter student's ID to view:\n");
			String id = enterID.nextLine();
			for (int i = 0; i<Data.students.size(); i++) {
				Student studentIndex = Data.students.get(i);
				if (studentIndex.getStudentID().equals(id)) {
					System.out.println(studentIndex.toString());
				}
			}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while viewing a student", ex);
        }
	}
	//public static void addInstructor() {}

}
