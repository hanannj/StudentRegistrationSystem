package com.jo.registration.bo;

import java.util.ArrayList;

import com.jo.registration.data.Data;

public class Instructor extends User{
	public static ArrayList<String> assignedCourses = new ArrayList<String>();
	private String instructorID;
	private String nationality, address;
	
	public Instructor() {}
	
	public Instructor(String fN, String lN, String usn, String psw) {
		super(fN,lN,usn,psw);
		setInstructorID();
		Department.instructors.add(this);
		
}
	public Instructor(String fN, String lN, String usn, String psw, String nationality, String address) {
		super(fN,lN,usn,psw);
		setInstructorID();
		this.nationality = nationality;
		this.address = address;
		Department.instructors.add(this);
}
	public String getInstructorID() {
		return instructorID;
	}
	public void setInstructorID() {
		if(Department.instructors.size() == 0)
			instructorID = "11111";
		else
			instructorID = Integer.toString(Data.students.size() + 1);
	}

	@Override
	public String toString() {
		return "Instructor [instructorID=" + instructorID + ", nationality=" + nationality + ", address=" + address
				+ "]";
	}
	
	
	}
	
	
