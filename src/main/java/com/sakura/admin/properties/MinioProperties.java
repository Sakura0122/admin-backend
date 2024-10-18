package com.sakura.admin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: sakura
 * @date: 2024/10/12 13:31
 * @description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix="spzx.minio")
public class MinioProperties {
    private String endpointUrl;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
