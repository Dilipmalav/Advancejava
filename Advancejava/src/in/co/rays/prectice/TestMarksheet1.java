package in.co.rays.prectice;

import java.util.Iterator;
import java.util.List;

import in.co.rays.marksheet.MarksheetModel;

public class TestMarksheet1 {
	
	public static void main(String[] args)throws Exception {
		
		  testAdd();
		//testUpdate();
		//testSearch();
		//testFindByPk();
		
	}

	private static void testUpdate() throws Exception {
		  MarksheetBean1 bean = new MarksheetBean1();
		  
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
		  MarksheetBean1 bean = new MarksheetBean1();
		  
		  //bean.setId(4);
		  bean.setName("rohit");
		  bean.setRollno(15);
		  bean.setPhy(82);
		  bean.setChe(76);
		  bean.setMaths(61);
		  
		  MarksheetModel1 m = new MarksheetModel1();
		  
		  m.add(bean);
		  
		
	}
	
	private static void testSearch() throws Exception {
		
		MarksheetModel1 model = new MarksheetModel1();
		
		List list = model.search();
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			MarksheetBean1 bean = (MarksheetBean1) it.next();
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollno());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChe());
			System.out.println("\t"+bean.getMaths());
		}
		
		
	}
	
	private static void testFindByPk() throws Exception {
		MarksheetModel1 model = new MarksheetModel1();
		
		MarksheetBean1 bean = model.findByPk("sagar");
		
		if (bean!=null) {
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getRollno());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChe());
			System.out.println("\t"+bean.getMaths());
			
		}else {
			
			System.out.println("name not found");
		}
		
	}
}