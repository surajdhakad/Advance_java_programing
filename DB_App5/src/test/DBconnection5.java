package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBconnection5 {

	public static void main(String[] args) {
		
		
		Scanner s=new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			
			PreparedStatement ps1=con.prepareStatement
					("insert into student71 values(?,?,?,?,?,?)"); //compilation
			PreparedStatement ps2=con.prepareStatement
					("insert into studentmark71 values(?,?,?,?,?,?,?)");  //compilation
			PreparedStatement ps3=con.prepareStatement
					("select * from student71");
			PreparedStatement ps4=con.prepareStatement
					("select * from student71 where sroll=?");
			PreparedStatement ps5=con.prepareStatement
					("update student71 set  STOTMARKS=?,SPERCENTAGE=?, SRESULT=? where sroll=?");
			PreparedStatement ps6=con.prepareStatement
					("update studentmark71 set sub1=?,sub2=?,sub3=?,sub4=?,sub5=?,sub6=? where sroll=?");
			PreparedStatement ps7=con.prepareStatement
					("delete from student71 where sroll=?");
			PreparedStatement ps8=con.prepareStatement
					("delete from studentmark71 where sroll=?");
			while(true)
			{
				System.out.println("*****Students Operation Choise********");
				
				System.out.println("\t1.AddStudent"
						+"\n\t2.View All Students"
						+"\n\t3.View Student ByRoll"
						+"\n\t4.Update Student"
						+"\n\t5.Delete Student"
						+"\n\t6.Exit");
				
				System.out.println("Enter your Choise:");
				
				int choice=s.nextInt();
				s.nextLine();
				
				switch(choice)
				{
				case 1:
					
					System.out.println("------read new Student details-------");
					
					System.out.println("1)Enter the Student-Roll_Number");
					String sroll=s.nextLine();
					System.out.println();
					
					System.out.println("2)Enter the Student-Name:");
					String Sname=s.nextLine();
					System.out.println();
					
					System.out.println("3)Enter the Student-Branch:");
					String Sbranch=s.nextLine();
					System.out.println();
					
					System.out.println("4)Enter the marks sub1:");
					int s1=s.nextInt();
					System.out.println();
					
					System.out.println("5)Enter the marks sub2:");
					int s2=s.nextInt();
					System.out.println();
					
					System.out.println("6)Enter the marks sub3:");
					int s3=s.nextInt();
					System.out.println();
					
					System.out.println("7)Enter the marks sub4:");
					int s4=s.nextInt();
					System.out.println();
					
					System.out.println("8)Enter the marks sub5:");
					int s5=s.nextInt();
					System.out.println();
					
					System.out.println("9)Enter the marks sub6:");
					int s6=s.nextInt();
					System.out.println();
					
					
					
					
					if(s1<0||s2<0||s3<0||s4<0||s5<0||s6<0) {
						System.out.println("marks should be not nagative");
					}
					else
					{
						int totmarks=(s1+s2+s3+s4+s5+s6);
						float percentage=(totmarks/6.0f);
						
						
						String result="";
						if(s1<33||s2<33||s3<33||s4<33||s5<33||s6<33)
						{
							result="Fail";
						}
						else
						{
							result="pass";
						}
						ps1.setString(1, sroll);
						ps1.setString(2, Sname);
						ps1.setString(3,  Sbranch);
						ps1.setInt   (4, totmarks);
						ps1.setFloat(5, percentage);
						ps1.setString(6, result);
						
						
						ps2.setString(1, sroll);
						ps2.setInt(2, s1);
						ps2.setInt(3, s2);
						ps2.setInt(4, s3);
						ps2.setInt(5, s4);
						ps2.setInt(6, s5);
						ps2.setInt(7, s6);
						
						int k=ps1.executeUpdate();
						int j=ps2.executeUpdate();
						if(k>0 && j>0) {
							System.out.println("student added succefulyy");
						}
						
					}
					
					
					break;
					
				case 2:
					ResultSet rs1=ps3.executeQuery();
					System.out.println("----------Student Details--------- ");
					
					
					while(rs1.next()) {
						System.out.println(rs1.getString(1)+"\t"
								+rs1.getString(2)+"\t"
								+rs1.getString(3)+"\t"
								+rs1.getInt(4)+"\t"
								+rs1.getDouble(5)+"\t"
								+rs1.getString(6));
						
					}//end loop
					break;
					
				case 3:
					System.out.println("---------Enter the Student-Deatils by student roll Number-------");
					System.out.println("enter the Roll number");
					String sroll1=s.nextLine();
					
				ps4.setString(1, sroll1);
				ResultSet rs2=ps4.executeQuery();
				
				if(rs2.next()) {
					System.out.println(rs2.getString(1)+"\t"
							+rs2.getString(2)+"\t"
							+rs2.getString(3)+"\t"
							+rs2.getInt(4)+"\t"
							+rs2.getDouble(5)+"\t"
							+rs2.getString(6));
					
				}
				else
				{
					System.out.println("Invalid Student rollNumber");
				}
				break;
				
				case 4:
				    System.out.println("----------Update Student by RollNo----------");
				    System.out.print("Enter Student RollNo: ");
				    String rol2 = s.nextLine();
				    System.out.println();

				    ps4.setString(1, rol2);
				    ResultSet rs3 = ps4.executeQuery();
				    if (rs3.next()) {
				        System.out.println();
				        System.out.println("Student Details Before Updation: ");
				        System.out.println(rs3.getString(1) + "\t" 
				                + rs3.getString(2) + "\t" 
				        		+ rs3.getString(3) + "\t"
				                + rs3.getInt(4) + "\t" 
				        		+ rs3.getFloat(5) + "\t" 
				                + rs3.getString(6));
				        System.out.println();
				        System.out.println("Enter Student Marks for update Result: ");
				        System.out.print("Sub1: ");
				        int sb1 = s.nextInt();
				        System.out.print("Sub2: ");
				        int sb2 = s.nextInt();
				        System.out.print("Sub3: ");
				        int sb3 = s.nextInt();
				        System.out.print("Sub4: ");
				        int sb4 = s.nextInt();
				        System.out.print("Sub5: ");
				        int sb5 = s.nextInt();
				        System.out.print("Sub6: ");
				        int sb6 = s.nextInt();
				        System.out.println();
				        
				        if(sb1<0||sb2<0||sb3<0||sb4<0||sb5<0||sb6<0) {
							System.out.println("marks should be not nagative");
						}

				        int tot2 = sb1 + sb2 + sb3 + sb4 + sb5 + sb6;
				        String result2 = "";
				        float perc2 = (tot2 / 6.0F);
				        if (sb1 < 33 || sb2 < 33 || sb3 < 33 || sb4 < 33 || sb5 < 33 || sb6 < 33) {
				            result2 = "Fail";
				        } else {
				            result2 = "Pass";
				        }

				        // Update statement with escaped column name
				        ps5.setInt(1, tot2);
				        ps5.setFloat(2, perc2);
				        ps5.setString(3, result2); // Ensure "result" is the correct column name
				        ps5.setString(4, rol2);

				        int k3 = ps5.executeUpdate();

				        ps6.setInt(1, sb1);
				        ps6.setInt(2, sb2);
				        ps6.setInt(3, sb3);
				        ps6.setInt(4, sb4);
				        ps6.setInt(5, sb5);
				        ps6.setInt(6, sb6);
				        ps6.setString(7, rol2);
				        int k4 = ps6.executeUpdate();

				        if (k3 > 0 && k4 > 0) {
				            System.out.println("Details Updated Successfully......");
				        }

				    } else {
				        System.out.println("Invalid RollNo !");
				    }
				    break;
				case 5:
					System.out.println("----------Enter the Student Roll Number to Delete Operation------");
					System.out.println("enter the roll number ");
					String sroll4 = s.nextLine();

					
					ps4.setString(1, sroll4);
					ResultSet rs6 = ps4.executeQuery();
					if (rs6.next()){
						ps7.setString(1, sroll4);
						ps8.setString(1, sroll4);
						
						    int k4 = ps7.executeUpdate();
						    int j4 = ps8.executeUpdate();

						    if (k4 > 0 && j4 > 0)
						    {
						        System.out.println("Student deleted successfully");
						    } 
						
					}
			
					else 
					{
					    System.out.println("Invalid Student Roll Number");
				}
				
					break;
					
				case 6:
					System.out.println("Operation Stopped..");
					System.exit(0);
					
					default:
						System.out.println("Invalid choice...");
						
						
				}//end of switch
			}// end loop
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
