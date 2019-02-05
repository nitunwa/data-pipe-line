package com.customer.datapipeline.dataWriter;

import java.io.File;

import com.customer.datapipeline.model.DataModel;

public class DbWriter<T extends DataModel> implements DataWriter<T> {
	DataHandler handler;

	@Override
	public void writeData(String dbType, T[] dataList) {
		DataHandler handler = new CustomerDataWriteHandler();

		
		try {
			handler.writeData(dataList,dbType);
		} catch (Exception e) {
			 
			e.printStackTrace();
		}

	}

}
