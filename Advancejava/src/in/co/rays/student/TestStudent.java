package in.co.rays.student;

public class TestStudent {
	 
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		testDelete();
		
	}
	private static void testAdd() throws Exception {
		
		StudentBean bean = new StudentBean();
		
		bean.setId(11);
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

}
