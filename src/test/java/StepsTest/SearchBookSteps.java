package StepsTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import production.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBookSteps {
	public List<List<String>> data;
	public SearchBook sb;
	int numberOfBook;
	boolean login;
	
	public SearchBookSteps(SearchBook sb) {
		this.sb = sb;
	}

	@Given("these books are contained in the system")
	public void these_books_are_contained_in_the_system(DataTable dataTable) {
		data=dataTable.asLists(String.class);
	}
	
	
	@When("I search for a book with  Subtitle {string}")
	public void i_search_for_a_book_with_subtitle(String Subtitle) {
		numberOfBook=sb.searchSub(data,Subtitle,0);
	}

	@When("I search for a book with complete title {string}")
	public void i_search_for_a_book_with_complete_title(String Title) {
		numberOfBook=sb.search(data, Title,0);
	}
	
	@When("I search for a book with SubString of author {string}")
	public void i_search_for_a_book_with_sub_string_of_author(String Sub_Author) {
		numberOfBook=sb.searchSub(data, Sub_Author,1);
	}

	@When("I search for a book with Author {string}")
	public void i_search_for_a_book_with_author(String Author) {
		numberOfBook=sb.search(data, Author,1);
	}
	
	
	@When("I search for a book with ISBN {string}")
	public void i_search_for_a_book_with_isbn(String ISBN) {
		numberOfBook=sb.search(data, ISBN,3);
	}
	
	@When("I search for a book with signature {string}")
	public void i_search_for_a_book_with_signature(String signature) {
		numberOfBook=sb.search(data, signature,2);
	}
	
	@When("I search for a book with title {string}")
	public void i_search_for_a_book_with_title(String string) {
		numberOfBook=sb.searchSub(data, string,0);
	}
	
	@When("I search for a book with part of the word {string}")
	public void i_search_for_a_book_with_part_of_the_word(String title) {
		numberOfBook = sb.searchSubOfName(data, title, 0);
	}
	@Given("user or administrator is logged in")
	public void user_or_administrator_is_logged_in() {
		login=true;
	}
	
	@When("I logged in and search for a book with  author {string}")
	public void i_logged_in_and_search_for_a_book_with_author(String string) {
		numberOfBook=sb.search(data, string,1);
	}
	
	@When("I search for a book with part of the word_Author {string}")
	public void i_search_for_a_book_with_part_of_the_word_author(String string) {
		numberOfBook = sb.searchSubOfName(data, string, 1);
	}
	
	
	@Then("{int} book should be displayed")
	public void book_should_be_displayed(Integer exp) {
		assertTrue(numberOfBook==exp);
	}

}
