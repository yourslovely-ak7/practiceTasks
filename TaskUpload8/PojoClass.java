package com.example.task8;

public class PojoClass {
	
	private String name;
	private int age;
	
	public PojoClass()
	{
		
	}
	
	public PojoClass(String name)
	{
		this.name=name;
	}
	
	public PojoClass(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String toString()
	{
		return ("Name : "+name+" & Age : "+age);
	}
}
