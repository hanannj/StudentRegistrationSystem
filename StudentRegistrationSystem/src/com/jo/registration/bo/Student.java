package com.jo.registration.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jo.registration.data.*;
import com.jo.registration.errorHandling.ErrorHandling;

public class Student extends User{
	//public static ArrayList<String> registeredCourses = new ArrayList<String>();
	private String studentID, department;
	private String nationality, address;
	
	public Student(String fN, String lN, String psw) throws ErrorHandling {
		super(fN,lN,psw);
		setStudentID();
		//Data.students.add(this);
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO users VALUES ('" + fN + "', '" + lN + "', " + psw + "')";
			stmt.execute(query);
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
}
	public Student(String fN, String lN, String psw, String department, String nationality, String address) throws ErrorHandling {
		super(fN,lN,psw);
		setStudentID();
		this.department = department;
		this.nationality = nationality;
		this.address = address;
		//Data.students.add(this);
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO users VALUES ('" + fN + "', '" + lN + "', " + psw + "')";
			stmt.execute(query);
			String query2 = "INSERT INTO student VALUES ('" + department + "', '" + nationality + 
					"', '" + address + "')";
			stmt.execute(query2);
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
}
	public Student() {
		
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID() {
		//if(Data.students.isEmpty())
		//	studentID = "11111";
		//else
		//	studentID = Integer.toString(Data.students.size() + 1);
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", First name: " + super.getFirstName() + 
				", Last name: " + super.getLastName() + ", nationality=" + nationality + ", address=" + address + "]";
	}

}