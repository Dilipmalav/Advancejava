package in.co.rays.transcationhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RollBack {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into emp values(9, 'sagar',1000)");
			i = stmt.executeUpdate("insert into emp values(10, 'sagar',2000)");
			i = stmt.executeUpdate("insert into emp values(11, 'sagar',3000)");
			
			conn.commit();
			System.out.println("data inserted="+i);
			
		} catch (Exception e) {
			conn.rollback();
		}
	}
}