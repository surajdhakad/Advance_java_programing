package test;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Db_image_retrive_from_database {

	
	
	public static void main(String[] args) {
		
		
		Scanner s=new Scanner(System.in);
		
		
		try(s;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps=con.prepareStatement
					("select * from StreamTab71 where id=?");
			
			System.out.println("enter the user-id to retrive namse and image");
			
			String id=s.nextLine();
			ps.setString(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(3);
				byte by[]=b.getBytes(1, (int)b.length());
				
				System.out.println("user id:"+id);
				
				System.out.println("user namne:"+rs.getString(2));
				System.out.println("enter the FpathName(destination) to Store image");
				String path=s.nextLine();
				
				FileOutputStream fos=new FileOutputStream(path);
				fos.write(by);
				
				
				System.out.println("image retrive and avaible in destination");
				fos.close();
				}
			else
			{
				System.out.println("invalid id......");
			}
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
