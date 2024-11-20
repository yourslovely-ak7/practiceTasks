package crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.Branch;
import pojo.Employee;
import pojo.User;
import query.Condition;
import query.Order;

public class EmployeeOperation 
{
	Operations newOpt= new Operations();
	Map<String,Condition> conditions;
	
	public void newEmployee(int empId, String uName, String name, String uType, String mobile, String email, String pass, long dob)
	{
		long dateTime= getCurrentTimeMillis();
		User newUser= new User();
		
		newUser.setUserName(uName);
		newUser.setName(name);
		newUser.setUserType(uType);
		newUser.setMobileNo(mobile);
		newUser.setEmailId(email);
		newUser.setAccountPass(pass);
		newUser.setDob(dob);
		newUser.setCreatedTime(dateTime);
		newUser.setModifiedTime(dateTime);
		newUser.setModifiedBy(empId);
		
		UserOperation usrOpt= new UserOperation();
		int userId= usrOpt.newUser(newUser);
		int branchId= getBranchId(empId);
		
		Employee employee= new Employee();
		employee.setEmpId(userId);
		employee.setBranchId(branchId);
		
		newOpt.createMethod(employee);
	}
	
	public Branch getBranchDetails(int empId)
	{
		BranchOperation bncOpt= new BranchOperation();
		int branchId= getBranchId(empId);
		
		return bncOpt.getDetails(branchId);
	}
	
	public int getBranchId(int empId)
	{
		Employee employee= new Employee();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("branchId");
		
		Map<Employee,List<String>> objects= new HashMap<Employee, List<String>>();
		objects.put(employee, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("Employee");
		newCondition.setFieldName("empId");
		newCondition.setFieldName(" = ");
		newCondition.setValue(empId);
		
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result = newOpt.selectMethod(objects, conditions, order);
		
		employee= (Employee) result.get(0).get(0);
		
		return employee.getBranchId();
		
	}
	
	private static long getCurrentTimeMillis() 
	{
		return System.currentTimeMillis();
	}
}
