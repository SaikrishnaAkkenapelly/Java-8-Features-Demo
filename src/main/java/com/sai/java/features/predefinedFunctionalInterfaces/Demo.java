package com.sai.java.features.predefinedFunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.sai.java.features.methodReferences.HashEncoderDecoder;

public class Demo
{
	public static void main(String[] args)
	{
		/*Java 8 has included many predefined functional interfaces which can be used for various purposes*/
		
		/*Predicate functional interface which has test(Object) method as it's abstract method*/
		
		Predicate<Integer> predicate = (Integer age) ->
		{
			//lambda expression to check if the required age is met are not to vote
			return age > 18;
		};
		
		System.out.println(predicate.test(19));
		
		/*Consumer functional interface with accept(Object) as it's abstract method*/
		
		Consumer<Integer> consumer = (Integer age) ->
		{
			//lambda expression to check if the required age is met are not to vote
			if(predicate.test((Integer)age))
			{
				System.out.println("Welcome");
			}
			else
			{
				System.out.println("Kids are not allowed");
			}
		};
		
		consumer.accept(19);
		consumer.accept(17);
		
		/*Function is a functional interface which has apply(Object) as it's abstract method*/
		
		Function<char[],char[]> function = (char input[]) ->
		{
			return HashEncoderDecoder.encodeUsingHashCode(input);
		};
		
		char encodedChars[] =  function.apply("saikrishna".toCharArray());
		System.out.println(String.valueOf(encodedChars));
		
		/*Using method reference*/
		
		HashEncoderDecoder hashEncoderDecoder = new HashEncoderDecoder();
		function = hashEncoderDecoder :: decodeUsingHashCode;
		System.out.println(function.apply(encodedChars));
		
		/*There are many predefined functions just google based on the requirement*/
	}
}
