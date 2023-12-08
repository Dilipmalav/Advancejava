package in.co.rays.transcationhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class Commit {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		//conn.setAutoCommit(false);
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into emp values(8, 'sagar',1000)");
		i = stmt.executeUpdate("insert into emp values(8, 'sagar',2000)");
		i = stmt.executeUpdate("insert into emp values(9, 'sagar',3000)");
		
		//conn.commit();
		System.out.println("data inserted="+i);
		
	}

}
