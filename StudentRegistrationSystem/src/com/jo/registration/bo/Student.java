package com.jo.registration.bo;

import java.util.ArrayList;

import com.jo.registration.data.*;

public class Student extends User{
	public static ArrayList<String> registeredCourses = new ArrayList<String>();
	private String studentID;
	private String nationality, address;
	
	public Student(String fN, String lN, String usn, String psw) {
		super(fN,lN,usn,psw);
		setStudentID();
		Data.students.add(this);
}
	public Student(String fN, String lN, String usn, String psw, String nationality, String address) {
		super(fN,lN,usn,psw);
		setStudentID();
		this.nationality = nationality;
		this.address = address;
		Data.students.add(this);
}
	public Student() {
		
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID() {
		if(Data.students.isEmpty())
			studentID = "11111";
		else
			studentID = Integer.toString(Data.students.size() + 1);
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", First name: " + super.getFirstName() + 
				", Last name: " + super.getLastName() + ", nationality=" + nationality + ", address=" + address + "]";
	}

}