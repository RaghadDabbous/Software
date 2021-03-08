package Production;

public class Logout {

	public boolean logoutFunction(boolean flag) {
		if(flag) {
			System.out.println("LoggedOut ");
			return true;
		}
		System.out.print("Fail");
		return false;
	}
}
