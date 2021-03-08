package Production;

import java.util.List;

public class Login {
	public static boolean isLoged=false;
	//boolean found=false;
	public List<List<String>> A;

	public Boolean LoginFunc(String em, String pass, List<List<String>> admin) {
		
		A=admin;
		for(int i=0;i<admin.size();i++) {
			String email=admin.get(i).get(0);
			String password = admin.get(i).get(1);
			if(em.equalsIgnoreCase(email)&&pass.equalsIgnoreCase(password)) {
				System.out.println("Logged in successfully");
				isLoged=true;
				return true;
			}	
		}
		
		if(!isLoged) {
			System.out.println("Error massege");
			return false;
		}
		return isLoged;
	}
}	
		
		
		
//		if (em.equals("m@gmail.com")&&pass.equals("123")) {
//			System.out.println("Logged in successfully");
//			isLoged=true;
//			return true;
//		}
//		else {
//			System.out.println("Error massege");
//			isLoged=false;
//			return false;
//		}			
//	}
//	public boolean check() {
//		return isLoged;
//	}
//
//}
