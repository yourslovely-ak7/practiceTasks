package com.example.task5;

import com.example.task5.Car;
import com.example.task5.Swift;
import com.example.task5.SCross;
import com.example.task5.XUV;
import java.util.*;

public class Runner
{
	private void normalMethod(Car car)
	{
		System.out.println("This method is invoked by an instace of "+ car.getClass());
		
		String type="None";
		
		if(car instanceof Swift)
		{
			type= "Hatch";
		}
		else if(car instanceof SCross)
		{
			type= "Sedan";
		}
		else if(car instanceof XUV)
		{
			type= "SUV";
		}
		
		System.out.println("The output is : "+ type);
	}
	
	private void anotherMethod(Swift car)
	{
		System.out.println("This method is invoked by an instace of "+ car.getClass());
	}
	
	public static void main(String [] args)
	{
		Runner runner=new Runner();
		
		runner.exerciseTwo();
		runner.exerciseThree();
		runner.exerciseFourAndFive(runner);
		runner.exerciseSix(runner);
		runner.exerciseSeven();
		runner.exerciseEight();
		runner.exerciseNine();
		runner.exerciseTen();		
	}
	
	private void exerciseTwo()
	{
		System.out.printf("\n2nd - Exercise : Swift instance with their getters & setters!\n\n");
		Swift car=new Swift();
		
		car.setSeats(5);
		car.setAirbags(2);
		car.setModel("Model_1");
		car.setColor("Blue");
		
		System.out.println("The no. of Seats in the car : "+ car.getSeats());
		System.out.println("The no. of Airbags in the car : "+ car.getAirbags());
		System.out.println("The Model of the car : "+ car.getModel());
		System.out.println("The Color of the car : "+ car.getColor());
	}
	
	private void exerciseThree()
	{
		System.out.printf("\n3rd - Exercise : SCross instance with their getters & setters including Car class!\n\n");
		SCross car1=new SCross();
		
		car1.setYearOfMake(2004);
		car1.setEngineNumber("ABC-012345");
		car1.setType("SUV");
		car1.setSeats(5);
		car1.setAirbags(3);
		car1.setModel("Model_2");
		car1.setColor("Black");
		
		System.out.println("The year of make of the car : "+ car1.getYearOfMake());
		System.out.println("The Engine Number of the car : "+ car1.getEngineNumber());
		System.out.println("The Type of the car : "+ car1.getType());
		System.out.println("The no. of Seats in the car : "+ car1.getSeats());
		System.out.println("The no. of Airbags in the car : "+ car1.getAirbags());
		System.out.println("The Model of the car : "+ car1.getModel());
		System.out.println("The Color of the car : "+ car1.getColor());	
	}
	
	private void exerciseFourAndFive(Runner runner)
	{
		System.out.printf("\n4th & 5th - Exercise : Call a method having Car object as argument by passing sub-class objects\n\n");
		
		Swift obj=new Swift();
		System.out.println("Attempting to call the method with instance of Swift...");
		runner.normalMethod(obj);
		
		SCross obj1=new SCross();
		System.out.println("Attempting to call the method with instance of SCross...");
		runner.normalMethod(obj1);
		
		XUV obj2=new XUV();
		System.out.println("Attempting to call the method with instance of XUV...");
		runner.normalMethod(obj2);	
	}
	
	private void exerciseSix(Runner runner)
	{
		System.out.printf("\n6th - Exercise : Call a method having Swift object as argument by passing other sub-class & superclass objects\n\n");
		
		Swift obj3=new Swift();
		System.out.println("Attempting to call the method with instance of Swift...");
		runner.anotherMethod(obj3);
		
	//The folowing method calls cannot be done since the objects are of different types.
		
	//	Car obj4=new Swift();
	//	runner.anotherMethod(obj4);	
		
	//	SCross obj5=new SCross();
	//	runner.anotherMethod(obj5);
		
	//	XUV obj6=new XUV();
	//	runner.anotherMethod(obj6);
	}
	
	private void exerciseSeven()
	{
		System.out.printf("\n7th - Exercise : Create a method in Car class & Override it in one sub-class.\n\n");
		
		SCross obj4=new SCross();
		obj4.maintenance();
		
		Car obj5=new SCross();
		obj5.maintenance();
		
		Car obj6=new Car();
		obj6.maintenance();
		
		Swift obj7=new Swift();
		obj7.maintenance();
	}
	
	private void exerciseEight()
	{
		System.out.printf("\n8th - Exercise : Create an overloaded constructor in Car class and XUV class.\n\n");
		
		System.out.println("The output while creating instance with default constructor : ");
		XUV obj8=new XUV();
		System.out.println("The output while creating instance with overloaded constructor : ");
		XUV obj9=new XUV("HelloWorld!");
	}
	
	private void exerciseNine()
	{
		System.out.printf("\n9th - Exercise : Create an instance of an abstract class & it's child class.\n\n");
		
	// Abstract classes cannot be instantiated. i.e., We cannot create an object for AbstractClass directly! 	
	//	BirdAbstract object=new BirdAbstract();
	
		ParrotMod object=new ParrotMod();
		object.fly();
		object.speak();
	}
	
	private void exerciseTen()
	{
		System.out.printf("\n10th - Exercise : Create an Abstract class with an abstarct method and give an implementation for it in a concrete class.\n\n");
		
		Duck object1=new Duck();
		object1.speak();
		object1.fly();
	}
	
}
