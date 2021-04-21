package production;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Book {

	public String title;
	public String author;
	public String signature;
	public String isbn;
	
	private static final Logger LOG = Logger.getLogger(Book.class.getName());
	private static ArrayList<Book> library = new ArrayList();
	
	public Book(String title, String author, String signature, String isbn) {
		this.title = title;
		this.author = author;
		this.signature = signature;
		this.isbn = isbn;
	}

	public boolean addBook(String title, String author, String signature, String isbn2) {
		if(!(searchBook(signature))) {
			Book book = new Book(title, author, signature, isbn2);
			library.add(book);
			return true;
		}
		else
			return false;	
	}
	
	private int indexOf(String signature) {
		Book book;
		for(int i = 0; i < library.size(); i++) {
			book = library.get(i);
			String s = book.signature;
			if(s.equalsIgnoreCase(signature))
				return i;
		}
		return -1;
	}
	
	public boolean searchBook(String sign) {	
		int i = indexOf(sign);
		if(i >= 0) {
			LOG.info("This signature is exist, Please enter new signature");
			return true;
		}
		else
			return false;
	}
	
}
