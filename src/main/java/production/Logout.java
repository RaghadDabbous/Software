package production;

import java.util.logging.Logger;

public class Logout {

	private static final Logger LOG = Logger.getLogger(Logout.class.getName());
	private boolean loggedOut = false;
	public boolean logoutFunction(boolean flag) {
		if(flag) {
			LOG.info("LoggedOut");
			loggedOut = true;
		}
		return loggedOut;
	}
}
