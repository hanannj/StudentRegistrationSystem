package com.jo.registration.services;

import java.util.Scanner;

import com.jo.registration.bo.Admin;
import com.jo.registration.bo.Department;
import com.jo.registration.bo.Instructor;
import com.jo.registration.bo.Student;
import com.jo.registration.data.Data;
import com.jo.registration.errorHandling.ErrorHandling;
import com.jo.registration.logging.Logging;

public class LoginImpl implements Login{
	public static void Login(int choice, String username, String password) throws ErrorHandling{
			//Check if username and password are correct
			if (choice == 1) {
				Admin admin = new Admin();
				for (int i = 0; i<Data.admins.size(); i++) {
					admin = Data.admins.get(i);
					if (username.equals(admin.getUsername()) && password.equals(admin.getPassword()))
						adminChoices();
					else //{System.out.println("Wrong username or password");
						Logging.logger.info("Wrong username or password");
			}
			}
			
			if (choice == 2) {
				Student student = new Student();				
				try (Scanner login = new Scanner(System.in);
						Scanner firstTimeLogin = new Scanner (System.in)) {
					
					for (int i = 0; i<Data.students.size(); i++) {
							student = Data.students.get(i);
							if (username.equals(student.getUsername()) && password.equals(student.getPassword())) {
								System.out.print("Is this your first time log? 1. Yes	2. No\n");
								int firstLog = firstTimeLogin.nextInt();
								if (firstLog == 1) {
									//Let the user create a new password				
									System.out.print("Enter a new password:\n");
									String newPassword = login.nextLine();
									student.setPassword(newPassword);
									System.out.println("Password changed successfully.\n");
								}
								studentChoices();}
							else //System.out.println("Wrong username or password");
								Logging.logger.info("Wrong username or password");}
			}
				catch (Exception ex) {
		            throw new ErrorHandling("Error occurred while Logging in", ex);
		        }}
			
			if (choice == 3) {  
				Instructor instructor = new Instructor();
				
				for (int i = 0; i<Department.instructors.size(); i++) {
					instructor = Department.instructors.get(i);
					if (username.equals(instructor.getUsername()) && password.equals(instructor.getPassword()))
						instructorChoices();
					else //System.out.println("Wrong username or password");
						Logging.logger.info("Wrong username or password");
			}}
			
			if (choice == 4)
				System.exit(0);
			
			}

	public static void adminChoices() throws ErrorHandling {
		System.out.print("1. Register a student\n"
				+ "2. Create a new course\n"
				+ "3. Delete a course\n"
				+ "4. View Courses\n"
				+ "5. Exit\n");
		
		try (Scanner input = new Scanner(System.in)) {
			int choice = input.nextInt();
			
			switch (choice) {
			case 1: AdminServicesImpl.registerStudent(); break;
			case 2: AdminServicesImpl.addCourse(); break;
			case 3: AdminServicesImpl.deleteCourse(); break;
			case 4: AdminServicesImpl.viewCourses(); break;
			case 5: System.exit(0); //break;
			default:
				System.out.println("Invalid choice, please try again");
				adminChoices();
			}
			input.close();
			//adminChoices();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while choosing", ex);
        }}
	
	public static void studentChoices() throws ErrorHandling {
		System.out.print("1. Register a course\n"
				+ "2. Drop a course\n"
				+ "3. View registered courses\n"
				+ "4. View all courses\n"
				+ "5. Exit\n");
		
		try (Scanner input = new Scanner(System.in)) {
			int choice = input.nextInt();
			
			switch (choice) {
			case 1: StudentServicesImpl.registerCourse(); break;
			case 2: StudentServicesImpl.dropCourse(); break;
			case 3: StudentServicesImpl.viewRegisteredCourses(); break;
			case 4: StudentServicesImpl.viewAllCourses(); break;
			case 5: System.exit(0);
			default:
				System.out.println("Invalid choice, please try again");
				studentChoices();
			}
			input.close();
			//studentChoices();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while choosing", ex);
        }
	}
	
	public static void instructorChoices() throws ErrorHandling {
		System.out.print("1. View student\n"
				+ "2. Students names in course\n"
				+ "3. Display information\n"
				+ "4. View courses\n"
				+ "5. Exit\n");
		
		try (Scanner input = new Scanner(System.in)) {
			int choice = input.nextInt();
			
			switch (choice) {
			case 1: InstructorServicesImpl.viewStudent(); break;
			case 2: InstructorServicesImpl.studentsNamesInCourse(); break;
			case 3: InstructorServicesImpl.displayInfo(); break;
			case 4: InstructorServicesImpl.viewCourses(); break;
			case 5: System.exit(0);
			default:
				System.out.println("Invalid choice, please try again");
				instructorChoices();
			}
			input.close();
			//instructorChoices();
		}
		catch (Exception ex) {
            throw new ErrorHandling("Error occurred while choosing", ex);
        }
	}
}
