package test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class MetaData {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try (s) {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");

            System.out.println("==========Database meta data==============");
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println("Database product version: " + dmd.getDatabaseMajorVersion());
            System.out.println("Database product name: " + dmd.getDatabaseProductName());

           
            String query = "SELECT * FROM BookDetails71";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

           
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Column count: " + rsmd.getColumnCount());

//           
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                System.out.println("Column " + i + ": " + rsmd.getColumnName(i));
//            }

          
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}