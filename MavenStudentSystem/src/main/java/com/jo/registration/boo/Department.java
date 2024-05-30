package com.jo.registration.boo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Entity;

import com.jo.registration.errorHandling.ErrorHandling;

@Entity
public class Department {
	private String departmentName;
	private String departmentID;
	//public static ArrayList<Course> courses = new ArrayList<Course>();
	//public static ArrayList<Instructor> instructors = new ArrayList<Instructor>(); ////////////////
	
	public Department(String departmentID, String departmentName) throws ErrorHandling{
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		//Data.departments.add(this);
		/*Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO department VALUES ('" + departmentName + "')";
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}*/
	}

	public Department() {}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
}
