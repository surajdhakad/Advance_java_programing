package test;




import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")

@WebServlet("/choice")

public class Mainservlet extends GenericServlet {
	
	
	@Override
	public void  service(ServletRequest req,ServletResponse res)
			throws ServletException,IOException {
		
		
		String sb=req.getParameter("sb");
		if(sb.equals("prime")) {
			RequestDispatcher rd=req.getRequestDispatcher("pri");
			
			rd.forward(req, res);
			
			
		}
		else if(sb.equals("palamdrom"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("palam");
			
			rd.forward(req, res);
			
		}
		else if(sb.equals("armstrong"))
		{
             RequestDispatcher rd=req.getRequestDispatcher("arm");
			
			rd.forward(req, res);
			
		}
		
		else if(sb.equals("strong"))
		{
             RequestDispatcher rd=req.getRequestDispatcher("strg");
			
			rd.forward(req, res);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
