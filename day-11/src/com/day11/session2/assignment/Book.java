package com.day11.session2.assignment;

public class Book implements Comparable<Book> {
	private int id;
	private String isbn;
	private String title;
	private String author;
	private int price;
	private int noOfCopies;
	
	
	
	public Book() {	// TODO Auto-generated constructor stub
	}
	public Book(int id, String isbn, String title, String author, int price,
			int noOfCopies) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.noOfCopies = noOfCopies;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title
				+ ", author=" + author + ", price=" + price + ", noOfCopies="
				+ noOfCopies + "]";
	}
	@Override
	public int compareTo(Book o) {
		return Integer.compare(this.getId(), o.getId());
	}
}









