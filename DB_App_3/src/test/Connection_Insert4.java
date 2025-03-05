package test;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;

public class Connection_Insert4 {

	public static void main(String[] args) {
		
Scanner sc=new Scanner(System.in);
		
		
		try(sc;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
			
			Statement stm = con.createStatement();
			System.out.println("Enter the NonSelect-query(Create/Insert/Update/Delete)");
			String qry = sc.nextLine();
			int k = stm.executeUpdate(qry);
			if(k>=0) {
			System.out.println("Query executed Successfully...");
			System.out.println("The value in k : "+k);
			}
			con.close();
			}
			catch(SQLException sqe) {
			System.out.println(sqe.getMessage());
		
		
	}
		
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
