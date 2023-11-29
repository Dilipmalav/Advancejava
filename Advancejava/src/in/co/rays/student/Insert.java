package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Insert {
	
	public static void main(String[] args) throws Exception {
		
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		  
		  PreparedStatement ps = conn.prepareStatement("insert into student values(9,'rohit',19,59,75,25)");
		  
		  int i = ps.executeUpdate();
		  
		  System.out.println("data inserted="+i);
	}

}
