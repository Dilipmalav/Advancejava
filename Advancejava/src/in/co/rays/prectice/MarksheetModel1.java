package in.co.rays.prectice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

public class MarksheetModel1 {
	
	public void add(MarksheetBean1 bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into mark values(?,?,?,?,?,?)");
		int pk = nextPk();
		ps.setInt(1, pk);
		//ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollno());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChe());
		ps.setInt(6, bean.getMaths());
		int i = ps.executeUpdate();
		
		System.out.println("data inserted="+i);
	}
	
	public void update(MarksheetBean1 bean) throws Exception {
		
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
      
	public List search()throws Exception {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("select * from mark");
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while (rs.next()) {
			
			MarksheetBean1 bean = new MarksheetBean1();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPhy(rs.getInt(4));
			bean.setChe(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			bean.setRollno(rs.getInt(3));
			
			list.add(bean);
		}
		return list;
	}
	
	public MarksheetBean1 findByPk(String name)throws Exception{
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
			
			PreparedStatement ps = conn.prepareStatement("select * from mark where name=?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			MarksheetBean1 bean = null;
			
			while (rs.next()) {
				
				bean=new MarksheetBean1();
				
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPhy(rs.getInt(4));
				bean.setChe(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				bean.setRollno(rs.getInt(3));
				
				
				
			}return bean;
	}
	
      public Integer nextPk() throws Exception {
    	  int pk = 0;
    	  Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
			
			PreparedStatement ps = conn.prepareStatement("select max(id) from mark");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				pk = rs.getInt(1);
				
			}
			return pk + 1;
			
      }
	
	
	
	
}
