package practical_29Dec2022;

import java.util.Scanner;

public class ThreadEvenOdd 
{

	public static void main(String[] args)
	{
		
		MyThread t=new MyThread();
		t.start();
	 }
}
		class MyThread extends Thread
		{
			public void run() 
			{
				Scanner sc=new Scanner(System.in);
	
				System.out.println("Enter the Number");
				int num=sc.nextInt();
				if(num%2==0)
				{
					System.out.println("Number is Even");
				}
				else
				{
			 System.out.println("Number is Odd");
				}
			}
	
	}

