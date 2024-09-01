package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.db.BookDB;
import com.model.Book;

public class BookServiceImpl implements BookService{

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
		String sql = "insert into book(title,isbn,author,price,publishYear)values(?,?,?,?,?)";
		
		try {
			PreparedStatement ptms = BookDB.getBD().prepareStatement(sql);
			ptms.setString(1, book.getTitle());
			ptms.setString(2, book.getIsbn());
			ptms.setString(3, book.getAuthor());
			ptms.setDouble(4, book.getPrice());
			ptms.setInt(5, book.getPublishYear());
			
			ptms.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int index) {
		// TODO Auto-generated method stub
		
		String deleteQuery = "DELETE FROM book WHERE bookId = ?";
		
		try {
			PreparedStatement ptms = BookDB.getBD().prepareStatement(deleteQuery);
			ptms.setInt(1, index);
			int rowAffected = ptms.executeUpdate();
			if(rowAffected>0) {
				System.out.println("Record with id "+index+" deleted successfully.");
			}else {
				System.out.println("Record with id "+index+" not found.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		List<Book> bookList = new ArrayList<>();
		String query = "SELECT*FROM book";
		
		try {
			//PreparedStatement ptms = BookDB.getBD().prepareStatement(query);
			Statement stm = BookDB.getBD().createStatement();
			ResultSet resultSet = stm.executeQuery(query);
			while(resultSet.next()) {
				int id  = resultSet.getInt("bookId");
				String title = resultSet.getString("title");
				String isbn = resultSet.getString("isbn");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				int publishYear = resultSet.getInt("publishYear");
				
				System.out.println("BookId: "+id+" Title: "+title+" ISBN: "+isbn+
						" Author: "+author+" Price: "+price+" Publish Year: "+publishYear);
				
				Book book = new Book(id, title, isbn, author, price, publishYear);
				bookList.add(book);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public void updateBook(int id) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		String updateQuery = "UPDATE book SET title = ?, isbn = ?, author = ?, price = ?, publishYear = ? WHERE bookId = ?";
		try {
			PreparedStatement preparedStatement = BookDB.getBD().prepareStatement(updateQuery);
			
			 System.out.println("Enter title: ");
		        String title = scanner.nextLine();
		        
		        System.out.println("Enter ISBN: ");
		        String isbn = scanner.nextLine();
		        
		        System.out.println("Enter author: ");
		        String author = scanner.nextLine();
		        
		        System.out.println("Enter price: ");
		        double price = scanner.nextDouble();
		        
		        System.out.println("Enter publish year: ");
		        int publishYear = scanner.nextInt();
		        
		        preparedStatement.setString(1, title);
		        preparedStatement.setString(2, isbn);
		        preparedStatement.setString(3, author);
		        preparedStatement.setDouble(4, price);
		        preparedStatement.setInt(5, publishYear);
		        preparedStatement.setInt(6, id);
		        
		        int rowsAffected = preparedStatement.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            System.out.println("Book with id " + id + " updated successfully.");
		        } else {
		            System.out.println("No book found with id " + id + ".");
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
