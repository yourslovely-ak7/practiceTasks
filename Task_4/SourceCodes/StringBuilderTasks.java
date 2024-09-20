package com.example.task4;

import com.example.task4.Helper;
import com.example.task4.InvalidException;

public class StringBuilderTasks
{
	public StringBuilder constructSB()
	{
		StringBuilder newSB=new StringBuilder();
		return newSB;
	}
	
	public StringBuilder constructSB(String newString) throws InvalidException
	{
		Helper.validateInput(newString);
		StringBuilder newSB=new StringBuilder(newString);
		return newSB;
	}
	
	public StringBuilder appendString(StringBuilder newSB, String newString) throws InvalidException
	{
		Helper.validateInput(newSB);
		return newSB.append(newString);
	}
	
	public String convertToString(StringBuilder newSB) throws InvalidException
	{
		Helper.validateInput(newSB);
		return newSB.toString();
	}
	
	private int indexOfSB(StringBuilder newSB, String source, int fromIndex) throws InvalidException
	{
		Helper.validateInput(newSB);
		Helper.validateInput(source);
		
		return newSB.indexOf(source,fromIndex);
	}
	
	private int indexOfSB(StringBuilder newSB, String source) throws InvalidException
	{
		Helper.validateInput(newSB);
		Helper.validateInput(source);
		
		return newSB.indexOf(source);
	}
	
	private int indexForRemove(StringBuilder newSB, String delimitter, int position, int num) throws InvalidException
	{
		int fromIndex=0;
		int start=0;
		
		if(position==0)
		{
			return start;
		}
		else if(position == num)
		{
			return (lengthOfStringBuilder(newSB))+1;
		}
		else
		{
			while(position>0)
			{
				start= indexOfSB(newSB,delimitter,fromIndex);
				position--;
				fromIndex= start+1;
			}
			return start+1;
		}
	}
	
	// The actual Tasks are as follows...
	
	public int lengthOfStringBuilder(StringBuilder newSB) throws InvalidException		//1
	{
		try
		{
			Helper.validateInput(newSB);
			return newSB.length();
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public StringBuilder stringArrayToStringBuilder(StringBuilder newSB, String[] stringArray, String delimitter) throws InvalidException	//2
	{
		try
		{
			Helper.validateInput(newSB);
			Helper.validateInput(stringArray);
			Helper.validateInput(delimitter);
			
			for(String iter: stringArray)
			{
				newSB= appendString(newSB,delimitter);
				newSB= appendString(newSB,iter);
			}
		
			return newSB;
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
		
	}
	
	public StringBuilder insertBetweenStrings(StringBuilder newSB, String newString, String delimitter, int position, int num) throws InvalidException	//3
	{
		try
		{
			Helper.validateInput(newSB);
			Helper.validateInput(newString);
			Helper.validateInput(delimitter);
			Helper.validateInput(num,position);
			
			int start= indexOfString(newSB,delimitter,position);
			int end= start+delimitter.length();
			
			return replaceSB(newSB,start,end,delimitter+newString+delimitter);
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public StringBuilder removeString(StringBuilder newSB, String delimitter, int index, int num) throws InvalidException	//4
	{
		try
		{
			Helper.validateInput(num,index);
			
			int start= indexForRemove(newSB,delimitter,index,num);
			int end= indexForRemove(newSB,delimitter,index+1,num)-1;
			
			return deleteSB(newSB,start,end);	
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public StringBuilder replaceString(StringBuilder newSB, String delimitter, String source) throws InvalidException	//5
	{
		try
		{
			Helper.validateInput(newSB);
			Helper.validateInput(delimitter);
			Helper.validateInput(source);
			
			int start= indexOfSB(newSB,delimitter);
			while(start!=-1)
			{
				newSB= replaceSB(newSB,start,start+delimitter.length(),source);
				start= indexOfSB(newSB,delimitter,start+1);
			}
			
			return newSB;
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public StringBuilder reverseSB(StringBuilder newSB) throws InvalidException	//6
	{
		try
		{
			Helper.validateInput(newSB);
			return newSB.reverse();
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public StringBuilder deleteSB(StringBuilder newSB, int start, int end) throws InvalidException	//7
	{
		try
		{
			Helper.validateInput(lengthOfStringBuilder(newSB),start);
			return newSB.delete(start,end);
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public StringBuilder replaceSB(StringBuilder newSB, int start, int end, String replacement) throws InvalidException	//8
	{
		try
		{
			int length= lengthOfStringBuilder(newSB);
			Helper.validateInput(length,start);
			Helper.validateInput(length,end);
			Helper.validateInput(replacement);
		
			return newSB.replace(start,end,replacement);
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
	
	public int indexOfString(StringBuilder newSB, String delimitter, int position) throws InvalidException	//9 & 10
	{
		try
		{
			Helper.validateInput(lengthOfStringBuilder(newSB),position);
			Helper.validateInput(delimitter);
		
			int fromIndex=0;
			int index=0;
			while(position>0)
			{
				index= indexOfSB(newSB,delimitter,fromIndex);
				position--;
				fromIndex= index+1;
			}
			return index;
		}
		catch(InvalidException error)
		{
			throw new InvalidException("There was an error occurred while exceution!",error);
		}
	}
}
