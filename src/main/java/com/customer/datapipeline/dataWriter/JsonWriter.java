package com.customer.datapipeline.dataWriter;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWriter<T> implements DataWriter<T> {
	public void writeData(String path, T[] dataList) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(path), dataList);
		} catch (JsonGenerationException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		;
	}

}
