package com.customer.datapipeline;

import java.io.IOException;

import com.customer.datapipeline.driver.DataDrive;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Application {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		DataDrive dataDrive = DataDrive.getInstance();
		
		dataDrive.startDataPipeline();
		
	}
	

}
