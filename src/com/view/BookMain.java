package com.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.model.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

public class BookMain {

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			System.out.println("-----Book Menu-----");
			System.out.println("1. Add Book");
			System.out.println("2. Delete Book");
			System.out.println("3. Display Book List");
			System.out.println("4. Update Book");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			
			switch(scanner.nextInt()) {
			case 1:
				addBtn();
				break;
			case 2: 
				deleteBtn();
				break;
			case 3: 
				listBtn();
				break;
			case 4: 
				updateBtn();
				break;
			case 5: 
				System.out.println("Thank you for your time.");
				System.exit(0);
		    default: 
		    	System.out.println("-----Invalid Choice-----");
		    	break;
			}
		}
	}
	
	static void deleteBtn() {
		BookService bookService = new BookServiceImpl();
		System.out.println("Enter book id to delete: ");
		bookService.deleteBook(scanner.nextInt());
		
	}
	
	static void listBtn() {
		BookService bookService = new BookServiceImpl();
		bookService.getAllBook();
		System.out.println("Print Success");
	}
	
	static void addBtn() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BookService bookService = new BookServiceImpl();
	
		char flag = 'y';
		
		do {
			Book book = new Book();
			
		System.out.println("Enter title: ");
		book.setTitle(bufferedReader.readLine());
		System.out.println("Enter isbn: ");
		book.setIsbn(bufferedReader.readLine());
		System.out.println("Enter author: ");
		book.setAuthor(bufferedReader.readLine());
		System.out.println("Enter price: ");
		book.setPrice(Double.parseDouble(bufferedReader.readLine()));
		System.out.println("Enter published year: ");
		book.setPublishYear(Integer.parseInt(bufferedReader.readLine()));
		
		bookService.addBook(book);
		
		System.out.println("Do you want to add more books y/n ?");
		flag = bufferedReader.readLine().charAt(0);
		}while(flag=='y');
		
	}
	
	static void updateBtn() {
		BookService bookService = new BookServiceImpl();
		System.out.println("Enter the book id you want to update");
		bookService.updateBook(scanner.nextInt());
	}
}
