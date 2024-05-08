package com.jo.registration.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jo.registration.data.Data;
import com.jo.registration.data.MySQLConnection;
import com.jo.registration.errorHandling.ErrorHandling;

public class Course {
	private  String courseName, courseID;
	private  int maxStudents;
	public  int enrolledStudents;
	//public  ArrayList<String> students;
	public Instructor courseInstructor;
	
	public Course() {}
	
	public Course(String courseName, String courseID, int maxStudents,
			int departmentID) throws ErrorHandling {
		this.courseName = courseName;
		this.courseID = courseID;
		this.maxStudents = maxStudents;
		this.enrolledStudents = 0;
		//this.students = students;
		//Department.courses.add(this);
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO course VALUES ('" + courseName + "', '" + courseID + "', '" + maxStudents +
					"', '" + 0 + "', '" + departmentID + "')";
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	/*public ArrayList<String> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<String> students) {
		this.students = students;
	}

	*/
	public Instructor getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(int courseInstructor) throws ErrorHandling {
		/*Instructor inst = new Instructor();
		int instructorIndex = 0;
		//this.courseInstructor = courseInstructor;
		
		for (int i = 0; i<Department.instructors.size(); i++) {
			inst = Department.instructors.get(i);
			instructorIndex = Department.instructors.indexOf(Department.instructors.get(i));
			
			if(courseInstructor.equals(inst.getInstructorID())){
				this.courseInstructor = inst;
				break;
			}
	}*/
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO instructorcourses VALUES ('" + courseInstructor + "', '" +
			this.courseID+ "')";
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
		}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseID=" + courseID + ", courseInstructor=" + 
				courseInstructor + ", maxStudents=" + maxStudents + ", enrolledStudents=" + enrolledStudents
				+ "]";
	}

}
