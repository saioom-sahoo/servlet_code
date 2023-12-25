import java.io.*;
import jakarta.servlet.*;
import java.util.*;
public class Third extends GenericServlet {
	ServletContext sc;
	ArrayList<String> al;
	
	public void init() {
		sc = getServletContext();
		al = (ArrayList<String>)sc.getAttribute("Second");
	}
	
	@Override
	public void service(ServletRequest req , ServletResponse res) throws  ServletException , IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body bgcolor='cyan'><font color='red' size='5'><center>");
		out.println("<br><br><b>I am in Third Page</b><br><br>");
		out.println("<table border='2'><tr><th><font size='5'>Name of Students </font></th></tr>");
		Iterator<String> ii = al.iterator();
		while(ii.hasNext()) {
			String name = ii.next();
			out.println("<tr><td align='center'><font size='5' color='red'>"+name+"</font></td></tr>");
		}
		
		out.println("</center></font></body></html>");
		
	}
	
}

