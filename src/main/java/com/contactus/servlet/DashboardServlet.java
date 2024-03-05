package com.contactus.servlet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.contactus.dao.RequestDao;
import com.contactus.model.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("requestId"));
		Boolean status = Boolean.parseBoolean(request.getParameter("status"));
		RequestDao.toggleUserStatus(id, status);
		response.sendRedirect("dashboard");	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		List<Request> activeRequests = new ArrayList<>();
		List<Request> archiveRequests = new ArrayList<>();

		activeRequests = RequestDao.fetchRequests(true);
		archiveRequests = RequestDao.fetchRequests(false);
		
        request.setAttribute("activeRequests", activeRequests);
        request.setAttribute("archiveRequests", archiveRequests);
        try {
	        RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
	        rd.forward(request, response);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
