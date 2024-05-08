package com.jo.registration.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jo.registration.data.Data;
import com.jo.registration.data.MySQLConnection;
import com.jo.registration.errorHandling.ErrorHandling;

public class Instructor extends User{
	//public static ArrayList<String> assignedCourses = new ArrayList<String>();
	private String instructorID, department;
	private String nationality, address;
	
	public Instructor() {}
	
	public Instructor(String fN, String lN, String psw) throws ErrorHandling {
		super(fN,lN,psw);
		setInstructorID();
		//Department.instructors.add(this);
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO users VALUES ('" + fN + "', '" + lN + "', " + psw + "')";
			stmt.execute(query);
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
		
}
	public Instructor(String fN, String lN, String psw, String department, String nationality, String address) throws ErrorHandling {
		super(fN,lN,psw);
		setInstructorID();
		this.department = department;
		this.nationality = nationality;
		this.address = address;
		//Department.instructors.add(this);
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO users VALUES ('" + fN + "', '" + lN + "', " + psw + "')";
			stmt.execute(query);
			String query2 = "INSERT INTO instructor VALUES ('" + department + "', '" + nationality + 
					"', '" + address + "')";
			stmt.execute(query2);
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
}
	public String getInstructorID() {
		return instructorID;
	}
	public void setInstructorID() {
	//	if(Department.instructors.size() == 0)
	//		instructorID = "11111";
	//	else
	//		instructorID = Integer.toString(Data.students.size() + 1);
	}

	@Override
	public String toString() {
		return "Instructor [instructorID=" + instructorID + ", nationality=" + nationality + ", address=" + address
				+ "]";
	}
	
	
	}
	
	
