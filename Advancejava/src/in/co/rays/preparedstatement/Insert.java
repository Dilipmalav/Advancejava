package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insert {
	
	  public static void main(String[] args) throws Exception {
		
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		  
		  PreparedStatement ps = conn.prepareStatement("insert into marksheet values(16,'rohit',107,55,44,66)");
		  
		  int i = ps.executeUpdate();
		  
		  System.out.println("data inserted="+i);
	}

}
