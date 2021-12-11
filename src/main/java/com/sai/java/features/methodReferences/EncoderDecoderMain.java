package com.sai.java.features.methodReferences;

public class EncoderDecoderMain
{
	public static void main(String[] args)
	{
		/*Method reference can be assumed as a pointer to a particular method of a particular class*/
		/*Method reference syntax is ClassName::MethodName*/
		/*Method reference can also be used to implement the functional interfaces*/
		/*This method which was referenced acts as the body for that particular abstract class*/
		
		//Creating a reference to a static method
		Encoder encoder = HashEncoderDecoder :: encodeUsingHashCode;
		char encodedChars[] = encoder.encode("saikrishna_akkenapelly".toCharArray());
		System.out.println(String.valueOf(encodedChars));
		
		//Creating a reference to instance method
		HashEncoderDecoder hashingEncoderDecoder = new HashEncoderDecoder();
		Decoder decoder = hashingEncoderDecoder :: decodeUsingHashCode;
		char decodedChars[] = decoder.decode(encodedChars);
		System.out.println(String.valueOf(decodedChars));
		
		/*Reference can also be created to a constructor as well by using new keyword instead of method name in syntax*/
	}
}
