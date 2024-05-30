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
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in) ;
		System.out.print("1. Admin\n" + "2. Student\n" + "3. Instructor\n" + "4. Exit\n");
		int choice = input.nextInt();
		
		System.out.println("ID: ");
		String id = input2.nextLine();
		
		System.out.println("Password: ");
		String password = input2.nextLine();
		
		try {
			LoginImpl.Login(choice, id, password);
		} catch (ErrorHandling e) {
			e.printStackTrace();
		}
		
		mySQLConnection.closeConnection();
	}

}
