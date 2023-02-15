package com.hibernateproj.jdbcproj;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	//Insert Operation
	public static void Insertion()
	{
		System.out.println("Insert the data you want");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Rani@123456");
			if(con.isClosed())
			{
				System.out.println("The connection is close");
			}
			else
			{
				System.out.println("The connection is established");
			}
			String q="Insert into student_info2(roll_no,s_name,dept_name,bookname,contact_no) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			
		//Insert the record
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Roll_no: ");
			int roll_no=sc.nextInt();
			System.out.println("Enter the Student Name: ");
			String s_name=sc.next();
			System.out.println("Enter the Department Name: ");
			String dept_name=sc.next();
			System.out.println("Enter the Book Name: ");
			String bookname=sc.next();
			System.out.println("Enter the Contact Number: ");
			int contact_no=sc.nextInt();
			
			pstmt.setInt(1, roll_no);
			pstmt.setString(2,s_name);
			pstmt.setString(3, dept_name);
			pstmt.setString(4, bookname);
			pstmt.setInt(5, contact_no);
			
			//execute the query
			pstmt.executeUpdate();
			System.out.println("Your data insert successfully");
			
			//close the connection
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Update Operation
	public static void Updation()
	{
		System.out.println("Update the data if you want");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Rani@123456");
			if(con.isClosed())
			{
				System.out.println("The connection is close");
			}
			else
			{
				System.out.println("The connection is established");
			}
			String q="update  student_info2 set bookname=? , s_name=?  where roll_no=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
		//Insert the record
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Roll_NO: ");
			int roll_no=sc.nextInt();
			System.out.println("Enter the Student Name: ");
			String s_name=sc.next();
			System.out.println("Enter the book name if you want: ");
			String bookname=sc.next();
			
			
			pstmt.setString(1, bookname);
			pstmt.setString(2, s_name);
			pstmt.setInt(3, roll_no);
			
			
			//Execute the query
			pstmt.executeUpdate();
			System.out.println("Your data updated successfully ");
			
			//Close the connection
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	///Delete Operation
	public static void Deletion()
	{
		System.out.println("Delete the data if you want");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Rani@123456");
			if(con.isClosed())
			{
				System.out.println("The connection is closed");
			}
			else
			{
				System.out.println("The connection is established");
			}
			String q="Delete from student_info2 where roll_no=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
		//Insert the record
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Roll_NO: ");
			int roll_no=sc.nextInt();
			
			
			pstmt.setInt(1, roll_no);
			
			
			//Execute the query
			pstmt.executeUpdate();
			
			System.out.println("Your data deleted successfully ");
			
			//close the connection
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Display Operation
	public static void Display()
	{
		System.out.println("Display the data");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Rani@123456");
			if(con.isClosed())
			{
				System.out.println("The connection is close");
			}
			else
			{
				System.out.println("The connection is established");
			}
			
			//display the record
			String q="Select roll_no,s_name,dept_name,bookname,contact_no from student_info2";
			PreparedStatement pstmt=con.prepareStatement(q);
            ResultSet rset=pstmt.executeQuery();
    		
    		while(rset.next())
    		{
    			int roll_no=rset.getInt(1);
    			String s_name=rset.getString(2);
    			String dept_name=rset.getString(3);
    			String bookname=rset.getString(4);
    			int contact_no=rset.getInt(5);
    			System.out.println("Roll_NO: "+roll_no+" "+"Student Name: "+s_name+"Department Name: "+dept_name+" "+"Book Name: "+bookname+" "+"Contact No: "+contact_no);
    		}
			
		
			
			//close the connection
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	 public static void main( String[] args )
	    {
	   
	    	
	    	{
	    	
	    	   Scanner sc= new Scanner(System.in);
	    	   System.out.println("Choose which operation do you want to perform : ");
	    	   System.out.println("1 : Insertion, 2 : Updation, 3 : Deletion, 4 : Display");
	    	   int a=sc.nextInt();
	    	   
	    	   switch(a)
	    	   {
	    	   case 1: Insertion();
	    	   break;
	    	   
	    	   case 2: Updation();
	    	   break;
	    	   
	    	   case 3: Deletion();
	    	   break;
	    	   
	    	   case 4: Display();
	    	   break;
	    	   } 
	    		   
	    		
	    
	    	
	    }
		
		
	  }
}
