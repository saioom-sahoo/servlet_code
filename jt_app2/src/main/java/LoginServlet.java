import jakarta.servlet.*;
import java.io.*;
import java.sql.*;

public class LoginServlet implements Servlet {
    Connection cn = null;
    PreparedStatement ps = null;

    public LoginServlet() {
        System.out.println("Object is Contructed");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
            ps = cn.prepareStatement("select * from loginjt where name=(?) and password=(?)");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        res.setContentType("text / html");
        PrintWriter out = res.getWriter();
        String s1 = req.getParameter("name");
        String s2 = req.getParameter("password");
        try {
            ps.setString(1, s1);
            ps.setString(2, s2);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                out.println("<html><body bgcolor='green'><font color='red' size='5+' ><center><br><br><b>You are an Authorized User</b></center></font></body></html>");
		
            } else {
                out.println(
                        "<html><body bgcolor='yellow'><font color='red' size='5+' ><center><br><br><b>You are an not Authorized User</b></center></font></body></html>");
		
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            ps.close();
            cn.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "java Technocrat";
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.getServletConfig();
    }
}
