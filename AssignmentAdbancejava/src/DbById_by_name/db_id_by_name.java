package DbById_by_name;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class db_id_by_name {

	public static void main(String[] args) {
	
		
Scanner s=new Scanner(System.in);
		
		try(s;)
		{
			
			 Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@Localhost:1521:xe", "system", "tiger");
			
	            CallableStatement cs=con.prepareCall
	            		("{call ?:=EmpnameById71(?)}");
		System.out.println("enter the emp-id");
		cs.setString(2, s.nextLine());
		cs.registerOutParameter(1, Types.VARCHAR);
		cs.execute();
		
		System.out.println(cs.getString(1));

	}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
