package StepsTest;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production.Login;
import production.Logout;

public class LogoutSteps {
	public boolean done;
	public Logout outt;
	public Login log;
	
	@Given("admin should be loged in")
	public void admin_should_be_loged_in() {
		log.isLoged = true;
	}

	@When("i call the Logout function")
	public void i_call_the_logout_function() {
		done=outt.logoutFunction(log.isLoged);
	}

	@Then("the administrator should be loged out")
	public void the_administrator_should_be_loged_out() {
		assertTrue(done==true);
	}
//	public LogoutSteps(Login isLogin, Logout outt) {
//		this.outt = outt;
//	}

	public LogoutSteps(Logout outt, Login log) {
		this.outt = outt;
		this.log = log;
	}

}
