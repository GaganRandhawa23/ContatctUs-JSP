package com.contactus.servlet;

import java.io.IOException;
import com.contactus.pojo.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactus.Dao.UserDao;
import com.contactus.pojo.User;


@WebServlet("/AuthenticateAdmin")
public class AuthenticateAdmin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin();
		
		admin.setName ((request.getParameter("name")).toString());
		admin.setPassword ((request.getParameter("password")).toString());
		
		
		
	}

}
