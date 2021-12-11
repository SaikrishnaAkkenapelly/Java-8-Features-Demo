package com.sai.java.features.staticAndDefaultMethods;

public interface Employee
{
	/*Java 8 allows static and default methods in interfaces, default methods are not mandatory to implement like the abstract methods*/
	/*Static methods can not be re-implemented in the child classes*/
	
	static void getEmployeeId()
	{
		Long id = 10000l;
		System.out.println("Employee Id : "+id);
	}
	
	default void getCurrentProduct()
	{
		System.out.println("S.E");
	}
	
	public void getCurrentRole();
	
	public void getAllDetails();
}
