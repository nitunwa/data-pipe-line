package com.customer.datapipeline.dataWriter;

import com.customer.datapipeline.model.DataModel;

public class DbWriter<T extends DataModel> implements DataWriter<T> {
	DataHandler handler;

	@Override
	public void writeData(String config, T[] dataList) {
		DataHandler handler = null;

		if (config.equals("customer")) {
			handler = new CustomerDataWriteHandler();
		}
		try {
			handler.writeData(dataList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
