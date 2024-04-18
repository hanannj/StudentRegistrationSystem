package com.jo.registration.services;

import java.util.Scanner;

import com.jo.registration.bo.Course;
import com.jo.registration.bo.Department;
import com.jo.registration.bo.Student;
import com.jo.registration.data.Data;
import com.jo.registration.errorHandling.ErrorHandling;

public class InstructorServicesImpl implements InstructorServices{
	public static void viewCourses() {
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
            throw new ErrorHandling("Error occurred while displaying information", ex);
        }
	}
	
	public static void studentsNamesInCourse() throws ErrorHandling {
		Course course = new Course();
		int courseIndex = 0;
		try (Scanner input = new Scanner(System.in)) {
			String courseID = input.nextLine();
			for (int i = 0; i<Data.students.size(); i++) {
				course = Department.courses.get(i);
				courseIndex = Department.courses.indexOf(Department.courses.get(i));
					if (courseID.equals(course.getCourseID()))
						course.getEnrolledStudents();
}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while displaying students names in course", ex);
        }
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
	//assign grades & assign to course
}
