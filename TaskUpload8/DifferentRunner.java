package com.example.task8diff;

import java.lang.reflect.Method;
import java.util.Scanner;

public class DifferentRunner 
{
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		
		try 
		{
			Class<?> pojoClass= Class.forName("com.example.task8.PojoClass");
			
			Object pojoClassObj= pojoClass.getConstructor().newInstance();
			System.out.println("Default Constructor invoked. - "+pojoClassObj);
			
			pojoClassObj= pojoClass.getConstructor(String.class, int.class).newInstance("Bala",20);
			System.out.println("Overloded Constructor invoked. - "+pojoClassObj);
			
			Method setNameMethod= pojoClass.getMethod("setName",String.class);
			setNameMethod.invoke(pojoClassObj, "Naveen");
			System.out.println("The new Name has been set to the object!");

			Method getNameMethod= pojoClass.getMethod("getName");
			String name= (String) getNameMethod.invoke(pojoClassObj);
			System.out.println("Output for getName method : "+name);
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
