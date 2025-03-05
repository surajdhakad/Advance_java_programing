package test;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.*;
public class Assignment_4 {

	public static void main(String[] args) {
	
		
		
		Scanner s=new Scanner (System.in);
		
		try(s;)
		{
		
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps=con.prepareStatement
					("select * from  playerDetails71 where eid=?");
			
			System.out.println("enter the user-id to retrive player details");
			
			String id=s.nextLine();
			ps.setString(1, id);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(3);
				byte by[]=b.getBytes(1, (int)b.length());
				
				System.out.println("user id:"+id);
				
				System.out.println("user name:"+rs.getString(2));
				System.out.println("enter the FpathName(destination) to Store image");
				String path=s.nextLine();
				
				FileOutputStream fos=new FileOutputStream(path);
				fos.write(by);
				
				
				System.out.println("date is :"+rs.getDate(4));
				
				
				System.out.println("image retrive and avaible in destination");
				fos.close();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
