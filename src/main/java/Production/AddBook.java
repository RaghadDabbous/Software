package Production;

public class AddBook {
	public Book book;
 	public static boolean  valid;

	public void Add(String title, String author, String signature, String isbn) {
		book =new Book();
		valid=book.addBook(title, author, signature, isbn);
	}

	public Boolean checkSignature() {
		return valid;
	}

	public static boolean isISBN10(String number) {
	      int sum = 0;
	      int digit = 0;
	      char ch = '\0';

	      for(int i=1; i<=9; i++) {
	         ch = number.charAt(i-1);
	         digit = Character.getNumericValue(ch);
	         sum += (i* digit);
	      }

	      // last digit
	      ch = number.charAt(9);
	      ch = Character.toUpperCase(ch);
	      if(ch =='X')
	         sum += (10*10);
	      else {
	         digit = Character.getNumericValue(ch);
	         sum += (digit * 10);
	      }

	      // check sum 
	      if(sum % 11 == 0)
	         return true;

	      return false;
	   }
	
}
