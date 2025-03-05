package DbConnection_Calling_function;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Db_calling_function {
	
	public static void main(String[] args) {
		
		try {
			Connection con=Db_calling_function.connec();
			Db_calling_function.callfunction(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static Connection connec() throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		return con;
	}
	
	public static void callfunction(Connection con) {
		try {
			CallableStatement cs=con.prepareCall("{?=call getTotalEmployees()}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			System.out.println(cs.getInt(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

   
}


