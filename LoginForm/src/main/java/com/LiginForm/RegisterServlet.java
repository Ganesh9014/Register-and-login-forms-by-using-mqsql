package com.LiginForm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String name=request.getParameter("uname");
			long pno=Long.parseLong(request.getParameter("pno"));
			String Email=request.getParameter("email");
			String password=request.getParameter("password"); 
		
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost/emp?"+"user=root & password=Ganesh54@");
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2,Email);
			ps.setLong(3, pno);
			ps.setString(4, password);
			int k=ps.executeUpdate();
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
			if(k>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request,response);
			}
			
		}catch(Exception e)
		{
			System.err.println(e);
		}
	}

}
