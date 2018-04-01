package com.coustomer.datapipeline.datareader;

import java.util.List;

public interface DataReader<T> {
  public List<T> readData(String filePath);
}
