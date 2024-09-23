package com.example.task7;

import java.util.Map;
import java.util.Scanner;

import com.example.exception.InvalidException;

public class Runner {
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		HashMapTasks obj=new HashMapTasks();
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
					case 19:
						runner.exercise19(scanner,obj);
						break;
					case 20:
						runner.exercise20(scanner,obj);
						break;
					case 0:
						flag++;
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
		System.out.printf("\nSelect a valid option from below : \n");
		System.out.printf("1 - Create & Print the HashMap with its size.	2 - Create & Add Key(String)-Value(String) to HMap\n"
				+ "3 - Create & Add Key(Integer)-Value(Integer) to HMap	4 - Create & Add Key(String)-Value(Integer) to HMap\n"
				+ "5 - Create & Add Key(String)-Value(Custom Object) to HMap	6 - Create & Add Key(String) with null Value\n"
				+ "7 - Create & Add with null Key & Non-NULL Value	8 - Check whether a Key exists in HMap\n"
				+ "9 - Check whether a Value exists in HMap	10 - Change Values for Key with Existing Values\n"
				+ "11 - Get Value of Existing Key	12 - Get value of Non-Existing Key\n"
				+ "13 - Get a default Value for a Non-existing Key	14 - Remove an existing Key from HMap\n"
				+ "15 - Remove an existing Key if the Value matches	16 - Replace the value of Existing Key\n"
				+ "17 - Replace the Value of existing Key if Value matches	18 - Add pairs of one Map to another\n"
				+ "19 - Iterate through Map entries	20 - Remove all entries in a HMap	0 - Exit\n\n");
	}
	
	private void exercise1(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,Integer> newMap= obj.createMap();
		
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise2(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise3(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<Integer,Integer> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		int key,value;
		for(int i=0;i<num;i++)
		{
			key= scanner.nextInt();
			value= scanner.nextInt();
			
			obj.addToMap(newMap, key, value);
		}
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise4(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,Integer> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key;
		int value;
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.nextInt();
			scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise5(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,Data> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the Key & Value(for Data Object)");
		String key,name;
		Data value;
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			System.out.println("Enter name for Data object entry : ");
			name= scanner.next();
			value= new Data(i+1,name);
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise6(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			if(i%2==0)
			{
				obj.addToMap(newMap, key, value);
			}
			else
			{
				obj.addToMap(newMap, key, null);
			}
		}
		
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise7(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			if(i%2==0)
			{
				obj.addToMap(newMap, key, value);
			}
			else
			{
				obj.addToMap(newMap, null, value);
			}
		}
		
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise8(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("Enter the key to be checked : ");
		key= scanner.next();
		
		boolean check= obj.checkForKey(newMap, key);
		System.out.println("Is the key present in the Map : "+check);
	}
	
	private void exercise9(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("Enter the value to be checked : ");
		value= scanner.next();
		
		boolean check= obj.checkForValue(newMap, value);
		System.out.println("Is the value present in the Map : "+check);
	}
	
	private void exercise10(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap);
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
		System.out.println();
		System.out.println("Enter the entries in Key - Value pair to be replaced :");
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.replaceValue(newMap, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap);
		
		size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise11(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("Enter the key to be fetched : ");
		key= scanner.next();
		
		String outString= obj.getValue(newMap, key);
		System.out.println("The value paired to the given key is : "+outString);
	}
	
	private void exercise12(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("Enter the Non-existing key to be fetched : ");
		key= scanner.next();
		
		String outString= obj.getValue(newMap, key);
		System.out.println("The value paired to the given key is : "+outString);
	}
	
	private void exercise13(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap);
	
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
		
		System.out.println("Enter the Non-existing key to be fetched : ");
		key= scanner.next();
		
		System.out.println("Enter the default value to be printed : ");
		String defaultValue= scanner.next();
		
		String outString= obj.getOrDefaultValue(newMap, key, defaultValue);
		System.out.println("The value paired to the given key is : "+outString);
		
		System.out.println("The Map entries are :"+newMap);
		
		size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise14(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("Enter the key to be removed : ");
		key= scanner.next();
		
		obj.remove(newMap, key);
		
		System.out.println("The Map entries are :"+newMap);
		
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise15(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap);
		
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
		
		System.out.println("Enter the key to be removed : ");
		key= scanner.next();
		System.out.println("Enter the value to check for paired up : ");
		value= scanner.next();
		
		obj.removeIfMatches(newMap, key, value);
		
		System.out.println("The Map entries are :"+newMap);
		
		size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise16(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("Enter the key to be replaced : ");
		key= scanner.next();
		System.out.println("Enter the value of replacement : ");
		value= scanner.next();
		
		obj.replaceValue(newMap, key, value);
		
		System.out.println("The Map entries are :"+newMap);
		
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise17(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap);
		
		int size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
		
		System.out.println("Enter the key to be replaced : ");
		key= scanner.next();
		System.out.println("Enter the value to check for paired up already : ");
		value= scanner.next();
		
		System.out.println("Enter the value of replacement : ");
		String newValue= scanner.next();
		
		obj.replaceIfMatches(newMap, key, value, newValue);
		
		System.out.println("The Map entries are :"+newMap);
		
		size= obj.sizeOfMap(newMap);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise18(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap1= obj.createMap();
		
		System.out.println("Enter the no. of entries for Map-1 : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap1, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap1);
		
		int size= obj.sizeOfMap(newMap1);
		System.out.println("The size of the Map is : "+size);
		
		Map<String,String> newMap2= obj.createMap();
		
		System.out.println("Enter the no. of entries for Map-2 : ");
		num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap2, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap2);
		
		size= obj.sizeOfMap(newMap2);
		System.out.println("The size of the Map is : "+size);
		
		obj.transferMap(newMap1, newMap2);
		
		System.out.println("The Map entries are :"+newMap1);
		
		size= obj.sizeOfMap(newMap1);
		System.out.println("The size of the Map is : "+size);
		
		System.out.println("The Map entries are :"+newMap2);
		
		size= obj.sizeOfMap(newMap2);
		System.out.println("The size of the Map is : "+size);
	}
	
	private void exercise19(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap= obj.createMap();
		
		System.out.println("Enter the no. of entries : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap, key, value);
		}
		
		for (Map.Entry<String, String> entry : obj.getEntry(newMap)) 
		{
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
	}
	
	private void exercise20(Scanner scanner, HashMapTasks obj) throws InvalidException
	{
		Map<String,String> newMap1= obj.createMap();
		
		System.out.println("Enter the no. of entries for Map-1 : ");
		int num= scanner.nextInt();
		
		System.out.println("Enter the entries in Key - Value pair separated by space : ");
		String key,value;
		
		for(int i=0;i<num;i++)
		{
			key= scanner.next();
			value= scanner.next();
			
			obj.addToMap(newMap1, key, value);
		}
		
		System.out.println("The Map entries are :"+newMap1);
		
		int size= obj.sizeOfMap(newMap1);
		System.out.println("The size of the Map is : "+size);
		
		obj.clearMap(newMap1);
		
		System.out.println("The Map entries are :"+newMap1);
		
		size= obj.sizeOfMap(newMap1);
		System.out.println("The size of the Map is : "+size);
		
	}
}
