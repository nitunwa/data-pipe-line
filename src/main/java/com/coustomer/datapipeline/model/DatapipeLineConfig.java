package com.coustomer.datapipeline.model;

public class DatapipeLineConfig {
	private String inputDataPath;
	private String dataType;

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

	@Override
	public String toString() {
		return "DatapipeLineConfig [inputDataPath=" + inputDataPath + ", dataType=" + dataType + "]";
	}

}
