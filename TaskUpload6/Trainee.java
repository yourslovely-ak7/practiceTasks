package com.example.task6;

public class Trainee {
	
	private String name;
	private String empId;
	private int joinedYear;
	private String workLocation;
	
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trainee(String name, String empId, int joinedYear, String workLocation) {
		super();
		this.name = name;
		this.empId = empId;
		this.joinedYear = joinedYear;
		this.workLocation = workLocation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public int getJoinedYear() {
		return joinedYear;
	}
	public void setJoinedYear(int joinedYear) {
		this.joinedYear = joinedYear;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	
	public String toString()
	{
		return "Trainee{name = "+name+" , employeeId = "+empId+"}";
	}
	
}
