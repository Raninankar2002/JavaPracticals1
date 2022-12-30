package String3;

import java.util.Scanner;
	
	interface Printable
	{
		void print();
	}
	interface Calculate{
		int Cal(int a);	
	}
	class CalSquare implements Calculate ,Printable
	{
		public void print()
		{
			System.out.println("Square of a number is :");
	    }
		
		public int Cal(int a)
		{
			int b=a*a;
			return b;
		}
			
	}
	class CalCube implements Calculate ,Printable
	{
		
		public void print()
		{
			System.out.println("cube of a number is :");
		}
		public int Cal(int a)
		{
			int c=a*a*a;
			return c;
		}
	}
	
	public class UseCalculate
	{
		public static void main(String[] args)
		{
			CalSquare s=new CalSquare();
			s.print();
			System.out.println(s.Cal(3));
			CalCube c=new CalCube();
			c.print();
			System.out.println(c.Cal(4));
			
		}	
	
	}

