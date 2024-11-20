package crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import mapping.YamlLoader;
import query.Condition;
import query.Fields;
import query.Join;
import query.Order;
import query.Query;

public class Operations 
{
	Query query=new Query();
	YamlLoader yaml= new YamlLoader();
	
	public <T> void createMethod(T object)
	{
		try
		{
			Class<?> clazz= object.getClass();
			String classSimpleName= clazz.getSimpleName();
			String tableName= yaml.getTableName(classSimpleName);
			
			List<String> fields= new ArrayList<>();
			List<Object> values= new ArrayList<>();
			
			Field[] declaredFields = clazz.getDeclaredFields();
			
			for (Field field : declaredFields) 
			{
				String fieldName= field.getName();
				String getterMethodName= "get"+capitalize(fieldName);
				
				Method getterMethod= clazz.getDeclaredMethod(getterMethodName);
				
				String fieldInput= yaml.getColumnName(classSimpleName, fieldName);
				String autoIncrement= yaml.getautoIncrementField(classSimpleName);
				
				if(autoIncrement== null || !(autoIncrement.equals(fieldInput)))
				{
					Object valueInput= getterMethod.invoke(object);
					
					fields.add(fieldInput);
					values.add(valueInput);            	 
				}
				
			}
			query.insert(tableName, fields, values);
		}
		catch(SQLException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
	
	public <T>List<List<Object>> selectMethod(Map<T,List<String>> objects, Map<String,Condition> condition, Order orderBy)
	{		
		List<Map<String,Object>> result= new ArrayList<>();
		try
		{			
			List<Fields> requiredFieldObjects= new ArrayList<>();
			List<String> requiredFieldNames;
			List<String> allTables= objects.keySet().stream()
					.map(obj -> yaml.getTableName(obj.getClass().getSimpleName()))
					.collect(Collectors.toList());
			
			Map<Join,Join> join= new HashMap<>();
			
			for (Map.Entry<T, List<String>> entry : objects.entrySet())
			{
				T object= entry.getKey();
				List<String> fields= entry.getValue();
				
				Class<?> clazz= object.getClass();
				String classSimpleName= clazz.getSimpleName();
				String tableName= yaml.getTableName(classSimpleName);
				
				requiredFieldNames= new ArrayList<>();
				
				for(String str: fields)
				{
					requiredFieldNames.add(yaml.getColumnName(classSimpleName, str));
				}
				
				Fields newObj= new Fields();
				newObj.setTableName(tableName);
				newObj.setFieldNames(requiredFieldNames);
				
				requiredFieldObjects.add(newObj);
				
//			System.out.println(classSimpleName+" "+allTables);
				join.putAll(constructJoin(classSimpleName, allTables));
//			allTables.remove(tableName);
				
			}
			
			Map<String,Condition> queryCond= new HashMap<>();
			
			if(condition.size()!=0)
			{
				queryCond= constructCondition(condition);
			}
			
			StringBuilder order = new StringBuilder();
			String classSimpleName= orderBy.getTableObject().getClass().getSimpleName();
			List<String> orderFields= orderBy.getOrderBy();
			int len= orderFields.size();
			if(len!=0)
			{
				order.append(" ORDER BY ");
				for (int i = 0; i < len; i++) 
				{
					order.append(yaml.getColumnName(classSimpleName,orderFields.get(i)));
					if (i < len - 1) 
					{
						order.append(", ");
					}
				}
			}
			
			if(orderBy.isDesc()!=false)
			{
				order.append(" DESC");
			}
			
			String setLimit="";
			int limit= orderBy.getLimit();
			
			if(limit!=0)
			{
				setLimit+= limit;
			}
			
			result= query.select(requiredFieldObjects, join, queryCond, order.toString(), setLimit);
			
			return objectConversion(objects,result);
		}
		catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> int update(List<T> objects, Map<String,Condition> condition) 
	{
		try 
		{
			
			int len= objects.size();
			List<String> allTables = objects.stream()
					.map(obj -> yaml.getTableName(obj.getClass().getSimpleName()))
					.collect(Collectors.toList());
			
			Map<Join,Join> join= new HashMap<>();
			
			List<Fields> newValues= new ArrayList<>();
			Fields valueEntry;
			
			for(T currObj: objects)
			{
				Class<?> clazz= currObj.getClass();
				String classSimpleName= clazz.getSimpleName();
				String tableName= yaml.getTableName(classSimpleName);
				
				Field[] declaredFields= clazz.getDeclaredFields();
				List<String> updateFields= new ArrayList<>();
				List<Object> updateValues= new ArrayList<>();
				
				for(Field currField: declaredFields)
				{
					String fieldName= currField.getName();
					
					String getterMethodName= "get"+capitalize(fieldName);
					Method getterMethod= clazz.getDeclaredMethod(getterMethodName);
					Object value= getterMethod.invoke(currObj);
					
					if(value != null && isNonEmptyValue(value))
					{
						updateFields.add(yaml.getColumnName(classSimpleName, fieldName));
						updateValues.add(value);
					}
				}
				
				valueEntry= new Fields();
				valueEntry.setTableName(tableName);
				valueEntry.setFieldNames(updateFields);
				valueEntry.setValues(updateValues);
				newValues.add(valueEntry);
				
				if(len>1)
				{
					join.putAll(constructJoin(classSimpleName, allTables));
				}
			}
			
			Map<String,Condition> queryCond= new HashMap<>();
			
			queryCond= constructCondition(condition);
			
			return query.update(newValues, join, queryCond);
		}
		catch(SQLException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public <T> void delete(List<T> object, Map<String,Condition> condition)
	{
		try 
		{
			
			int len= object.size();
			List<String> allTables = object.stream()
					.map(obj -> yaml.getTableName(obj.getClass().getSimpleName()))
					.collect(Collectors.toList());
			
			
			Map<Join,Join> join= new HashMap<>();
			
			List<String> tableNames= new ArrayList<String>(allTables);
			
			for(T currObj: object)
			{
				Class<?> clazz= currObj.getClass();
				String classSimpleName= clazz.getSimpleName();
//				String tableName= yaml.getTableName(classSimpleName);
				
				if(len!=1)
				{
					join.putAll(constructJoin(classSimpleName, tableNames));
				}
			}
			
			Map<String,Condition> queryCond= new HashMap<>();
			
			if(condition.size()!=0)
			{
				queryCond= constructCondition(condition);			
			}
			else
			{
				queryCond= constructPKCondition(object);
			}
			
//		System.out.println(allTables);
			query.delete(allTables, join, queryCond);
		}
		catch(SQLException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}

	private static String capitalize(String name) 
	{
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
	
	private Map<String,Condition> constructCondition(Map<String,Condition> condition)
	{
		Map<String,Condition> queryCondition= new HashMap<>();
		Condition newCondition;
		
		for(Map.Entry<String,Condition> entry: condition.entrySet())
		{
			String key= entry.getKey();
			Condition currCond= entry.getValue();
			
			String tableName= yaml.getTableName(currCond.getTableName());
			String fieldName= yaml.getColumnName(currCond.getTableName(), currCond.getFieldName());
			
			newCondition= new Condition();
			newCondition.setTableName(tableName);
			newCondition.setFieldName(fieldName);
			newCondition.setValue(currCond.getValue());
			newCondition.setOperator(currCond.getOperator());
			
			queryCondition.put(key, newCondition);
		}	
		
		return queryCondition;
	}
	
	private <T> Map<String,Condition> constructPKCondition(List<T> object) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException
	{
		Map<String,Condition> queryCond= new HashMap<>();
		
		T newObj= object.get(0);
		Class<?> clazz= newObj.getClass();
		String classSimpleName= clazz.getSimpleName();
		String tableName= yaml.getTableName(classSimpleName);
		
		String pk= yaml.getPrimaryKey(clazz.getSimpleName());
		String pkFieldName= yaml.getPrimaryKeyFieldName(classSimpleName,pk);
		Object value="";
		Field[] declaredFields = clazz.getDeclaredFields();
		 
        for (Field field : declaredFields) 
        {
             String fieldName= field.getName();
             if(fieldName.equals(pkFieldName))
             {
            	 String getterMethodName= "get"+capitalize(fieldName);
             
            	 Method getterMethod= clazz.getDeclaredMethod(getterMethodName);
           
            	 value= getterMethod.invoke(newObj);
             }
        }
        
        Condition newCondition= new Condition();
        newCondition.setTableName(tableName);
        newCondition.setFieldName(pk);
        newCondition.setOperator(" = ");
        newCondition.setValue(value);
        
        queryCond.put("", newCondition);
        
        return queryCond;
	}
	
	private Map<Join,Join> constructJoin(String classSimpleName, List<String> tableNames)
	{
		Map<Join,Join> join= new HashMap<>();
		String tableName= yaml.getTableName(classSimpleName);
		
		Map<String, Map<String, String>> foreignKeys = yaml.getAllForeignKeyReferences(classSimpleName);
		Join table1= new Join();
		Join table2= new Join();
		
		if (foreignKeys != null) 
		{
			for (Map.Entry<String, Map<String, String>> fkEntry : foreignKeys.entrySet()) 
			{
				Map<String, String> fkDetails = fkEntry.getValue();
				
				String referencedTable = fkDetails.get("reference");
				String foreignKeyField = fkDetails.get("field");
				String referenceField = fkDetails.get("referenceField");
				
				if (tableNames.contains(referencedTable)) 
				{
					
					table1.setTableName(tableName);
					table1.setFieldName(foreignKeyField);
					table2.setTableName(referencedTable);
					table2.setFieldName(referenceField);
					
//					System.out.println(tableName+" "+foreignKeyField+" "+referencedTable+" "+referenceField);
					
					join.put(table1, table2);
					
					tableNames.remove(referencedTable);
				}
			}
		}
		
		return join;
	}
	
	private static boolean isNonEmptyValue(Object value) 
	{
	    if (value instanceof String) 
	    {
	    	return !((String) value).trim().isEmpty();
	    }
	    else if (value instanceof Integer) 
	    {
	        return (Integer) value != 0;
	    }
	    else if (value instanceof Long) 
	    {
	        return (Long) value != 0L;
	    } 
	    else if (value instanceof Double) 
	    {
	        return (Double) value != 0.0;
	    } 
	    else if (value instanceof Float) 
	    {
	        return (Float) value != 0.0f;
	    }
	    return true;
	}
	
	private <T> List<List<Object>> objectConversion(Map<T,List<String>> objects, List<Map<String,Object>> result) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		List<List<Object>> output= new ArrayList<>();
		List<Object> rowOutput= new ArrayList<>();
		int len= result.size();
		
		for(int i=0;i<len;i++)
		{
			Map<String,Object> row= result.get(i);
			
			for (Map.Entry<T, List<String>> entry : objects.entrySet())
			{
				T object= entry.getKey();
				List<String> fields= entry.getValue();
				
				Class<?> clazz= object.getClass();
				Object newInstance = clazz.getDeclaredConstructor().newInstance();
				String classSimpleName= clazz.getSimpleName();
				String columnName;
				for(String currField: fields)
				{
					columnName = yaml.getColumnName(classSimpleName, currField);
					
					if(row.keySet().contains(columnName))
					{
						Object value= row.get(columnName);
						String setterMethodName= "set"+capitalize(currField);
						
						Method setterMethod= clazz.getDeclaredMethod(setterMethodName, value.getClass());
						
						setterMethod.invoke(newInstance, value);
					}
				}
				rowOutput.add(newInstance);
			}
			output.add(rowOutput);
		}
		
		return output;
	}
}
