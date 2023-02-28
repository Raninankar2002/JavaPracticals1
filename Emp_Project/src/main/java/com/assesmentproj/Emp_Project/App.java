// Question= Many to Many relationship between Employee and Project


package com.assesmentproj.Emp_Project;

import java.util.ArrayList;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate3.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	//create employee
    	
    	Employee_1 e1=new Employee_1();
    	e1.setEmp_id(19921);
    	e1.setEmp_name("Rani");
    	
    	Employee_1 e2=new Employee_1();
    	e2.setEmp_id(19922);
    	e2.setEmp_name("Raavi");
    	
    	Employee_1 e3=new Employee_1();
    	e3.setEmp_id(19923);
    	e3.setEmp_name("Rishita");
    	
    	
    	//create projects
    	
    	Projects p1=new Projects();
    	p1.setP_Id(5661);
    	p1.setP_Name("delivery website");
    	

    	Projects p2=new Projects();
    	p2.setP_Id(5662);
    	p2.setP_Name("Food Website");
    	
    	Projects p3=new Projects();
    	p3.setP_Id(5663);
    	p3.setP_Name("e-commerce website");
    	
    	Projects p4=new Projects();
    	p4.setP_Id(5664);
    	p4.setP_Name("college Mangement");
    	
    	
    	
    
    	List<Employee_1> list1=new ArrayList<Employee_1>();
    	List<Projects> list2=new ArrayList<Projects>();
    	
    	list1.add(e1);
    	list1.add(e2);
    	list1.add(e3);
    	
    	list2.add(p1);
    	list2.add(p2);
    	list2.add(p3);
    	
    	
    	e1.setProjects(list2);
    	p1.setEmployee_1(list1);
    	
    	//open the session
    	Session session=factory.openSession();
    	
    	//begin the transaction
    	Transaction tx=session.beginTransaction();
    	
    	//saving the data
    	session.save(e1);
    	session.save(e2);
    	session.save(e3);
    	session.save(p1);
    	session.save(p2);
    	session.save(p3);
    	
    	
    	tx.commit();
    	//close the session
    	session.close();
    	
    	//close the factory
    	factory.close();
    	
    
    }
    
}
