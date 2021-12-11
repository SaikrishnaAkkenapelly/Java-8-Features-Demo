package com.sai.java.features.staticAndDefaultMethods;

public class QualityAnalyst implements Employee
{
	@Override
	public void getCurrentRole()
	{
		System.out.println("QA");
	}

	@Override
	public void getAllDetails()
	{
		/*Static method calling*/ 
		Employee.getEmployeeId();
		getCurrentProduct();
		getCurrentRole();
	}
	
	@Override
	public void getCurrentProduct()
	{
		Employee.super.getCurrentProduct();
	}	
}
