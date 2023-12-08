package metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaData {
   
	   public static void main(String[] args) throws Exception {
		
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		   
		   Statement stmt = conn.createStatement();
		   
		   ResultSet rs = stmt.executeQuery("select id,name,salary from emp");
		   
		   ResultSetMetaData rm = rs.getMetaData();
		   System.out.println("Catlod Name:"+rm.getCatalogName(1));
		   System.out.println("table Name:"+rm.getTableName(1));
		   int columnCount = rm.getColumnCount();
		   System.err.println("total colunm:-"+columnCount);
		   for (int i  = 1; i <columnCount ; i++) {
			   System.err.println("column:-"+i);
			   System.err.println("lable:-"+rm.getColumnLabel(i));
			   System.err.println("name:-"+rm.getCatalogName(i));
			   System.err.println("type:-"+rm.getColumnTypeName(i));
			   System.err.println("size:-"+rm.getColumnDisplaySize(i));
			   System.err.println("precision:-"+rm.getPrecision(i));
			
		}
	}
}
