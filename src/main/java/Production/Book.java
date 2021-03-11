package Production;

import java.util.ArrayList;

public class Book {

	private String title;
	private String author;
	private String signature;
	private String isbn;
	
	// Declaring ArrayList
	private static ArrayList<Book> library = new ArrayList<Book>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String Title, String Author, String Signature, String ISBN) {
		
		this.title = Title;
		this.author = Author;
		this.signature = Signature;
		this.isbn = ISBN;
	}

	public boolean addBook(String Title, String Author, String Signature, String isbn2) {
		if(!(Search(Signature))) {
			Book book = new Book(Title, Author, Signature, isbn2);
			library.add(book);
			return true;
		}
		else
			return false;
		
	}
	
	private int indexOf(String Signature) {
		Book book;
		for(int i = 0; i < library.size(); i++) {
			book = library.get(i);
			String s = book.signature;
			if(s.equalsIgnoreCase(Signature))
				return i;
		}
		return -1;
	}
	
	public boolean Search(String Signature) {	
		int i = indexOf(Signature);
		if(i >= 0) {
			System.out.println("This signature is exist , Please enter new signature");
			return true;
		}
		else
			return false;
	}
	public void print() {
		for(int i = 0; i < library.size(); i++) {
			System.out.println(library.get(i).title);
			System.out.println(library.get(i).author);
			System.out.println(library.get(i).signature);
			System.out.println(library.get(i).isbn);
			System.out.println();
		}
	}

}
