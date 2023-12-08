package in.co.rays.bundle;

import java.util.ResourceBundle;

public class TestGreeting {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");
		
		System.out.println(rb.getString("greet"));
		
//       ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
//		
//		System.out.println(rb.getString("greeting"));
	}
	}


