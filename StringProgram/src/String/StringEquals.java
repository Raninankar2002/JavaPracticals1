package String;

import java.util.Scanner;

public class StringEquals
{

	public static void main(String[] args) {
		String str1, str2;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter first string");
		str1= sc.next();
		
		System.out.println("enter second string");
		str2= sc.next();
		
		if(str1.equals(str2))
		{
			System.out.println("String are equals");
		}
		else
		{
			System.out.println("String are not equals");
		}
			
	}

}
