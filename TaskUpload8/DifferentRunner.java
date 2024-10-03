package com.example.task8diff;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Logger;

public class DifferentRunner 
{
	public static Logger logger= Logger.getLogger(DifferentRunner.class.getName());
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		
		try 
		{
			Class<?> pojoClass= Class.forName("com.example.task8.PojoClass");
			
			Object pojoClassObj= pojoClass.getConstructor().newInstance();
			logger.info("Default Constructor invoked. - "+pojoClassObj);
			
			pojoClassObj= pojoClass.getConstructor(String.class, int.class).newInstance("Bala",20);
			logger.info("Overloded Constructor invoked. - "+pojoClassObj);
			
			Method setNameMethod= pojoClass.getMethod("setName",String.class);
			setNameMethod.invoke(pojoClassObj, "Naveen");
			logger.info("The new Name has been set to the object!");

			Method getNameMethod= pojoClass.getMethod("getName");
			String name= (String) getNameMethod.invoke(pojoClassObj);
			logger.info("Output for getName method : "+name);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			scanner.close();
		}
	}
}
