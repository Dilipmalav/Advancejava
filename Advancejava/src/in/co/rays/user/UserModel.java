package in.co.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class UserModel {

	  public void add(UserBean bean)throws Exception {
          
//		  Class.forName("com.mysql.cj.jdbc.Driver");
//		  
//		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		Connection conn = JDBCDataSource.getConnection();
		  
		  PreparedStatement ps = conn.prepareStatement("insert into user values( ?, ?, ?, ?, ?, ?, ?)");
		    
		  ps.setInt(1, bean.getId());
		  ps.setString(2, bean.getFirst_name());
		  ps.setString(3, bean.getLast_name());
		  ps.setString(4, bean.getLogin_id());
		  ps.setString(5, bean.getPassword());
		  ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		  ps.setString(7, bean.getAddress());
		  
		  int i = ps.executeUpdate();
		  
		  System.out.println("data inserted="+i);
		  
	  }
	  
	  public void update(UserBean bean)throws Exception{
		  
          Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		  
		  PreparedStatement ps = conn.prepareStatement("update user set last_name = ? where id = ?");
		     
		    ps.setString(1, bean.getLast_name());
		    ps.setInt(2, bean.getId());
		  
		  int i = ps.executeUpdate();
		  
		  System.out.println("data updated="+i);
		  
	  }
	  
	   public List search(UserBean bean) throws Exception{
		   
		       Class.forName("com.mysql.cj.jdbc.Driver");
			  
			  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			  
			  StringBuffer sql = new StringBuffer("select * from user where 1=1");
			  
			  if (bean != null) {
				    
				      if (bean.getDob() != null && bean.getDob().getTime()>0) {
				    	  sql.append(" and dob like '"+new java.sql.Date(bean.getDob().getTime())+"%'");
						
					}
			}
			  
			  System.out.println("sql query ===>>>"+sql);
			  PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			  ResultSet rs = ps.executeQuery();
			  List list = new ArrayList();
			  
			  while (rs.next()) {
				
				  bean.setId(rs.getInt(1));
				  bean.setFirst_name(rs.getString(2));
				  bean.setLast_name(rs.getString(3));
				  bean.setLogin_id(rs.getString(4));
				  bean.setPassword(rs.getString(5));
				  bean.setDob(rs.getDate(6));
				  bean.setAddress(rs.getString(7));
				  list.add(bean);
			}
			  
			  return list;
			  
	   }
	  
	  public UserBean findByPk(int id) throws Exception{
		  
		  
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		    
		     PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		     
		     ps.setInt(1, id);
		     
		     ResultSet rs = ps.executeQuery();
		     
		     UserBean bean = null;
		     
		     while (rs.next()) {
				
		    	  bean = new UserBean();
		    	 
		    	 bean.setId(rs.getInt(1));
		    	 bean.setFirst_name(rs.getString(2));
		    	 bean.setLast_name(rs.getString(3));
		    	 bean.setLogin_id(rs.getString(4));
		    	 bean.setPassword(rs.getString(5));
		    	 bean.setDob(rs.getDate(6));
		    	 bean.setAddress(rs.getString(7));
			}
		     return bean;
		  
	  }
	  
	  
//	  public Integer nextPk() throws Exception {
//		  
//		  Class.forName("com.mysql.cj.jdbc.Driver");
//		  
//		  Connection conn = 
//	  }
	  
	  
	  
}
