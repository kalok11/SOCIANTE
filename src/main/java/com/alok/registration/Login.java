package com.alok.registration;

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
 * Servlet implementation class Login
 */

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher=null;
		
		if(username ==  null || username.equals("")) {
			
			request.setAttribute("status", "invalidUserName");
			dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
		}
		
		if(password ==  null || password.equals("")) {
			
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false","root","8002098005aA@");
			
			PreparedStatement pst=con.prepareStatement("select * from sonicate where username = ?  and password = ?");
			
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs= pst.executeQuery();
			
			if(rs.next()) {
				
				session.setAttribute("name", rs.getString("username"));
				dispatcher=request.getRequestDispatcher("index.jsp");
			}
		
			else {
				
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("signin.jsp");
			}
			
			dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}

}
