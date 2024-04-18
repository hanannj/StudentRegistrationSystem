package com.jo.registration.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.jo.registration.bo.Course;
import com.jo.registration.bo.Department;
import com.jo.registration.bo.Student;
import com.jo.registration.errorHandling.ErrorHandling;

public class StudentServicesImpl implements StudentServices{
	public static void registerCourse() throws ErrorHandling {
		Course course = new Course();
		ArrayList<String> regCourse = new ArrayList<String>();
		try (Scanner input = new Scanner(System.in)) {
			//Enter course ID
			System.out.print("Enter courseID: ");
			String courseID = input.nextLine();
			//Add course to student's list of registered courses
			Student.registeredCourses.add(courseID);
			//Add student name to registered students of the course
			System.out.println("Verify full name: ");
			String firstName = input.nextLine();
			System.out.println("Verify last name: ");
			String lastName = input.nextLine();
					
			for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					if (course.getEnrolledStudents() == course.getMaxStudents()) {
						System.out.println("Course is full.");
						break;}
					course.enrolledStudents++;
					course.students.add(firstName + " " + lastName);
					}
				}
		}
		catch (Exception ex) {
	        throw new ErrorHandling("Error occurred during course registration", ex);}
	}
	
	public static void dropCourse() throws ErrorHandling {
		Course course = new Course();
		ArrayList<String> regCourse = new ArrayList<String>();
		try (Scanner input = new Scanner(System.in)) {
			//Enter course ID
			System.out.print("Enter courseID: ");
			String courseID = input.nextLine();
			//Add course to student's list of registered courses
			Student.registeredCourses.add(courseID);
			//Add student name to registered students of the course
			System.out.println("Verify full name: ");
			String firstName = input.nextLine();
			System.out.println("Verify last name: ");
			String lastName = input.nextLine();
					
			for (int i = 0; i<Department.courses.size(); i++) {
				course = Department.courses.get(i);
				if (course.getCourseID().equals(courseID)) {
					course.enrolledStudents--;
					course.students.remove(firstName + " " + lastName);
					}
				}
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred during dropping the course", ex);
        }		}
	
	public static void viewRegisteredCourses() {

		System.out.println(Student.registeredCourses.toString());
	
}
	public static void viewAllCourses() {

		System.out.println(Department.courses.toString());
	
}

}
