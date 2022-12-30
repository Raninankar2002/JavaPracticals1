package String1;

import java.util.Scanner;hall

public class StringExists {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str1,str2;
		System.out.println("Enter the String");
		str1=sc.nextLine();
		str2=sc.next();
		if(str1.contains(str2)) 
		{
			System.out.println("Yes, first string exist in another");
		}
		else
		{
			System.out.println("No, first string Not exist in another");
		}

	}

}
