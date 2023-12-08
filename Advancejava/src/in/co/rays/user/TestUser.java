package in.co.rays.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {
     
	public static void main(String[] args) throws Exception {
		
		testAdd();
		//testUpdate();
		//testSearch();
		//testFindByPk();
	
	}

	private static void testAdd() throws Exception {
		UserBean bean = new UserBean();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setId(55);
		bean.setFirst_name("rohit");
		bean.setLast_name("kashayap");
		bean.setLogin_id("rohit@gmail.com");
		bean.setPassword("123456");
		bean.setDob(sdf.parse("2002-01-22"));
		bean.setAddress("jhalawar");
		
		UserModel model = new UserModel();
		model.add(bean);
		
	}
	
	private static void testUpdate() throws Exception {
		UserBean bean = new UserBean();
		
		bean.setId(4);
		bean.setLast_name("kumar");
		
		UserModel model = new UserModel();
		model.update(bean);
		
	}
	
	private static void testSearch() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		
		
		UserBean bean = new UserBean();
		bean.setDob(sdf.parse("2002-05-26"));
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (UserBean) it.next();
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirst_name());
			System.out.print("\t"+bean.getLast_name());
			System.out.print("\t"+bean.getLogin_id());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.err.println("\t"+bean.getAddress());
		}	
		
	}	
	
	private static void testFindByPk() throws Exception {
		    
		UserModel model = new UserModel();
		
		UserBean bean = model.findByPk(1);
		
		if (bean != null) {
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getFirst_name());
			System.out.print("\t"+bean.getLast_name());
			System.out.print("\t"+bean.getLogin_id());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getAddress());
		}
		
	}  
	
	
	
}
