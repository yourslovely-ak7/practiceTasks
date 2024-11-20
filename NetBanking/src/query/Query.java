package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {
	
//	private String stringArray[]= new String[0];
	Connection connection;
	
	public Query()
	{
		try 
		{
			connection = MySQLDataBase.initializeDatabase();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void insert(String tableName, List<String> fields, List<Object> values) throws SQLException
	{
		StringBuilder columns= new StringBuilder();
		StringBuilder placeholders= new StringBuilder();
		
		if(fields.size()==values.size())
		{
			for(int i=0;i<fields.size();i++)
			{
				columns.append(fields.get(i));
				placeholders.append("?");
				
				if(i<fields.size()-1)
				{
					columns.append(", ");
					placeholders.append(", ");
				}
			}
			
			String query= "INSERT INTO "+tableName+"("+columns+") VALUES ("+placeholders+");";
			
			try(PreparedStatement statement= connection.prepareStatement(query))
			{				
				for(int i=0;i<values.size();i++)
				{
					statement.setObject(i+1, values.get(i));
				}
				System.out.println(statement);
				statement.executeUpdate();
			}
		}
	}
	
	public List<Map<String,Object>> select(List<Fields> fields, Map<Join,Join> join, Map<String,Condition> condition, String order, String limit) throws SQLException
	{
		StringBuilder columnBuilder= new StringBuilder();
		int len= fields.size();
		int colSize;
		String tableName;
		String tables[]= {};
		
		for(int j=0;j<len;j++)
		{	
			Fields currentField= fields.get(j);
			tableName= currentField.getTableName();
			
			List<String> columns= currentField.getFieldNames();
			colSize= columns.size();
			
			for(int i=0;i<colSize;i++)
			{
				columnBuilder.append(tableName+"."+columns.get(i));
				
				if(i<colSize-1)
				{
					columnBuilder.append(", ");
				}
			}
			
			if(j<len-1)
			{
				columnBuilder.append(", ");
			}
		}
		
		tableName= fields.get(0).getTableName();
		String query= "SELECT "+columnBuilder+" FROM "+tableName;
		
		StringBuilder joinBuilder= new StringBuilder();
		if(join.size()!=0)
		{
			Join keys[]=  join.keySet().toArray(new Join[0]);
			len= keys.length;
			Join value;
			for(int i=0;i<len;i++)
			{
				joinBuilder.append(" JOIN ");
				
				value= join.get(keys[i]);
				joinBuilder.append(value.getTableName()+" ON "+ keys[i].getTableName()+"."+keys[i].getFieldName()
						+" = "+value.getTableName()+"."+value.getFieldName());
			}
			
			query+= joinBuilder;
		}
		
		if(condition.size()!=0)
		{
			StringBuilder conditionBuilder= new StringBuilder();
			tables = condition.keySet().toArray(new String[0]);
			len=tables.length;
			
			query+= " WHERE";
			for(int i=0;i<len;i++)
			{
				Condition givenCond= condition.get(tables[i]);
				
				conditionBuilder.append(" "+tables[i]+" "+givenCond.getTableName()+"."+givenCond.getFieldName()+" "+givenCond.getOperator()+" ?");
			}
			
			query+= conditionBuilder;
		}
		
		if(order.length()>0)
		{
			query+= " "+order;
		}
		
		if(limit.length()>0)
		{
			query+= " LIMIT "+limit;
		}
	
		query+= ";";
		
		try(PreparedStatement statement= connection.prepareStatement(query))
		{
			if(condition.size()!=0)
			{
				len= tables.length;
				for(int i=0;i<len;i++)
				{
					Condition givenCond= condition.get(tables[i]);
					statement.setObject(i+1, givenCond.getValue());
				}
				ResultSet result= statement.executeQuery();
				return resultSetConversion(result);
//				System.out.println(statement);
			}
			else
			{
				ResultSet result= statement.executeQuery();
				return resultSetConversion(result);
//				System.out.println(statement);
			}			
		}
	}
	
	public int update(List<Fields> newValues, Map<Join,Join> join, Map<String,Condition> condition) throws SQLException
	{
		String tableName= newValues.get(0).getTableName();
		String query="UPDATE "+tableName;
		int len;
		StringBuilder joinBuilder= new StringBuilder();
		
		if(join.size()!=0)
		{
			Join keys[]=  join.keySet().toArray(new Join[0]);
			len= keys.length;
			Join value;
			for(int i=0;i<len;i++)
			{
				joinBuilder.append(" JOIN ");
				
				value= join.get(keys[i]);
				joinBuilder.append(value.getTableName()+" ON "+ keys[i].getTableName()+"."+keys[i].getFieldName()
						+" = "+value.getTableName()+"."+value.getFieldName());
			}
			
			query+= joinBuilder;
		}

		StringBuilder setBuilder= new StringBuilder();
		Fields fields[]= newValues.toArray(new Fields[0]);
		query+= " SET ";
		len= fields.length;
		
		for(int i=0;i<len;i++)
		{
			Fields currField= fields[i];
			List<String> columns= currField.getFieldNames();
			int colSize= columns.size();
			
			for(int j=0;j<colSize;j++)
			{
				setBuilder.append(currField.getTableName()+"."+columns.get(j)+" = ? ");
				
				if(j<colSize-1)
				{
					setBuilder.append(", ");
				}
			}

			if(i<len-1)
			{
				setBuilder.append(", ");
			}
		}
		
		query+= setBuilder;
//		System.out.println(query);
		
		String tables[]= {};
		if(condition.size()!=0)
		{
			StringBuilder conditionBuilder= new StringBuilder();
			tables = condition.keySet().toArray(new String[0]);
			len=tables.length;
			
			query+= " WHERE";
			for(int i=0;i<len;i++)
			{
				Condition givenCond= condition.get(tables[i]);
				
				conditionBuilder.append(" "+tables[i]+" "+givenCond.getTableName()+"."+givenCond.getFieldName()+" "+givenCond.getOperator()+" ?");
			}
			
			query+= conditionBuilder;
		}
		
		query+= ";";
		
		try(PreparedStatement statement= connection.prepareStatement(query))
		{
			int index=1;
			
			len= fields.length;
			for(int i=0;i<len;i++)
			{
				Fields currField= fields[i];
				List<Object> values= currField.getValues();
				int valSize= values.size();
				
				for(int j=0;j<valSize;j++)
				{
					statement.setObject(index, values.get(j));
					index++;
				}
			}
			
			if(condition.size()!=0)
			{
				len= tables.length;
				for(int i=0;i<len;i++)
				{
					Condition givenCond= condition.get(tables[i]);
					statement.setObject(index, givenCond.getValue());
					index++;
				}
				return statement.executeUpdate();
//				System.out.println(statement);
			}
			else
			{
				return statement.executeUpdate();
//				System.out.println(statement);
			}			
		}
	}
	
	public void delete(List<String> tables, Map<Join,Join> join, Map<String,Condition> condition) throws SQLException
	{
		String query= "DELETE ";
		int len= tables.size();
		String tableName;
		
		StringBuilder tableBuilder= new StringBuilder();
		for(int i=0;i<len;i++)
		{
			tableName= tables.get(i);
			tableBuilder.append(tableName+" ");
			
			if(i<len-1)
			{
				tableBuilder.append(", ");
			}
		}
		
//		System.out.println(tables);
		
		tableName= tables.get(0);
		query+= tableBuilder+" FROM "+tableName+" ";
		
		StringBuilder joinBuilder= new StringBuilder();
		if(join.size()!=0)
		{
			Join keys[]=  join.keySet().toArray(new Join[0]);
			len= keys.length;
			Join value;
			for(int i=0;i<len;i++)
			{
				joinBuilder.append(" JOIN ");
				
				value= join.get(keys[i]);
				joinBuilder.append(value.getTableName()+" ON "+ keys[i].getTableName()+"."+keys[i].getFieldName()
						+" = "+value.getTableName()+"."+value.getFieldName());
			}
			
			query+= joinBuilder;
		}
		
		String entry[]= {};
		if(condition.size()!=0)
		{
			StringBuilder conditionBuilder= new StringBuilder();
			entry = condition.keySet().toArray(new String[0]);
			len=entry.length;
			
			query+= " WHERE";
			for(int i=0;i<len;i++)
			{
				Condition givenCond= condition.get(entry[i]);
				
				conditionBuilder.append(" "+entry[i]+" "+givenCond.getTableName()+"."+givenCond.getFieldName()+" "+givenCond.getOperator()+" ?");
			}
			query+= conditionBuilder;
		}
		
		query+= ";";
		
		try(PreparedStatement statement= connection.prepareStatement(query))
		{
			if(condition.size()!=0)
			{
				len= entry.length;
				for(int i=0;i<len;i++)
				{
					Condition givenCond= condition.get(entry[i]);
					statement.setObject(i+1, givenCond.getValue());
				}
//				statement.execute();
				System.out.println(statement);
			}
			else
			{
				//statement.execute();
				System.out.println(statement);
			}
		}
	}
	
	private List<Map<String,Object>> resultSetConversion(ResultSet result) throws SQLException
	{
		List<Map<String, Object>> dataSet = new ArrayList<Map<String,Object>>();
		ResultSetMetaData metaData= result.getMetaData();
		int columnCount= metaData.getColumnCount();
		
		while (result.next()) 
		{
            Map<String, Object> row = new HashMap<>();
        
            for (int i = 1; i <= columnCount; i++) 
            {
                String columnName = metaData.getColumnName(i);
                Object columnValue = result.getObject(i);
                row.put(columnName, columnValue);
            }
            dataSet.add(row);
        }
        return dataSet;
	}
}