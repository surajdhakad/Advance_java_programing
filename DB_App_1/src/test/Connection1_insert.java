package test;
import java.sql.*;
import java.util.*;
public class Connection1_insert {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			System.out.println("enter the book-code :");
			int bCode=Integer.parseInt(s.nextLine());
			System.out.println("enter the book-name :");
			String bName=s.nextLine();
			System.out.println("enter the author Name :");
			String bAuthor=s.nextLine();
			System.out.println("enter the book price :");
			float bprice=Float.parseFloat(s.nextLine());
			System.out.println("enter the book-qty :");
			int bqty=Integer.parseInt(s.nextLine());
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
			Statement stm=con.createStatement();
			
			int k=stm.executeUpdate("insert into BookDetails71 values("+bCode+",'"+bName+"','"+bAuthor+"',"+bprice+","+bqty+")");
			if(k>0) {
				System.out.println("book details insert succefully...");
				
			}
			con.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
