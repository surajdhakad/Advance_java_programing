package test;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Scanner;

public class Assignment_1 {
	
	
	public static void main(String[] args) {
		
		
		
		Scanner s=new Scanner(System.in);
		
		try(s;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			
			PreparedStatement ps=con.prepareStatement
					("insert into empresume values(?,?,?)");
			
			
			System.out.println("enter the emp-id stored resume");
			String id=s.nextLine();
			
			
			System.out.println("enter the emp-name");
			String name=s.nextLine();
			
			
			System.out.println("enter the file path");
			String path=s.nextLine();
			
			
			
			File f=new File(path);
			
			if(f.exists()) {
				
				FileInputStream fis=new FileInputStream(path);
				
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setBinaryStream(3, fis,f.length());
				
				int k=ps.executeUpdate();
				if(k>0) {
					System.out.println("file update successfuly");
				}
				else
				{
					System.out.println("invalid file path");
				}
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
