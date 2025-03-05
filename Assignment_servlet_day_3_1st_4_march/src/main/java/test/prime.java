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
@WebServlet("/pri")
public class prime extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    	

        int  v1 = Integer.parseInt(req.getParameter("v1"));


		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");

                boolean isPrime = isPrime(v1);

                if (isPrime) {
                    pw.println(v1 + " is a prime number.<br>");
                } else {
                    pw.println(v1 + " is not a prime number.<br>");
                }
            

        RequestDispatcher rd = req.getRequestDispatcher("input.html");
        rd.include(req, res);
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}