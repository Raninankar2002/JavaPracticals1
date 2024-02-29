package jdbc_library_mang_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) throws Exception {
		User user=new User();
		Book book=new Book();
		UserCRUD usercrud=new UserCRUD();
		BookCRUD bookcrud=new BookCRUD();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Welcome to LMS!");
		System.out.println("Enter your Choice \n1.SignUp \n2.Login \n3.Exit");
		int choice=	scanner.nextInt();
		switch(choice)
		{
		case 1:{
			signIn(scanner,user,usercrud);
		}
		case 2:{
			login(scanner,user,usercrud, book, bookcrud);
		}
		case 3:{
			break;
		}
		}
		
		
	}



	private static void signIn(Scanner scanner, User user, UserCRUD usercrud) throws Exception {
		System.out.println("<--------------------------------------signUp page-------------------------------------->");
		System.out.println("Enter your ID");
		int id=scanner.nextInt();
		System.out.println("Enter your name");
		String name=scanner.next();
		System.out.println("Enter your phone number");
		long phone=scanner.nextLong();	
		System.out.println("Enter your Email");
		String email=scanner.next();
		System.out.println("Enter you Password ");
		String password=scanner.next();
		
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		
		int result=usercrud.signUp(user);
		if(result!=0)
		{
			System.out.println("signin succesfully!");
			System.out.println("do you want to login y or n");
			char ch=scanner.next().charAt(0);
			switch(ch)
			{
			case 'y':
			{
				login(scanner,user,usercrud);
				return;
			}
			case 'n':
			{	signIn(scanner, user, usercrud);
				return;
			}
			}
		}
		else
		{
			System.out.println("not successfull!");
		}
		
		
	}
	
	
	
	
	private static void login(Scanner scanner, User user, UserCRUD usercrud,Book book,BookCRUD bookcrud) throws Exception {
		System.out.println("-----------------------------------------LOGIN PAGE-----------------------------------------");
		boolean flag=true;
		while(flag)
		{
		System.out.println("Enter your Registerd Email");
		String email=scanner.next();
		System.out.println("Enter your password");
		String password=scanner.next();
		user.setPassword(password);
		user.setEmail(email);
		ResultSet result=usercrud.fetchByEmail(user);
				
		if(result.next())
		{
			if(result.getString("password").equals(password))
			{
				System.out.println("Login Successfull!");
				//boolean flag1=true;
				
				System.out.println("Enter your choice \n1.Get all books \n2.Add Book \n3.Delete Book \n4.Update Book "
						+ "\n5.Get Book by Id \\n6.Get Book by name\\n7.Get Book by author\\n8.Get Book by price\\n9.Get Book by genre");
				actions(scanner, book, bookcrud,usercrud,user);
				
				System.out.println("Enter your choice \n1.Display Password \n2.Update Password \n3. Logout");
				int choice=scanner.nextInt();
				switch (choice)
				{
				case 1:{
					displayPassword(scanner,user,usercrud);
					return;
				}
				case 2:{
					updatePassword(scanner,user,usercrud);
					return;
				}
				case 3:{
					System.out.println("logout");
					login(scanner, user, usercrud, book, bookcrud);
				}
					
					
				}
			}

			
			else
			{
				System.out.println("invalid details");
				//forgatePassword(scanner,user,usercrud);
				System.out.println("Enter your choice /n1.Forgot Password /n2.retry /n3.exit");
				int choice=scanner.nextInt();
				switch(choice)
				{
				case 1:{
					forgatePassword(scanner, user, usercrud);
					return;
				}
				
				case 2:
				{
				//	flag=true;
					break;
				}
				case 3:
				{
					return;
				}
				}
			}
		}
		
		else
		{
			System.out.println("user not registered please signin");
			signIn(scanner, user, usercrud);
		}
		}
	}
	



	private static void updatePassword(Scanner scanner, User user, UserCRUD usercrud) throws Exception {
		System.out.println("_____________update Password page____________________________");
		System.out.println("Enter your Registered email");
		String email=scanner.next();
		System.out.println("enter new password");
		String newpass=scanner.next();

		user.setPassword(newpass);
		int result=usercrud.updatePassword(user);
		if(result!=0)
		{			
			System.out.println("password updated sucessfully");
		}
		else {
			System.out.println("password not updated sucessfully");
		}
			
		
		
		
	}



	private static void displayPassword(Scanner scanner, User user, UserCRUD usercrud) throws Exception {
		System.out.println("______________Display Password Page_________________________");
		System.out.println("Enter your Registered email");
		String email=scanner.next();
		ResultSet result=usercrud.dispalyPassword(user);
		while(result.next())
		{	if(email.equals(user.getEmail()))
			{
				System.out.println(result.getString("password"));
			}
		}
	}



	private static void forgatePassword(Scanner scanner, User user, UserCRUD usercrud) throws Exception {
		System.out.println("____________________________Forgot Password Page_________________________");
		System.out.println("Enter your Registered Email id");
		String email=scanner.next();
		System.out.println("Enter your phone number");
		long phone=scanner.nextLong();
		ResultSet result=usercrud.fetchByEmail(user);
		if(result.next())
		{
			if(result.getLong("phone")==phone)
			{
				System.out.println("Enter your new password");
				String newpassword=scanner.next();

				int result1=usercrud.updatePassword(user);
				
				if(result1!=0)
				{
					//user.setPassword(newpass);
					System.out.println("password updated successfully");
				}
				else
				{
					System.out.println("password not updated!");
				}
				
			}
			else {
				System.out.println("phone number is not registerd");
			}
		}
		else
		{
			System.out.println("user not registered");
		
		}
	}
	
	/* -----------------------------------book -------------------------------------------------- */
	
	public static void actions(Scanner scanner,Book book,BookCRUD bookcrud,UserCRUD usercrud,User user) throws Exception
	{
		
		int choice1=scanner.nextInt();

		switch(choice1)
		{
		case 1:{
			ResultSet set=bookcrud.getAllBooks(book);
			//while()
		}
		case 2:
		{
			addAllBook(scanner, book, bookcrud);
			
		}
		case 3:{
			bookcrud.deleteBook(book);
		}
		case 4:
		{
			bookcrud.getBookById(book);
		}
		case 5:{
			bookcrud.getBookByName(book);
		}
			
		case 6:{
			bookcrud.getBookByAuthor(book);
		}
		case 7:
		{
			bookcrud.getBookByprice(book);
		}
		case 8:{
			bookcrud.getBookByGenre(book);
		}
		case 9:{
			usercrud.updateUserDetails(user);
		}
		}
	}
	
	public static void addAllBook(Scanner scanner,Book book,BookCRUD bookCRUD) throws Exception
	{
		System.out.println("Enter the Book Id");
		int id=scanner.nextInt();
		System.out.println("Enter the Book Name");
		String name=scanner.next();
		System.out.println("Enter the Author Name");
		scanner.nextLine();

		String author=scanner.next();
		//scanner.nextLine();

		System.out.println("Enter the Book Price");
		scanner.nextLine();

		double price=scanner.nextDouble();
		System.out.println("Enter the Genre");
		String genre=scanner.next();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		book.setGenre(genre);
		int result=bookCRUD.addBook(book);
		if(result!=0)
		{
			System.out.println("book added successfully!");
		}
		else
		{
			System.out.println("book not added");
		}
	}

}
