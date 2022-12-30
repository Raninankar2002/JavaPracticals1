package practical_29Dec2022;

import java.util.Scanner;

public class Divide_two_Numbers
{

	public static void main(String[] args)
	{
		 Scanner sc=new Scanner(System.in);
		   System.out.println("Enter the value");
		   int x=sc.nextInt();
		   int y=sc.nextInt();
		   int i;
		   try
		   {
			    i=x/y;
			   System.out.println("The Division Of two Number:"+i);
		   }
		   catch(Exception e)
		   {
			   System.out.println("The Exception is :"+e);
		   }

	}

		
}




