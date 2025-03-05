package test;
import java.io.*;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/dis")
public class UserDisplay implements Servlet{

	@Override
	public void init(ServletConfig scf) {
		
		// no code
	}
	
	
	@Override
	public void service(ServletRequest req,ServletResponse res)
			throws ServletException,IOException
	{
		
		String UId=req.getParameter("uid");
		String UName = req.getParameter("uName");
		String UCity = req.getParameter("ucity");
		String UmId = req.getParameter("umid");
		long UphNo = Long.parseLong(req.getParameter("uphno"));
		
		 PrintWriter pw=res.getWriter();
		 res.setContentType("text/html");
		 
		 pw.println("UId :"+UId+"<br>");
		 pw.println("UName :"+UName+"<br>");
		 pw.println("Ucity :"+UCity+"<br>");
		 pw.println("Umid :"+UmId+"<br>");
		 pw.println("UphNo :"+UphNo+"<br>");
	
	}
	
	@Override
	public void destroy()
	{
		// no code
	}
	
	@Override
	public String getServletInfo()
	{
		return "This Servlte will display user details";
	}
	
	@Override
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}

	
	

}
