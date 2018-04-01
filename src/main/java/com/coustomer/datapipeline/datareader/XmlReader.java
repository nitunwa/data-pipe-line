package com.coustomer.datapipeline.datareader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlReader<T> implements DataReader<T> {

	public List<T> readData(String filePath) {
		XmlMapper mapper = new XmlMapper();
		List<T> dataList = null;
		try {
			dataList = mapper.readValue(new File(filePath), new TypeReference<List<T>>(){});
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
