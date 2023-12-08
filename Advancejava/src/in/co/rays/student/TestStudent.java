package in.co.rays.student;

import java.util.Iterator;
import java.util.List;

public class TestStudent {
	 
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
          testSearch();	
		//testFindByPk();
	}

	private static void testAdd() throws Exception {
		
		StudentBean bean = new StudentBean();
		
		//bean.setId(11);
		bean.setName("avinash");
		bean.setRollno(21);
		bean.setPhy(99);
		bean.setChe(88);
		bean.setMaths(89);
		
		StudentModel model = new StudentModel();
		model.add(bean);
		
	}
	
	private static void testUpdate() throws Exception {
		StudentBean bean = new StudentBean();
		
		bean.setId(8);
		bean.setRollno(18);
		
		StudentModel model = new StudentModel();
		model.update(bean);
		
	}
     
	private static void testDelete() throws Exception {
		
		StudentModel model = new StudentModel();
		model.delete(11);
		
	}
	
	
	private static void testSearch() throws Exception {
		     
		StudentBean bean = new StudentBean();
		
		bean.setName("r");
		  
		StudentModel model = new StudentModel();  
		
		List list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			  
			   bean = (StudentBean) it.next();
			  
			  System.out.print("\t"+bean.getId());
			  System.out.print("\t"+bean.getName());
			  System.out.print("\t"+bean.getRollno());
			  System.out.print("\t"+bean.getPhy());
			  System.out.print("\t"+bean.getChe());
			  System.out.println("\t"+bean.getMaths());
			  
			  
			  
		}
		
		
	}
        
	private static void testFindByPk() throws Exception {
		
		StudentModel model = new StudentModel();
		
		StudentBean bean = model.findByPk(66);
		
		if (bean!=null) {
			 
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollno());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChe());
			System.out.println("\t"+bean.getMaths());
		}
		else {
			System.out.println("id not found..");
		}
		
	}
}
