package com.you;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCloudConsumerRibbonApplication {

    /**
     * 负载均衡注解
     *
     * @return
     */
    @LoadBalanced
    @Bean("balancedRestTemplate")
    public RestTemplate balancedRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 非负载均衡
     *
     * @return
     */
    @Bean("notBalancedRestTemplate")
    public RestTemplate notBalancedRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerRibbonApplication.class, args);
    }

}
