package com.contactus.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.contactus.dao.LoginDao;
import com.contactus.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        try {
            if (LoginDao.validAdmin(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("userName", user.getName());

                response.sendRedirect("dashboard");
                System.out.println("Authenticated user: " + user.getName());
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");                
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
