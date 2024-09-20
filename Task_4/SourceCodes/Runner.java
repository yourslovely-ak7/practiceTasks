package com.example.task4;

import java.util.*;
import com.example.task4.InvalidException;

public class Runner
{
	public String resLen="The length of the String Builder : ";
	public String resOut="The final String : ";
	public String reqNum="Enter the no. of Strings : ";
	public String reqDl="Enter the delimitter : ";
	public String reqVal="Enter the values for Strings : ";
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		StringBuilderTasks obj=new StringBuilderTasks();
		Runner runner=new Runner();
		int flag=0;
		
		try
		{
			while(flag==0)
			{
				try
				{
					runner.defaultPrint();
					int option= scanner.nextInt();
					
					switch(option)
					{
						case 1:
							runner.lengthOfSB(scanner,obj);
							break;
						case 2:
							runner.addArrayElements(scanner,obj);
							break;
						case 3:
							runner.insertString(scanner,obj);
							break;
						case 4:
							runner.removeString(scanner,obj);
							break;
						case 5:
							runner.replaceSpace(scanner,obj);
							break;
						case 6:
							runner.reverseString(scanner,obj);
							break;
						case 7:
							runner.deleteString(scanner,obj);
							break;
						case 8:
							runner.replaceString(scanner,obj);
							break;
						case 9:
						case 10:
							runner.indexOfStringBuilder(scanner,obj);
							break;
						case 0:
							System.out.println("Ta!Ta!");
							flag++;
							break;
						default:
							System.out.println("Enter a valid option : ");
					}
				}
				catch(InputMismatchException error)
				{
					System.out.println("The entered option is Invalid! Please, try again...");
					scanner.next();
				}
				catch(InvalidException error)
				{
					System.out.println("Error : "+error.getMessage());
					error.printStackTrace();
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
		System.out.printf("\n\n1 - Append & find the Length of SB	2 - Append array of Strings with delimitter in SB\n3 - Insert String in between Strings in SB	4 - Delete a String from SB\n5 - Replace delimitter with another delimitter in SB	6 - Reverse of a SB\n7 - Delete characters within specific index in SB	8 - Replace characters within specific index in SB\n9 & 10 - Find the index of delimitter with its position	0 - Exit\n\n");
		System.out.println("Enter a option from below : ");
	}
	
	private void lengthOfSB(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		StringBuilder newSB= obj.constructSB();
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter a String : ");
		String newString= scanner.next();
		
		newSB= obj.appendString(newSB,newString);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void addArrayElements(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println("Enter a String : ");
		String newString= scanner.next();
		
		StringBuilder newSB= obj.constructSB(newString);
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(reqNum);
		int arrayLength= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		String stringArray[]=new String[arrayLength];
		
		System.out.println(reqVal);
		for(int i=0;i<arrayLength;i++)
		{
			stringArray[i]= scanner.next();
		}
		
		newSB= obj.stringArrayToStringBuilder(newSB,stringArray,delimitter);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void insertString(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter the String to be inserted : ");
		String insertString= scanner.next();
		
		System.out.println("Enter the position to be inserted : ");
		int position= scanner.nextInt();	
		
		newSB= obj.insertBetweenStrings(newSB,insertString,delimitter,position,num);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void removeString(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter the index of String to be removed : ");
		int index= scanner.nextInt();
		
		newSB= obj.removeString(newSB,delimitter,index,num);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void replaceSpace(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter the delimitter to be set : ");
		String source= scanner.next();
		
		newSB= obj.replaceString(newSB,delimitter,source);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void reverseString(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		newSB= obj.reverseSB(newSB);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void deleteString(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter the begin index for deletion : ");
		int start= scanner.nextInt();
		
		System.out.println("Enter the end index for deletion : ");
		int end= scanner.nextInt();
		
		newSB= obj.deleteSB(newSB,start,end);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void replaceString(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter the begin index : ");
		int start= scanner.nextInt();
		
		System.out.println("Enter the end index : ");
		int end= scanner.nextInt();
		
		System.out.println("Enter the String for replacement : ");
		String replacement= scanner.next();
		
		newSB= obj.replaceSB(newSB,start,end,replacement);
		
		length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println(resOut+obj.convertToString(newSB));
	}
	
	private void indexOfStringBuilder(Scanner scanner, StringBuilderTasks obj) throws InvalidException
	{
		System.out.println(reqNum);
		int num= scanner.nextInt();
		
		System.out.println(reqDl);
		String delimitter= scanner.next();
		
		StringBuilder newSB= obj.constructSB();
		
		System.out.println(reqVal);
		for(int i=0;i<num;i++)
		{
			if(i>0)
			{
				obj.appendString(newSB,delimitter);
			}
			obj.appendString(newSB,scanner.next());
		}
		
		int length= obj.lengthOfStringBuilder(newSB);
		System.out.println(resLen+length);
		
		System.out.println("Enter the position of delimitter to find the index for : ");
		int position= scanner.nextInt();

		int index= obj.indexOfString(newSB,delimitter,position);
		System.out.println("The index of "+delimitter+" in the String Builder : "+index);
	}
	
	
}
