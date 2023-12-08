package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(MarksheetBean bean) throws Exception {
		int pk = nextPk();

		

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		ps.setInt(1, pk);
		//ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRo_no());
		ps.setInt(4, bean.getChe());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getMaths());

		int i = ps.executeUpdate();

		System.out.println("data inserted=" + i);

	}

	public void delete(int id) throws Exception {

		

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		System.out.println("data deleted=" + i);
	}

	public void update(MarksheetBean bean) throws Exception {

		

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("update marksheet set name=?,ro_no=?, che=?,phy=?,maths=? where id = ?");

		ps.setInt(6, bean.getId());
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRo_no());
		ps.setInt(3, bean.getChe());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getMaths());

		int i = ps.executeUpdate();

		System.out.println("data updated=" + i);

	}

	public List search(MarksheetBean bean,int pageno,int pagesize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
		
		

		if (bean!=null) {
			if (bean.getName()!= null && bean.getName().length()>0) {
				sql.append(" and name like '"+bean.getName()+"%' ");
			}
				if(bean.getRo_no()>0) {
					sql.append(" and ro_no = "+ bean.getRo_no()+" ");
					
				}
				
		}
			if (pagesize>0) {
				
				pageno= (pageno-1)* pagesize;
				sql.append(" limit " + pageno + "," +pagesize);
				
			}
			  
		
		System.out.println("sql query====>>>"+sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			 bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRo_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);

		}
		return list;
	}

	public MarksheetBean findByPk(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id=?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRo_no(rs.getInt(3));
			bean.setChe(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		return bean;

	}

}
