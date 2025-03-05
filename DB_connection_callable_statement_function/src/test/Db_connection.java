package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;


public class Db_connection {
	
	
	public static void main(String[] args) {
		
		
		Scanner s=new Scanner(System.in);
		
		try(s;)
		{
			
			 Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@Localhost:1521:xe", "system", "tiger");
			
	            
	            CallableStatement cs=con.prepareCall
	            		("{ ?=call Retrievephno71(?)}");
	            
	            System.out.println("Enter the emp-id to Retrive Phone:");
	            
	            String eid=s.nextLine();
	            
	            cs.setString(2,eid);
	            cs.registerOutParameter(1, Types.BIGINT);
	            
	            cs.execute();
	            
	            System.out.println("cust-id"+eid);
	            System.out.println("cust-phono :"+cs.getLong(1));
	            
	            con.close();
	            
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
