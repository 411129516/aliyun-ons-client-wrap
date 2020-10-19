package com.laiyl.study.aliyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author laiyulong
 * @since 2020-10-19
 */
@SpringBootApplication
@EnableOpenApi
@EnableConfigurationProperties
public class AliyunOnsMain {

    public static void main(String[] args) {
        SpringApplication.run(AliyunOnsMain.class, args);
    }
}
