package query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDMethods {
	
	public void createMethod() throws SQLException, ClassNotFoundException
	{
		Query obj=new Query();
		String tableName="USER";
		List<String> fields= new ArrayList<String>();
		fields.add("userName");
		fields.add("dob");
		
		List<Object> values= new ArrayList<Object>();
		values.add("Ak");
		values.add(System.currentTimeMillis());
	
		obj.insert(tableName, fields, values);
	}
	
	public void selectMethod() throws SQLException, ClassNotFoundException
	{
		String order="ASC";
		String limit= "";
		
		Query obj= new Query();
		List<String> userFields= new ArrayList<String>();
		userFields.add("userName");
		userFields.add("dob");
		
		List<String> custFields= new ArrayList<String>();
		custFields.add("custId");
		custFields.add("pan");
		
		List<String> accFields= new ArrayList<String>();
		accFields.add("accountNo");
		accFields.add("balance");
		
		Fields table1= new Fields();
		table1.setTableName("User");
		table1.setFieldNames(userFields);
		
		Fields table2= new Fields();
		table2.setTableName("Customer");
		table2.setFieldNames(custFields);

		Fields table3= new Fields();
		table3.setTableName("Account");
		table3.setFieldNames(accFields);
		
		List<Fields> fields=new ArrayList<Fields>();
		fields.add(table1);
		fields.add(table2);
		fields.add(table3);
		
		Join join1= new Join();
		join1.setTableName("User");
		join1.setFieldName("userId");
		
		Join join2= new Join();
		join2.setTableName("Customer");
		join2.setFieldName("custId");
		
		Join join3= new Join();
		join3.setTableName("Account");
		join3.setFieldName("custId");
		
		Map<Join,Join> join= new HashMap<Join, Join>();
		join.put(join1, join2);
		join.put(join2, join3);
		
		Condition condition1= new Condition();
		condition1.setTableName("Customer");
		condition1.setFieldName("custId");
		condition1.setValue(2);
		condition1.setOperator(">");
		
		Condition condition2= new Condition();
		condition2.setTableName("Customer");
		condition2.setFieldName("pan");
		condition2.setValue("hdas5646sas");
		condition2.setOperator("=");
		
		Map<String, Condition> where= new HashMap<String, Condition>();
		where.put("", condition1);
		where.put("AND", condition2);

		obj.select(fields, join, where, order ,limit);
	}
	
	public void updateMethod() throws SQLException, ClassNotFoundException
	{		
		Query obj= new Query();
		List<String> userFields= new ArrayList<String>();
		userFields.add("userName");
		userFields.add("dob");
		
		List<Object> userValues= new ArrayList<Object>();
		userValues.add("Ak");
		userValues.add(System.currentTimeMillis());
		
		List<String> accFields= new ArrayList<String>();
		accFields.add("balance");
		
		List<Object> accValues=new ArrayList<Object>();
		accValues.add(200000);
		
		Fields table1= new Fields();
		table1.setTableName("User");
		table1.setFieldNames(userFields);
		table1.setValues(userValues);

		Fields table3= new Fields();
		table3.setTableName("Account");
		table3.setFieldNames(accFields);
		table3.setValues(accValues);
		
		List<Fields> fields=new ArrayList<Fields>();
		fields.add(table1);
		fields.add(table3);
		
		Join join1= new Join();
		join1.setTableName("User");
		join1.setFieldName("userId");
		
		Join join3= new Join();
		join3.setTableName("Account");
		join3.setFieldName("custId");
		
		Map<Join,Join> join= new HashMap<Join, Join>();
		join.put(join1, join3);
		
		Condition condition1= new Condition();
		condition1.setTableName("User");
		condition1.setFieldName("userId");
		condition1.setValue(12);
		condition1.setOperator("<");
		
		Condition condition2= new Condition();
		condition2.setTableName("Account");
		condition2.setFieldName("ifsc");
		condition2.setValue("hdas5646sas");
		condition2.setOperator("=");
		
		Map<String, Condition> where= new HashMap<String, Condition>();
		where.put("", condition1);
		where.put("AND", condition2);

		obj.update(fields, join, where);
	}
	
	public void deleteMethod() throws SQLException
	{
		Query obj= new Query();
		
		String table1= "User";

		String table3= "Account";
		
		List<String> fields=new ArrayList<>();
		fields.add(table1);
		fields.add(table3);
		
		Join join1= new Join();
		join1.setTableName("User");
		join1.setFieldName("userId");
		
		Join join3= new Join();
		join3.setTableName("Account");
		join3.setFieldName("custId");
		
		Map<Join,Join> join= new HashMap<Join, Join>();
		join.put(join1, join3);
		
		Condition condition1= new Condition();
		condition1.setTableName("User");
		condition1.setFieldName("userId");
		condition1.setValue(12);
		condition1.setOperator("<");
		
		Condition condition2= new Condition();
		condition2.setTableName("Account");
		condition2.setFieldName("ifsc");
		condition2.setValue("hdas5646sas");
		condition2.setOperator("=");
		
		Map<String, Condition> where= new HashMap<String, Condition>();
		where.put("", condition1);
		where.put("OR", condition2);

		obj.delete(fields, join, where);
	}
}
