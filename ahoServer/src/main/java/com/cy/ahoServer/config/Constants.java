package com.cy.ahoServer.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @创建者 CY
 * @创建时间 2019/12/30 17:16
 * @描述
 */
@Component
public class Constants implements InitializingBean {
//    @Value("${oss.file.endpoint}")
//    private String endpoint;
//    @Value("${oss.file.bucketEndpoint}")
//    private String bucketEndpoint;
//    @Value("${oss.file.keyId}")
//    private String keyId;
//    @Value("${oss.file.keySecret}")
//    private String keySecret;
//    @Value("${oss.file.bucketName}")
//    private String bucketName;
//    @Value("${oss.file.fileHost}")
//    private  String fileHost;
//
//
//    public static String OSS_ENDPOINT;
//    public static String OSS_BUCKET_ENDPOINT;
//    public static String OSS_KEY_ID;
//    public static String OSS_KEY_SECRET;
//    public static String OSS_BUCKET_NAME;
//    public static String OSS_FILE_HOST;

    /**
     * 短信验证码
     */
    public static Integer TEL_CODE_LENGTH = 6;

    @Override
    public void afterPropertiesSet() throws Exception {
//        OSS_ENDPOINT=endpoint;
//        OSS_KEY_ID=keyId;
//        OSS_KEY_SECRET=keySecret;
//        OSS_BUCKET_NAME=bucketName;
//        OSS_FILE_HOST=fileHost;
//        OSS_BUCKET_ENDPOINT=bucketEndpoint;
    }
}
