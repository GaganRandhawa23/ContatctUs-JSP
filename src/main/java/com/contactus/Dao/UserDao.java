package com.contactus.Dao;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

import com.contactus.pojo.User;

public class UserDao {
	
	public static void addUserInDatabase(User user) throws ClassNotFoundException
	{
		String sql = "INSERT INTO users (name, email, message) values(?,?,?)";
	    Class.forName("org.postgresql.Driver");
	    String url = "jdbc:postgresql://localhost:5432/ContactUs";
	    String username = "postgres";
	    String password = "Randhawa@2024";
	    
	    try  {
	    	
	    	Connection connection = DriverManager.getConnection(url, username, password);
	    	PreparedStatement statement = connection.prepareStatement(sql);
            
	    	statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getMessage());
			System.out.print(user.getName());
			ResultSet rs = statement.executeQuery();
			rs.next();
	    	
	    
	    }catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
