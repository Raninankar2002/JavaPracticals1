package jdbc_library_mang_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookCRUD {

	public Connection getConnection() throws Exception
	{
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/lmsdb";
		String user="root";
		String password="Rani@123456";
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public int addBook(Book book) throws Exception
	{
		String sql="insert into book (id,name,author,price,genre) values (?,?,?,?,?)";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2,book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setDouble(4, book.getPrice());
		preparedStatement.setString(5, book.getGenre());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	public ResultSet getAllBooks(Book book) throws Exception
	{
		Connection connection=getConnection();
		String sql="select * from book where id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getId());
	    ResultSet result=preparedStatement.executeQuery();
	    return result;
	}
	public int deleteBook(Book book) throws Exception
	{
		String sql="delete from book where id=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getId());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
	public int updateBook(Book book) throws Exception
	{
		String sql="update book set name=?,author=?,price=?,genre=? where id=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setDouble(3,book.getPrice());
		preparedStatement.setString(4, book.getGenre());
		preparedStatement.setInt(5, book.getId());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
	
	public ResultSet getBookById(Book book) throws Exception
	{
		String sql="select * from book where id=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getId());
	    ResultSet result=preparedStatement.executeQuery();
	    return result;
	}
	
	public ResultSet getBookByName(Book book) throws Exception
	{
		String sql="select * from book where name=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, book.getName());
		ResultSet result=preparedStatement.executeQuery();
		return result;
	}
	
	public ResultSet getBookByAuthor(Book book) throws Exception
	{
		String sql="select * from book where author=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, book.getAuthor());
		ResultSet result=preparedStatement.executeQuery();
		return result;
	}
	
	public ResultSet getBookByprice(Book book) throws Exception
	{
		String sql="select * from book where price=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setDouble(1, book.getPrice());
		ResultSet result=preparedStatement.executeQuery();
		return result;
	}
	
	public ResultSet getBookByGenre(Book book) throws Exception
	{
		String sql="select * from book where genre=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, book.getGenre());
		ResultSet result=preparedStatement.executeQuery();
		return result;
	}
}
