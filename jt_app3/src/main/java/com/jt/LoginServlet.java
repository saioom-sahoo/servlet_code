package com.jt;

import java.io.*;
import jakarta.servlet.*;

public class LoginServlet extends GenericServlet {

	ServletConfig sc = null;
	public void init() {
		
		sc = getServletConfig();
	
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			
		    res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			System.out.println(sc);
			String name = sc.getInitParameter("name");
			out.println("<html><body bgcolor='cyan'><center><font color='red'>");
			out.println("Name is : "+name);
			out.println("</font></center></body></html>");
	}
	
}
