package com.customer.datapipeline.model;

public class DatapipeLineConfig {
	private String inputDataPath;
	private String dataType;
	private String outputDataPath;
	private String outputDataType;

	public String getInputDataPath() {
		return inputDataPath;
	}

	public void setInputDataPath(String inputDataPath) {
		this.inputDataPath = inputDataPath;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	

	public String getOutputDataPath() {
		return outputDataPath;
	}

	public void setOutputDataPath(String outputDataPath) {
		this.outputDataPath = outputDataPath;
	}

	public String getOutputDataType() {
		return outputDataType;
	}

	public void setOutputDataType(String outputDataType) {
		this.outputDataType = outputDataType;
	}

	@Override
	public String toString() {
		return "DatapipeLineConfig [inputDataPath=" + inputDataPath + ", dataType=" + dataType + "]";
	}

}
