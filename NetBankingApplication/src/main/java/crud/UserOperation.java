package crud;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.User;
import query.Condition;
import query.Order;

public class UserOperation 
{
	Operations newOpt= new Operations();
	Map<String,Condition> conditions;
	
	public int newUser(User user)
	{
		newOpt.createMethod(user);
		
		return getUserId(user.getUserName());
	}
	
	public User getUserDetails(String userName)
	{
		User newUser=new User();
		List<String> requiredFields= getAllFields(newUser.getClass());
		
		Map<User,List<String>> objects= new HashMap<User, List<String>>();
		objects.put(newUser, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("User");
		newCondition.setFieldName("userName");
		newCondition.setOperator(" = ");
		newCondition.setValue(userName);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result= newOpt.selectMethod(objects, conditions, order);
		
		if(result.size()!=0)
		{
			newUser= (User) result.get(0).get(0);			
		}
		
		return newUser;
	}
	
	public String getPassword(String uName)
	{
		User user=new User();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("accountPass");
		
		Map<User,List<String>> objects= new HashMap<User, List<String>>();
		objects.put(user, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("User");
		newCondition.setFieldName("userName");
		newCondition.setOperator(" = ");
		newCondition.setValue(uName);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result= newOpt.selectMethod(objects, conditions, order);
		
		user= (User) result.get(0).get(0);
		return user.getAccountPass();
	}
	
	private int getUserId(String uName)
	{
		User user=new User();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("userId");
		
		Map<User,List<String>> objects= new HashMap<User, List<String>>();
		objects.put(user, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("User");
		newCondition.setFieldName("userName");
		newCondition.setOperator(" = ");
		newCondition.setValue(uName);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result= newOpt.selectMethod(objects, conditions, order);
		
		user= (User) result.get(0).get(0);
		return user.getUserId();
	}
	
	public boolean updateUserDetails(int userId, User updatedUser)
	{
		long currentTimeMillis= getCurrentTimeMillis();
		
		updatedUser.setModifiedTime(currentTimeMillis);
		updatedUser.setModifiedBy(userId);
		
		List<Object> objects= new ArrayList<Object>();
		objects.add(updatedUser);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("User");
		newCondition.setFieldName("userId");
		newCondition.setOperator(" = ");
		newCondition.setValue(userId);
		conditions.put("", newCondition);
		
		int result = newOpt.update(objects, conditions);
		
		if(result==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private List<String> getAllFields(Class<?> clazz)
	{
		List<String> requiredFields= new ArrayList<String>();
		
		Field[] declaredField= clazz.getDeclaredFields();
		
		for(Field currField: declaredField)
		{
			requiredFields.add(currField.getName());
		}
		
		return requiredFields;
	}
	
	private static long getCurrentTimeMillis() 
	{
		return System.currentTimeMillis();
	}
}