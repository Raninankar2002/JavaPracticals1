
//Question= one to Many relationship between Employee and Department


package com.hibernateproj.empdeptproj;


import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
      //System.out.println( "program is running" );
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	//System.out.println(factory);
    	//System.out.println(factory.isClosed());
    	
    	//create Employee
    	Employee e1 = new Employee();
    	e1.setEId(10991);
    	e1.setEName("Rishita");
    	
    	
    	//creating Department
    	
    	Department d1 = new Department();
    	d1.setDId(100451);
    	d1.setDName("Finace");
    	d1.setEmployee(e1);
    	

    	Department d2 = new Department();
    	d2.setDId(100452);
    	d2.setDName("Marketing");
    	d2.setEmployee(e1);
    	
    	Department d3 = new Department();
    	d3.setDId(100453);
    	d3.setDName("HR");
    	d3.setEmployee(e1);
    	
    	//creating the list of department to associate with 1 employee
    	List<Department> list= new ArrayList<Department>();
    	list.add(d1);
    	list.add(d2);
    	list.add(d3);
    	
    	//setting the department with employee
    	e1.setDepartment(list);
    	
    	
    	
    	Session session = factory.openSession();
    	
    	//begin the transaction
    	Transaction tx=session.beginTransaction();
    	session.save(e1);
    	session.save(d1);
    	session.save(d2);
    	session.save(d3);
    	
    	tx.commit();
    	session.close();
    	factory.close();
    }
}
    	
    	
    	
	
