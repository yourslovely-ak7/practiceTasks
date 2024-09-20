package com.example.task5;

public class Car
{
	private int yearOfMake;
	private String engineNumber;
	private String type;
	
	public Car()
	{
	
	}

	public Car(String newString)
	{
		System.out.println("The string is : "+ newString);
	}
	
	public Car(int yearOfMake, String engineNumber, String type)
	{
		this.yearOfMake= yearOfMake;
		this.engineNumber= engineNumber;
		this.type= type;
	}
	
	public void setYearOfMake(int yearOfMake)
	{
		this.yearOfMake= yearOfMake;
	}
	
	public int getYearOfMake()
	{
		return yearOfMake;
	}
	
	public void setEngineNumber(String engineNumber)
	{
		this.engineNumber= engineNumber;
	}
	
	public String getEngineNumber()
	{
		return engineNumber;
	}
	
	public void setType(String type)
	{
		this.type= type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void maintenance()
	{
		System.out.println("Car under Maintenance!");
	}
}
