package com.day11.session2.assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// BookApp<>-------Book
public class BookApp {
	private String bookStoreName;
	private List<Book> bookList = new LinkedList<Book>();

	public void sellBook(String isbn, int noOfCopies)
			throws NotSufficientStockException {
		ListIterator<Book> it = bookList.listIterator();

		while (it.hasNext()) {
			Book book = it.next();
			if (book.getIsbn().equals(isbn)) {
				int stockBalance = book.getNoOfCopies() - noOfCopies;
				if (stockBalance < 0)
					throw new NotSufficientStockException(
							"not sufficient stock avaliable for "
							+ "book isbn:"
									+ isbn);
				book.setNoOfCopies(stockBalance);
				it.set(book);
			}
		}

		// logic
		/*
		 * iterate through all books if book found check the quantity if qty is
		 * less then what customer is looking for then throw notsuffbookex else
		 * minus the qty
		 */
	}

	public void purchageBook(String isbn, int noOfCopies) {
		// logic
		/*
		 * iterate through all books if book found check increse the qty
		 */

	}

	public Book searchBookByIdV2(int id) throws BookNotFoundException {
		Collections.sort(bookList);
		int index = Collections.binarySearch(bookList,
				new Book(id, "", "", "",
				0, 0));
		if (index < 0)
			throw new BookNotFoundException("book with id " + id
					+ " is not found");
		else
			return bookList.get(index);
	}

	// code for searching a book
	public Book searchBookById(int id) throws BookNotFoundException {
		// binary seach
		Book bookToSearch = null;
		for (Book book : bookList) {
			if (book.getId() == id) {
				bookToSearch = book;
				break;
			}
		}
		if (bookToSearch == null)
			throw new BookNotFoundException("book with id " + id
					+ " is not found");
		else
			return bookToSearch;
	}

	// code for printing all books
	public void printAllBooks() {
		for (Book book : bookList) {
			System.out.println(book);
		}
	}

	public BookApp(String fileName) {
		// read the file and populate booklist
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(":");
				Book book = new Book(Integer.parseInt(tokens[0]), tokens[1],
						tokens[2], tokens[3], Integer.parseInt(tokens[4]),
						Integer.parseInt(tokens[5]));
				bookList.add(book);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
