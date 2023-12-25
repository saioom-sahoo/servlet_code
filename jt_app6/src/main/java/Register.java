import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import org.apache.tomcat.jakartaee.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.tomcat.jakartaee.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;

import jakarta.servlet.*;
public class Register extends GenericServlet {
	
	ServletContext sc = null;
	Connection cn = null;
	PreparedStatement ps = null;
	String driver , username , password , url;
	
	@Override
	public void init() {
		sc = getServletContext();
		driver = sc.getInitParameter("driver");
		username = sc.getInitParameter("username");
		password = sc.getInitParameter("password");
		url = sc.getInitParameter("url");
		
		try {
			Class cc = Class.forName(driver);
			cc.newInstance();
			System.out.println("Hello");
			cn = DriverManager.getConnection( url, username , password);
			System.out.println(cn);
			ps = cn.prepareStatement("insert into jr_register values(?,?,?,?,?)");
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String name = req.getParameter("username");
			String password = req.getParameter("password");
			String confirm_password = req.getParameter("confirmpassword");
			String address = req.getParameter("address");
			String mobile_no = req.getParameter("mobile");
			System.out.println(name+password+confirm_password+address+mobile_no);
			try {
				ps.setString(1 , name);
				ps.setString(2, password);
				ps.setString(3, confirm_password);
				ps.setString(4, address);
				ps.setString(5, mobile_no);
				ps.executeUpdate();
				out.println("<html><body bgcolor='cyan'><font color='red' size=5><center>");
				out.println("<b>Data is Inserted</b>");
				out.println("<a href = 'http://localhost:8085/jt_app6/index.html'> Login Page </a>");
				out.println("</center></font></body></html>");
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		
	}
	
	@Override
	public void destroy() {
		try {
			ps.close();
			cn.close();
		} catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
	
}