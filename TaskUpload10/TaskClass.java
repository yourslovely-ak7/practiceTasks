package com.example.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.exception.Helper;
import com.example.exception.InvalidException;

public class TaskClass 
{
	public boolean mobileNumberValidation(String number, String regex) throws InvalidException
	{
		Helper.validateInput(number);
		Helper.validateInput(regex);
		
		Pattern pattern= Pattern.compile(regex);
		Matcher match= pattern.matcher(number);
		return match.matches();
	}
	
	public boolean alphaNumericValidation(String newString, String regex) throws InvalidException
	{
		Helper.validateInput(newString);
		Helper.validateInput(regex);
		
		Pattern pattern= Pattern.compile(regex);
		Matcher match= pattern.matcher(newString);
		return match.matches();
	}
	
	public boolean stringMatchValidation(String givenString, String regex) throws InvalidException
	{
		Helper.validateInput(givenString);
		Helper.validateInput(regex);
		
		return Pattern.matches(regex,givenString);
	}
	
	public boolean caseInsensitiveValidation(String givenString, Pattern pattern) throws InvalidException
	{
		Helper.validateInput(givenString);
		Helper.validateInput(pattern);
		
		Matcher match= pattern.matcher(givenString);
		return match.matches();
	}
	
	public boolean emailValidation(String email, String regex) throws InvalidException
	{
		Helper.validateInput(email);
		Helper.validateInput(regex);
		
		Pattern pattern= Pattern.compile(regex);
		Matcher match= pattern.matcher(email);
		return match.matches();
	}
	
	public boolean lengthValidation(String email, String regex) throws InvalidException
	{
		Helper.validateInput(email);
		Helper.validateInput(regex);
		
		Pattern pattern= Pattern.compile(regex);
		Matcher match= pattern.matcher(email);
		return match.matches();
	}
	
	public boolean listElementsValidation(String givenString, String regex) throws InvalidException
	{
		Helper.validateInput(givenString);
		Helper.validateInput(regex);
		
		Pattern pattern= Pattern.compile(regex);
		Matcher match= pattern.matcher(givenString);
		return match.matches();
	}
	
	public List<String> htmlTagsValidation(String givenString, String regex) throws InvalidException
	{
		Helper.validateInput(givenString);
		Helper.validateInput(regex);
		
		Pattern pattern= Pattern.compile(regex);
		Matcher match= pattern.matcher(givenString); 
		List<String> list=new ArrayList<>();
		
		while(match.find())
		{
			list.add(match.group());
		}
		
		return list;
	}
}
