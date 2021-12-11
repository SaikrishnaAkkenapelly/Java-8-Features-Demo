package com.sai.java.features.methodReferences;

@FunctionalInterface
public interface Decoder
{
	/*This is an example of functional interface*/
	/*A functional interface is a type of normal interface but has only one abstract method that can be implemented unlike normal interfaces*/
	
	public char[] decode(char input[]);
}
