package com.example.task11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.exception.InvalidException;

public class Runner {
	
	public static void main(String [] args)
	{
		Scanner scanner=new Scanner(System.in);
		Runner runner= new Runner();
		TaskClass obj=new TaskClass();
		Connection connection;
		int flag=0,option;
		
		try
		{
			connection= MySQLDataBase.initializeDatabase();
			
			while(flag==0)
			{
				runner.defaultPrint();
				option= scanner.nextInt();
				scanner.nextLine();
				
				try
				{
					switch(option)
					{
						case 1:
							runner.exercise1(scanner,connection,obj);
							break;
						case 2:
							runner.exercise2(scanner,connection,obj);
							break;
						case 3:
							runner.exercise3(scanner,connection,obj);
							break;
						case 4:
							runner.exercise4(scanner,connection,obj);
							break;
						case 5:
							runner.exercise5(scanner,connection,obj);
							break;
						case 6:
							runner.exercise6(scanner,connection,obj);
							break;
						case 7:
							runner.exercise7(scanner,connection,obj);
							break;
						case 9:
							runner.exercise9(scanner,connection,obj);
							break;
						case 10:
							runner.exercise10(scanner,connection,obj);
							break;
						case 11:
							runner.exercise11(scanner,connection,obj);
							break;
						case 12:
							runner.exercise12(scanner,connection,obj);
							break;
						case 0:
							flag++;
							System.out.println("Thank You! Bye...");
							break;
						default:
							System.out.println("Please, Select a valid option!");
					}
				}
				catch(InvalidException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			scanner.close();
		}
		
	}
	
	private void defaultPrint()
	{
		System.out.printf("\nSelect an option : \n");
	}
	
	private void exercise1(Scanner scanner, Connection connection, TaskClass obj) throws InvalidException, SQLException
	{
		String query= "Create table if not exists Employee(EMPLOYEE_ID int NOT NULL, NAME varchar(20) NOT NULL, MOBILE varchar(10) NOT NULL,"
				+ "EMAIL varchar(30) NOT NULL, DEPARTMENT varchar(15) NOT NULL, PRIMARY KEY (EMPLOYEE_ID));";
		
		obj.createTable(connection, query);
		
		describeTable(connection, obj);
	}
	
	private void exercise2(Scanner scanner, Connection connection, TaskClass obj) throws InvalidException, SQLException
	{
		System.out.println("No. of records to be added : ");
		int num= scanner.nextInt();
		
		String query="Insert into Employee(EMPLOYEE_ID,NAME,MOBILE,EMAIL,DEPARTMENT) values(?,?,?,?,?);";
		int empId;
		String name,mobile,email,dept;
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter the values for record "+(i+1)+" : ");
			empId= scanner.nextInt();
			scanner.nextLine();
			name= scanner.nextLine();
			mobile= scanner.nextLine();
			email= scanner.nextLine();
			dept= scanner.nextLine();
			
			obj.insertValues(connection, query, empId, name, mobile, email, dept);
		}
		
		showTable(connection, obj);
	}
	
	private void exercise3(Scanner scanner, Connection connection, TaskClass obj) throws InvalidException, SQLException
	{
		String query= "Select * from Employee where name=?;";
		System.out.println("Enter the name to search for : ");
		String name= scanner.nextLine();
		
		ResultSet resultSet= obj.getRecords(connection, query, name);
		
		printRecords(resultSet);
	}
	
	private void exercise4(Scanner scanner, Connection connection, TaskClass obj) throws InvalidException, SQLException
	{
		String query= "Update Employee Set MOBILE=?, EMAIL=?, DEPARTMENT=? where EMPLOYEE_ID=?;";
		System.out.println("Enter the ID to be updated : ");
		int empId= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the mobile number : ");
		String mobile= scanner.nextLine();
		System.out.println("Enter the email address : ");
		String email= scanner.nextLine();
		System.out.println("Enter the department : ");
		String dept= scanner.nextLine();
		
		obj.updateRecords(connection, query, empId, mobile, email, dept);
		
		showTable(connection, obj);
	}
	
	private void exercise5(Scanner scanner,Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Select * from Employee LIMIT ?;";
		System.out.println("Enter the no. of records : ");
		int limit= scanner.nextInt();
			
		ResultSet resultSet= obj.showTable(connection, query,limit);
		
		printRecords(resultSet);
	}
	
	private void exercise6(Scanner scanner,Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Select * from Employee order by";
		System.out.println("Enter column by which the data is ordered by : ");
		String columnName= scanner.nextLine();
		String order[]= {"ASC","DESC"};
		System.out.println("1 - Ascending order\t2 - Descending order");
		int index= scanner.nextInt();
		
		query= query+" "+columnName+" "+order[index-1]+";";
		ResultSet resultSet= obj.sortRecords(connection, query);
		
		printRecords(resultSet);
	}
	
	private void exercise7(Scanner scanner,Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Delete from Employee where EMPLOYEE_ID = ?;";
		System.out.println("Enter the ID of the record to be deleted : ");
		int id= scanner.nextInt();
			
		ResultSet resultSet= obj.deleteRecord(connection, query, id);
		
		printRecords(resultSet);
	}
	
	private void exercise9(Scanner scanner,Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Create Table EmployeeDetails ( EMPLOYEE_ID int NOT NULL, NAME varchar(20) NOT NULL, "
				+ "AGE int NOT NULL, MARITAL_STATUS varchar(10), PRIMARY KEY(EMPLOYEE_ID), "
				+ "FOREIGN KEY(EMPLOYEE_ID) References Employee(EMPLOYEE_ID));";
		
		obj.createTable(connection, query);
	}
	
	private void exercise10(Scanner scanner, Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Insert into EmployeeDetails(EMPLOYEE_ID, NAME, AGE, MARITAL_STATUS) "
				+ "Select EMPLOYEE_ID, NAME, ?, ? from Employee "
				+ "Where EMPLOYEE_ID = ? ;";
		
		System.out.println("Enter the no. of record needed to be added : ");
		int num= scanner.nextInt();
		int empId,age;
		String maritalStatus;
		
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter the employeeId of the record : ");
			empId= scanner.nextInt();
			System.out.println("Enter the age of the record : ");
			age= scanner.nextInt();
			System.out.println("Enter the marital status : ");
			maritalStatus= scanner.next();
			
			obj.insertDependantTable(connection, query, empId, age, maritalStatus);
		}
	}
	
	private void exercise11(Scanner scanner, Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Select * from EmployeeDetails where EMPLOYEE_ID = ? AND NAME = ?;";
		
		System.out.println("Enter the employeeId : ");
		int empId= scanner.nextInt();
		System.out.println("Enter the employee Name : ");
		scanner.nextLine();
		String name= scanner.nextLine();
		
		ResultSet resultSet= obj.getRecordsDependantTable(connection, query, empId, name);
		
		printRecordsDependentTable(resultSet);
	}
	
	private void exercise12(Scanner scanner,Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Select * from EmployeeDetails order by";
		System.out.println("Enter column by which the data is ordered by : ");
		String columnName= scanner.nextLine();
		String order[]= {"ASC","DESC"};
		System.out.println("1 - Ascending order\t2 - Descending order");
		int index= scanner.nextInt();
		System.out.println("Enter the no. of records to be fetched : ");
		int limit= scanner.nextInt();
		
		query= query+" "+columnName+" "+order[index-1]+" LIMIT ? ;";
		ResultSet resultSet= obj.sortRecordsDependantTable(connection, query, limit);
		
		printRecordsDependentTable(resultSet);
	}
	
	private void describeTable(Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Describe Employee;";
		ResultSet resultSet= obj.describeTable(connection, query);
		
		 System.out.printf("%-20s %-20s %-10s %-10s %-10s %-10s%n", 
                 "Field", "Type", "Null", "Key", "Default", "Extra");

		 System.out.println("---------------------------------------------------------------------------------");
		 while (resultSet.next()) 
		 {
			   String field = resultSet.getString("Field");
			   String type = resultSet.getString("Type");
			   String isNullable = resultSet.getString("Null");
			   String key = resultSet.getString("Key");
			   String defaultValue = resultSet.getString("Default");
			   String extra = resultSet.getString("Extra");

			   System.out.printf("%-20s %-20s %-10s %-10s %-10s %-10s%n", 
			                     field, type, isNullable, key, defaultValue, extra);
		 }
	}
	
	private void showTable(Connection connection, TaskClass obj) throws SQLException, InvalidException
	{
		String query="Select * from Employee;";
		ResultSet resultSet= obj.showTable(connection, query);
		
		printRecords(resultSet);
	}
	
	private void printRecords(ResultSet resultSet) throws SQLException
	{
		System.out.printf("%-20s %-20s %-10s %-20s %-30s%n", 
                "EMPLOYEE_ID", "NAME", "MOBILE", "EMAIL", "DEPARTMENT");

		 System.out.println("---------------------------------------------------------------------------");
		 while (resultSet.next())
		 {
			   int empId = resultSet.getInt(1);
			   String name = resultSet.getString(2);
			   String mobile = resultSet.getString(3);
			   String email = resultSet.getString(4);
			   String dept = resultSet.getString(5);

			   System.out.printf("%-20d %-20s %-10s %-20s %-30s%n", 
			                     empId, name, mobile, email, dept);
		 }
	}
	
	private void printRecordsDependentTable(ResultSet resultSet) throws SQLException
	{
		System.out.printf("%-20s %-20s %-10s %-20s%n", 
                "EMPLOYEE_ID", "NAME", "AGE", "MARITAL_STATUS");

		 System.out.println("---------------------------------------------------------------------------");
		 while (resultSet.next())
		 {
			   int empId = resultSet.getInt(1);
			   String name = resultSet.getString(2);
			   int age = resultSet.getInt(3);
			   String maritalStatus = resultSet.getString(4);

			   System.out.printf("%-20d %-20s %-10d %-20s%n", 
			                     empId, name, age, maritalStatus);
		 }
	}
}
