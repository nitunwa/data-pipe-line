package com.customer.datapipeline.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.customer.datapipeline.model.Customer;
import com.customer.datapipeline.model.Item;
import com.customer.datapipeline.model.Shopping;

public class DataProcessor {
	DataSource dataSource;

	public DataProcessor(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void saveCustomerData() throws ClassNotFoundException, SQLException{
		Connection connection = dataSource.getConnection();
		Statement   statement = connection.createStatement();
		ResultSet   resultSet = statement.executeQuery("select * from `data-line-pipe`.`customer`;");
		while(resultSet.next()){
            Integer customerId = resultSet.getInt("customerId");
            String customerName = resultSet.getString("customerName");
            Date createDate = resultSet.getDate("createDate");
            System.out.println("id: "+customerId);
            System.out.println("text: "+customerName);
            System.out.println("text: "+createDate.toGMTString());
        }
	}
	public void saveCustomerData(Customer[] coustomerList) throws SQLException {
		Statement statement = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			for (Customer cust : coustomerList) {
				 for(Shopping shopping : cust.getShopList()){
					 for(Item item : shopping.getItemList()){
						 //System.out.println(cust.getShopList());
							String insertTableSQL = "INSERT INTO `data-line-pipe`.`customer` (`customerName`) VALUES ('"+cust.getName()+ "');";
							
							statement = connection.createStatement();
							System.out.println(cust.toString());
							statement.executeUpdate(insertTableSQL); 
					 }
				 }
				 
				
				saveCustomerData();
				//System.out.println("Record is inserted into DBUSER table!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
