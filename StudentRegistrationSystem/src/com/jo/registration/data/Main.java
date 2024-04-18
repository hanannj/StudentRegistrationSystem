package com.jo.registration.data;

import com.jo.registration.errorHandling.ErrorHandling;
import com.jo.registration.logging.Logging;
import com.jo.registration.services.LoginImpl;
import com.jo.registration.bo.*;

public class Main {

	public static void main(String[] args) {
		
		User admin = new Admin("Dummy","Submission","Admin","Admin");
		User instructor = new Instructor("Bob","The Builder","instructor","instructor");
		User student = new Student("Peter","Parker","student","student");
		
		/*System.out.println(Data.students.isEmpty());
		System.out.println(Data.admins.isEmpty());
		System.out.println(Department.instructors.isEmpty());*/


		
		try {
			LoginImpl.Login();
		} catch (ErrorHandling e) {
			e.printStackTrace();
		}
		
	}

}
