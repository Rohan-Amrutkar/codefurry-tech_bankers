package com.test.registration;

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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		//server side verfication for username & password(text fields should be empty)
		if(username == null || username.equals("")) {
			request.setAttribute("status", "invalidUsername");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		if(password == null || password.equals("")) {
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			DBConnection dbConn = new DBConnection();
			conn = dbConn.getConn();
			PreparedStatement pst = conn.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getString("username").equals("admin"))
				{
					session.setAttribute("name", rs.getString("username"));
					dispatcher = request.getRequestDispatcher("admin.html");
				}
				else
				{
					session.setAttribute("name", rs.getString("username"));
					dispatcher = request.getRequestDispatcher("user.html");
				}
				
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
