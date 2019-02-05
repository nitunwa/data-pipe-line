package com.customer.datapipeline.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DbReader {
	DataSource dataSource;

	public void readDataFmDb() throws ClassNotFoundException, SQLException {
		Connection connection = dataSource.getConnection("mysql");
		Statement satement = connection.createStatement();
		ResultSet resultSet = satement.executeQuery("select * from `data-line-pipe`.`customer`;");
		while (resultSet.next()) {
			Integer customerId = resultSet.getInt("customerId");
			String customerName = resultSet.getString("customerName");
			// Date createDate = resultSet.getDate("createDate");
			System.out.println("id: " + customerId);
			System.out.println("text: " + customerName);
			// System.out.println("text: "+createDate.toGMTString());
		}
	}
}
