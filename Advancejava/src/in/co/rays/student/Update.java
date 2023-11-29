package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update student set id=8 where name='rohit'");
		
		int i = ps.executeUpdate();
		
		System.out.println("data updated="+i);
	}

}
