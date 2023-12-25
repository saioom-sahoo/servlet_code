import java.io.*;
import java.sql.*;
import jakarta.servlet.*;

public class Login extends GenericServlet {
	ServletContext sc = null;
	Connection cn = null;
	PreparedStatement ps = null;
	
	@Override
	public void init() {
		sc = getServletContext();
		String driver = sc.getInitParameter("driver");
		String username = sc.getInitParameter("username");
		String url = sc.getInitParameter("url");
		String password = sc.getInitParameter("password");
		
		try {
			Class c1 = Class.forName(driver);
			c1.newInstance();
			cn = DriverManager.getConnection(url, username, password);
			ps = cn.prepareStatement("select * from jr_register where name = (?) and password = (?)");
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html");
	String name = req.getParameter("name");
	String password = req.getParameter("password");
	PrintWriter out = res.getWriter();
	
	try {
		ps.setString(1, name);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			out.println("<html><body bgcolor='cyan'><font color='red' size='5'><center>");
			out.println("<br><br><b>Welcome To Java Technocart</b>");
			out.println("</center></font></body></html>");
		} else {
			out.println("<html><body bgcolor='cyan'><font color='red' size='5'><center>");
			out.println("<br><br><b>Check the Username and Password</b>");
			out.println("<a href='http://localhost:8085/jt_app6/register.html'>New User</a>");
			out.println("</center></font></body></html>");
			
		}
	} catch(Exception ee) {
		ee.printStackTrace();
	}
	
}	

	public void destroy() {
		try {
			ps.close();
			cn.close();
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
	
}