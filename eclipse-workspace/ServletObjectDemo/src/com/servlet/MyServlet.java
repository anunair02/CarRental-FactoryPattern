package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.RequestDispatcher;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student =new Student();
		student.setFirstName(request.getParameter("First name"));
		student.setLastName(request.getParameter("Last name"));
		
		HttpSession session=request.getSession();
		session.setAttribute("student", student);
		
		try {
			javax.servlet.RequestDispatcher rd= getServletContext().getRequestDispatcher("/Student2.jsp");
			rd.forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
