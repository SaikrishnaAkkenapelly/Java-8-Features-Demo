package com.sai.java.features.functionalInterfaces;

@FunctionalInterface
public interface Account
{
	/*This is an example of functional interface*/
	/*A functional interface is a type of normal interface but has only one abstract method that can be implemented unlike normal interfaces*/
	
	public void createAccount(String firstName,String lastName);
	
}
