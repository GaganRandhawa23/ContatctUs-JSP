package com.contactus.servlet;

import java.io.IOException;
import com.contactus.*;
import com.contactus.pojo.User;
import com.contactus.Dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		User user = new User();
		
		user.setName ((request.getParameter("name")).toString());
		user.setEmail ((request.getParameter("email")).toString());
		user.setMessage ((request.getParameter("message")).toString());
		
		try {
			UserDao.addUserInDatabase(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("index.html");
		
	}

}
