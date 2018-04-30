package com.customer.datapipeline.model;

public class DatapipeLineConfig {
	private String inputDataPath;
	private String inputDataType;
	private String outputDataPath;
	private String outputDataType;

	public String getInputDataPath() {
		return inputDataPath;
	}

	public void setInputDataPath(String inputDataPath) {
		this.inputDataPath = inputDataPath;
	}

	public String getInputDataType() {
		return inputDataType;
	}

	public void setInputDataType(String dataType) {
		this.inputDataType = dataType;
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
		return "DatapipeLineConfig [inputDataPath=" + inputDataPath + ", dataType=" + inputDataType + "]";
	}

}
