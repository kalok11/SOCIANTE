package com.alok.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname=request.getParameter("fname");
		String midname=request.getParameter("midname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String pnumber=request.getParameter("pnumber");
		String gender=request.getParameter("gender");
		String civilStatus=request.getParameter("civilStatus");
		String age=request.getParameter("age");
		String dob=request.getParameter("dob");
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		
		
		
		
		RequestDispatcher dispatcher=null;
	
		if(fname ==  null || fname.equals("")) {
			
			request.setAttribute("status", "invalidfname");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		
	if(midname ==  null || midname.equals("")) {
			
			request.setAttribute("status", "invalidmidname");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
	
	if(lname ==  null || lname.equals("")) {
		
		request.setAttribute("status", "invalidlname");
		dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}
	
if(address ==  null || address.equals("")) {
		
		request.setAttribute("status", "invalidaddress");
		dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}
	
if(email ==  null || email.equals("")) {
	
	request.setAttribute("status", "invalidemail");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}

if(pnumber ==  null || pnumber.equals("")) {
	
	request.setAttribute("status", "invalidpnumber");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}else if(pnumber.length() > 10) {
	
	request.setAttribute("status", "invalidpnumberLength");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
	
}

if(civilStatus ==  null || civilStatus.equals("")) {
	
	request.setAttribute("status", "invalidcivilStatus");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}

if(gender ==  null || gender.equals("")) {
	
	request.setAttribute("status", "invalidgender");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}

if(age ==  null || age.equals("")) {
	
	request.setAttribute("status", "invalidage");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}

if(dob ==  null || dob.equals("")) {
	
	request.setAttribute("status", "invaliddob");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}

if(username ==  null || username.equals("")) {
	
	request.setAttribute("status", "invalidusername");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}

if(pass ==  null || pass.equals("")) {
	
	request.setAttribute("status", "invalidpass");
	dispatcher = request.getRequestDispatcher("register.jsp");
	dispatcher.forward(request, response);
}


		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false","root","8002098005aA@");
			PreparedStatement pst = con.prepareStatement("insert into sonicate(fname,midname,lname,address,email,pnumber,civilStatus,gender,age,dob,username,password) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			pst.setString(1, fname);
			pst.setString(2, midname);
			pst.setString(3, lname);
			pst.setString(4, address);
			pst.setString(5, email);
			pst.setString(6, pnumber);
			pst.setString(7, civilStatus);
			pst.setString(8, gender);
			pst.setString(9, age);
			pst.setString(10, dob);
			pst.setString(11, username);
			pst.setString(12, pass);
			
			
			int rowCount= pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("register.jsp");
			
			if(rowCount > 0) {
				request.setAttribute("status", "success");
			}
			else {
				
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
