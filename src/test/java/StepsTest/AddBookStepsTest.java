package StepsTest;

import static org.junit.Assert.assertEquals;

import Production.AddBook;
import Production.Book;
import Production.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBookStepsTest {
	//Book book;
	//public String title,author,signature,isbn;
	AddBook myBook;
	Boolean isLogin,isValidSignature,isValidISBN;
	String message;
	
	
	

	public AddBookStepsTest(AddBook myBook) {
		
		this.myBook = myBook;
	}
	@Given("The administrator has logged in")
	public void the_administrator_has_logged_in() {
	   Login.isLoged=true;
	}
	@Given("Administrator not logged in")
	public void administrator_not_logged_in() {
		Login.isLoged=false;
	}
	
	@When("admin add book with {string}  and {string}  and {string}  and {string}")
	public void admin_add_book_with_and_and_and(String title, String author, String signature, String isbn) {
		 if(Login.isLoged) {
			    isValidISBN=myBook.isISBN10(isbn);
			    if(isValidISBN) {
			    	myBook.Add(title,author,signature,isbn);
			    	message="The book has been added successfully";
			    	System.out.println(message);
			    }
			    else {
		    		message = "invalid ISBN";
		    		System.out.println(message);
		    	}
		    }
		    else {
		    	message="The book cannot be added, please login first";
		    	System.out.println(message);
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
	
	
	@When("admin add book with Title {string}  and Author {string}  and Signature {string}  and ISBN {string}")
	public void admin_add_book_with_title_and_author_and_signature_and_isbn(String title, String author, String signature, String isbn) {
		if(Login.isLoged) {
	    	myBook.Add(title,author,signature,isbn);
	    	isValidSignature=myBook.checkSignature();
	    	if(isValidSignature) {
	    		message="The book has been added successfully";
	    	}
	    	else
	    		message = "invalid signature";
	    }
	    else {
	    	message="The book cannot be added, please login first";
	    	System.out.println(message);
	    }
	}

	@Then("the book will not be added and Error message will be displayed")
	public void the_book_will_not_be_added_and_error_message_will_be_displayed() {
	    assertEquals("invalid signature", message);
	}
	
	
	@When("admin add book with Title {string}  and Author {string}  and Signature {string}  and invalid ISBN {string}")
	public void admin_add_book_with_title_and_author_and_signature_and_invalid_isbn(String title, String author, String signature, String isbn) {
		if(Login.isLoged) {
	    ///	myBook.Add(title,author,signature,isbn);
	    	isValidISBN=myBook.isISBN10(isbn);
	    	if(isValidISBN) {
	    		myBook.Add(title,author,signature,isbn);
	    		message="The book has been added successfully";
	    	}
	    	else {
	    		message = "invalid ISBN";
	    		System.out.println(message);
	    	}
	    }
	    else {
	    	message="The book cannot be added, please login first";
	    	System.out.println(message);
	    }
	}

	@Then("the book will not be added and Error message will be displayed \\(Invalid ISBN)")
	public void the_book_will_not_be_added_and_error_message_will_be_displayed_invalid_isbn() {
		assertEquals("invalid ISBN", message);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
