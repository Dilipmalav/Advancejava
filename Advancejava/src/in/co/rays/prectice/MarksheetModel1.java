package in.co.rays.prectice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MarksheetModel1 {
	
	public void add(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into mark values(?,?,?,?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollno());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChe());
		ps.setInt(6, bean.getMaths());
		int i = ps.executeUpdate();
		
		System.out.println("data inserted="+i);
	}
	
	public void update(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update mark set phy=?,che=?,maths=?,name=?,rollno=? where id=?");
		  ps.setInt(1, bean.getPhy());
		  ps.setInt(2, bean.getChe());
		  ps.setInt(3, bean.getMaths());
		   ps.setInt(5, bean.getRollno());
		   ps.setString(4, bean.getName());
		   ps.setInt(6, bean.getId());
		
		int i = ps.executeUpdate();
		
		System.out.println("data updated="+i);
	}

}
