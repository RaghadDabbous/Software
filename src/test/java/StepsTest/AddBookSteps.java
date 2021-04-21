package StepsTest;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import production.*;

public class AddBookSteps {
	AddBook myBook;
	Boolean isLogin,isValidSignature,isValidISBN;
	String message;
	public Login log;
	private static final Logger LOG = Logger.getLogger(SearchBook.class.getName());
	
	public AddBookSteps(AddBook myBook, Login log) {
		this.myBook = myBook;
		this.log = log;
	}
	@Given("The administrator has logged in")
	public void the_administrator_has_logged_in() {
	   log.isLoged = true;
	}

	@Given("Administrator not logged in")
	public void administrator_not_logged_in() {
		log.isLoged = false;
	}
	
	@When("admin add book with {string}  and {string}  and {string}  and {string}")
	public void admin_add_book_with_and_and_and(String title, String author, String signature, String isbn) {
		 addBookAdmin(title, author, signature, isbn);	
	}
	public void addBookAdmin(String title, String author, String signature, String isbn) {
		if(log.isLoged) {
			
			    isValidISBN=myBook.isISBN10(isbn);
			    if(isValidISBN) {
			    	myBook.addToLibrary(title,author,signature,isbn);
			    	message = "The book has been added successfully";
			    	LOG.info(message);
			    }
			    else {
		    		message = "invalid ISBN";
		    		LOG.info(message);
		    	}
			    
			    
		    }
		    else {
		    	message="The book cannot be added, please login first";
		    	LOG.info(message);
		    }
	}
	
	@Then("the book will be added")
	public void the_book_will_be_added() {
	    assertEquals("The book has been added successfully",message);
	}
	
	@Then("the book will not be added")
	public void the_book_will_not_be_added() {
	   assertEquals("The book cannot be added, please login first", message);
	}
	
	@When("admin add book with Title {string} and Author {string}  and valid Signature {string}  and ISBN {string}")
	public void admin_add_book_with_title_and_author_and_valid_signature_and_isbn(String title, String author, String signature, String isbn) {
		addBookValidSign(title, author, signature, isbn);
	}
	
	@When("admin add book with Title {string}  and Author {string}  and Signature {string}  and ISBN {string}")
	public void admin_add_book_with_title_and_author_and_signature_and_isbn(String title, String author, String signature, String isbn) {
		addBookValidSign(title, author, signature, isbn);
	}
	
	private void addBookValidSign(String title, String author, String signature, String isbn) {
		if(log.isLoged) {
	    	myBook.addToLibrary(title,author,signature,isbn);
	    	isValidSignature = myBook.checkSignature();
	    	if(isValidSignature) {
	    		message ="The book has been added successfully";
	    		LOG.info(message);
	    	}
	    	else {
	    		message = "invalid signature";
	    		LOG.info(message);
	    	}
	    }
	    else {
	    	message = "The book cannot be added, please login first";
	    	LOG.info(message);
	    }
	}

	@Then("the book will not be added and Error message will be displayed")
	public void the_book_will_not_be_added_and_error_message_will_be_displayed() {
	    assertEquals("invalid signature", message);
	}
	
	
	@When("admin add book with Title {string}  and Author {string}  and Signature {string}  and invalid ISBN {string}")
	public void admin_add_book_with_title_and_author_and_signature_and_invalid_isbn(String title, String author, String signature, String isbn) {
		addBookAdmin(title, author, signature, isbn);
	}

	@Then("the book will not be added and Error message will be displayed \\(Invalid ISBN)")
	public void the_book_will_not_be_added_and_error_message_will_be_displayed_invalid_isbn() {
		assertEquals("invalid ISBN", message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
