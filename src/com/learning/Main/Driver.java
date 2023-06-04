package com.learning.Main;

import java.util.Scanner;
import com.learning.Model.Employee;
import com.learning.Services.CredentialService;
import com.learning.Services.UserException;

public class Driver {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
	  //System.out.println("Driver Method");
	  Scanner sc =new Scanner(System.in);
	  System.out.println("Please enter First Name:");
	  String firstName = sc.nextLine();
	  System.out.println("Please enter Last Name:");
	  String lastName = sc.nextLine();
	  
	  Employee emp = new Employee(firstName,lastName);
	  System.out.println("Employee's name  is :" + emp.getFirstName() + " " + emp.getLastName());
	  try {
	  displayMenu();
	  int choice = sc.nextInt();
	  String[] departmentArr = {"Technical","Admin","HR","Legal"};
	  String department = "";
	  System.out.println("Employee's input is :" + choice);
	  
		  if ( choice >= 1 && choice <=4 ){
		   department = departmentArr[choice-1];
		  } else {
			  //System.out.println("Incorrect Input , please enter input 1-4");
			  throw new UserException("Incorrect option");
		  }
	  //System.out.println("Employee's department is :" + department);
	  CredentialService cred = new CredentialService();
	  String emailAddress= cred.generateEmailAddress(emp, department);
	  //System.out.println("Employee's emailAddress: " +emailAddress);
	  String pwd =cred.generatePassword();
	  //System.out.println("password "+ pwd);
	  emp.setPassword(pwd);
	  emp.setEmailAddress(emailAddress);
	  cred.showCredential(emp);
	  } catch (UserException ae) {
		  System.out.println(ae.getMessage());
		  ae.printStackTrace();
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	}
	
	public static void displayMenu() {
		  System.out.println("Please enter department:");
		  System.out.println("1.Technical");
		  System.out.println("2.Admin");
		  System.out.println("3.Human Resources");
		  System.out.println("4.legal");
		  
	}
	
   

}
