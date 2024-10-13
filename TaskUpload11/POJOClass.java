package com.example.task11;

public class POJOClass 
{
	private int empId;
	private String name;
	private String mobile;
	private String email;
	private String dept;
	
	public POJOClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public POJOClass(int empId, String name, String mobile, String email, String dept) {
		super();
		this.empId = empId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.dept = dept;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
