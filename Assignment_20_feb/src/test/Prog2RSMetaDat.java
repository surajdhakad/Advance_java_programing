package test;

import java.sql.*;

import java.util.Scanner;

public class Prog2RSMetaDat {
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
						
			try(con;){
				//insertStud(con);			
				PreparedStatement ps = con.prepareStatement("select * from studentInfo");
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData rm = rs.getMetaData();
				System.out.println("column count: "+rm.getColumnCount());
				System.out.println("Other details");
				for(int i=1;i<=rm.getColumnCount();i++) {
					System.out.println(rm.getColumnName(i)+" : "+rm.getColumnTypeName(i));
				}
				
			}
			catch(Exception e) {
				
			}
		} catch (Exception e) {
			
		}

	}
	public static void insertStud(Connection con) throws SQLException {
		Scanner s = new Scanner(System.in);
		PreparedStatement ps = con.prepareStatement("insert into studentInfo values(?,?,?)");
		System.out.println("Enter RollNo:");
		ps.setString(1, s.nextLine());
		System.out.println("Enter Name:");
		ps.setString(2, s.nextLine());
		System.out.println("Enter AdmissionDate:");
		String s1=s.nextLine();
		Date d = Date.valueOf(s1);
		ps.setDate(3, d);
		int k =ps.executeUpdate();
		if(k>0) {
			System.out.println("Inserted...");
		}
		
	}
	}