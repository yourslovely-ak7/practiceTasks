package com.example.task10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.example.exception.InvalidException;

public class Runner 
{
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		TaskClass obj=new TaskClass();
		Runner runner=new Runner();
		int flag=0;
		int option=0;
		
		try
		{
			while(flag==0)
			{	
				try
				{
					runner.defaultPrint();
					option= scanner.nextInt();
					scanner.nextLine();
					
					switch(option)
					{
					case 1:
						runner.exercise1(scanner,obj);
						break;
					case 2:
						runner.exercise2(scanner,obj);
						break;
					case 3:
						runner.exercise3(scanner,obj);
						break;
					case 4:
						runner.exercise4(scanner,obj);
						break;
					case 5:
						runner.exercise5(scanner,obj);
						break;
					case 6:
						runner.exercise6(scanner,obj);
						break;
					case 7:
						runner.exercise7(scanner,obj);
						break;
					case 8:
						runner.exercise8(scanner,obj);
						break;
					case 0:
						flag++;
						System.out.println("Thank U!");
						break;
					default:
						System.out.println("Invalid Input! Enter a valid input..");
					}
				}
				catch(InvalidException error)
				{
					System.out.println(error.getMessage());
				}
			}
		}
		finally
		{
			scanner.close();
		}
	}
	
	private void defaultPrint()
	{
		System.out.printf("\nSelect an option : \n");
	}
	
	private void exercise1(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter the mobile number : ");
		String number= scanner.nextLine();
		
		String regex= "^[789]\\d{9}$";
		
		boolean check= obj.mobileNumberValidation(number, regex);
		
		System.out.println("The validation result is : "+check);
	}
	
	private void exercise2(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter an alphanumeric string : ");
		String newString= scanner.nextLine();
		
		String regex= "^[a-zA-Z0-9]+$";
		
		boolean check= obj.alphaNumericValidation(newString, regex);
		
		System.out.println("The validation result is : "+check);
	}
	
	private void exercise3(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter a value for string : ");
		String givenString= scanner.nextLine();
		
		System.out.println("Enter a value for matching string : ");
		String matchingString= scanner.nextLine();
		
		String regex= "^"+Pattern.quote(matchingString)+".*";
		boolean check= obj.stringMatchValidation(givenString, regex);
		
		System.out.println("Is the given String starts with matching String : "+check);
		
		regex= ".*"+matchingString+".*";
		check= obj.stringMatchValidation(givenString, regex);
		
		System.out.println("Is the given String contains the matching String : "+check);
		
		regex= ".*"+matchingString+"$";
		check= obj.stringMatchValidation(givenString, regex);
		
		System.out.println("Is the given ends with matching String : "+check);
		
		regex= "^"+matchingString+"$";
		check= obj.stringMatchValidation(givenString, regex);
		
		System.out.println("Is the given String matches the matching String : "+check);
	}
	
	private void exercise4(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter the number of elements : ");
		int num= scanner.nextInt();
		scanner.nextLine();
		List<String> list=new ArrayList<>();
		String newString;
		System.out.println("Enter the Strings : ");
		for(int i=0;i<num;i++)
		{
			newString= scanner.nextLine();
			list.add(newString);
		}
		
		System.out.println("Enter the matching String : ");
		String matchingString= scanner.nextLine();
		
		Pattern pattern= Pattern.compile(Pattern.quote(matchingString),Pattern.CASE_INSENSITIVE);
		
		for(String iter: list)
		{
			if(obj.caseInsensitiveValidation(iter, pattern))
			{
				System.out.println("The given String "+iter+" matches with the matching String");
			}
			else
			{
				System.out.println("The given String "+iter+" doesn't matches with the matching String");
			}
		}
	}
	
	private void exercise5(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter the e-mail address : ");
		String email= scanner.nextLine();
		System.out.println(email);
		String regex= "^[a-z]{1}[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,}$";
		
		boolean check= obj.emailValidation(email, regex);
		
		System.out.println("The validation result is : "+check);
	}
	
	private void exercise6(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter the number of elements : ");
		int num= scanner.nextInt();
		scanner.nextLine();
		
		List<String> list=new ArrayList<>();
		String newString;
		
		System.out.println("Enter the Strings : ");
		for(int i=0;i<num;i++)
		{
			newString= scanner.nextLine();
			list.add(newString);
		}
		System.out.println("Enter the maximum range of length : ");
		int max= scanner.nextInt();
		
		String regex="^\\.{1,"+max+"}$";
		
		for(String iter: list)
		{
			if(obj.lengthValidation(iter, regex))
			{
				System.out.println("The given String "+iter+" is within the given range");
			}
			else
			{
				System.out.println("The given String "+iter+" is not within the given range");
			}
		}
	}
	
	private void exercise7(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter the number of elements for list 1: ");
		int num= scanner.nextInt();
		scanner.nextLine();
		
		List<String> list1=new ArrayList<>();
		String newString;
		
		System.out.println("Enter the Strings : ");
		for(int i=0;i<num;i++)
		{
			newString= scanner.nextLine();
			list1.add(newString);
		}
		
		System.out.println("Enter the number of elements for list 2: ");
		num= scanner.nextInt();
		scanner.nextLine();
		
		List<String> list2=new ArrayList<>();
		
		System.out.println("Enter the Strings : ");
		for(int i=0;i<num;i++)
		{
			newString= scanner.nextLine();
			list2.add(newString);
		}
		
		String regex;
		Map<String,Integer> map=new HashMap<>();
		
		for(String matchString : list2)
		{
			regex= "\\b"+Pattern.quote(matchString)+"\\b";
			
			for(int i=0;i<list1.size();i++)
			{
				if(obj.listElementsValidation(list1.get(i), regex))
				{
					map.put(matchString,i);
				}
			}
		}
		
		System.out.println(map);
	}
	
	private void exercise8(Scanner scanner, TaskClass obj) throws InvalidException
	{
		System.out.println("Enter a string with HTML tags : ");
		String newString= scanner.nextLine();
		
		String regex= "<[^>]+>";
		
		List<String> list= obj.htmlTagsValidation(newString, regex);
		
		System.out.println(list);
	}
	
}
