package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
	
	public static void main(String[] args) throws Exception {
		
		 testAdd();
		//testDelete();
		//testUpdate();
		
		//testSearch();
//		for (int i = 0; i < 30; i++) {
//			System.out.println(i);
//			
		//testFindByPk();
//		}
	}

	private static void testFindByPk() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = model.findByPk(13);
		
		if (bean!=null) {
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRo_no());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChe());
			System.out.println("\t"+bean.getMaths());
			
		}else {
			
			System.out.println("id not found");
		}
		
	}

	private static void testSearch() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		bean.setName("s");
		//bean.setRo_no(568);
		
		
		MarksheetModel model = new MarksheetModel();
		
		List list = model.search(bean,1,5);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			 bean = (MarksheetBean)it.next();
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRo_no());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChe());
			System.out.println("\t"+bean.getMaths());
			
		}
		
		
	}

	private static void testAdd() throws Exception {
		  MarksheetBean bean = new MarksheetBean();
		
		  
		  
		 bean.setId(16);
		  bean.setName("deepu");
		  bean.setRo_no(106);
		  bean.setChe(88);
		  bean.setPhy(78);
		  bean.setMaths(98);
		  
		  
		  MarksheetModel model = new MarksheetModel();
		  
		  model.add(bean);
	}

     private static void testDelete() throws Exception{
        
	
	
	
	
	MarksheetModel model = new MarksheetModel();
	
	model.delete(11);
}
         
      private static void testUpdate() throws Exception {
    	  
    	     MarksheetBean bean = new MarksheetBean();
    	     
    	    bean.setId(12);
    	    bean.setName("Himanshu");
    	    bean.setRo_no(568);
    	   
    	     bean.setChe(88);
    	     bean.setPhy(58);
    	     bean.setMaths(47);
    	     
    	     
    	     MarksheetModel model = new MarksheetModel();
    	     
    	     model.update(bean);
      }
}


