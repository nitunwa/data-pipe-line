package com.customer.datapipeline.dataWriter;

import com.customer.datapipeline.model.DataModel;


public class DataWriterFactory<T extends DataModel> {

	//DatapipeLineConfig datapipeLineConfig;

	public DataWriter<T> getDataWriterFactory(String outputdataType) {
		DataWriter<T> dataWriter = null;
		if (outputdataType.equals("json")) {
			dataWriter = new JsonWriter<T>();
		} else if (outputdataType.equals("xml")) {
			dataWriter = new XmlWriter<T>();

		} else if (outputdataType.equals("db")) {
			dataWriter = new DbWriter<T>();

		} else if (outputdataType.equals("s3")) {
			dataWriter = new S3DataWrite<T>();

		} else {
			dataWriter = null;
		}

		return dataWriter;

	}
}
