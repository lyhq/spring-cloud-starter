package com.you;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.cloud.stream.converter.CompositeMessageConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.converter.ConfigurableCompositeMessageConverter;

/**
 * @EnableTurbineStream: 开启EnableTurbineStream功能
 */
@EnableTurbineStream
@SpringBootApplication
public class SpringCloudHystrixTurbineStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixTurbineStreamApplication.class, args);
    }

}
