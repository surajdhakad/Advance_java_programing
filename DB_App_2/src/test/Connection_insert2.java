package test;
import java.sql.*;
import java.util.*;
public class Connection_insert2 {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		try(sc){
			System.out.println("enter the product-code");
			int pCode=Integer.parseInt(sc.nextLine());
			
			System.out.println("enter the product-name");
			String pName=sc.nextLine();
			
			System.out.println("enter the price");
			Float pPrice=Float.parseFloat(sc.nextLine());
			
			System.out.println("enter the qty");
			int pqty=Integer.parseInt(sc.nextLine());
			
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
			
			Statement stm=con.createStatement();
			
			

			int k=stm.executeUpdate("insert into product values("+pCode+",'"+pName+"',"+pPrice+","+pqty+")");
			if(k>0) {
				System.out.println("product  details insert succefully...");
				
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
