package com.jt;

import java.io.*;
import jakarta.servlet.*;
import java.sql.*;
public class LoginServlet extends GenericServlet{

	ServletConfig sc = null;
	
	@Override
	public void init() {
		sc = getServletConfig();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String userName = sc.getInitParameter("username");
		String password = sc.getInitParameter("password");
		
		Connection cn = null;
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(url,userName,password);
			out.println("<html><body bgcolor='cyan'><center><font size = '5+'><b>");
			out.println("Connected");
			out.println("</b></font></center></body></html");
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
}
