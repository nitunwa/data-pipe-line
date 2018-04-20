package com.customer.datapipeline.dataWriter;

import com.customer.datapipeline.model.DatapipeLineConfig;

public class DataWriterFactory<T> {

	DatapipeLineConfig datapipeLineConfig;

	public DataWriter<T> getDataWriterFactory(String outputdataType) {
		DataWriter<T> dataWriter = null;
		if (outputdataType.equals("json")) {
			dataWriter = new JsonWriter<T>();
		} else if (outputdataType.equals("xml")) {
			dataWriter = new XmlWriter<T>();

		} else {
			dataWriter = null;
		}

		return dataWriter;

	}
}
