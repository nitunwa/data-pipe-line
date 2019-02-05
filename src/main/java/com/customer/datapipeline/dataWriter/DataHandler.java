package com.customer.datapipeline.dataWriter;

public interface DataHandler {
	public void writeData(Object obj,String dbType)  throws Exception;
}
