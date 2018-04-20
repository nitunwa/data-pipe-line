package com.customer.datapipeline.datareader;

import java.util.List;

public interface DataReader<T> {
  public T readData(String filePath, Class<T> valueType);
}
