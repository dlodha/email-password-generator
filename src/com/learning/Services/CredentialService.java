package com.learning.Services;

import com.learning.Interfaces.ICredentials;
import com.learning.Model.Employee;
import java.util.Random;

public class CredentialService implements ICredentials{
	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		  String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		  String numbers = "0123456789";
		  String specialCharacters = "!@#$%^&*_=+-/.?<>)";
		  String values = capitalLetters+smallLetters+numbers+specialCharacters;
		  Random random = new Random();
		  String password = "";
		//  String.valueOf(0)
		  for(int i=1;i<=8;i++)
		  {
			  password = password + values.charAt(random.nextInt(values.length()));
		  }
	    return password;
	}
   
	@Override
	public String generateEmailAddress(Employee emp, String department) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append(emp.getFirstName()).append(".").append(emp.getLastName()).append("@")
		.append(department).append(".abc.com");
		String emailAddress = sb.toString();
		return emailAddress;
	}
	@Override
	public void showCredential(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println("Employee " + emp.getFirstName() + " has following credential.");
		System.out.println("Email Address is:" + emp.getEmailAddress());
		System.out.println("Password is :" + emp.getPassword());
	}
    

}
