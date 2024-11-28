package crud;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.Account;
import pojo.Branch;
import query.Condition;
import query.Order;

public class AccountOperation 
{
	private Operations newOpt= new Operations();
	private Map<String,Condition> conditions;
	List<Object> objects;
	private Condition newCondition;
	private String tableName;
	private String pk;
	
	public AccountOperation()
	{
		tableName= "Account";
		pk= "accountNo";
	}
	
	public void newAccount(int empId, int custId, String accType, long initialBalance)
	{
		long createdTime= getCurrentTimeMillis();
		EmployeeOperation empOpt= new EmployeeOperation();
		Branch branch= empOpt.getBranchDetails(empId);
		
		int branchId= branch.getBranchId();
		int branchCode= branch.getBranchCode();
		
		String ifsc= getIfsc(branchCode);
		
		Account newAccount= new Account();
		newAccount.setIfsc(ifsc);
		newAccount.setCustId(custId);
		newAccount.setType(accType);
		newAccount.setBalance(initialBalance);
		newAccount.setBranchId(branchId);
		newAccount.setStatus("ACTIVE");
		newAccount.setCreatedTime(createdTime);
		newAccount.setModifiedTime(createdTime);
		newAccount.setModifiedBy(empId);
		
		newOpt.createMethod(newAccount);
	}
	
	public Account getAccountDetails(int accountNo)
	{
		Account newAccount=new Account();
		List<String> requiredFields= getAllFields(newAccount.getClass());
		
		Map<Account,List<String>> objects= new HashMap<Account, List<String>>();
		objects.put(newAccount, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result= newOpt.selectMethod(objects, conditions, order);
		
		newAccount= (Account) result.get(0).get(0);
		
		return newAccount;
	}
	
	public boolean changeBranch(int empId, long accountNo)
	{
		long createdTime= getCurrentTimeMillis();
		EmployeeOperation empOpt= new EmployeeOperation();
		Branch branch= empOpt.getBranchDetails(empId);
		
		int branchId= branch.getBranchId();
		
		Account account= new Account();
		account.setBranchId(branchId);
		account.setModifiedTime(createdTime);
		account.setModifiedBy(empId);
		
		List<Object> objects= new ArrayList<Object>();
		objects.add(account);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		conditions.put("", newCondition);
		
		int affectedRows = newOpt.update(objects, conditions);
		
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean deactivateAccount(int empId, long accountNo)
	{
		long dateTime= getCurrentTimeMillis();
		
		EmployeeOperation empOpt= new EmployeeOperation();
		if(empOpt.getBranchId(empId)==getBranchId(accountNo))
		{
			Account account= new Account();
			account.setStatus("INACTIVE");
			account.setModifiedTime(dateTime);
			account.setModifiedBy(empId);
			
			objects= new ArrayList<Object>();
			objects.add(account);
			
			conditions= new HashMap<String, Condition>();
			Condition newCondition= new Condition();
			newCondition.setTableName(tableName);
			newCondition.setFieldName(pk);
			newCondition.setOperator(" = ");
			newCondition.setValue(accountNo);
			conditions.put("", newCondition);
			
			int affectedRows = newOpt.update(objects, conditions);
			
			if(affectedRows>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public List<Long> getAccounts(int custId)
	{
		List<Long> accountNo= new ArrayList<Long>();
		
		Account account= new Account();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add(pk);
		
		Map<Account,List<String>> objects= new HashMap<Account, List<String>>();
		objects.put(account, requiredFields);
		
		conditions= new HashMap<String, Condition>();
		Condition newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName("custId");
		newCondition.setOperator(" = ");
		newCondition.setValue(custId);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result= newOpt.selectMethod(objects, conditions, order);
		
		for(List<Object> row: result)
		{
			account= (Account) row.get(0);
			accountNo.add(account.getAccountNo());
		}
		
		return accountNo;
	}
	
	public int getCustId(long accNo)
	{		
		Map<Account,List<String>> objects= new HashMap<>();
		Account account= new Account();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("custId");
		objects.put(account, requiredFields);
		
		conditions= new HashMap<>();
		newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accNo);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result = newOpt.selectMethod(objects, conditions, order);
		
		account= (Account) result.get(0).get(0);
		
		int custId= account.getCustId();
		
		return custId;
	}
	
	public int getBranchId(long accNo)
	{		
		Map<Account,List<String>> objects= new HashMap<>();
		Account account= new Account();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("branchId");
		objects.put(account, requiredFields);
		
		conditions= new HashMap<>();
		newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accNo);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result = newOpt.selectMethod(objects, conditions, order);
		
		account= (Account) result.get(0).get(0);
		
		int branchId= account.getBranchId();
		
		return branchId;
	}
	
	public long retrieveBalance(long accountNo)
	{
		Map<Account,List<String>> objects= new HashMap<>();
		Account account= new Account();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("balance");
		objects.put(account, requiredFields);
		
		conditions= new HashMap<>();
		newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result = newOpt.selectMethod(objects, conditions, order);

		List<Object> row= result.get(0);
		Account accountObj= (Account) row.get(0);
		
		return accountObj.getBalance();
	}
	
	public boolean checkAccountStatus(long accountNo)
	{
		Map<Account,List<String>> objects= new HashMap<>();
		Account account= new Account();
		List<String> requiredFields= new ArrayList<String>();
		requiredFields.add("status");
		objects.put(account, requiredFields);
		
		conditions= new HashMap<>();
		newCondition= new Condition();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		conditions.put("", newCondition);
		
		Order order= new Order();
		
		List<List<Object>> result = newOpt.selectMethod(objects, conditions, order);

		List<Object> row= result.get(0);
		Account accountObj= (Account) row.get(0);
		
		if(accountObj.getStatus().equalsIgnoreCase("ACTIVE"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean debitAmount(long accountNo, long amount, long txnDateTime)
	{
		long balance = retrieveBalance(accountNo);
		int custId= getCustId(accountNo);
		
		if(balance<amount)
		{
			return false;
		}
		
		long newBalance= balance-amount;
		
		objects= new ArrayList<Object>();
		Account accountObj= new Account();
		accountObj.setBalance(newBalance);
		accountObj.setModifiedTime(txnDateTime);
		accountObj.setModifiedBy(custId);
		objects.add(accountObj);
		
		conditions= new HashMap<>();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		conditions.put("", newCondition);
		
		int affectedRows = newOpt.update(objects, conditions);
		
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean creditAmount(long accountNo, long amount, long txnDateTime)
	{
		long balance = retrieveBalance(accountNo);
		int custId= getCustId(accountNo);
		
		long newBalance= balance+amount;
		
		objects= new ArrayList<>();
		Account accountObj= new Account();
		accountObj.setBalance(newBalance);
		accountObj.setModifiedTime(txnDateTime);
		accountObj.setModifiedBy(custId);
		objects.add(accountObj);
		
		conditions= new HashMap<>();
		newCondition.setTableName(tableName);
		newCondition.setFieldName(pk);
		newCondition.setOperator(" = ");
		newCondition.setValue(accountNo);
		conditions.put("", newCondition);
		
		int affectedRows = newOpt.update(objects, conditions);
		
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static long getCurrentTimeMillis() 
	{
		return System.currentTimeMillis();
	}
	
	private static String getIfsc(int branchCode)
	{
		
		String ifsc= "MAIN0";
		int paddingZero=0, temp=branchCode;

		while(temp>0)
		{
			temp/= 10;
			paddingZero++;
		}
		
		for(int i=paddingZero;i<6;i++)
		{
			ifsc+="0";
		}
		
		ifsc+= branchCode;
		
		return ifsc;
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
}
