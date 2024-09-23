package com.example.task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.example.exception.Helper;
import com.example.exception.InvalidException;

public class HashMapTasks {
	
	public <K,V> Map<K,V> createMap()
	{
		Map<K,V> newMap=new HashMap<K,V>();
		
		return newMap;
	}
	
	public <K,V> int sizeOfMap(Map<K,V> newMap) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.size();
	}
	
	public <K,V> V addToMap(Map<K,V> newMap, K key, V value) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.put(key, value);
	}
	
	public <K,V> boolean checkForKey(Map<K,V> newMap, K key) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.containsKey(key);
	}
	
	public <K,V> boolean checkForValue(Map<K,V> newMap, V value) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.containsValue(value);
	}
	
	public <K,V> V replaceValue(Map<K,V> newMap, K key, V value) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.replace(key, value);
	}
	public <K,V> V getValue(Map<K,V> newMap, K key) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.get(key);
	}
	
	public <K,V> V getOrDefaultValue(Map<K,V> newMap, K key, V defaultValue) throws InvalidException
	{
		Helper.validateInput(newMap);
		Helper.validateInput(key);
		
		return newMap.getOrDefault(key, defaultValue);
	}
	
	public <K,V> V remove(Map<K,V> newMap, K key) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.remove(key);
	}
	
	public <K,V> boolean removeIfMatches(Map<K,V> newMap, K key, V value) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.remove(key,value);
	}
	
	public <K,V> boolean replaceIfMatches(Map<K,V> newMap, K key, V value, V newValue) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.replace(key,value,newValue);
	}	
	
	public <K,V> void transferMap(Map<K,V> newMap, Map<K,V> sourceMap) throws InvalidException
	{
		Helper.validateInput(newMap);
		Helper.validateInput(sourceMap);
		
		newMap.putAll(sourceMap);
	}
	
	public <K,V> Set<Map.Entry<K,V>> getEntry(Map<K,V> newMap) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		return newMap.entrySet();
	}
	
	public <K,V> void clearMap(Map<K,V> newMap) throws InvalidException
	{
		Helper.validateInput(newMap);
		
		newMap.clear();
	}
}
