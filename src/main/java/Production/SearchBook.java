package Production;

import java.util.List;

public class SearchBook {
	int index = 0;
	List<List<String>> book;

	public int searchSub(List<List<String>> data, String title, int j) {
		title = title.toLowerCase();

		book = data;
		for (int i = 0; i < data.size(); i++) {
			String sub = data.get(i).get(j).toLowerCase();
			String[] tokens = sub.split(" ");
			for (String s : tokens) {
				if (s.equalsIgnoreCase(title)) {
					index++;
					print(i);
				}
			}

		}
		if (index == 0) {
			System.out.println("No books match the criteria\n______________________________________");
		}
		return index;
	}

	public int search(List<List<String>> data, String title, int j) {
		title = title.toLowerCase();
		book = data;
		for (int i = 0; i < data.size(); i++) {
			String BookTi = data.get(i).get(j).toLowerCase();
			if (BookTi.equalsIgnoreCase(title)) {
				index++;
				print(i);
			}
		}
		if (index == 0) {
			System.out.println("No books match the criteria\n______________________________________");
		}
		return index;
	}

	public int searchSubOfName(List<List<String>> data, String title, int j) {
		title = title.toLowerCase();
		int size = title.length();
		boolean f = false;
		book = data;
		char arrayData[];
		char arrayTitle[] = title.toCharArray();

		for (int i = 0; i < data.size(); i++) {
			String sub = data.get(i).get(j).toLowerCase();
			String[] tokens = sub.split(" ");

			for (String s : tokens) {
				arrayData = s.toCharArray();
				for (int k = 0; k < size; k++) {
					if (arrayTitle[k] == arrayData[k]) {
						f = true;
					} 
					else {
						f = false;
						break;
					}
				}
				if (f) {
					index++;
					print(i);
				}
			}
		}
		if (index == 0) {
			System.out.println("No books match the criteria\n____________________________________");
		}
		return index;
	}

	public void print(int x) {
		System.out.println("Title: " + book.get(x).get(0));
		System.out.println("Author: " + book.get(x).get(1));
		System.out.println("Signature: " + book.get(x).get(2));
		System.out.println("ISBN: " + book.get(x).get(3) + "\n______________________________________");
	}

}
