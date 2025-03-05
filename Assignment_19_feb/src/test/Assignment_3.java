package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Assignment_3 {

	public static void main(String[] args) {
		
		
		Scanner s=new Scanner(System.in);
		
		try(s;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			
			PreparedStatement ps=con.prepareStatement
					("insert into playerDetails71 values(?,?,?,?)");
			
			
			System.out.println("enter the player id");
			String id=s.nextLine();
			
			System.out.println("enter the player name");
			String name=s.nextLine();
			
			
			System.out.println("enter the player-image");
			
			String path=s.nextLine();
			File f=new File(path);
			
			System.out.println("enter the player Date of birth");
			
			String date=s.nextLine();
			Date d= Date.valueOf(date);
//			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date utilDate = sdf.parse(date); // Parse into java.util.Date
//
//            
//            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Create java.sql.Date

            
            
            if(f.exists()) {
				FileInputStream fis=new FileInputStream(path);
				
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setBinaryStream(3, fis,f.length());
				ps.setDate(4, d);
				
				
				
				int k=ps.executeUpdate();
				
				if(k>0) {
					System.out.println("details added successfuly");
					
				}
				else
				{
					System.out.println("invalid details");
				}
				con.close();
					
				
            }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
