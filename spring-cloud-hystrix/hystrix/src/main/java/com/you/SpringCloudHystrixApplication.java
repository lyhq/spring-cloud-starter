package com.you;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableHystrix: 开启断路器功能
 * @EnableFeignClients： 开启远程调用
 */
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class SpringCloudHystrixApplication {

    /**
     * Ribbon 负载均衡注解
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixApplication.class, args);
    }

    /**
     * 等效于
     * feign:
     *   hystrix:
     *     enabled: true #开启熔断机制
     * @return
     */
    /*@Bean
    public Feign.Builder feignHystrixBuilder() {
        return HystrixFeign.builder();
    }*/
}
