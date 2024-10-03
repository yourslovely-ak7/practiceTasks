package com.example.task8;

import java.util.Scanner;

import com.example.exception.InvalidException;

public class ClassRunner {
	
	public static void main(String []args)
	{
		Scanner scanner=new Scanner(System.in);
		ClassRunner runner=new ClassRunner();
		
		int flag=0;
		int option;
	
		try
		{
			while(flag==0)
			{
				runner.defaultPrint();
				option= scanner.nextInt();
				try
				{
					switch(option)
					{
					case 5:
						runner.exercise5(scanner);
						break;
					case 6:
						runner.exercise6(scanner);
						break;
					case 7:
						runner.exercise7(scanner);
						break;
					case 8:
						runner.exercise8(scanner);
						break;
					case 9:
						runner.exercise9(scanner);
						break;
					case 0:
						flag++;
						System.out.println("Thank You!");
						break;
					default:
						System.out.println("Please! Enter a valid option...");
					}
				}
				catch(InvalidException error)
				{
					System.out.println(error.getMessage());
				}
			}
		}
		finally {
			scanner.close();
		}
	}
	
	private void defaultPrint()
	{
		System.out.printf("\nSelect an option : \n");
	}
	
	private void exercise5(Scanner scanner) throws InvalidException
	{
		scanner.nextLine();
		System.out.println("Enter the name for the object : ");
		String name= scanner.nextLine();
		
		PojoClass obj=new PojoClass(name);
		System.out.println(obj);
	}
	
	private void exercise6(Scanner scanner) throws InvalidException
	{
		scanner.nextLine();
		System.out.println("Enter the name for the object : ");
		String name= scanner.nextLine();
		System.out.println("Enter the age for the object : ");
		int age= scanner.nextInt();
		
		PojoClass obj=new PojoClass(name,age);
		System.out.println(obj);
	}
	
	private void exercise7(Scanner scanner) throws InvalidException
	{
		scanner.nextLine();
		PojoClass obj=new PojoClass();
		System.out.println("Enter the name for the object : ");
		String name= scanner.nextLine();
		System.out.println("Enter the age for the object : ");
		int age= scanner.nextInt();
		
		obj.setName(name);
		obj.setAge(age);
		
		System.out.println("Object - Name : "+obj.getName()+" & Age : "+obj.getAge());
	}
	
	private void exercise8(Scanner scanner) throws InvalidException
	{
		for(RainbowColours colour: RainbowColours.values())
		{
			System.out.println("Colour : "+colour.name()+"		ColourCode : "+(colour.ordinal()+1));
		}
	}
	
	private void exercise9(Scanner scanner) throws InvalidException
	{
		SingletonClass obj1= SingletonClass.getInstance();
		SingletonClass obj2= SingletonClass.getInstance();
		
		if(obj1.equals(obj2))
		{
			System.out.println("Both variables refers the same object in the heap!");
		}
	}
}
