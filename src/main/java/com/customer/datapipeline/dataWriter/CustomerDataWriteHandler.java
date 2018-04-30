package com.customer.datapipeline.dataWriter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.customer.datapipeline.db.DataSource;
import com.customer.datapipeline.model.Customer;
import com.customer.datapipeline.model.Item;
import com.customer.datapipeline.model.Shopping;

public class CustomerDataWriteHandler implements DataHandler {


	
	public void writeData(Object obj) throws Exception {
		DataSource dataSource = new DataSource();

		Statement statement = null;
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			Customer[] coustomerList = (Customer[]) obj;

			for (Customer cust : coustomerList) {
				for (Shopping shopping : cust.getShopList()) {
					for (Item item : shopping.getItemList()) {
						// System.out.println(cust.getShopList());
						String insertTableSQL = "INSERT INTO `data-line-pipe`.`customer` (`customerName`) VALUES ('"
								+ cust.getName() + "');";

						statement = connection.createStatement();
						System.out.println(insertTableSQL.toString());
						statement.executeUpdate(insertTableSQL);
					}
				}

			}

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		}

	}

}
