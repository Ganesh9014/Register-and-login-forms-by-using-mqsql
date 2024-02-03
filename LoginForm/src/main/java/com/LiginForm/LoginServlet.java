package com.LiginForm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String Email=request.getParameter("email");
			String password=request.getParameter("password"); 
			String sql="select name from register where EmailId=? and password=?";
			Connection es=null;
			es=DriverManager.getConnection("jdbc:mysql://localhost/emp?"+"user=root & password=Ganesh54@");
			PreparedStatement st=es.prepareStatement(sql);
			st.setString(1, Email);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();
			HttpSession session =request.getSession();
			
			if(rs.next()) {
				session.setAttribute("k", rs.getString(1));
				RequestDispatcher rd=request.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(request,response);
				
				
			}
			
			
			
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
