package test;




import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings("serial")

@WebServlet("/choice")

public class ChoiceServlet extends GenericServlet {
	
	
	@Override
	public void  service(ServletRequest req,ServletResponse res)
			throws ServletException,IOException {
		
		
		String sb=req.getParameter("sb");
		if(sb.equals("Add")) {
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			
			rd.forward(req, res);
			
			
		}
		else if(sb.equals("Avg"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("av");
			
			rd.forward(req, res);
			
		}
		else if(sb.equals("Sub"))
		{
             RequestDispatcher rd=req.getRequestDispatcher("sub");
			
			rd.forward(req, res);
			
		}
		
		else if(sb.equals("Div"))
		{
             RequestDispatcher rd=req.getRequestDispatcher("div");
			
			rd.forward(req, res);
			
		}
		else if(sb.equals("Mul"))
		{
             RequestDispatcher rd=req.getRequestDispatcher("mul");
			
			rd.forward(req, res);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
