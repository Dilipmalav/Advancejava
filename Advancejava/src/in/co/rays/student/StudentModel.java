package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class StudentModel {
	
	public void add(StudentBean bean)throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollno());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getChe());
		ps.setInt(6, bean.getMaths());
		int i = ps.executeUpdate();
		
		System.out.println("data insert ="+i);
		
	}
	
	 public void update(StudentBean bean) throws Exception {
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
			
			PreparedStatement ps = conn.prepareStatement("update student set rollno=? where id=?");
			
			ps.setInt(1, bean.getRollno());
			ps.setInt(2, bean.getId());
			
			int i = ps.executeUpdate();
			
			System.out.println("data updated="+i);
		 
	 }
	 
	 public void delete(int id) throws  Exception{
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
			
			PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			System.out.println("date deleted="+i);
		 
	 }
       
//	 public List search() throws Exception {
//		 
//	 }
}
