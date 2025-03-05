
		
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
		@WebServlet("/strg")
		public class StrongNumber extends GenericServlet {
			
			@Override
			
			public void service(ServletRequest req,ServletResponse res) 
					throws ServletException,IOException{
				
				
				int v1=Integer.parseInt(req.getParameter("v1"));
				
				PrintWriter pw=res.getWriter();
				res.setContentType("text/html");
				
				 boolean isStrongNumber= isStrongNumber(v1);
				 
				 if (isStrongNumber(v1)) {
		             pw.println(v1 + " is a isStrongNumber.<br>");
		         } else {
		             pw.println(v1 + " is not a isStrongNumber number.<br>");
		         }
				 
				 RequestDispatcher rd=req.getRequestDispatcher("input.html");
				 rd.include(req, res);
				
			}
			
			private boolean isStrongNumber(int n) { // Corrected method name
		        int originalNumber = n;
		        int sum = 0;

		        while (n > 0) {
		            int digit = n % 10;
		            sum += factorial(digit);
		            n /= 10;
		        }

		       if( sum == originalNumber)
		       {
		    	   return true;
		       }
		       else
		    		   {
		    	   return false;
		    		   }
		    }

		    private int factorial(int n) {
		        if (n == 0) {
		            return 1;
		        }
		        int fact = 1;
		        for (int i = 1; i <= n; i++) {
		            fact *= i;
		        }
		        return fact;
		    }
		}