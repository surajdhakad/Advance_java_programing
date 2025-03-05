package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class DBCon12 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try (s;) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
            
            
            PreparedStatement ps1 = con.prepareStatement(
                    "select * from Bank71 where accno=?");
            
            
            PreparedStatement ps2 = con.prepareStatement(
                    "update Bank71 set balance=balance+? where accNo=?");
            
            
            
            System.out.println("Commit Status : " + con.getAutoCommit());
            con.setAutoCommit(false);
            System.out.println("Commit Status : " + con.getAutoCommit());
            
            
            
            Savepoint sp = con.setSavepoint();
            
            
            System.out.println("Enter the my account number :");
            long hAccNo = s.nextLong();
            ps1.setLong(1, hAccNo);
            ResultSet rs1 = ps1.executeQuery();
            
            
            if (rs1.next()) {
                float bal = rs1.getFloat(3);
                System.out.println("Enter TO account number :");
                
                
                long bAccNo = s.nextLong();
                ps1.setLong(1, bAccNo);
                ResultSet rs2 = ps1.executeQuery();
                if (rs2.next()) {
                    System.out.println("Enter the amount to be transferred:");
                    float amt = s.nextFloat();
                    if (amt <= bal) {
                       
                    	
                    	
                    	//Subtract amount
                    	
                        ps2.setFloat(1, -amt);
                        ps2.setLong(2, hAccNo);
                        int p = ps2.executeUpdate();
                      
                        
                        //add amount 
                        ps2.setFloat(1, +amt);
                        ps2.setLong(2, bAccNo);
                        int q = ps2.executeUpdate();
                        if (p == 1 && q == 1) 
                        {
                            con.commit();
                            System.out.println("Transaction Successfully...");
                        } 
                        else
                        {
                            con.rollback(sp);
                            System.out.println("Transaction Failed...");
                        }
                    }
                    else 
                    {
                        System.out.println("InSufficient fund...");
                    }
                }
                else
                {
                    System.out.println("Invalid bAccNo...");
                }
            } 
            else 
            {
                System.out.println("Invalid HomeAccNo...");
            }
        }
        catch (ClassNotFoundException e)
        {
            System.err.println("Driver not found: " + e.getMessage());
        } 
        catch (SQLException e) 
        {
            System.err.println("Database error: " + e.getMessage());
        } 
        catch (Exception e) 
        {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}