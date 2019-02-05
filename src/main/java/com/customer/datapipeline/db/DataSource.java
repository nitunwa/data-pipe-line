package com.customer.datapipeline.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://localhost/data-line-pipe?" + "user=root&password=123456";
	
	public Connection getConnection(String dbType) throws ClassNotFoundException, SQLException {
		if(dbType.equals("mysql")){
			Connection connection;
			 Class.forName(MYSQL_DRIVER);
	         connection = DriverManager.getConnection(MYSQL_URL);
	         return connection;
		}{
			return null;
		}
		
	}
}
