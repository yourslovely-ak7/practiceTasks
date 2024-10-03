package com.example.task8;

import java.util.Scanner;
import java.util.logging.Logger;

import com.example.exception.InvalidException;

public class TimeRunner 
{
	public static Logger logger= Logger.getLogger(TimeRunner.class.getName());
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		TimeTasks timeObj=new TimeTasks();
		TimeRunner runner=new TimeRunner();
		
		int flag=0;
		int option;
		
		try {
			
			while(flag==0)
			{
				runner.defaultPrint();
				option= scanner.nextInt();
				
				try
				{
					switch(option)
					{
					case 1:
						runner.exercise1(scanner,timeObj);
						break;
					case 2:
						runner.exercise2(scanner,timeObj);
						break;
					case 3:
						runner.exercise3(scanner,timeObj);
						break;
					case 4:
						runner.exercise4(scanner,timeObj);
						break;
					case 5:
						runner.exercise5(scanner, timeObj);
						break;
					case 6:
						runner.exercise6(scanner, timeObj);
						break;
					case 0:
						flag++;
						logger.info("Thank You! See you again...");
						break;
					default:
						logger.info("Enter a valid Input!");
					}
				}
				catch(InvalidException error)
				{
					logger.severe("Error : "+ error);
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
	
	private void exercise1(Scanner scanner, TimeTasks timeObj) throws InvalidException
	{
		String pattern= "dd-MM-yyyy HH:mm:ss";
		System.out.println(timeObj.getCurrentTime(pattern));
	}
	
	private void exercise2(Scanner scanner, TimeTasks timeObj)
	{
		System.out.println("CurrentTime in Millis using java.time package : "+timeObj.getCurrentTimeInMilliUsingTimePackage());
		System.out.println("CurrentTime in Millis using System package : "+timeObj.getCurrentTimeInMilliUsingSystem());
	}
	
	private void exercise3(Scanner scanner, TimeTasks timeObj) throws InvalidException
	{
		String zone1= "America/New_York";
		String zone2= "Europe/London";
		String pattern= "dd-MM-yyyy HH:mm:ss";
		
		System.out.println("Current Time at zone : "+zone1+" is = "+timeObj.getCurrentTimeFromZones(zone1, pattern));
		System.out.println();
		System.out.println("Current Time at zone : "+zone2+" is = "+timeObj.getCurrentTimeFromZones(zone2, pattern));
	}
	
	private void exercise4(Scanner scanner, TimeTasks timeObj)
	{
		long millis= timeObj.getCurrentTimeInMilliUsingSystem();
		
		System.out.println("The day of the week for the given millis : "+ timeObj.getCurrentDayOfWeekFromMillis(millis));
	}
	
	private void exercise5(Scanner scanner, TimeTasks timeObj)
	{
		long millis= timeObj.getCurrentTimeInMilliUsingSystem();
		
		System.out.println("The day of the week for the given millis : "+ timeObj.getCurrentMonthFromMillis(millis));
	}
	
	private void exercise6(Scanner scanner, TimeTasks timeObj)
	{
		long millis= timeObj.getCurrentTimeInMilliUsingSystem();
		
		System.out.println("The day of the week for the given millis : "+ timeObj.getCurrentYearFromMillis(millis));
	}
}
