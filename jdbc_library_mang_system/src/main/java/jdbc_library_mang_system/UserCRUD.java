package jdbc_library_mang_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCRUD {
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
	
	
	public int signUp(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user(id,name,phone,email,password)values(?,?,?,?,?)");
		preparedStatement.setInt(1,user.getId());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPassword());
		int result=preparedStatement.executeUpdate();
		connection.close();

		return result;
	}
	
	public ResultSet fetchByEmail(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from user where email=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet result=preparedStatement.executeQuery();
		return result;
		
	}
	public ResultSet dispalyPassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select password from user where email=? ");
		preparedStatement.setString(1, user.getEmail());
		ResultSet result=preparedStatement.executeQuery();
		return result;
	}
	
	public int updatePassword(User user) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update user set password=? where email=?");
		preparedStatement.setString(1, user.getPassword());
		preparedStatement.setString(2, user.getEmail());
		int result=preparedStatement.executeUpdate();
		return result;
	}
	
	public int updateUserDetails(User user) throws Exception
	{
		String sql="update user set name=?,phone=?,email=?,password=? where id=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setLong(2, user.getPhone());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setInt(5, user.getId());
		int result=preparedStatement.executeUpdate();
		return result;
	}
}
