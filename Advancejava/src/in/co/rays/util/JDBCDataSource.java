package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
	
	private static JDBCDataSource datasource = null;
	
	private  ComboPooledDataSource cpds = null;
	
	private static ResourceBundle rb= ResourceBundle.getBundle("in.co.rays.bundle.system");
	
	private JDBCDataSource() {
		

	try {

	cpds = new ComboPooledDataSource();

	cpds.setDriverClass(rb.getString("driver")); 

	cpds.setJdbcUrl(rb.getString("url"));

	cpds.setUser(rb.getString("username"));

	cpds.setPassword(rb.getString("password"));

	cpds.setInitialPoolSize (Integer.parseInt(rb.getString("initialpoolsize")));

	cpds.setAcquireIncrement (Integer.parseInt(rb.getString("aquiredincrement")));

	cpds.setMaxPoolSize (Integer.parseInt(rb.getString("maxpoolsize")));

	} catch (PropertyVetoException e) {

	e.printStackTrace();
	}
	}
	
	public static JDBCDataSource  getInstance() {

	if (datasource == null) {

	datasource = new JDBCDataSource(); 
	
	}

	return datasource;

	}
	public static Connection getConnection() {

	try {
		return getInstance().cpds.getConnection();
		
		}catch (SQLException e) {
	return null;
	}
	}
}			


			

			

