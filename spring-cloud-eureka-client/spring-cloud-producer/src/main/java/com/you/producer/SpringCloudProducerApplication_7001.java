package com.you.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//从Finchley.RC1 这个版本的 Spring Cloud 已经无需添加 @EnableDiscoveryClient 注解了。
//@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProducerApplication_7001 {

    /**
     * 配套修改下application.yml配置文件中
     * server:
     *   port: 7001
     *
     * config:
     *   producer:
     *     instance: 1
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProducerApplication_7001.class, args);
    }

}
