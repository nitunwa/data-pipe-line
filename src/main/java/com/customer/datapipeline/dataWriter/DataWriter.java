package com.customer.datapipeline.dataWriter;

public interface DataWriter<T> {
	public void writeData(String path, T[] dataList);

}
