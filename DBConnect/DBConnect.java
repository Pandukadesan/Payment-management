package com.payment;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String url = "jdbc:mysql://localhost:3306/payment";
	private static String userName = "root";
	private static String password = "Panduka12345";
	public static Connection con;
	
	public static Connection getconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			System.out.println("Database connection is not success");
		}
		return con;
	}
		
}
