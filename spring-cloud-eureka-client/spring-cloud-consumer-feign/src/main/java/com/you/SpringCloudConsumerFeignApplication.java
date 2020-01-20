package com.you;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 开启feign客户端
 */
@EnableFeignClients
@SpringBootApplication
public class SpringCloudConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerFeignApplication.class, args);
    }

}
