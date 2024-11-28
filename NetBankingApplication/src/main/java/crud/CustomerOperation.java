package crud;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.Customer;
import pojo.User;
import query.Condition;
import query.Order;

public class CustomerOperation 
{
	Operations newOpt= new Operations();
	Map<String,Condition> conditions;
	
	public void newCustomer(int empId, String uName, String name, String mobile, String email, String pass, long dob, long aadharNo, String pan)
	{
		long dateTime= getCurrentTimeMillis();
		User newUser= new User();
		
		newUser.setUserName(uName);
		newUser.setName(name);
		newUser.setUserType("Customer");
		newUser.setMobileNo(mobile);
		newUser.setEmailId(email);
		newUser.setAccountPass(pass);
		newUser.setDob(dob);
		newUser.setCreatedTime(dateTime);
		newUser.setModifiedTime(dateTime);
		newUser.setModifiedBy(empId);
		
		UserOperation usrOpt= new UserOperation();
		int userId= usrOpt.newUser(newUser);
		
		Customer newCustomer= new Customer();
		newCustomer.setCustId(userId);
		newCustomer.setAadharNo(aadharNo);
		newCustomer.setPan(pan);
		newCustomer.setStatus("ACTIVE");
		
		newOpt.createMethod(newCustomer);
	}
	
	public List<Object> getCustomerDetails(int custId)
	{	
		Customer newCust=new Customer();
		List<String> requiredCustFields= getAllFields(newCust.getClass());
		
		System.out.println(requiredCustFields);
		
		Map<Object,List<String>> objects= new HashMap<>();
		objects.put(newCust, requiredCustFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("Customer");
		newCondition.setFieldName("custId");
		newCondition.setOperator(" = ");
		newCondition.setValue(custId);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result= newOpt.selectMethod(objects, conditions, order);
		
		if(result.size()!=0)
		{
			return result.get(0);
		}
		
		return null;
	}
	
	public void deactivateCustomer(int empId, int custId)
	{
		Customer newCustomer= new Customer();
		newCustomer.setStatus("INACTIVE");
		
		List<Object> objects= new ArrayList<Object>();
		objects.add(newCustomer);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("Customer");
		newCondition.setFieldName("custId");
		newCondition.setOperator(" = ");
		newCondition.setValue(custId);
		conditions.put("", newCondition);
		
		newOpt.update(objects, conditions);
		
		AccountOperation accOpt= new AccountOperation();
		
		List<Long> result= accOpt.getAccounts(custId);
		
		for(long accountNo: result)
		{
			accOpt.deactivateAccount(empId, accountNo);
		}
	}
	
	private static long getCurrentTimeMillis() 
	{
		return System.currentTimeMillis();
	}
	
	private List<String> getAllFields(Class<?> clazz)
	{
		List<String> requiredFields= new ArrayList<String>();
		
		Field[] declaredField= clazz.getDeclaredFields();
		
		for(Field currField: declaredField)
		{
			requiredFields.add(currField.getName());
		}
		
		String superClass= clazz.getSuperclass().getSimpleName();
		if(!superClass.equals("Object"))
		{
			requiredFields.addAll(getAllFields(clazz.getSuperclass()));
		}
		
		return requiredFields;
	}
}
