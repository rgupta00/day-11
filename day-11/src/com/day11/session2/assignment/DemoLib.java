package com.day11.session2.assignment;

public class DemoLib {
	
	public static void main(String[] args) {
		BookApp app=new BookApp("books.txt");
		app.printAllBooks();
		
		
		try {
			Book book=app.searchBookByIdV2(121);
			System.out.println("---sarched book----");
			System.out.println(book);
			System.out.println("sell the books");
			app.sellBook("AE3A", 490);
			System.out.println("---current status of stock----");
			app.printAllBooks();
			
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NotSufficientStockException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
