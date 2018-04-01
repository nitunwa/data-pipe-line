package com.coustomer.datapipeline.driver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.coustomer.datapipeline.datareader.DataReader;
import com.coustomer.datapipeline.datareader.DataReaderFactory;
import com.coustomer.datapipeline.datareader.JsonReader;
import com.coustomer.datapipeline.datareader.XmlReader;
import com.coustomer.datapipeline.model.Customer;
import com.coustomer.datapipeline.model.DatapipeLineConfig;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataDrive {


	DatapipeLineConfig datapipeLineConfig = null;
	DataReaderFactory<Customer> dataReaderFactory = new DataReaderFactory<Customer>();
	@SuppressWarnings("unused")
	public void readCoustomerData() {
		DataReader<Customer> reader = null;
		List<Customer> coustomerList;
/*
		if (datapipeLineConfig.getDataType().equals("json")) {
			reader = new JsonReader<Customer>();

		} else if (datapipeLineConfig.getDataType().equals("xml")) {
			reader = new XmlReader<Customer>();

		} else {
			reader = null;
		}*/
		reader=dataReaderFactory.getDataReader(datapipeLineConfig.getDataType());
		
		coustomerList = reader.readData(datapipeLineConfig.getInputDataPath());
		int size = coustomerList.size();
		System.out.println("Count : " + size);

	}

	private DataDrive()  {
		ObjectMapper objectMapper = new ObjectMapper();
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource("DatapipelineConfig.json").getFile());
		try {
			datapipeLineConfig = objectMapper.readValue(file, DatapipeLineConfig.class);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
			System.exit(0);
		} catch (JsonMappingException e) {
			
			System.exit(0);
		} catch (IOException e) {
			
			System.exit(0);
		}
		
		
		System.out.println(datapipeLineConfig.toString());

	}
	

	private static class SingletonHelper {
		private static final DataDrive INSTANCE= new DataDrive();;
		
	}

	public static DataDrive getInstance() {
		return SingletonHelper.INSTANCE;
	}

}
