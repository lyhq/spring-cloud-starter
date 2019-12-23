package com.you;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动类
 *
 * @EnableEurekaServer: 启动EurekaServer功能
 * @Slf4j 引入日志打印的功能
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaServerAloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerAloneApplication.class, args);
        log.info("spring-cloud-eureka-service启动!");
    }

}
