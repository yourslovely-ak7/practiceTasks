package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crud.Operations;
import pojo.Account;
import pojo.Customer;
import pojo.User;
import query.Condition;
import query.Order;

public class RUnner {

	public static <E> void main(String [] args)
	{
		//Scanner x=new Scanner(System.in);
//		CRUDMethods obj= new CRUDMethods();
		
		try
		{
//			obj.createMethod();
//			obj.selectMethod();
//			obj.updateMethod();
//			obj.deleteMethod();
//			
//			YamlLoader yaml=new YamlLoader("mapping/mapping.yaml");
//			
//			System.out.println(yaml.getColumnName("User","userId"));
//			System.out.print(yaml.getTableName("User"));
			
			Operations opt=new Operations();
			Account acc=new Account();
			acc.setIfsc("asdf0123456");
			acc.setBalance(11000);
			acc.setBranchId(5);
			acc.setCustId(2);
			acc.setCreatedTime(System.currentTimeMillis());
			acc.setModifiedBy(13);
			acc.setModifiedTime(System.currentTimeMillis());
			acc.setStatus("Active");
			acc.setType("Savings");
			
			opt.createMethod(acc);
			
			Customer cust= new Customer();
			cust.setCustId(1);
			cust.setAadharNo(286205103966L);
			cust.setPan("2345678dfgh2");
			cust.setStatus("Active");
			
			opt.createMethod(cust);
			
			acc= new Account();
			List<String> accFields= new ArrayList<>();
			accFields.add("accountNo");
			accFields.add("ifsc");
			accFields.add("branchId");
			
			cust=new Customer();
			List<String> custFields= new ArrayList<>();
			custFields.add("custId");
			custFields.add("pan");
			
			User user= new User();
			List<String> userFields= new ArrayList<>();
			userFields.add("emailId");
			userFields.add("accountPass");
			
			Map<Object,List<String>> selectFields= new HashMap<>();
			selectFields.put(acc, accFields);
			selectFields.put(cust,custFields);
			selectFields.put(user, userFields);
			
			Map<String,Condition> condition= new HashMap<>();
			Condition cond1= new Condition();
			cond1.setTableName("Account");
			cond1.setFieldName("custId");
			cond1.setOperator(" = ");
			cond1.setValue(2);
			
			Condition cond2= new Condition();
			cond2.setTableName("Account");
			cond2.setFieldName("status");
			cond2.setOperator(" = ");
			cond2.setValue("Active");
			
			condition.put("", cond1);
			condition.put(" AND ", cond2);
			
			Order order=new Order();
			order.setOrderBy(accFields);
			order.setLimit(0);
			order.setDesc(true);
			
			opt.selectMethod(selectFields, condition, order);
			
			acc= new Account();
			acc.setBalance(999);
			acc.setType("Salary");
			
			cust= new Customer();
			cust.setAadharNo(286205103966L);
			
			List<Object> updateItems= new ArrayList<>();
			updateItems.add(acc);
			updateItems.add(cust);
			
			opt.update(updateItems, condition);
			
			acc= new Account();
			cust=new Customer();
			List<Object> deleteItems= new ArrayList<Object>();
			deleteItems.add(acc);
			deleteItems.add(cust);
			
			opt.delete(deleteItems, condition);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
}