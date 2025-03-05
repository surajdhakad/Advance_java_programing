package test;
import java.io.*;
import java.util.Arrays;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class EmployeeDisplay implements Servlet {
	
	@Override
	public void init(ServletConfig scf) {
		
		// no code
	}
	
	
	@Override
	public void service(ServletRequest req,ServletResponse res)
			throws ServletException,IOException
	{
	
		
		
		String EId=req.getParameter("EId");
		String EName=req.getParameter("EName");
		String EAdd=req.getParameter("EAdd");
		String ESal=req.getParameter("ESal");
		String gender = req.getParameter("gender");
		
		 String[] hobbies = req.getParameterValues("hobbies");
		
		
		
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		 pw.println("EId :"+EId+"<br>");
		 pw.println("EName :"+EName+"<br>");
		 pw.println("EAdd :"+EAdd+"<br>");
		 pw.println("ESal :"+ESal+"<br>");
		 pw.println("gender :"+gender+"<br>");
		 pw.println("hobies :"+Arrays.toString(hobbies)+"<br>");
		
		
		
		
		
		
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
