package com.jo.registration.bo;

import java.util.ArrayList;

import com.jo.registration.data.Data;

public class Department {
	private String departmentName;
	private String departmentID;
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Instructor> instructors = new ArrayList<Instructor>(); ////////////////
	
	public Department(String departmentID, String departmentName){
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		Data.departments.add(this);
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
