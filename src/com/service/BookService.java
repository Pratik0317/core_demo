package com.service;

import java.util.List;

import com.model.Book;

public interface BookService {

	void addBook(Book book);
	void deleteBook(int index);
	List<Book> getAllBook();
	void updateBook(int id);
}
