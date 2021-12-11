package com.sai.java.features.methodReferences;

public class HashEncoderDecoder
{
	private static int hashCode;
	
	public static char[] encodeUsingHashCode(char input[])
	{
		int length = input.length;
		hashCode = input.hashCode();
		
		for(int index = 0; index < length; index++)
		{
			input[index] = (char)(input[index] + hashCode);
		}
		
		return input;
	}
	
	public char[] decodeUsingHashCode(char input[])
	{
		int length = input.length;
		
		for(int index = 0; index < length; index++)
		{
			input[index] = (char)(input[index] - hashCode);
		}
		
		return input;
	}
}
