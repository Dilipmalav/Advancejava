package in.co.rays.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Practice {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into st values(10, 'lavishiiiii')");

		System.out.println("Data Inserted = " + i);
	}

}
