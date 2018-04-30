package com.customer.datapipeline.driver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.customer.datapipeline.dataWriter.DataWriter;
import com.customer.datapipeline.dataWriter.DataWriterFactory;
import com.customer.datapipeline.dataWriter.S3DataWrite;
import com.customer.datapipeline.datareader.DataReader;
import com.customer.datapipeline.datareader.DataReaderFactory;
import com.customer.datapipeline.db.DataProcessor;
import com.customer.datapipeline.db.DataSource;
import com.customer.datapipeline.model.Customer;
import com.customer.datapipeline.model.DatapipeLineConfig;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataDrive {

	DatapipeLineConfig datapipeLineConfig = null;
	DataReaderFactory<Customer[]> dataReaderFactory = new DataReaderFactory<Customer[]>();
	DataWriterFactory<Customer> dataWriterFactory = new DataWriterFactory<Customer>();

	@SuppressWarnings("unused")
	public void startDataPipeline() {

		// read data
		Customer[] coustomerList = readData();
		// transformation
		// filter

		// write data

		writeData(coustomerList);
	}

	public Customer[] readData() {
		DataReader<Customer[]> reader = null;
		// read
		reader = dataReaderFactory.getDataReader(datapipeLineConfig.getInputDataType());
		Customer[] coustomerList = reader.readData(datapipeLineConfig.getInputDataPath(), Customer[].class);
		return coustomerList;
	}

	public void writeData(Customer[] coustomerList) {
		DataWriter<Customer> writer = null;
		writer = dataWriterFactory.getDataWriterFactory(datapipeLineConfig.getOutputDataType());
		writer.writeData(datapipeLineConfig.getOutputDataPath(), coustomerList);

	}

	private DataDrive() {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource("DatapipelineConfig.json").getFile());
		try {
			datapipeLineConfig = objectMapper.readValue(file, DatapipeLineConfig.class);
		} catch (JsonParseException e) {

			e.printStackTrace();
			System.exit(0);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println(datapipeLineConfig.toString());

	}

	private static class SingletonHelper {
		private static final DataDrive INSTANCE = new DataDrive();;

	}

	public static DataDrive getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
