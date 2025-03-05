
		
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
		@WebServlet("/arm")
		public class armstrom extends GenericServlet {
			
			@Override
			
			public void service(ServletRequest req,ServletResponse res) 
					throws ServletException,IOException{
				
				
				int v1=Integer.parseInt(req.getParameter("v1"));
				
				PrintWriter pw=res.getWriter();
				res.setContentType("text/html");
				
				 boolean isArmstrong = isArmstrong(v1);
				 
				 if (isArmstrong(v1)) {
		             pw.println(v1 + " is a isArmstrongnumber.<br>");
		         } else {
		             pw.println(v1 + " is not a isArmstrong number.<br>");
		         }
				 
				 RequestDispatcher rd=req.getRequestDispatcher("input.html");
				 rd.include(req, res);
				
			}
			
			 private boolean isArmstrong(int n) {
			        int originalNumber = n;
			        int sum = 0;
			        int digits = String.valueOf(n).length(); // Get the number of digits

			        while (n > 0) {
			            int remainder = n % 10;
			            sum += Math.pow(remainder, digits);
			            n /= 10;
			        }

			        if(sum == originalNumber) {
			        	return true;
			        }
			        else
			        {
			        	return false;
			        }
			    }
			}