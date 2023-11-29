package in.co.rays.prectice;

import in.co.rays.marksheet.MarksheetModel;

public class TestMarksheet {
	
	public static void main(String[] args)throws Exception {
		
		//testAdd();
		testUpdate();
	}


	private static void testUpdate() throws Exception {
		  MarksheetBean bean = new MarksheetBean();
		  
		  bean.setId(6);
		  bean.setName("lavish");
		  bean.setRollno(15);
		  bean.setChe(95);
		  bean.setPhy(76);
		  bean.setMaths(38);
		  
		  MarksheetModel1 model = new MarksheetModel1();
		  model.update(bean);
		
	}


	private static void testAdd() throws Exception {
		  MarksheetBean bean = new MarksheetBean();
		  
		  bean.setId(4);
		  bean.setName("rahul");
		  bean.setRollno(14);
		  bean.setPhy(85);
		  bean.setChe(74);
		  bean.setMaths(62);
		  
		  MarksheetModel1 m = new MarksheetModel1();
		  
		  m.add(bean);
		  
		
	}
	
	  
	
	
}