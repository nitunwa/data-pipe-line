package com.coustomer.datapipeline.datareader;

import java.io.File;
import java.io.IOException;
import java.util.List;
 
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader<T> implements DataReader<T> {

	public List<T> readData(String filePath) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<T> dataList = null;
		try {
			dataList = objectMapper.readValue(new File(filePath), new TypeReference<List<T>>(){});
		} catch (JsonParseException e) {
				e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

}
