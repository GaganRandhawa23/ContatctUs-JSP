package com.contactus.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import com.contactus.*;
import com.contactus.model.Request;
import com.contactus.dao.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			RequestDispatcher rd = request.getRequestDispatcher("contactus.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		Request req = new Request();
		
		req.setName ((request.getParameter("name")).toString());
		req.setEmail ((request.getParameter("email")).toString());
		req.setMessage ((request.getParameter("message")).toString());
		RequestDao.saveRequest(req);
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("contactus.jsp");
			rd.forward(request, response);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
}
