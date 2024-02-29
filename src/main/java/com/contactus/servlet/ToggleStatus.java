package com.contactus.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ToggleStatus")
public class ToggleStatus extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("id"));
	     boolean status = Boolean.parseBoolean(request.getParameter("statusBool"));
	    
	    String url = "jdbc:postgresql://localhost:5432/ContactUs";
	    String username = "postgres";
	    String password = "Randhawa@2024";
	    
	    String sql = "UPDATE users  SET status = ? WHERE id = ?";
	    boolean newStatus = (status) ? false : true;

		
	    
	    try  {
	    	Class.forName("org.postgresql.Driver");
	    	Connection connection = DriverManager.getConnection(url, username, password);
	    	PreparedStatement statement = connection.prepareStatement(sql);
            
	    	statement.setBoolean(1, newStatus);
			statement.setInt(2, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
	    	
	    
	    }catch (Exception e) {
            e.printStackTrace();
        }
		
	    response.sendRedirect("DisplayData.jsp");
		
	}

}
