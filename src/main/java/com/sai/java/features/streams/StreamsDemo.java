package com.sai.java.features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsDemo
{
	public static void main(String[] args)
	{
		List<String> cities = Arrays.asList("Hyderabad","Bombay","","Delhi","","Chennai");
		System.out.println(cities);
		
		/*Need to count the total number of empty strings in the given list*/
		/*Conventional way*/
		long count = getCountOfEmptyStrings(cities);
		System.out.println(count);
		
		/*Java 8 way*/
		/*Stream is a class introduced in java 8 which generally means flow of data*/
		/*Filter is one of it's method, which takes Predicate functional interface as it's argument*/
		/*Stream class is similar to many other stream classes in java like PrintStream InputStream OutputStream*/
		/*Predicate is a predefined functional interface with test method as its abstract method*/
		/*Internally filter will make use of the test method of the Predicate class to filter*/
		/*To filter based on our own logic we need to implement the test method as per our requirement*/
		/*Implementation of abstract methods of a functional interface can be done by both lambda expressions and method references*/
		
		/*Method reference way*/
		count = cities.stream().filter(String :: isEmpty).count();
		System.out.println(count);
		
		/*Lambda expressions way*/
		count = cities.stream().filter((String name) ->
		{
			return name.isEmpty();
		}).count();
		System.out.println(count);
		
		/*filter() method will take Predicate as argument but why it is taking lambda and method reference with no issues as it's argument*/
		/*In general we create a class which implements the predicate to implement it's test method and we pass this object here because accepting
		interface object means it was like that to accept all the implementation classes of that interface but with java 8 on demand implementations
		are possible with lambda and method references for functional interfaces, when we use either of them it is same as the classic way of creating
		an implementation class and implementing that particular method and passing this class's object*/
		
		/*Need to get the strings with length 2*/
		/*Conventional way*/
		count = getCountOfSpecificLength(cities,2);
		System.out.println(count);
		
		/*Java 8 way*/
		count = cities.stream().filter((String city) ->
		{
			return city.length() == 5;
		}).count();
		System.out.println(count);
		
		/*Need to get remove empty strings*/
		/*Conventional way*/
		cities = removeEmptyStrings(cities);
		System.out.println(cities);
		
		/*Java 8 way*/
		/*Collectors is a final class provided in java 8 for performing various operations like accumulating data into collections etc..*/
		/*Collector is a class in java which is used to collect data into a specific data structure*/
		/*Collectors.toList() will give you the collector which collects the data into list data structure*/
		/*Different types of collectors can be obtained from Collectors final class*/
		cities = cities.stream().filter((String city) ->
		{
			return !city.isEmpty();
		}).collect(Collectors.toList());
		System.out.println(cities);
		
		/*Need to form a new string by concatenating all the cities with comma*/
		/*Conventional way*/
		String allCities = formStringWithComma(cities);
		System.out.println(allCities);
		
		/*Java 8 way*/
		/*Collectors.joining() will return Collector of type String*/
		allCities = cities.stream().collect(Collectors.joining(","));
		System.out.println(allCities);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,6);
		
		/*Need to get the squares of each number in the list numbers*/
		/*Conventional way we loop through the list calculate square of each element and add all of them one by one to a new list the we return list*/
		/*Java 8 way*/
		/*map is a method which apply the given function on each of the element and put the results to a new stream*/
		/*map takes Function functional interface as input argument which consists of apply(Object,Object) method as it's abstract method*/
		/*We can also use method reference as well when we need to implement a functional interface*/
		/*distinct is used to select only distinct elements into the new stream from the old stream*/
		numbers = numbers.stream().map((Integer input) ->
		{
			return input * input;
		}).distinct().collect(Collectors.toList());
		
		System.out.println(numbers);
		
		/*BinaryOperator is a @FunctionalInterface
		Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
		This is a specialization of BiFunction for the case where the operands and the result are all of the same type.
		This is a functional interface whose functional method is apply(Object, Object).
		reduce will take this BinaryOperator functional interface
		this returns an optional object*/

		int productOfSquares = numbers.stream().reduce((Integer firstValue, Integer secondValue) ->
		{
			return firstValue*secondValue;
		}).get();
		
		System.out.println("productOfSquares" + productOfSquares);
		
		/*This variant of reduce will take initial value of the result along with the accumulator function
		like we initialize sum = 0 if calculating sum or product = 1 while calculating product*/
		productOfSquares = numbers.stream().reduce(1,(Integer firstValue, Integer secondValue) ->
		{
			return firstValue*secondValue;
		});
		
		System.out.println("productOfSquares" + productOfSquares);
		
		/*This variant of reduce will be used in case of a parallel stream which will take combiner to combine the result from parallel streams*/ 
		productOfSquares = numbers.parallelStream().reduce(1,(Integer firstValue, Integer secondValue) ->
		{
			return firstValue*secondValue;
		},
		(Integer firstStreamResult, Integer secondStreamResult) ->
		{
			return firstStreamResult*secondStreamResult;
		}
		);
		
		System.out.println("productOfSquares" + productOfSquares);
		
		/*Need to get the max,minimum,sum etc .. from the given list*/
		/*Conventional way is we need to loop and find each and every property from the list*/
		/*Java 8 way*/
		/*mapToInt will take ToIntFunction functional interface as input argument which has applyAsInt() as it's abstract method*/
		
		IntSummaryStatistics statistics = numbers.stream().mapToInt((Integer number) ->
		{
			return number.intValue();
		}).summaryStatistics();
		
		System.out.println("Max : " +statistics.getMax());
		System.out.println("Min : " +statistics.getMin());
		System.out.println("Sum : " +statistics.getSum());
		System.out.println("Avg : " +statistics.getAverage());
		
		/*Instead of getting a stream every time you can also get a parallel stream which makes use of parallel processing*/
		Set<Integer> allNumbers = numbers.parallelStream().collect(Collectors.toSet());
		System.out.println(allNumbers);
		
		/*printing all elements in a set*/
		/*forEach on a stream will take a Consumer functional interface as an input argument which has accept(object) method as it's abstract method*/
		allNumbers.stream().forEach(System.out :: println);
		
		/*sorted method will take Comparator functional interface as it's input argument which as compareTo(Object,Object) as it's abstract class*/
		List<Integer> sortedNumbers = allNumbers.stream().sorted((Integer firstValue,Integer secondValue) ->
		{
			return secondValue.compareTo(firstValue);
		}).collect(Collectors.toList());
		
		System.out.println(sortedNumbers);
		
		/*Need to print ten random numbers*/
		Random random = new Random();
		for(int iteration = 0; iteration < 10; iteration++)
		{
			System.out.println(random.nextInt());
		}
	    
		/*Java 8 way*/
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		/*Stream class has lot of other methods as well which will be used based on out requirement*/
		/*There are many other predefined functional interfaces as well in java 8*/
	}

	private static long getCountOfEmptyStrings(List<String> cities)
	{
		long count = 0;
		
		for(String name : cities)
		{
			if(name.isEmpty())
				count++;
		}
		
		return count;
	}
	
	private static long getCountOfSpecificLength(List<String> cities,int length)
	{
		long count = 0;
		
		for(String name : cities)
		{
			if(name.length() == length)
				count++;
		}
		
		return count;
	}
	
	private static List<String> removeEmptyStrings(List<String> cities)
	{
		List<String> nonEmptyStrings = new ArrayList<>();
		
		for(String city : cities)
		{
			if(city.isEmpty())
				continue;
			else
				nonEmptyStrings.add(city);
		}
		
		return nonEmptyStrings;
	}
	
	private static String formStringWithComma(List<String> cities)
	{
		StringBuilder builder = new StringBuilder();
		
		for(String city : cities)
		{
			builder.append(city);
			builder.append(",");
		}
		
		builder.deleteCharAt(builder.length()-1);
		
		return builder.toString();
	}
}
