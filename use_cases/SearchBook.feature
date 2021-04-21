Feature: Search for books

  Background: The System has a repository of books with their information (title-author-signature-ISBN)
    Given these books are contained in the system
      | Thinking, Fast and Slow                  | Daniel Kahneman   | Kahneman2012    | 0141033576 |
      | Act Like a Success, Think Like a Success | Steve Harvey      | Harvey2015      | 0062220330 |
      | The Pattern Seekers                      | Simon Baron-Cohen | Baron-Cohen2020 | 1541647149 |
      | Think Again                              | Adam Grant        | Grant2021       | 0753553902 |
      | Jump                                     | Steve Harvey      | Harvey2016      | 0062571648 |
      |How to Think About Analysis               | Lara Alcock       | Alcock2014      | 0191035378 |

  #Scenario1
  Scenario: Search for a book by Subtitle
    When I search for a book with  Subtitle "Think"
    Then 3 book should be displayed

  #Scenario2
  Scenario: Search for a book by title
    When I search for a book with complete title "The Pattern Seekers"
    Then 1 book should be displayed

  Scenario: Search for a book by SubString of author
    When I search for a book with SubString of author "Steve"
    Then 2 book should be displayed

  Scenario: Search for a book by author
    When I search for a book with Author "Daniel Kahneman"
    Then 1 book should be displayed
    
   Scenario: Search for a book by part of the word_Author 
    When I search for a book with part of the word_Author "Baro"
    Then 1 book should be displayed
    
  Scenario: Search for a book by ISBN
    When I search for a book with ISBN "0062220330"
    Then 1 book should be displayed
    
   Scenario: No books match the ISBN 
    When I search for a book with ISBN "0012365411"
    Then 0 book should be displayed
    
  Scenario: Search for a book by signature
    When I search for a book with signature "Kahneman2012"
    Then 1 book should be displayed
    
    Scenario: No books match the signature 
    When I search for a book with signature "Harvey2010"
    Then 0 book should be displayed
    
  Scenario: No books match the Subtitle
    When I search for a book with title "Food"
    Then 0 book should be displayed
    
    Scenario: No books match the Sub author
    When I search for a book with SubString of author "Randall Munroe"
    Then 0 book should be displayed
    
    Scenario: Search for a book by part of the word 
	    When I search for a book with part of the word "Thi"
	    Then 4 book should be displayed
    
    
    Scenario: No books match the part of the word
	    When I search for a book with part of the word "rag"
	    Then 0 book should be displayed
	    
	   Scenario: Searching also works when the user or administrator is logged in
		    Given user or administrator is logged in
		    When I logged in and search for a book with  author "Steve Harvey" 
		    Then 2 book should be displayed
    
    
    
      
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
