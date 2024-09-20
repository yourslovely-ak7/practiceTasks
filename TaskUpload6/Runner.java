package com.example.task6;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.exception.InvalidException;

public class Runner {
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		ArrayListTasks obj=new ArrayListTasks();
		Runner runner=new Runner();
		int flag=0;
		try
		{
			while(flag==0)
			{
				runner.defaultPrint();
				int option= scanner.nextInt();
				
				try
				{
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
						
					case 9:
						runner.exercise9(scanner,obj);
						break;
						
					case 10:
						runner.exercise10(scanner,obj);
						break;
						
					case 11:
						runner.exercise11(scanner,obj);
						break;
						
					case 12:
						runner.exercise12(scanner,obj);
						break;
					case 13:
						runner.exercise13(scanner,obj);
						break;
					case 14:
						runner.exercise14(scanner,obj);
						break;
						
					case 15:
						runner.exercise15(scanner,obj);
						break;
						
					case 16:
						runner.exercise16(scanner,obj);
						break;
						
					case 17:
						runner.exercise17(scanner,obj);
						break;
						
					case 18:
						runner.exercise18(scanner,obj);
						break;
						
					case 0:
						System.out.println("Thank You! BYE...");
						flag++;
						break;
					
						default:
							System.out.println("Enter a valid option!!!");
					}
				}
				catch(InvalidException error)
				{
					System.out.println("Error : "+error.getMessage());
				}
				catch(InputMismatchException error)
				{
					System.out.println("Enter a valid Input!");
					scanner.next();
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
		System.out.printf("\nSelect an option from below : ");
		System.out.printf("\n1 - Create & Print size of an AL	2 - Add String to AL & Print them\n"
				+ "3 - Add Integer to AL & Print them	4 - Add Custom objects to AL & Print them\n"
				+ "5 - Add String,Integer,Custom objects to AL & Print them	6 - Find index of an element\n"
				+ "7 - Print the elements using ForLoop & Iterator method	8 - Get element by index value\n"
				+ "9 - First & Last index of an element in AL	10 - Add element at specific index\n"
				+ "11 - Create an AL using specific elements from another AL	12 - Create an AL using other ALs specifying first AL has to be ahead\n"
				+ "13- Create an AL using other ALs specifying second has to be ahead\n"
				+ "14 - Remove an element from specific index	15 - Remove elements from an AL which are there in another AL\n"
				+ "16 - Remove elements from an AL which are not in another AL	17 - Remove all the element from an AL\n"
				+ "18 - Check whether an element is present or not in an AL	0 - Exit\n\n");
	}
	
	private void exercise1(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		int size= obj.sizeOfAL(newList);
		
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise2(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		int size= obj.sizeOfAL(newList);
		
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise3(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<Integer> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.nextInt());
		}
		
		int size= obj.sizeOfAL(newList);
		
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise4(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<Trainee> newList = obj.createAL();
		
		Trainee obj1=new Trainee("AK","PT-7617",2025,"Karaikudi");
		Trainee obj2=new Trainee("Guru","PT-7618",2025,"Madurai");
		Trainee obj3=new Trainee("Subi","PT-7619",2025,"Coimbatore");
		
		obj.addToAL(newList, obj1);
		obj.addToAL(newList, obj2);
		obj.addToAL(newList, obj3);
		
		int size= obj.sizeOfAL(newList);
		
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise5(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<Object> newList = obj.createAL();
		System.out.println("Enter the no. of Integer inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.nextInt());
		}
		
		System.out.println("Enter the no. of String inputs you want to add : ");
		num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		Trainee obj1=new Trainee("AK","PT-7617",2025,"Karaikudi");
		Trainee obj2=new Trainee("Guru","PT-7618",2025,"Madurai");
		Trainee obj3=new Trainee("Subi","PT-7619",2025,"Coimbatore");
		
		obj.addToAL(newList, obj1);
		obj.addToAL(newList, obj2);
		obj.addToAL(newList, obj3);
		
		int size= obj.sizeOfAL(newList);
		
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise6(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		System.out.println("Enter the string you want to search for : ");
		String newString= scanner.next();
		
		int index= obj.indexOfAL(newList, newString);
		System.out.println("The index of the given string is : "+index);
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise7(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		Iterator<String> iterator= obj.iterOfAL(newList);
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		for(String iter:newList)
		{
			System.out.println(iter);
		}
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise8(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		System.out.println("Enter the index you want to search for : ");
		int index= scanner.nextInt();
		
		String newString= obj.getElement(newList, index);
		System.out.println("The string in the given index is : "+newString);
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise9(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		System.out.println("Enter the string you want to search for : ");
		String newString= scanner.next();
		
		int firstIndex= obj.indexOfAL(newList, newString);
		System.out.println("The first index of the given string is : "+firstIndex);
		
		int lastIndex= obj.lastIndexOfAL(newList, newString);
		System.out.println("The last index of the given string is : "+lastIndex);
	}
	
	private void exercise10(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		System.out.println("Enter the string you want to insert : ");
		String newString= scanner.next();
		System.out.println("Enter the index you want to insert : ");
		int index= scanner.nextInt();
		
		obj.addAtIndex(newList, newString, index);
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise11(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		System.out.println("Enter the starting index : ");
		int startIndex= scanner.nextInt();
		
		System.out.println("Enter the ending index : ");
		int endIndex= scanner.nextInt();
		
		List<String> outList= obj.subListOfAL(newList, startIndex, endIndex);
		
		int size= obj.sizeOfAL(outList);
		System.out.println("The element are : "+ (outList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise12(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList1 = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List-1 : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList1, scanner.next());
		}
		
		List<String> newList2 = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List-2 : ");
		num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList2, scanner.next());
		}
		
		List<String> outList= obj.createAL();
		obj.addListToAL(outList, newList1);
		obj.addListToAL(outList, newList2);
		
		int size= obj.sizeOfAL(outList);
		System.out.println("The element are : "+ (outList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise13(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList1 = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List-1 : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList1, scanner.next());
		}
		
		List<String> newList2 = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List-2 : ");
		num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList2, scanner.next());
		}
		
		List<String> outList= obj.createAL();
		obj.addListToAL(outList, newList2);
		obj.addListToAL(outList, newList1);
		
		int size= obj.sizeOfAL(outList);
		System.out.println("The element are : "+ (outList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise14(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<Double> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of Double : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.nextDouble());
		}
		
		System.out.println("Enter the index you want to remove : ");
		int index= scanner.nextInt();
		
		obj.removeAt(newList, index);
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise15(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList1 = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List-1 : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList1, scanner.next());
		}
		
		List<String> newList2 = obj.createAL();
		
		System.out.println("Enter the no. of inputs you want to add to List-2 : ");
		num= scanner.nextInt();

		System.out.println("Enter the values of String that shall be in List-1 : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList2, scanner.next());
		}
		
		obj.removeAllFromAL(newList1, newList2);
		
		int size= obj.sizeOfAL(newList1);
		System.out.println("The element are : "+ (newList1));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise16(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList1 = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List-1 : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList1, scanner.next());
		}
		
		List<String> newList2 = obj.createAL();
		
		System.out.println("Enter the no. of inputs you want to add to List-2 : ");
		num= scanner.nextInt();

		System.out.println("Enter the values of String that shall be in List-1 : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList2, scanner.next());
		}
		
		obj.retainAllFromAL(newList1, newList2);
		
		int size= obj.sizeOfAL(newList1);
		System.out.println("The element are : "+ (newList1));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise17(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<Long> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of Long : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.nextLong());
		}
		
		obj.clearAL(newList);
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
	
	private void exercise18(Scanner scanner, ArrayListTasks obj) throws InvalidException
	{
		List<String> newList = obj.createAL();
		System.out.println("Enter the no. of inputs you want to add to List : ");
		int num= scanner.nextInt();

		System.out.println("Enter the values of String : ");
		for(int i=0;i<num;i++)
		{
			obj.addToAL(newList, scanner.next());
		}
		
		System.out.println("Enter the String to be checked : ");
		String newString= scanner.next();
		
		boolean check= obj.containInAl(newList, newString);
		System.out.println("Is the element present in the ArrayList : "+check);
		
		int size= obj.sizeOfAL(newList);
		System.out.println("The element are : "+ (newList));
		System.out.println("The size of the ArrayList : "+size);
	}
}
