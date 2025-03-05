package test;
import java.sql.*;
import java.util.*;
public class jdbcCon_09 {

	public static void main(String[] args) {
		
   Scanner s=new Scanner(System.in);
   
   try(s;){
	   
	   
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection con=DriverManager.getConnection
			   ("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
	   CallableStatement cs=con.prepareCall("{call InsertEmployee71(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	   
	   System.out.println("Enter the Emp-id:");
	   String Eid=s.nextLine();
	   
	   System.out.println("Enter the Emp-Name:");
	   String Ename=s.nextLine();
	   
	   System.out.println("Enter the Emp-desg:");
	   String Edesg=s.nextLine();
	   
	   System.out.println("Enter the Emp-Hno");
	   String hno=s.nextLine();
	   
	   System.out.println("Enter the  Emp-Sname");
	   String Sname=s.nextLine();
	   
	   System.out.println("Enter the Emp-CityName");
	   String city=s.nextLine();
	   
	   System.out.println("Enter the Emp-StateName");
	   String state=s.nextLine();
	   
	   
	   System.out.println("Enter the Emp-Pincode");
	   int pincode=Integer.parseInt(s.nextLine());
	   
	   System.out.println("Enter the Emp-MailId");
	   String MailId=s.nextLine();
	   
	   System.out.println("Enter the Emp-phno");
	   Long phno=Long.parseLong(s.nextLine());
	   
	   System.out.println("Enter the Emp-Bsal");
	   int Bsal=Integer.parseInt(s.nextLine());
	   
	   
	   Double hra=(Bsal * 0.06 ); 
	  
	   
	   
	   
	   
	   Double Da=(Bsal * 0.05 ); 
	 
	   
	   
	   
	  
	   Double totSal=Math.round((Da + hra + Bsal) * 100.0) / 100.0; 
	  
	   
	   
	   cs.setString(1, Eid);
	   cs.setString(2,Ename);
	   cs.setString(3, Edesg);
	   cs.setString(4, hno);
	   cs.setString(5, Sname);
	   cs.setString(6, city);
	   cs.setString(7, state);
	   cs.setInt(8, pincode);
	   cs.setString(9, MailId);
	   cs.setLong(10, phno);
	   cs.setInt(11, Bsal);
	   cs.setDouble(12, hra);
	  cs.setDouble(13, Da);
	  cs.setDouble(14, totSal);
	  
	  System.out.println("--------------successfulyAdded Details-------------");
	   cs.execute();
   }
   catch(Exception e){
	   e.printStackTrace();
   }
		
		
	}

}
