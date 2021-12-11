package com.sai.java.features.base64;

import java.util.Base64;

public class Base64Demo
{
	public static void main(String[] args)
	{
		/*Base64 was introduced in java 8*/ 
		/*Simple encoding and decoding*/
		String name = "Saikrishna";
		String encodedName = Base64.getEncoder().encodeToString(name.getBytes());
		System.out.println(encodedName);
		
		String decodedString = new String(Base64.getDecoder().decode(encodedName.getBytes()));
		System.out.println(decodedString);
		
		/*URL encoding and decoding*/
		String url = "http://localhost/supplyWeb/owner/login";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes());
		System.out.println(encodedUrl);
		
		String decodedUrl = new String(Base64.getUrlDecoder().decode(encodedUrl.getBytes()));
		System.out.println(decodedUrl);
		
		/*MIME encoding and decoding*/
		String mail = "Hi Sai,\nWelcome onboard.\nThanks,\nkrishna.";
		String encodedMail = Base64.getMimeEncoder().encodeToString(mail.getBytes());
		System.out.println(encodedMail);
		
		String decodedMail = new String(Base64.getMimeDecoder().decode(encodedMail.getBytes()));
		System.out.println(decodedMail);
	}
}
