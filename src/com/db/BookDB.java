package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookDB {

	public static Connection getBD() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/appsoft_db","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * public static void main(String[] args) throws SQLException {
	 * 
	 * try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection connection =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/appsoft_db","root",
	 * ""); if(connection!= null) { System.out.println("Connected Successfully");
	 * }else { System.out.println("Failed to connect"); }
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
}
