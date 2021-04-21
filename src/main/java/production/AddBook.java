package production;

import java.util.logging.Logger;

public class AddBook {
	public static Book book;
 	public static boolean  valid;
 	private static final Logger LOG = Logger.getLogger(AddBook.class.getName());
 	
	public static void addToLibrary(String title, String author, String signature, String isbn) {
		book =new Book(title, author, signature, isbn);
		valid=book.addBook(title, author, signature, isbn);
	}

	public Boolean checkSignature() {
		return valid;
	}

	public boolean isISBN10(String number) {

	      int sum = 0;
	      int digit = 0;
	      char ch;

	      for(int i = 1; i <= 9; i++) {
	         ch = number.charAt(i - 1);
	         digit = Character.getNumericValue(ch);
	         sum += (i * digit);
	      }

	      ch = number.charAt(9);
	      ch = Character.toUpperCase(ch);

	         digit = Character.getNumericValue(ch);
	         sum += (digit * 10);


	      if(sum % 11 == 0) {
	    	  LOG.info("Valid ISBN");
		     return true;
	      }
	      else {
	    	  LOG.info("Invalid ISBN");
	    	  return false;
	      }
	   }

}
