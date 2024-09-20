package com.example.demo;

import java.util.*;
import java.io.Console;
import com.example.demo.StringTasks;
import com.example.demo.InvalidException;

public class Runner
{
	public String reqStr= "Enter your String : ";
	public String reqChar= "Enter the character : ";
	public String resValid= "The output of the validation is ";
	public String resStr= "The resultant String is ";
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		StringTasks obj=new StringTasks();
		Runner runner=new Runner();
		
		int flag=0,option=0;
		
		try
		{
		
		while(flag==0)
		{
			try
			{
				String string1= null;
				if(args.length >= 1)
				{
					string1= args[0];
				}
				
				runner.defaultPrint();
				option=scanner.nextInt();
			
				if((option>1 && option<18) || option==20)
				{
					System.out.println("Enter your String : ");
				}
			
			switch(option)
			{
				case 1:
					runner.lengthOfTheString(string1,obj);
					break;
				case 2:
					runner.stringToCharArray(scanner,obj);
					break;
				case 3:
					runner.penultimateElement(scanner,obj);					
					break;
				case 4:
					runner.occuranceOfElement(scanner,obj);
					break;
				case 5:
					runner.greatestPosition(scanner,obj);
					break;
				case 6:
					runner.lastFewCharacters(scanner,obj);					
					break;
				case 7:
					runner.firstFewCharacters(scanner,obj);
					break;
				case 8:
					runner.replaceFirstFewCharacters(scanner,obj);					
					break;
				case 9:
					runner.startsWithCheck(scanner,obj);					
					break;
				case 10:
					runner.endsWithCheck(scanner,obj);					
					break;
				case 11:
					runner.lowerToUpperCase(scanner,obj);					
					break;
				case 12:
					runner.upperToLowerCase(scanner,obj);					
					break;
				case 13:
					runner.stringReverse(scanner,obj);					
					break;
				case 14:
					runner.getMultipleStrings(scanner);					
					break;
				case 15:
					runner.concatenateStrings(scanner,obj);					
					break;
				case 16:
					runner.multipleStringsToArray(scanner,obj);					
					break;
				case 17:
					runner.mergeStringArray(scanner,obj);					
					break;
				case 18:
					runner.caseSensitiveEquals(scanner,obj);					
					break;
				case 19:
					runner.caseInsensitiveEquals(scanner,obj);					
					break;
				case 20:
					runner.trimSpaces(scanner,obj);					
					break;
				case 0:
					flag=1;
					
					System.out.println("Thank You! See you again...");
					
					break;
				default:
					System.out.println("You have entered a invalid choice!!!");
					System.out.println("Please, Select a suitable option.");
			}
			} 
			catch(InputMismatchException errorMessage)
			{
				System.out.println("Invalid Input recognized.");
				System.out.println("No Problem. Try Again...");
				scanner.next();
			}
			catch(InvalidException errorMessage)
			{
				System.out.println("Error : "+errorMessage.getMessage());
				errorMessage.printStackTrace();
				//System.out.println("The root cause : "+errorMessage.getCause());
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
		System.out.printf("\nSelect from the following operations to perform :\n");
		System.out.printf("1 - Length of the String	2 - Convert to Char Array\n3 - Penultimate Element of the String	4 - Occurance of a Char in given String\n5 - Greatest position of the given element	6 - Last few characters of the String\n7 - First few characters of the String	8 - Replace first few Char by replacement String\n9 - Check if the String starts with given prefix	10 - Check if the String ends with given suffix\n11 - Convert LowerCase to UpperCase	12 - Convert UpperCase to LowerCase\n13 - Reverse the given String	14 - Accept a line with multiple Strings\n15 - Concatenate individual Strings	16 - Multiple Strings to String Array\n17 - Merge multiple Strings with a special character	18 - Case sensitive Equality check b/w Strings\n19 - Case in-sensitive Equality check b/w Strings	20 - Trim leading & trailing spaces\n0 - Exit\n\n");
	} 
	
	private void lengthOfTheString(String newString, StringTasks obj) throws InvalidException
	{
		int length= obj.length(newString);
				
		System.out.println("The length of the given String is "+length);		
	}
	
	private void stringToCharArray(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
					
		char array[]= obj.stringToCharArr(newString);

		for(char iter:array)
		{
			System.out.print(iter+" ");
		}
		System.out.println();			
	}
	
	private void penultimateElement(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println("Enter the index of the element you need : ");
		int index= scanner.nextInt();
		int penultimateValue= ((obj.length(newString)) - index) +1; 
		char element= obj.penultimateEle(newString,penultimateValue);

		System.out.println("The penultimate Element is "+element);
	}
	
	private void occuranceOfElement(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println(reqChar);
		char element= scanner.next().charAt(0);
				
		int occurance= obj.occuranceOfEle(newString,element);

		System.out.println("The occurance of the ele "+element+" is "+occurance);			
	}
	
	private void greatestPosition(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println(reqChar);
		char element= scanner.next().charAt(0);
					
		int position= obj.greatestPosition(newString,element);
					
		System.out.println("The greatest position of the ele "+element+" is "+position);
	}
	
	private void lastFewCharacters(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println("Enter the required length : ");
		int value= scanner.nextInt();
					
		char array6[]= obj.lastFewChar(newString,value);
					
		for(char iter:array6)
		{
			System.out.print(iter+" ");
		}
		System.out.println();
	}
	
	private void firstFewCharacters(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println("Enter the required length : ");
		int value= scanner.nextInt();
				
		char array7[]= obj.firstFewChar(newString,value);
					
		for(char iter:array7)
		{
			System.out.print(iter+" ");
		}
		System.out.println();			
	}
	
	private void replaceFirstFewCharacters(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println("Enter the required length : ");
		int value= scanner.nextInt();
		System.out.println("Enter the replacement String : ");
		String source= scanner.next();
					
		String output= obj.replaceFirstFewChar(newString,value,source);
					
		System.out.println(output);
	}
	
	private void startsWithCheck(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println("Enter the prefix String : ");
		String prefix= scanner.next();
					
		boolean check= obj.startsWith(newString,prefix);
					
		System.out.println (resValid+check);
	}
	
	private void endsWithCheck(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
		System.out.println("Enter the suffix String : ");
		String suffix= scanner.next();
					
		boolean check= obj.endsWith(newString,suffix);
					
		System.out.println (resValid+check);
	}
	
	private void lowerToUpperCase(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
					
		String output= obj.toUpperCase(newString);
					
		System.out.println (resStr+output);
	}
	
	private void upperToLowerCase(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
					
		String output= obj.toLowerCase(newString);
					
		System.out.println (resStr+output);
	}
	
	private void stringReverse(Scanner scanner, StringTasks obj) throws InvalidException
	{
		String newString= scanner.next();
					
		String output= obj.reverse(newString);
					
		System.out.println (resStr+output);
	}
	
	private void getMultipleStrings(Scanner scanner)
	{
		scanner.nextLine();
		String newString= scanner.nextLine();
					
		System.out.println(newString);
	}
	
	private void concatenateStrings(Scanner scanner, StringTasks obj) throws InvalidException
	{
		scanner.nextLine();
		String newString= scanner.nextLine();
		System.out.println("Enter the delimtter used : ");
		String delimitter= scanner.next();
		String output= obj.concatenate(newString,delimitter);
					
		System.out.println("The concatenated String is "+output);
	}
	
	private void multipleStringsToArray(Scanner scanner, StringTasks obj) throws InvalidException
	{
		scanner.nextLine();
		String newString= scanner.nextLine();
		System.out.println("Enter the delimtter used : ");
		String delimitter= scanner.next();
					
		String array16[]= obj.stringArray(newString,delimitter);
					
		System.out.println("The resultant array is "+Arrays.toString(array16));
	}
	
	private void mergeStringArray(Scanner scanner, StringTasks obj) throws InvalidException
	{
		System.out.println("To end the input session Press ENTER without any inputs!");
		System.out.println("Proceed with your inputs : ");
		scanner.nextLine();
		String input;
		List<String> list=new ArrayList<>();
					
		while(true)
		{
			input= scanner.nextLine();
			if(input.isEmpty())
			{
				break;
			}
						
			list.add(input);
		}
					
		String array17[]= list.toArray(new String[0]);
		System.out.println("Enter the special character you need : ");
		String mergeElement= scanner.next();
					
		String output= obj.mergeStringArr(array17,mergeElement);
					
		System.out.println (resStr+output);
	}
	
	private void caseSensitiveEquals(Scanner scanner, StringTasks obj) throws InvalidException
	{
		System.out.println("Enter the first String");
		String newString1= scanner.next();
		System.out.println("Enter the second String");
		String newString2= scanner.next();
					
		boolean check= obj.caseSensitiveEqualityCheck(newString1,newString2);
					
		System.out.println (resValid+check);
	}
	
	private void caseInsensitiveEquals(Scanner scanner, StringTasks obj) throws InvalidException
	{
		System.out.println("Enter the first String");
		String newString1= scanner.next();
		System.out.println("Enter the second String");
		String newString2= scanner.next();
					
		boolean check= obj.caseInsensitiveEqualityCheck(newString1,newString2);
					
		System.out.println (resValid+check);
	}
	
	private void trimSpaces(Scanner scanner, StringTasks obj) throws InvalidException
	{
		scanner.nextLine();
		String newString= scanner.nextLine();
					
		String output= obj.removeExtraSpaces(newString);
					
		System.out.println(output);
	}
}
