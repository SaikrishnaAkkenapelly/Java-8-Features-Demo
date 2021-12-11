package com.sai.java.features.lambdaExpressions;

import com.sai.java.features.functionalInterfaces.Account;

public class AccountMain {

	public static void main(String[] args)
	{
		/*Lambda expression syntax is parameter -> expression body*/
		/*Lambda expression can be used to implement the functional interfaces*/
		/*This expression acts as the body for that particular abstract method in the interface*/
		
		Account account = (String firstName, String lastName) ->
		{
			String fullName = firstName +" "+lastName;
			System.out.println("The name of the account holder is "+fullName);
		};
		
		account.createAccount("Saikrishna", "Akkenapelly");
	}
}
