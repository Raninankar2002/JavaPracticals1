package com.assesmentproj.Emp_Project;

import java.util.List;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projects 
{
	@Id
	private int P_Id;
	private String P_Name;
	
	@ManyToMany //(mappedBy="projects")
	
	private List<Employee_1>employee_1;

	//getter and setter
	public int getP_Id() {
		return P_Id;
	}

	public void setP_Id(int p_Id) {
		P_Id = p_Id;
	}

	public String getP_Name() {
		return P_Name;
	}

	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}

	public List<Employee_1> getEmployee_1() {
		return employee_1;
	}

	public void setEmployee_1(List<Employee_1> employee_1) {
		this.employee_1 = employee_1;
	}

	//constructors
	public Projects(int p_Id, String p_Name, List<Employee_1> employee_1) {
		super();
		P_Id = p_Id;
		P_Name = p_Name;
		this.employee_1 = employee_1;
	}

	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

	