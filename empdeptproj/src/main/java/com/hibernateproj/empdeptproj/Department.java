package com.hibernateproj.empdeptproj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name="Department_Table")
public class Department
{
	@Id@Column(name="Department_Id")
	private int DId;
	private String DName;
	
	@ManyToOne
	private Employee employee;

	
	//getter and setter
	public int getDId() {
		return DId;
	}

	public void setDId(int dId) {
		DId = dId;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	//constructors
	public Department(int dId, String dName, Employee employee) {
		super();
		DId = dId;
		DName = dName;
		this.employee = employee;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
