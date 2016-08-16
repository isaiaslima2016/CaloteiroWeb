package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/JavaWeb21", "root","root");
		} catch (SQLException e) {

			throw new RuntimeException(e);
		
		}
		
	}
	
	
}
