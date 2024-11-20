package crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.Branch;
import query.Condition;
import query.Order;

public class BranchOperation 
{
	Branch branch;
	Map<String,Condition> conditions;
	Operations newOpt= new Operations();
	
	public void newBranch(int empId, String bName, int bCode, String city)
	{
		long dateTime= getCurrentTimeMillis();
		
		branch= new Branch();
		branch.setBranchName(bName);
		branch.setBranchCode(bCode);
		branch.setCity(city);
		branch.setManagerId(empId);
		branch.setCreatedTime(dateTime);
		branch.setModifiedTime(dateTime);
		branch.setModifiedBy(empId);
		
		newOpt.createMethod(branch);
	}
	
	public Branch getDetails(int branchId)
	{
		branch= new Branch();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("branchName");
		requiredFields.add("branchCode");
		requiredFields.add("city");
		requiredFields.add("managerId");
		
		Map<Branch,List<String>> objects= new HashMap<Branch, List<String>>();
		objects.put(branch, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName("Branch");
		newCondition.setFieldName("branchId");
		newCondition.setOperator(" = ");
		newCondition.setValue(branchId);
		
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result=  newOpt.selectMethod(objects, conditions, order);
		
		branch = (Branch) result.get(0).get(0);
		
		return branch;
	}
	
	private static long getCurrentTimeMillis() 
	{
		return System.currentTimeMillis();
	}
}
