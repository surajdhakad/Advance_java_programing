package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection_2 {

	public static void main(String[] args) {

		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
			//step-3 : Preparing JDBC-statement
			Statement stm = con.createStatement();
			//step-4 : Executing query
			ResultSet rs = stm.executeQuery("select * from product");
			System.out.println("------productDetails-----");
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+"\t"
			+rs.getString(2)+"\t"
			+rs.getFloat(3)+"\t"
			+rs.getInt(4));
			}//end of while
			//step-5 : Close the Connection from Database product
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}

	}

}
