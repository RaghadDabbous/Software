package production;

import java.util.List;
import java.util.logging.Logger;

public class Login {
	
	private static final Logger LOG = Logger.getLogger(Login.class.getName());
	public boolean isLoged = false;
	public List<List<String>> accounts;
	
	public Boolean loginFunc(String em, String pass, List<List<String>> admin) {
		
		accounts=admin;
		for(int i = 0; i < admin.size(); i++) {
			String email = admin.get(i).get(0);
			String password = admin.get(i).get(1);
			if(em.equalsIgnoreCase(email) && pass.equalsIgnoreCase(password)) {
				LOG.info("Logged in successfully");
				isLoged=true;
				return true;	
			}
		}
		
		if(!isLoged) {
			LOG.info("Error massege");
			isLoged = false;
		}
		return isLoged;
	}
}	
		
