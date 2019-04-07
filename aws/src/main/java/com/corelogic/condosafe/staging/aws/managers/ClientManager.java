package com.corelogic.condosafe.staging.aws.managers;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import com.amazonaws.auth.BasicAWSCredentials;

@Component
public class ClientManager {

    @Value("${aws.accessKey}")
    private static String accessKey;

    @Value("${aws.privateKey}")
    private static String secretKey;

    private static AWSCredentials getAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    public static AmazonS3 getS3Client() {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(getAWSCredentials()))
                .withRegion(Regions.US_EAST_2).build();
    }

}
