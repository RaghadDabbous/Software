package production;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.*;


public class SearchBook {
	int index = 0;
	List<List<String>> book;
	private static final String NO_BOOK = "No books match the criteria";
	private static final String LINE = "______________________________________";
	private static final Logger LOG = Logger.getLogger(SearchBook.class.getName());
	public int searchSub(List<List<String>> data, String title, int j) {
		
		title = title.toLowerCase();
		
		book = data;
		for(int i = 0; i < data.size(); i++) {
			String sub = data.get(i).get(j).toLowerCase();
			String [] tokens = sub.split(" ");
			for (String s : tokens) {
				if(s.equalsIgnoreCase(title)) {
					index++;
					print(i);
				}
			}
		}
		if(index == 0) {
			LOG.info(NO_BOOK);
			LOG.info(LINE);
		}
		return index;	
	}

	public int search(List<List<String>> data, String title, int j) {
		title = title.toLowerCase();
		book = data;
		for(int i = 0; i < data.size(); i++) {
			String bookTi = data.get(i).get(j).toLowerCase();
			if(bookTi.equalsIgnoreCase(title)) {
				index++;
				print(i);
			}
		}
		if(index == 0) {
			LOG.info(NO_BOOK);
			LOG.info(LINE);
		}
		return index;
	}

	public int searchSubOfName(List<List<String>> data, String title, int j) {
		title=title.toLowerCase();
		int size = title.length();
		boolean f = false;
		book=data;
		char [] arrayData;
		char [] arrayTitle = title.toCharArray();
		
		
		for(int i = 0; i < data.size(); i++) {
			String sub = data.get(i).get(j).toLowerCase();
			String [] tokens = sub.split(" ");
			
			
			for (String s : tokens) {
				arrayData = s.toCharArray();
				for(int k = 0; k < size; k++) {
					if(arrayTitle[k] == arrayData[k]) {
						f = true;
					}
					else {
						f = false;
						break;
					}
				}
				if(f) {
					index++;
					print(i);
				}	
			}
		}
		if(index == 0) {
			LOG.info(NO_BOOK);
			LOG.info(LINE);
		}
		return index;
	}
	
	
	public void print(int x) {
		LOG.info("Title: " + book.get(x).get(0));
		LOG.info("Author: " + book.get(x).get(1));
		LOG.info("Signature: " + book.get(x).get(2));
		LOG.info("ISBN: " + book.get(x).get(3));
		LOG.info(LINE);
	}

}

