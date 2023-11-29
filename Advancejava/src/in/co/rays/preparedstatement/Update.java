package in.co.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	
	public static void main(String[] args) throws Exception {
		
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/advance04", "root", "root");
		  
		  PreparedStatement ps = conn.prepareStatement("update marksheet set name='ankit' where id=16");
		  
		  int i = ps.executeUpdate();
		  
		  System.out.println("data updated="+i);
	}

}
