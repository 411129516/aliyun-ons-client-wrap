package com.laiyl.study.aliyun.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@Data
@Component
@ConfigurationProperties(prefix = "ons.aliyun")
public class AliyunProperties {

    private String accessKey;
    private String accessSecret;
    private String instanceId;
    private String regionId;
}
