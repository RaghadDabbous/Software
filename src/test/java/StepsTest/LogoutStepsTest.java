package StepsTest;

import static org.junit.Assert.assertTrue;

import Production.Login;
import Production.Logout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepsTest {
	public Login isLogin;
	public boolean done;
	public Logout outt;
	
	@Given("admin should be loged in")
	public void admin_should_be_loged_in() {
	   // flag=true;
		Login.isLoged=true;
	}

	@When("i call the Logout function")
	public void i_call_the_logout_function() {
		done=outt.logoutFunction(Login.isLoged);
	}

	@Then("the administrator should be loged out")
	public void the_administrator_should_be_loged_out() {
		assertTrue(done==true);
	}
	public LogoutStepsTest(Login isLogin, Logout outt) {
		this.outt = outt;
	}

}
