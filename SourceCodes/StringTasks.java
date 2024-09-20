package com.example.demo;
import java.util.*;
import com.example.demo.InvalidException;
import com.example.demo.Helper;

public class StringTasks 
{	
	// Below codes are the String functions.
	
	public int length(String newString) throws InvalidException	//1
	{
		try
		{
			Helper.validateInput(newString);
		
			return newString.length();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public char[] stringToCharArr(String newString)	throws InvalidException	//2
	{
		try
		{
			Helper.validateInput(newString);
		
			return newString.toCharArray();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public char penultimateEle(String newString, int index)	throws InvalidException	//3
	{
		try
		{
			Helper.validateInput(length(newString),index);
		
			return newString.charAt((newString.length())-index);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public int occuranceOfEle(String newString, char element) throws InvalidException	//4
	{
		try
		{
			Helper.validateInput(newString);
		
			int count =0;
		
			for(char iter:newString.toCharArray())
			{
				if(iter==element)
				{
					count++;
				}
			}
		
			return count;
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public int greatestPosition(String newString, char element) throws InvalidException	//5
	{
		try
		{
			Helper.validateInput(newString);
		
			return newString.lastIndexOf(element);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public char[] lastFewChar(String newString, int value) throws InvalidException	//6
	{
		try
		{
			int length= length(newString);
			Helper.validateInput(length,value);
			
			String reqNewString= newString.substring(length-value);
			
			return reqNewString.toCharArray();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public char[] firstFewChar(String newString, int end) throws InvalidException	//7
	{
		try
		{
			int length= length(newString);
			Helper.validateInput(length,end);
			
			String reqNewString= newString.substring(0,end);
			
			return reqNewString.toCharArray();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String replaceFirstFewChar(String newString, int end, String source) throws InvalidException	//8
	{
		try
		{
			int length= length(newString);
			Helper.validateInput(length,end);
			Helper.validateInput(source);
			
			String subString= newString.substring(0,end);
		
			return newString.replaceFirst(subString,source);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public boolean startsWith(String newString, String prefix) throws InvalidException	//9
	{
		try
		{
			Helper.validateInput(newString);
			Helper.validateInput(prefix);
			
			return newString.startsWith(prefix);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public boolean endsWith(String newString, String suffix) throws InvalidException	//10
	{
		try
		{
			Helper.validateInput(newString);
			Helper.validateInput(suffix);
			
			return newString.endsWith(suffix);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String toUpperCase(String newString) throws InvalidException			//11
	{
		try
		{
			Helper.validateInput(newString);
			
			return newString.toUpperCase();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String toLowerCase(String newString) throws InvalidException			//12
	{
		try
		{
			Helper.validateInput(newString);
		
			return newString.toLowerCase();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String reverse(String newString) throws 	InvalidException	//13
	{
		try
		{		
			int length= length(newString);
			String output="";

			for(int i=length-1;i>=0;i--)
			{
				output+= newString.charAt(i);
			}

			return output;
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String concatenate(String newString, String delimitter) throws InvalidException		//15 //Swami
	{
		try
		{
			Helper.validateInput(newString);
			Helper.validateInput(delimitter);
		
			String replacement="";
			String output= newString.replace(delimitter,replacement);
		
			return output;
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String[] stringArray(String newString, String delimitter) throws InvalidException		//16
	{
		try
		{
			Helper.validateInput(newString);
			Helper.validateInput(delimitter);
		
			return newString.split(delimitter);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String mergeStringArr(String [] newStringArray, String mergeElement) throws InvalidException	//17  //Swami
	{
		try
		{
			Helper.validateInput(mergeElement);
			Helper.validateInput(newStringArray);
		
			String output= String.join(mergeElement, newStringArray);
		
			return output;
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public boolean caseSensitiveEqualityCheck(String newString1, String newString2) throws 	InvalidException	//18
	{
		try
		{
			Helper.validateInput(newString1);
			Helper.validateInput(newString2);
		
			return newString1.equals(newString2);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public boolean caseInsensitiveEqualityCheck(String newString1, String newString2) throws InvalidException	//19
	{
		try
		{
			Helper.validateInput(newString1);
			Helper.validateInput(newString2);
		
			return newString1.equalsIgnoreCase(newString2);
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}

	public String removeExtraSpaces(String newString) throws InvalidException				//20
	{
		try
		{
			Helper.validateInput(newString);
		
			return newString.trim();
		}
		catch(InvalidException errorMessage)
		{
			throw new InvalidException("There was an error occurred while execution",errorMessage);
		}
	}
}
