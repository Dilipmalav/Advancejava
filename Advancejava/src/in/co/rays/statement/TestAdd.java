package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestAdd {
	//public static void main(String[] args) throws Exception {
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04","root","root");
//		Statement stmt = conn.createStatement();
//		int i = stmt.executeUpdate("insert into marksheet values(14,'sagar',105,47,59,69)");
//		System.out.println("Data inserted = " + i);
		
		
//		public static void main(String[] args) throws Exception {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
//			
//			Statement stmt = conn.createStatement();
//			
//			int i = stmt.executeUpdate("update marksheet set name='dilip' where id=10");
//			
//			System.out.println("data updated ="+i);
//		}
	   
//	      public static void main(String[] args) throws Exception {
//			
//	    	  Class.forName("com.mysql.cj.jdbc.Driver");
//	    	  
//	    	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
//	    	  
//	    	  Statement stmt = conn.createStatement();
//	    	  
//	    	  int i = stmt.executeUpdate("delete from marksheet where id=10");
//	    	  
//	    	  System.out.println("data deleted="+i);
//		}
//	
	     
	  public static void main(String[] args) throws Exception {
		
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
              
		    Statement stmt = conn.createStatement();
		    
		    int i = stmt.executeUpdate("alter table marksheet add total int");
		    
		    System.out.println("column added="+i);
		    
	}
	}


 
