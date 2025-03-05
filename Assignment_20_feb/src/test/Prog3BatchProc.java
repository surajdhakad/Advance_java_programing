package test;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prog3BatchProc {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) { // Try-with-resources for Scanner
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
                 PreparedStatement ps = con.prepareStatement("insert into emp71 (id, name, desg, Bsal) values(?,?,?,?)")) { // Modified insert

                System.out.println("Enter how many rows you want to insert");
                int n = Integer.parseInt(s.nextLine());

                for (int i = 1; i <= n; i++) {
                    try { // Inner try-catch for NumberFormatException
                        System.out.println("Enter eid:");
                        ps.setString(1, s.nextLine());
                        System.out.println("Enter ename:");
                        ps.setString(2, s.nextLine());
                        System.out.println("Enter edesg:");
                        ps.setString(3, s.nextLine());
                        System.out.println("Enter esal:");
                        int sal = Integer.parseInt(s.nextLine());
                        ps.setInt(4, sal);

                        ps.addBatch();
                    } catch (NumberFormatException ex) {
                        System.err.println("Invalid salary input. Please enter an integer.");
                        i--; // Decrement i to repeat the current entry
                        continue; // Skip to next iteration
                    }
                }

                int[] k = ps.executeBatch();
                if (k.length > 0) {
                    System.out.println("Inserted rows: " + k.length);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(); // Print the SQLException
            }

        } catch (ClassNotFoundException | NumberFormatException ex) { // Catch specific exceptions
            ex.printStackTrace();
        }
    }
}