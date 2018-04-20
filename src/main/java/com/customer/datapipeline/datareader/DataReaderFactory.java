package com.customer.datapipeline.datareader;


import com.customer.datapipeline.model.DatapipeLineConfig;

public class DataReaderFactory<T> {

	DatapipeLineConfig datapipeLineConfig;

	@SuppressWarnings("unused")
	public DataReader<T> getDataReader(String readerType) {
		DataReader<T> reader = null;

		if (readerType.equals("json")) {
			reader = new JsonReader<T>();

		} else if (readerType.equals("xml")) {
			reader = new XmlReader<T>();

		} else {
			reader = null;
		}
		return reader;

	}

}
