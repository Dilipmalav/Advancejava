package in.co.rays.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import in.co.rays.marksheet.MarksheetBean;

public class StudentModel {
	
	public void add(StudentBean bean)throws Exception{
		int pk = nextPk();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
		
		ps.setInt(1, pk);
		//ps.setInt(1, bean.getId());
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
       
	 public List search(StudentBean bean) throws Exception {
	    
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
			
			    StringBuffer sql = new StringBuffer("select * from student where 1=1");
			    
			    if (bean!=null) {
			    	
			    	if (bean.getName()!=null && bean.getName().length()>0) {
			    		sql.append(" and name like '"+bean.getName()+"%'");
						
					}
					
				}
			
			 System.out.println("sql query====>>>"+sql);   
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
            ResultSet rs = ps.executeQuery();
            
            List list = new ArrayList();
            
            while (rs.next()) {
				
                bean = new StudentBean();
            	
            	bean.setId(rs.getInt(1));
            	bean.setName(rs.getString(2));
            	bean.setRollno(rs.getInt(3));
            	bean.setPhy(rs.getInt(4));
            	bean.setChe(rs.getInt(5));
            	bean.setMaths(rs.getInt(6));
            	
            	list.add(bean);
			}
            return list;
			
	        
	 }
	 
	     public StudentBean findByPk(int id) throws Exception {
	    	 
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
	    	 
	    	 PreparedStatement ps = conn.prepareStatement("select * from student where id=?");
	    	 
	    	 ps.setInt(1, id);
	    	 
	    	 ResultSet  rs = ps.executeQuery();
	    	 
	    	 StudentBean bean = null;
	    	 
	    	 while (rs.next()) {
				
	    		 bean = new StudentBean();
	    		 bean.setId(rs.getInt(1));
	    		 bean.setName(rs.getString(2));
	    		 bean.setRollno(rs.getInt(3));
	    		 bean.setPhy(rs.getInt(4));
	    		 bean.setChe(rs.getInt(5));
	    		 bean.setMaths(rs.getInt(6));
			}
	    	 return bean;
	     }
	    
	     public Integer nextPk() throws Exception {
	    	   
	    	   int pk = 0;
              Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prectice", "root", "root");
	    	 
	    	  PreparedStatement ps = conn.prepareStatement("select max(id) from student");
	    	  
	    	  ResultSet rs = ps.executeQuery();
	    	  
	    	  while (rs.next()) {
				 
	    		  pk = rs.getInt(1);
	    		  
			}
	    	  return pk + 1;
	     }
	 
	 
}
