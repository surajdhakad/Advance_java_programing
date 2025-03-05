package test;


import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayUSer extends GenericServlet{
	
	
	@Override
	public void service(ServletRequest req,ServletResponse res) 
			throws ServletException,IOException{
		
		RequestDispatcher rd=req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
	
	

}
}