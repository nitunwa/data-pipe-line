package com.customer.datapipeline.datareader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlReader<T> implements DataReader<T> {

	public T readData(String filePath, Class<T> valueType) {
		XmlMapper mapper = new XmlMapper();
		T dataList = null;
	
			// dataList = objectMapper.readValue(new File(filePath), new
			// TypeReference<List<T>>(){});
			try {
				dataList = mapper.readValue(new File(filePath), valueType);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return dataList;
	}
}
