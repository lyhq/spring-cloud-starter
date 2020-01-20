package com.you.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/test")
@RestController
public class TestController {

    /**
     * 负载均衡客户端
     */
    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public String test(@RequestParam String name) {
        name += "!";
        //获取生产者服务实例
        ServiceInstance instance = client.choose("eureka-producer");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/test?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

}
