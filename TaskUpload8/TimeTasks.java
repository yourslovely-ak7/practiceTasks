package com.example.task8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.example.exception.Helper;
import com.example.exception.InvalidException;

public class TimeTasks 
{
	public String getCurrentTime(String pattern) throws InvalidException
	{
		Helper.validateInput(pattern);
		
		LocalDateTime dateTime= LocalDateTime.now();
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern(pattern);
		
		return dateTime.format(formatter);
	}
	
	public long getCurrentTimeInMilliUsingTimePackage()
	{
		return Instant.now().toEpochMilli();
	}
	
	public long getCurrentTimeInMilliUsingSystem()
	{
		return System.currentTimeMillis();
	}
	
	public String getCurrentTimeFromZones(String zone, String pattern) throws InvalidException
	{
		Helper.validateInput(zone);
		Helper.validateInput(pattern);
		
		ZoneId id= ZoneId.of(zone);
		ZonedDateTime dateTime= ZonedDateTime.now(id);
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern(pattern);
		
		return dateTime.format(formatter);
	}
	
	public String getCurrentDayOfWeekFromMillis(long millis)
	{
		LocalDateTime dateTime= LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
		
		return dateTime.getDayOfWeek().toString();
	}

	public String getCurrentMonthFromMillis(long millis)
	{
		LocalDateTime dateTime= LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
		
		return dateTime.getMonth().toString();
	}
	
	public int getCurrentYearFromMillis(long millis)
	{
		LocalDateTime dateTime= LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
		
		return dateTime.getYear();
	}
}
