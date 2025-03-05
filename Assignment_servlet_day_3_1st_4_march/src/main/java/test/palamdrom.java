package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@SuppressWarnings("serial")
@WebServlet("/palam")
public class palamdrom extends GenericServlet {
	
	@Override
	
	public void service(ServletRequest req,ServletResponse res) 
			throws ServletException,IOException{
		
		
		int v1=Integer.parseInt(req.getParameter("v1"));
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		 boolean isPalindrome = isPalindrome(v1);
		 
		 if (isPalindrome(v1)) {
             pw.println(v1 + " is a alindrome number.<br>");
         } else {
             pw.println(v1 + " is not a alindrome number.<br>");
         }
		 
		 RequestDispatcher rd=req.getRequestDispatcher("input.html");
		 rd.include(req, res);
		
	}
	
	private boolean isPalindrome(int n) {
	    if (n < 0) {
	        return false;
	    }

	    int originalNumber = n;
	    int reversedNumber = 0;

	    while (n > 0) {
	        int remainder = n % 10;
	        reversedNumber = reversedNumber * 10 + remainder;
	        n /= 10;
	    }

	    if(originalNumber == reversedNumber){
	        return true;
	    } else {
	        return false;
	    }
	}
}
