Feature: Add book
Adds a book to the library, so that it can be searched and borrowed. Only the
administrator can do this. Thus, the administrator has to be logged in.

Scenario Outline: Add a book when the administrator is logged in
Given The administrator has logged in
When admin add book with <Title>  and <Author>  and <Signature>  and <ISBN>  
Then the book will be added

Examples:
|Title	                                   | Author	            |	Signature	        |	ISBN         |		
|"Thinking, Fast and Slow"	               |	"Daniel Kahneman"	|	"Kahneman2012"	  |	"0141033576" |
|"Act Like a Success, Think Like a Success"|	"Steve Harvey"		|"Harvey2015"	      |	"0062220330" |
|"Mind Change"		                         |"Susan Greenfield"  |	"Greenfield2014"  |"1473501067"  |
|"The Pattern Seekers"	                   |"Simon Baron-Cohen" |	"Baron-Cohen2020"	|	"1541647149" |
|"Food for Life"		                       | "Laila Ali	"       |	"Ali2018"			    |"1250131103"  |
|"What If?"		                             |"Randall Munroe"	  |	"Munroe2014"	    |	"0544272641" |

Scenario: Add a book with exists signature when the administrator is logged in
Given The administrator has logged in
When admin add book with Title "Mind Change"  and Author "Susan Greenfield"  and Signature "Greenfield2014"  and ISBN "1473501067"  
Then the book will not be added and Error message will be displayed

Scenario: Add a book the administrator is logged in and Invalid ISBN
Given The administrator has logged in
When admin add book with Title "Social Chemistry"  and Author "Marissa King"  and Signature "King2021"  and invalid ISBN "0140449117"  
Then the book will not be added and Error message will be displayed (Invalid ISBN)



Scenario Outline: Add a book when the administrator is not logged in
Given Administrator not logged in
When admin add book with <Title>  and <Author>  and <Signature>  and <ISBN> 
Then the book will not be added

Examples:
|Title	                                   | Author	            |	Signature	        |	ISBN         |		
|"Thinking, Fast and Slow"	               |	"Daniel Kahneman"	|	"Kahneman2012"	  |	"0141033576" |
|"Act Like a Success, Think Like a Success"|	"Steve Harvey"		|"Harvey2015"	      |	"0062220330" |
|"Mind Change"		                         |"Susan Greenfield"  |	"Greenfield2014"  |"1473501067"  |
|"The Pattern Seekers"	                   |"Simon Baron-Cohen" |	"Baron-Cohen2020"	|	"1541647149" |
|"Food for Life"		                       | "Laila Ali	"       |	"Ali2018"			    |"1250131103"  |
|"What If?"		                             |"Randall Munroe"	  |	"Munroe2014"	    |	"0544272641" |




