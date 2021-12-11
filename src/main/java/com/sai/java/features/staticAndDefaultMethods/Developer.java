package com.sai.java.features.staticAndDefaultMethods;

public class Developer implements Employee
{
	@Override
	public void getCurrentRole()
	{
		System.out.println("Developer");
	}

	@Override
	public void getAllDetails()
	{
		/*Static method calling*/ 
		Employee.getEmployeeId();
		Employee.super.getCurrentProduct();
		getCurrentRole();
	}
}
