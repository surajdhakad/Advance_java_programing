package test;
import java.sql.*;
public class DB_connection_1 {

	public static void main(String[] args) {
		
		
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
			//step-3 : Preparing JDBC-statement
			Statement stm = con.createStatement();
			//step-4 : Executing query
			ResultSet rs = stm.executeQuery("select * from BookDetails71");
			System.out.println("------BookDetails-----");
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+"\t"
			+rs.getString(2)+"\t"
			+rs.getString(3)+"\t"
			+rs.getFloat(4)+"\t"
			+rs.getInt(5));
			}//end of while
			//step-5 : Close the Connection from Database product
			con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
	}

}
