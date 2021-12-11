package com.sai.java.features.optionalClass;

import java.util.Optional;

public class OptionalClassDemo
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		/*Optional class was introduced in java 8 to write cleaner code in the areas of handling null checks in the programs*/
		/*Conventional way*/
		
		String city = null;
		/*throws a null pointer exception here if we do not handle null check*/
		if(city != null)
		{
			if(city.equals("Hyderabad"))
			{
				System.out.println("HYD");
			}
			else if(city.equals("Delhi"))
			{
				System.out.println("DEL");
			}
		}
		
		/*Java 8 way*/
		/*We need to handle optional with isPresent method*/
		/*ofNullable method will return an optional object if the passed value is not null else it will return empty optional object Optional.empty*/
		city = "Hyderabad";
		Optional<String> place = Optional.ofNullable(city);
		
		if(place.isPresent())
		{
			/*Optional.get() method will get the actual object from Optional container*/
			if(place.get().equals("Hyderabad"))
			{
				System.out.println("HYD");
			}
			else if(place.get().equals("Delhi"))
			{
				System.out.println("DEL");
			}
		}
		
		try
		{
			/*Optional.of() will also return an optional object but throws a null pointer if passed a null value*/
			city = null;
			place = Optional.of(city);
			
			if(place.isPresent())
			{
				/*Optional.get() method will get the actual object from Optional container*/
				if(place.get().equals("Hyderabad"))
				{
					System.out.println("HYD");
				}
				else if(place.get().equals("Delhi"))
				{
					System.out.println("DEL");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Null pointer at Optional.Of() method usage");
		}
		
		place = Optional.ofNullable(city);
		
		try
		{
			/*get throws null pointer if optional is empty*/
			System.out.println(place.get());
		}
		catch(Exception e)
		{
			System.out.println("Null pointer at get() method usage");
		}
		
		/*orElse will not throw the null pointer even if optional is empty, it just returns the default value that we pass*/
		System.out.println(place.orElse("Mumbai"));
		
		city = "DELHI";
		place = Optional.ofNullable(city);
		/*orElse will get the value if present or if optional is not empty*/
		System.out.println(place.orElse("Mumbai"));
		
		/*There are some other methods in Optional class like orElseGet(), orElseThrow() etc..*/
	}
}
