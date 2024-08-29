package com.model;

public class Book {

	private int bookId;
	private String title;
	private String isbn;
	private String author;
	private double price;
	private int publishYear;
	
	
	public Book(int bookId, String title, String isbn, String author, double price, int publishYear) {
		this.bookId = bookId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.publishYear = publishYear;
	}
	
	
	public Book() {
		
	}


	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", author=" + author + ", price="
				+ price + ", publishYear=" + publishYear + "]";
	}

	
}
