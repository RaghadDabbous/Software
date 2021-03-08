package StepsTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import Production.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsTest {
	public List<List<String>> Admin;
	public Login L;
	public static String em,pass;
	public Boolean correct,loginPage;
	
	
	public LoginStepsTest(Login l) {
		L = l;
	}
	
	@Given("these accounts are contained in the system")
	public void these_accounts_are_contained_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		Admin=dataTable.asLists(String.class);
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		loginPage=true;
	}

	@When("I fill in {string} and {string}")
	public void i_fill_in_and(String email, String password) {
		em=email;
		pass=password; 
	}

	@When("I call  Login Func")
	public void i_call_login_func() {
		correct=L.LoginFunc(em,pass,Admin);
	}

	@Then("I should see Login successful")
	public void i_should_see_login_successful() {
	    assertTrue(correct==true);
	}

	@Then("I should see Error message")
	public void i_should_see_error_message() {
		assertTrue(correct==false);
	}
	
	
	
	
	
	
	
	
	
	
	
//	public String AdminName, AdminPassword;
//	public Login Log;
//	
//	
//	
//	public LoginStepsTest(Login log) {
//		
//		Log = log;
//		
//	}
//
//	@Given("admin enter valid {string} and {string}")
//	public void admin_enter_valid_and(String name, String password) {
//		AdminName=name;
//		AdminPassword=password;
//		Log.L=true;
//	}
//
//	
//
//	@Then("the administrator will loged in")
//	public void the_administrator_will_loged_in() {
//	    assertTrue(AdminName.equals("raghad"));
//	    assertTrue(AdminPassword.equals("123"));
//	}
//	
//	@When("i call the login function")
//	public void i_call_the_login_function() {
//		Log.DisplayMess();
//	}
//
//	@Given("admin enter wrong password")
//	public void admin_enter_wrong_password() {
//	    
//	}
//
//	@Then("error message displayed")
//	public void error_message_displayed() {
//	    System.out.print("hhhh");
//	}

}
