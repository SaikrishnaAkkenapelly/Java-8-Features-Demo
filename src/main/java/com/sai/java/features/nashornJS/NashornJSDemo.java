package com.sai.java.features.nashornJS;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornJSDemo
{
	public static void main(String[] args)
	{
		/*In java 8 nashorn a new java script engine was introduced*/
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		/*rihno is the old js engine used before java 8*/
		ScriptEngine nashorn = engineManager.getEngineByName("nashorn");
		
		try
		{
			String name = "Saikrishna";
			String script = "print('" + name + "')";
			/*eval method will execute the script in the engine*/
			nashorn.eval(script);
			Integer sum = (Integer)nashorn.eval("10+20");
			System.out.println(sum);
		}
		catch (ScriptException e)
		{
			System.out.println("ScriptException, given script might not be correct");
		}
		
		/*refer to the nashornDemo.js file in the same project to know how to use java inside javascrit using nashorn*/
	}
}
