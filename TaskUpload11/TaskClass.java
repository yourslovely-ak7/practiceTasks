package com.example.task11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.exception.Helper;
import com.example.exception.InvalidException;

public class TaskClass {
	
	public void createTable(Connection connection, String query) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		
		statement.execute();
	}
	
	public void insertValues(Connection connection, String query, int empId, String name, String mobile, String email, String dept) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		Helper.validateInput(name);
		Helper.validateInput(mobile);
		Helper.validateInput(email);
		Helper.validateInput(dept);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setInt(1, empId);
		statement.setString(2, name);
		statement.setString(3, mobile);
		statement.setString(4, email);
		statement.setString(5, dept);
		
		statement.execute();
	}
	
	public ResultSet getRecords(Connection connection, String query, String name) throws InvalidException, SQLException
	{
		Helper.validateInput(query);
		Helper.validateInput(name);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setString(1, name);
		
		return statement.executeQuery();
	}
	
	public void updateRecords(Connection connection, String query, int empId, String mobile, String email, String dept) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		Helper.validateInput(mobile);
		Helper.validateInput(email);
		Helper.validateInput(dept);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setString(1, mobile);
		statement.setString(2, email);
		statement.setString(3, dept);
		statement.setInt(4, empId);
		
		statement.execute();
	}
	
	public ResultSet sortRecords(Connection connection, String query) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		
		return statement.executeQuery();
	}
	
	public ResultSet deleteRecord(Connection connection, String query, int id) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setInt(1, id);
		
		return statement.executeQuery();
	}
	
	public void insertDependantTable(Connection connection, String query, int empId, int age, String maritalStatus) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		Helper.validateInput(maritalStatus);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setInt(1, age);
		statement.setString(2, maritalStatus);
		statement.setInt(3, empId);
		
		statement.execute();
	}
	
	public ResultSet getRecordsDependantTable(Connection connection, String query, int empId, String name) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		Helper.validateInput(name);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setInt(1, empId);
		statement.setString(2, name);
		
		return statement.executeQuery();
	}
	
	public ResultSet sortRecordsDependantTable(Connection connection, String query, int limit) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setInt(1, limit);
		
		return statement.executeQuery();
	}
	
	public ResultSet describeTable(Connection connection, String query) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		return statement.executeQuery();
	}
	
	public ResultSet showTable(Connection connection, String query) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		return statement.executeQuery();
	}
	
	public ResultSet showTable(Connection connection, String query, int limit) throws SQLException, InvalidException
	{
		Helper.validateInput(query);
		
		PreparedStatement statement= connection.prepareStatement(query);
		statement.setInt(1, limit);
		
		return statement.executeQuery();
	}
}
