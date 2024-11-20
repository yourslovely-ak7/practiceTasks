package crud;

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
	
//	private static long getCurrentTimeMillis() 
//	{
//		return System.currentTimeMillis();
//	}
}