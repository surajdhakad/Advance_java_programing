package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Db_image_store_to_data_base {
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		try(s;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			
			PreparedStatement ps=con.prepareStatement
					("insert into StreamTab71 values(?,?,?)");
			
			
			System.out.println("enter the user id to store image");
			String id=s.nextLine();
			
			System.out.println("enter the userr name:");
			String name=s.nextLine();
			System.out.println("enter the path (source) User-image:");
			
			String path=s.nextLine();
			
			File f=new File(path);
			
			
			if(f.exists()) {
				FileInputStream fis=new FileInputStream(path);
				
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setBinaryStream(3, fis,f.length());
				
				int k=ps.executeUpdate();
				
				if(k>0) {
					System.out.println("image Stored Successfuly");
				}
				else
				{
					System.out.println("invlid fpath of the  name");
				}
				con.close();
		
			}
			
			
			
		}
			catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

		
	}
	
	


