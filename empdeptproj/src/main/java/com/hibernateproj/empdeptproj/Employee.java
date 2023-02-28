package com.hibernateproj.empdeptproj;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity(name="Employee_Table")

public class Employee 
{
	@Id  //Column(name="Employee_Id")
	private int EId;
	private String EName;
	
	@OneToMany@JoinColumn(name="Employee_Department_Id")
	private List<Department>department;

	
	//getter and setter
	public int getEId() {
		return EId;
	}

	public void setEId(int eId) {
		EId = eId;
	}

	public String getEName() {
		return EName;
	}

	public void setEName(String eName) {
		EName = eName;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	//constructors
	public Employee(int eId, String eName, List<Department> department) {
		super();
		EId = eId;
		EName = eName;
		this.department = department;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	
	
	


	
	
	
	
	
	
}
