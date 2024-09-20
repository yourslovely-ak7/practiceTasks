package com.example.demo;
import com.example.demo.StringConst;

public class Helper
{
	public static void validateInput(Object newObj) throws InvalidException
	{
		if(newObj == null)
		{
			throw new InvalidException(StringConst.NullPointerExceptionMessage);
		}
	}
	
	public static void validateInput(int length, int value) throws InvalidException
	{	
		if(length< value)
		{
			throw new InvalidException(StringConst.InvalidMessageLength);
		}
		else if(value<0)
		{
			throw new InvalidException(StringConst.InvalidMessageZero);
		}
	}
}

