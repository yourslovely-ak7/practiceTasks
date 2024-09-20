package com.example.task6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.exception.Helper;
import com.example.exception.InvalidException;

public class ArrayListTasks {
	
	public <T> List<T> createAL()//SOLID Principles -- O- Open Closed Principle or Coding to the interface.
	{
		List<T> newList= new ArrayList<>();
		return newList;
	}
	
//	public <T> List<T> createAL(Collection<? extends T> c)
//	{
//		List<T> newList= new ArrayList<>(c);
//		return newList;
//	}
	
	public <T> List<T> addToAL(List<T> newList, T element) throws InvalidException
	{
			Helper.validateInput(newList);
			newList.add(element);
			return newList;
	}
	
	public <T> int sizeOfAL(List<T> newList) throws InvalidException
	{
			Helper.validateInput(newList);
			return newList.size();
	}
	
	
	public <T> int indexOfAL(List<T> newList, T element) throws InvalidException
	{
		Helper.validateInput(newList);
		Helper.validateInput(element);
		
		return newList.indexOf(element);
	}
	
	public <T> Iterator<T> iterOfAL(List<T> newList) throws InvalidException
	{
		Helper.validateInput(newList);
		return newList.iterator();
	}
	
	public <T> T getElement(List<T> newList, int index) throws InvalidException
	{
		int size= sizeOfAL(newList);
		Helper.validateInput(size,index);
		
		return newList.get(index);
	}
	
	public <T> int lastIndexOfAL(List<T> newList, T element) throws InvalidException
	{
		Helper.validateInput(newList);
		Helper.validateInput(element);
		
		return newList.lastIndexOf(element);
	}
	
	public <T> List<T> addAtIndex(List<T> newList, T element, int index) throws InvalidException
	{
		int size= sizeOfAL(newList);
		Helper.validateInput(size,index);
		Helper.validateInput(element);
		
		newList.add(index,element);
		
		return newList;
	}
	
	public <T> List<T> subListOfAL(List<T> newList, int startIndex, int endIndex) throws InvalidException
	{
		int size= sizeOfAL(newList);
		Helper.validateInput(size,startIndex);
		Helper.validateInput(size,endIndex);
		
		return newList.subList(startIndex, endIndex);
	}
	
	public <T> List<T> addListToAL(List<T> newList, List<T> source) throws InvalidException
	{
		Helper.validateInput(newList);
		Helper.validateInput(source);
		
		newList.addAll(source);
		return newList;
	}	
	
	public <T> List<T> removeAt(List<T> newList, int index) throws InvalidException
	{
		int size= sizeOfAL(newList);
		Helper.validateInput(size,index);
		
		newList.remove(index);
		return newList;
	}
	
	public <T> List<T> removeAllFromAL(List<T> newList, List<T> source) throws InvalidException
	{
		Helper.validateInput(newList);
		Helper.validateInput(source);
		
		newList.removeAll(source);
		return newList;
	}
	
	public <T> List<T> retainAllFromAL(List<T> newList, List<T> source) throws InvalidException
	{
		Helper.validateInput(newList);
		Helper.validateInput(source);
		
		newList.retainAll(source);
		return newList;
	}	
	
	public <T> List<T> clearAL(List<T> newList) throws InvalidException
	{
		Helper.validateInput(newList);
		newList.clear();
		return newList;
	}
	
	public <T> boolean containInAl(List<T> newList, T element) throws InvalidException
	{
		Helper.validateInput(newList);
		Helper.validateInput(element);
		
		return newList.contains(element);
	}
}
