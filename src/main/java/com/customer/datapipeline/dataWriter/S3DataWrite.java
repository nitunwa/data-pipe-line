package com.customer.datapipeline.dataWriter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class S3DataWrite<T> implements DataWriter<T>   {
	//private   String S3_BUCKET_NAME = "shopping-data";
	private   String S3_BUCKET_NAME;
	private static final String S3_KEY_NAME = "data-output/customer.json";
	private static final String CONTENT_TYPE = "application/json";

	private static final AmazonS3 AMAZON_S3 = s3client();
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	public void writeData(String path,T[] coustomerList) {
		S3_BUCKET_NAME=path;
		try {
			String fileContentString = OBJECT_MAPPER.writeValueAsString(coustomerList);
			byte[] fileContentBytes = fileContentString.getBytes(StandardCharsets.UTF_8);
			InputStream fileInputStream = new ByteArrayInputStream(fileContentBytes);
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(CONTENT_TYPE);
			metadata.setContentLength(fileContentBytes.length);
			PutObjectRequest putObjectRequest = new PutObjectRequest(S3_BUCKET_NAME, S3_KEY_NAME, fileInputStream,
					metadata);
			AMAZON_S3.putObject(putObjectRequest);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

	public static AmazonS3 s3client() {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAIDJU4EBQ3NMH676A",
				"VnViATXu2jWwNqMmaPDdT2WWAcw5PYXdvDoWkfdu");

		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.fromName("us-west-2"))
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

		return s3Client;
	}
}
