package test;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Assignment_2 {

	public static void main(String[] args) {
		
		
		Scanner s=new Scanner(System.in);
		try(s;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps=con.prepareStatement
					("select * from empResume where eid=?");
			
			System.out.println("enter the eid to retrive data from data base");
			
			String id=s.nextLine();
			
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				Blob b=rs.getBlob(3);
				
				byte by[]=b.getBytes(1, (int)b.length());
				
				System.out.println("user id:"+id);
				System.out.println("user name :"+rs.getString(2));
				
				
				System.out.println("enter the filePath name ");
				
				String path=s.nextLine();
				FileOutputStream fos=new FileOutputStream(path);
				fos.write(by);
				
				System.out.println("file retrive destini");
				
				fos.close();
			}
			else
			{
				System.out.println("invalid file path name");
				
			}
			con.close();
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
