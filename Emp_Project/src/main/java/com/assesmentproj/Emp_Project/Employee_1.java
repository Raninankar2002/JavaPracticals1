package com.assesmentproj.Emp_Project;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

import javax.persistence.*;
@Entity
public class Employee_1 
{
	@Id
	private int emp_id;
	private String emp_name;
	
	@ManyToMany @JoinTable(name="employee_projects_table",
			joinColumns= {@JoinColumn(name="emp_Id")},
			inverseJoinColumns= {@JoinColumn(name="P_Id")})
	
	private List<Projects>projects;

	//getter and setter
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	//constructors
	public Employee_1(int emp_id, String emp_name, List<Projects> projects) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.projects = projects;
	}

	public Employee_1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
}
