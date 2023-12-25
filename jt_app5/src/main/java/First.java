import java.io.*;
import jakarta.servlet.*;
import java.util.*;
public class First extends GenericServlet {
	ServletContext sc;
	ArrayList<String> aa;
	
	public void init() {
		sc = getServletContext();
		aa = new ArrayList();
	}
	
	@Override
	public void service(ServletRequest req , ServletResponse res) throws  ServletException , IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		aa.add("sai");
		aa.add("rashmi");
		aa.add("subham");
		aa.add("bastia");
		aa.add("avinash");
		sc.setAttribute("first", aa);
		out.println("<html><body bgcolor='cyan'><font color='red' size='5'><center>");
		out.println("<br><br><b>I am in First Page</b>");
		out.println("<a href='http://localhost:8085/jt_app5/text1'>Go to the Next Page</a>");
		out.println("</center></font></body></html>");
		
	}
	
}
