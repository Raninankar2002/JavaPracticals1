package practical_29Dec2022;

import java.util.Scanner;

public class Voting_Eligibility {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the age Of user");
		int age=sc.nextInt();
		 if(age>=18)
		 {
			 System.out.println("You are Eligible to vote");
		 }
		 else
		 {
			 throw new ArithmeticException("Age is Not correct");
		 }

	}

}

	


