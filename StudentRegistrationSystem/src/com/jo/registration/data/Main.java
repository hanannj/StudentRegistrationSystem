package com.jo.registration.data;

import com.jo.registration.errorHandling.ErrorHandling;
import com.jo.registration.logging.Logging;
import com.jo.registration.services.LoginImpl;
import java.util.Scanner;
import com.jo.registration.bo.*;

public class Main {

	public static void main(String[] args) throws ErrorHandling {
		
		MySQLConnection mySQLConnection = new MySQLConnection();
        mySQLConnection.connect();
		
		/*User admin = new Admin("Dummy","Submission","Admin","Admin");
		User instructor = new Instructor("Bob","The Builder","instructor","instructor");
		User student = new Student("Peter","Parker","student","student");*/
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in) ;
		System.out.print("1. Admin\n" + "2. Student\n" + "3. Instructor\n" + "4. Exit\n");
		int choice = input.nextInt();
		
		System.out.println("Username: ");
		String username = input2.nextLine();
		
		System.out.println("Password: ");
		String password = input2.nextLine();
		
		try {
			LoginImpl.Login(choice, username, password);
		} catch (ErrorHandling e) {
			e.printStackTrace();
		}
		
	}

}
