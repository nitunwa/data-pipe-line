package com.customer.datapipeline.datareader;

import java.io.InputStream;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;

public class S3Reader<T> implements DataReader<T> {
 
	private static final String S3_KEY_NAME = "data-input/customer.json";
 
	private static final AmazonS3 awsS3Client = s3client();

	public T readData(String bucketName, Class<T> valueType) {
		T dataList = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			S3Object object = awsS3Client.getObject(new GetObjectRequest(bucketName, S3_KEY_NAME));
			InputStream objectData = object.getObjectContent();

			dataList = objectMapper.readValue(objectData, valueType);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return dataList;
	}

	public static AmazonS3 s3client() {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAIDJU4EBQ3NMH676A",
				"VnViATXu2jWwNqMmaPDdT2WWAcw5PYXdvDoWkfdu");

		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName("us-west-2"))
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		return s3Client;
	}

}
