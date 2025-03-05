package test;

import java.sql.*;
import java.util.Scanner;

public class Db_conn_10 {

    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        try (s;) 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@Localhost:1521:xe", "system", "tiger");

            CallableStatement cs = con.prepareCall(
                    "{call RetriveEmp71(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            System.out.println("Enter the emp-id to retrieve details:");
            String eid = s.nextLine();
            cs.setString(1, eid);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.registerOutParameter(6, Types.INTEGER);
            cs.registerOutParameter(7, Types.INTEGER);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.BIGINT);
            cs.registerOutParameter(10, Types.VARCHAR);
            cs.registerOutParameter(11, Types.VARCHAR);
            cs.registerOutParameter(12, Types.VARCHAR);
            cs.registerOutParameter(13, Types.VARCHAR);
            cs.registerOutParameter(14, Types.INTEGER);

            cs.execute(); 

            System.out.println("============emp71 details =============");
           
            System.out.println("emp-name: " + cs.getString(2));
            System.out.println("emp-degs: " + cs.getString(3));
            System.out.println("emp-sal: " + cs.getInt(4));
            System.out.println("emp-hra: " + cs.getInt(5));
            System.out.println("emp-da: " + cs.getInt(6));
            System.out.println("emp-totsal: " + cs.getString(7));
            System.out.println("emp-mid: " + cs.getString(8));
            System.out.println("emp-phno: " + cs.getLong(9));
            System.out.println("emp-hno: " + cs.getString(10));
            System.out.println("emp-sname: " + cs.getString(11));
            System.out.println("emp-cty: " + cs.getString(12));
            System.out.println("emp-state: " + cs.getString(13));
            System.out.println("emp-pcode: " + cs.getInt(14));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}