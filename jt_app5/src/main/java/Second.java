import java.io.*;
import jakarta.servlet.*;
import java.util.*;
public class Second extends GenericServlet {
	ServletContext sc;
	ArrayList<String> al;
	
	public void init() {
		sc = getServletContext();
		al = (ArrayList<String>)sc.getAttribute("first");
	}
	
	@Override
	public void service(ServletRequest req , ServletResponse res) throws  ServletException , IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		al.add("amit");
		al.add("anurag");
		al.add("smuti");
		al.add("priya");
		al.add("nishikant");
		sc.setAttribute("Second", al);
		out.println("<html><body bgcolor='cyan'><font color='red' size='5'><center>");
		out.println("<br><br><b>I am in Second Page</b>");
		out.println("<a href='http://localhost:8085/jt_app5/text2'>Go to the Next Page</a>");
		out.println("</center></font></body></html>");
		
	}
	
}

